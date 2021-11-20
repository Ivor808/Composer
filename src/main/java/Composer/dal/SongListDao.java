package Composer.dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Composer.model.SongList;
import Composer.model.User;

public class SongListDao {

  protected ConnectionManager connectionManager;

  private static SongListDao instance = null;

  protected SongListDao() {
    connectionManager = new ConnectionManager();
  }

  public static SongListDao getInstance() {
    if (instance == null) {
      instance = new SongListDao();
    }
    return instance;
  }

  public SongList create(SongList songList) throws SQLException {
    String insertSongList =
        "INSERT INTO SongList(UserId) " +
            "VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    ResultSet resultKey = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertSongList,
          Statement.RETURN_GENERATED_KEYS);
      insertStmt.setInt(1, songList.getUserId().getUserId());
      insertStmt.executeUpdate();
      resultKey = insertStmt.getGeneratedKeys();
      int songListId = -1;
      if (resultKey.next()) {
        songListId = resultKey.getInt(1);
      } else {
        throw new SQLException("Unable to retrieve auto-generated key.");
      }
      songList.setSongListId(songListId);
      return songList;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (insertStmt != null) {
        insertStmt.close();
      }
      if (resultKey != null) {
        resultKey.close();
      }
    }
  }

  public SongList getSongListBySongListId(int songListId) throws SQLException {
    String selectSongList =
        "SELECT SongListId, UserId " +
            "FROM SongList " +
            "WHERE SongListId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectSongList, Statement.RETURN_GENERATED_KEYS);
      selectStmt.setInt(1, songListId);
      results = selectStmt.executeQuery();
      UserDao userDao = UserDao.getInstance();
      if (results.next()) {
        int resultSongListId = results.getInt("songListId");
        int userId = results.getInt("userId");

        User user = userDao.getUserByUserId(userId);
        SongList songList = new SongList(resultSongListId, user);
        return songList;
      }
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (selectStmt != null) {
        selectStmt.close();
      }
      if (results != null) {
        results.close();
      }
    }
    return null;
  }
  
 public List<SongList> getSongListByUserId(int UserId) throws SQLException {
	  String selectSongList =
	      "SELECT SongListId, UserId " +
	          "FROM SongList " +
	          "WHERE UserId=?;";
	  Connection connection = null;
	  PreparedStatement selectStmt = null;
	  ResultSet results = null;
	  List<SongList> songLists = new ArrayList<>();
	  try {
	    connection = connectionManager.getConnection();
	    selectStmt = connection.prepareStatement(selectSongList);
	    selectStmt.setInt(1, UserId);
	    results = selectStmt.executeQuery();
	    UserDao userDao = UserDao.getInstance();
	    while (results.next()) {
	      int resultSongListId = results.getInt("SongListId");
	      int userId = results.getInt("UserId");
	      User user = userDao.getUserByUserId(userId);
	      SongList songList = new SongList(resultSongListId, user);
	      songLists.add(songList);
	    }
	  } catch (SQLException e) {
	    e.printStackTrace();
	    throw e;
	  } finally {
	    if (connection != null) {
	      connection.close();
	    }
	    if (selectStmt != null) {
	      selectStmt.close();
	    }
	    if (results != null) {
	      results.close();
	    }
	  }
	  return songLists;
	}
  
  

  public SongList delete(SongList songList) throws SQLException {
    String deleteSongList = "DELETE FROM SongList WHERE SongListId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteSongList);
      deleteStmt.setInt(1, songList.getSongListId());
      deleteStmt.executeUpdate();
      return null;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if (connection != null) {
        connection.close();
      }
      if (deleteStmt != null) {
        deleteStmt.close();
      }
    }
  }
}
