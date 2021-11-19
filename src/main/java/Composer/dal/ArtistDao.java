package Composer.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Composer.model.Artist;

public class ArtistDao {

  protected ConnectionManager connectionManager;

  // Single pattern: instantiation is limited to one object.
  private static ArtistDao instance = null;
  protected ArtistDao() {
    connectionManager = new ConnectionManager();
  }
  public static ArtistDao getInstance() {
    if(instance == null) {
      instance = new ArtistDao();
    }
    return instance;
  }

  public Artist create(Artist artist) throws SQLException {
    String insertArtist = "INSERT INTO Artist(name) VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertArtist);

      insertStmt.setString(1, artist.getName());

      insertStmt.executeUpdate();

      return artist;
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

  public Artist getArtistByName(String name) throws SQLException {
    String selectArtist = "SELECT name FROM artist WHERE name=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectArtist);
      selectStmt.setString(1, name);
      results = selectStmt.executeQuery();
      if(results.next()) {
        String resultName = results.getString("name");
        Artist artist = new Artist(resultName);
        return artist;
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

  public Artist updateArtistName(Artist artist, String name) throws SQLException {
    String updateArtist = "UPDATE artist SET name=? WHERE name=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateArtist);
      updateStmt.setString(1, name);
      updateStmt.executeUpdate();

      artist.setName(name);
      return artist;
    } catch (SQLException e) {
      e.printStackTrace();
      throw e;
    } finally {
      if(connection != null) {
        connection.close();
      }
      if(updateStmt != null) {
        updateStmt.close();
      }
    }
  }

  public Artist delete(Artist artist) throws SQLException {
    String deleteArtist = "DELETE FROM artist WHERE name=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteArtist);
      deleteStmt.setString(1, artist.getName());
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
