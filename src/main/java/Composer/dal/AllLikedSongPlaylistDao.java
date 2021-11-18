package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.AllLikedSongPlaylist;
import model.SongList;
import model.User;


public class AllLikedSongPlaylistDao extends SongListDao {
  private static AllLikedSongPlaylistDao instance = null;
  protected AllLikedSongPlaylistDao() {
    super();
  }
  public static AllLikedSongPlaylistDao getInstance() {
    if(instance == null) {
      instance = new AllLikedSongPlaylistDao();
    }
    return instance;
  }

  public AllLikedSongPlaylist create(AllLikedSongPlaylist allLikedSongPlaylist) throws SQLException {

    SongList res = create(new SongList(allLikedSongPlaylist.getSongListId(), allLikedSongPlaylist.getUserId()));
    allLikedSongPlaylist.setSongListId(res.getSongListId());
    String insertAllLikedSongPlaylist = "INSERT INTO AllLikedSongPlaylist(SongListId) VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertAllLikedSongPlaylist);
      insertStmt.setInt(1, allLikedSongPlaylist.getSongListId());
      insertStmt.executeUpdate();
      return allLikedSongPlaylist;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(insertStmt != null) {
        insertStmt.close();
      }
    }
  }

  public AllLikedSongPlaylist getAllLikedSongPlaylistById(int allLikedSongPlaylistId) throws SQLException {
    String selectAllLikedSongPlaylist =
        "SELECT AllLikedSongPlaylist.SongListId AS AllLikedSongPlaylistId " +
            "FROM LeastPlayedSongs INNER JOIN SongList " +
            "  ON AllLikedSongPlaylist.SongListId = SongListId.SongListId " +
            "WHERE AllLikedSongPlaylist.AllLikedSongPlaylistId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectAllLikedSongPlaylist);
      selectStmt.setInt(1, allLikedSongPlaylistId);
      results = selectStmt.executeQuery();
      UserDao userDao = UserDao.getInstance();
      if(results.next()) {
        int resultAllLikedSongPlaylistId = results.getInt("SongListId");
        int userId = results.getInt("UserId");

        User user = userDao.getUserByUserId(userId);
        AllLikedSongPlaylist allLikedSongPlaylist = new AllLikedSongPlaylist(resultAllLikedSongPlaylistId, user);
        return allLikedSongPlaylist;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(selectStmt != null) {
        selectStmt.close();
      }
      if(results != null) {
        results.close();
      }
    }
    return null;
  }

  public AllLikedSongPlaylist delete(AllLikedSongPlaylist allLikedSongPlaylist) throws SQLException {
    String deleteAllLikedSongPlaylist = "DELETE FROM deleteAllLikedSongPlaylist WHERE SongListId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteAllLikedSongPlaylist);
      deleteStmt.setInt(1, allLikedSongPlaylist.getSongListId());
      deleteStmt.executeUpdate();
      super.delete(allLikedSongPlaylist);

      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }
}
