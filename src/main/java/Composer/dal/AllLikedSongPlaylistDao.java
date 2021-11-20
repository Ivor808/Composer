package Composer.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Composer.model.AllLikedSongPlaylist;
import Composer.model.SongList;
import Composer.model.User;


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

    SongList res = create(new SongList(allLikedSongPlaylist.getUserId()));
    allLikedSongPlaylist.setSongListId(res.getSongListId());
    String insertAllLikedSongPlaylist = "INSERT INTO AllLikedSongPlaylist(SongListID) VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertAllLikedSongPlaylist, Statement.RETURN_GENERATED_KEYS);
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
        "SELECT AllLikedSongPlaylist.SongListID AS AllLikedSongPlaylistId " +
            "FROM AllLikedSongPlaylist INNER JOIN SongList " +
            "  ON AllLikedSongPlaylist.SongListID = SongList.SongListID " +
            "WHERE AllLikedSongPlaylist.SongListID=?;";
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
        int resultAllLikedSongPlaylistId = results.getInt("AllLikedSongPlaylistId");
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
    String deleteAllLikedSongPlaylist = "DELETE FROM deleteAllLikedSongPlaylist WHERE SongListID=?;";
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
