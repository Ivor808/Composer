package Composer.dal;

import Composer.model.LeastPlayedSongs;
import Composer.model.SongList;
import Composer.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LeastPlayedSongsDao extends SongListDao {
  private static LeastPlayedSongsDao instance = null;
  protected LeastPlayedSongsDao() {
    super();
  }
  public static LeastPlayedSongsDao getInstance() {
    if(instance == null) {
      instance = new LeastPlayedSongsDao();
    }
    return instance;
  }

  public LeastPlayedSongs create(LeastPlayedSongs leastPlayedSongs) throws SQLException {

    SongList res = create(new SongList(leastPlayedSongs.getSongListId(), leastPlayedSongs.getUserId()));
    leastPlayedSongs.setSongListId(res.getSongListId());
    String insertLeastPlayedSongs = "INSERT INTO LeastPlayedSongs(SongListId) VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertLeastPlayedSongs);
      insertStmt.setInt(1, leastPlayedSongs.getSongListId());
      insertStmt.executeUpdate();
      return leastPlayedSongs;
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

  public LeastPlayedSongs getLeastPlayedSongsById(int leastPlayedSongsId) throws SQLException {
    String selectLeastPlayedSongs =
        "SELECT LeastPlayedSongs.SongListId AS LeastPlayedSongsId " +
            "FROM LeastPlayedSongs INNER JOIN SongList " +
            "  ON LeastPlayedSongs.SongListId = SongList.SongListId " +
            "WHERE LeastPlayedSongs.LeastPlayedSongsId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectLeastPlayedSongs);
      selectStmt.setInt(1, leastPlayedSongsId);
      results = selectStmt.executeQuery();
      UserDao userDao = UserDao.getInstance();
      if(results.next()) {
        int resultLeastPlayedSongsId = results.getInt("SongListId");
        int userId = results.getInt("UserId");

        User user = userDao.getUserByUserId(userId);
        LeastPlayedSongs leastPlayedSongs = new LeastPlayedSongs(resultLeastPlayedSongsId, user);
        return leastPlayedSongs;
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

  public LeastPlayedSongs delete(LeastPlayedSongs leastPlayedSongs) throws SQLException {
    String deleteLeastPlayedSongs = "DELETE FROM deleteLeastPlayedSongs WHERE SongListId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteLeastPlayedSongs);
      deleteStmt.setInt(1, leastPlayedSongs.getSongListId());
      deleteStmt.executeUpdate();
      super.delete(leastPlayedSongs);

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