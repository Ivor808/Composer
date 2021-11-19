package Composer.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Composer.model.Song;




public class SongDao {
	protected ConnectionManager connectionManager;

    private static SongDao instance = null;

    protected SongDao() {
        connectionManager = new ConnectionManager();
    }

    public static SongDao getInstance() {
        if (instance == null) {
            instance = new SongDao();
        }
        return instance;
    }
    
    
    public Song create(Song song) throws SQLException {
        String insertSong =
                "INSERT INTO Song(SongTitle, ArtistName, ArtistID, ReleaseYear, GenreType" +
                        "VALUES(?,?,?,?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
		//ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertSong);
            //insertStmt.setInt(1, (song.getSongId()));
            insertStmt.setString(1, (song.getSongTitle()));
            insertStmt.setString(2, (song.getArtistName()));
            insertStmt.setInt(3, (song.getArtistID()));
            insertStmt.setInt(4, (song.getReleaseYear()));
            insertStmt.setString(5, (song.getGenreType().name()));
            insertStmt.executeUpdate();
    
            return song;
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
    
    public Song getSongById(int songId) throws SQLException {
        String selectSong = "SELECT SongId, SongTitle, ArtistName, ArtistID, ReleaseYear, GenreType FROM Song WHERE SongId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectSong);
            selectStmt.setInt(1, songId);
            results = selectStmt.executeQuery();
            if(results.next()) {
                int sonId = results.getInt("SongId");
                String title = results.getString("SongTitle");
                String name = results.getString("ArtistName");
                int id = results.getInt("ArtistID");
                int year = results.getInt("ReleaseYear");
                Song.GenreType gt = Song.GenreType.valueOf(results.getString("GenreType"));
                Song song = new Song(sonId, title, name, id, year, gt);
                return song;
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
    
    
    
    
    /**
     * This runs a DELETE statement.
     */
    public Song delete(Song song) throws SQLException {
        String deleteSong = "DELETE FROM Song WHERE SongTitle=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteSong);
            deleteStmt.setString(1, song.getSongTitle());
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
