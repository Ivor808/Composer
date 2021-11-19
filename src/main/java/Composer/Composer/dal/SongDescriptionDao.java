package Composer.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Composer.model.SongDescription;

public class SongDescriptionDao {

  protected ConnectionManager connectionManager;

  // Single pattern: instantiation is limited to one object.
  private static SongDescriptionDao instance = null;
  protected SongDescriptionDao() {
    connectionManager = new ConnectionManager();
  }
  public static SongDescriptionDao getInstance() {
    if(instance == null) {
      instance = new SongDescriptionDao();
    }
    return instance;
  }

  public SongDescription create(SongDescription sd) throws SQLException {
    String insertSD = "Insert into songdescription(danceability,energy,valence,tempo,loudness,acousticness,instrumentalness,liveness,speechiness,explicit,mode,duration,popularity,songid values(?,?,?,?,?,?,?,?,?,?,?,?,?,?";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertSD);
      // PreparedStatement allows us to substitute specific types into the query template.
      // For an overview, see:
      // http://docs.oracle.com/javase/tutorial/jdbc/basics/prepared.html.
      // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
      // For nullable fields, you can check the property first and then call setNull()
      // as applicable.
      insertStmt.setDouble(1, sd.getDanceability());
      insertStmt.setDouble(2,sd.getEnergy());
      insertStmt.setDouble(3, sd.getValence());
      insertStmt.setDouble(4, sd.getTempo());
      insertStmt.setDouble(5, sd.getLoudness());
      insertStmt.setDouble(6, sd.getAcousticness());
      insertStmt.setDouble(7, sd.getInstrumentalness());
      insertStmt.setDouble(8, sd.getInstrumentalness());
      insertStmt.setDouble(9, sd.getLiveness());
      insertStmt.setDouble(10, sd.getSpeechiness());
      insertStmt.setDouble(11, sd.getExplicit());
      insertStmt.setDouble(12, sd.getMode());
      insertStmt.setInt(13, sd.getDuration());
      insertStmt.setDouble(14, sd.getPopularity());
      insertStmt.setInt(15, sd.getSongId());
      // Note that we call executeUpdate(). This is used for a INSERT/UPDATE/DELETE
      // statements, and it returns an int for the row counts affected (or 0 if the
      // statement returns nothing). For more information, see:
      // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
      // I'll leave it as an exercise for you to write UPDATE/DELETE methods.
      insertStmt.executeUpdate();

      // Note 1: if this was an UPDATE statement, then the person fields should be
      // updated before returning to the caller.
      // Note 2: there are no auto-generated keys, so no update to perform on the
      // input param person.
      return sd;
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

  public SongDescription getSongDescriptionBySongId(Integer songId) throws SQLException {
    String selectSongDescription = "Select danceability,energy,valence,tempo,loudness,acousticness,instrumentalness,liveness,speechiness,explicit,mode,duration,popularity,songid from songdescription where songid=?";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectSongDescription);
      selectStmt.setInt(1, songId);
      // Note that we call executeQuery(). This is used for a SELECT statement
      // because it returns a result set. For more information, see:
      // http://docs.oracle.com/javase/7/docs/api/java/sql/PreparedStatement.html
      // http://docs.oracle.com/javase/7/docs/api/java/sql/ResultSet.html
      results = selectStmt.executeQuery();
      // You can iterate the result set (although the example below only retrieves
      // the first record). The cursor is initially positioned before the row.
      // Furthermore, you can retrieve fields by name and by type.
      if(results.next()) {
        Double danceability =results.getDouble("danceability");
        Double energy = results.getDouble("energy");
        Double valence = results.getDouble("valence");
        Double tempo = results.getDouble("tempo");
        Double loudness = results.getDouble("loudness");
        Double acousticness = results.getDouble("acousticness");
        Double instrumentalness = results.getDouble("instrumentalness");
        Double liveness = results.getDouble("liveness");
        Double speechiness = results.getDouble("speechiness");
        Double explicit = results.getDouble("explicit");
        Double mode  =  results.getDouble("mode");
        Integer duration = results.getInt("duration");
        Double popularity = results.getDouble("popularity");
        Integer resultSongId = results.getInt("songid");
        SongDescription sd = new SongDescription(danceability,energy,valence,tempo,loudness,acousticness,instrumentalness,liveness,speechiness,explicit,mode,duration,popularity,resultSongId);
        return sd;
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

  public SongDescription updateEnergy(SongDescription sd,Double energy) throws SQLException {
    String updateSD = "UPDATE songdescription SET energy=? WHERE songid=?;";
    Connection connection = null;
    PreparedStatement updateStmt = null;
    try {
      connection = connectionManager.getConnection();
      updateStmt = connection.prepareStatement(updateSD);
      updateStmt.setDouble(1, energy);
      updateStmt.setInt(2, sd.getSongId());
      updateStmt.executeUpdate();

      // Update the company param before returning to the caller.
      sd.setEnergy(energy);
      return sd;
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

  public SongDescription deleteSongDescription(SongDescription sd) throws SQLException {
    String deleteSongDescription = "DELETE FROM songdescription WHERE songid=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteSongDescription);
      deleteStmt.setInt(1, sd.getSongId());
      deleteStmt.executeUpdate();

      // Return null so the caller can no longer operate on the Company instance.
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
