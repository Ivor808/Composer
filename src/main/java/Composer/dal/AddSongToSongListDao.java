package dal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.*;

public class AddSongToSongListDao {
  protected ConnectionManager connectionManager;
  private static AddSongToSongListDao instance = null;

  protected AddSongToSongListDao() {
    connectionManager = new ConnectionManager();
  }

  public static AddSongToSongListDao getInstance() {
    if (instance == null) {
      instance = new AddSongToSongListDao();
    }
    return instance;
  }

  public AddSongToSongList create(AddSongToSongList addSongToSongList) throws SQLException {
    // can i read the db get the restaurnat info then create
    String insertAddSongToSongList = "INSERT INTO AddSongToSongList(SongID,SongListID) VALUES(?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertAddSongToSongList);
      insertStmt.setInt(1, addSongToSongList.getSong().getSongId());
      insertStmt.setInt(2, addSongToSongList.getSongList().getSongListId());
      insertStmt.executeUpdate();
      return addSongToSongList;
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
    }
  }
  public List<AddSongToSongList> getAddSongToSongListBySongId(int songId) throws SQLException {
    List<AddSongToSongList> addSongToSongLists= new ArrayList<>();
    String selectAddSongToSongList = "SELECT SongID,SongListID FROM AddSongToSongList WHERE SongId=?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectAddSongToSongList);
      selectStmt.setInt(1, songId);
      results = selectStmt.executeQuery();
      while (results.next()) {
        int SongListID = results.getInt("SongListID");
        SongListDao songListDao = SongListDao.getInstance();
        SongList songList=songListDao.getSongListBySongListId(SongListID);


        SongDao songDao = SongDao.getInstance();
        Song song = songDao.getSongById(songId);
        AddSongToSongList addSongToSongList = new AddSongToSongList(song, songList);
        addSongToSongLists.add(addSongToSongList);
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
    return addSongToSongLists;
  }

  public List<AddSongToSongList> getAddSongToSongListBySongListId(int SongListID) throws SQLException {
    List<AddSongToSongList> addSongToSongLists= new ArrayList<>();
    String selectAddSongToSongList = "SELECT SongID,SongListID FROM AddSongToSongList WHERE SongListID=?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectAddSongToSongList);
      selectStmt.setInt(1, SongListID);
      results = selectStmt.executeQuery();
      while (results.next()) {
        int songId = results.getInt("SongID");
        SongListDao songListDao = SongListDao.getInstance();
        SongList songList=songListDao.getSongListBySongListId(SongListID);
        SongDao songDao = SongDao.getInstance();
        Song song = songDao.getSongById(songId);
        AddSongToSongList addSongToSongList = new AddSongToSongList(song, songList);
        addSongToSongLists.add(addSongToSongList);
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
    return addSongToSongLists;
  }

  public AddSongToSongList delete(AddSongToSongList addSongToSongList) throws SQLException {
    String deleteAddSongToSongList = "DELETE FROM AddSongToSongList WHERE SongID=? AND SongListID=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteAddSongToSongList);
      deleteStmt.setInt(1, addSongToSongList.getSong().getSongId());
      deleteStmt.setInt(2, addSongToSongList.getSongList().getSongListId());
      deleteStmt.executeUpdate();

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
