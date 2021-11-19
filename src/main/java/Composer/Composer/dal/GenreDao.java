package Composer.dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Composer.model.Genre;


public class GenreDao {
	protected ConnectionManager connectionManager;

    private static GenreDao instance = null;

    protected GenreDao() {
        connectionManager = new ConnectionManager();
    }

    public static GenreDao getInstance() {
        if (instance == null) {
            instance = new GenreDao();
        }
        return instance;
    }
    
    
    public Genre create(Genre genre) throws SQLException {
        String insertSong =
                "INSERT INTO Genre(GenreType VALUES(?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
		//ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertSong);
            //insertStmt.setInt(1, (song.getSongId()));
            insertStmt.setString(1, (genre.getGenreType().name()));
            insertStmt.executeUpdate();
    
            return genre;
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
    
    public Genre getGenreById(int genreId) throws SQLException {
        String selectGenre = "SELECT GenreId, GenreType FROM Genre WHERE GenreId=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;
        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectGenre);
            selectStmt.setInt(1, genreId);
            results = selectStmt.executeQuery();
            if(results.next()) {
                int genId = results.getInt("GenreId");
                Genre.GenreType gt = Genre.GenreType.valueOf(results.getString("GenreType"));
                Genre genre = new Genre(genId, gt);
                return genre;
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
    
}
