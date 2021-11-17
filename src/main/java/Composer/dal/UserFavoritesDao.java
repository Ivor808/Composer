package Composer.dal;

import Composer.model.SongList;
import Composer.model.User;
import Composer.model.UserFavorites;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserFavoritesDao extends SongListDao {
  private static UserFavoritesDao instance = null;
  protected UserFavoritesDao() {
    super();
  }
  public static UserFavoritesDao getInstance() {
    if(instance == null) {
      instance = new UserFavoritesDao();
    }
    return instance;
  }

  public UserFavorites create(UserFavorites userFavorites) throws SQLException {

    SongList res = create(new SongList(userFavorites.getSongListId(), userFavorites.getUserId()));
    userFavorites.setSongListId(res.getSongListId());
    String insertUserFavorites = "INSERT INTO UserFavorites(SongListId) VALUES(?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertUserFavorites);
      insertStmt.setInt(1, userFavorites.getSongListId());
      insertStmt.executeUpdate();
      return userFavorites;
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

  public UserFavorites getUserFavoritesById(int userFavoritesId) throws SQLException {
    String selectUserFavorites =
        "SELECT UserFavorites.SongListId AS UserFavoritesId " +
            "FROM UserFavorites INNER JOIN SongList " +
            "  ON UserFavorites.SongListId = SongList.SongListId " +
            "WHERE UserFavorites.userFavoritesId=?;";
    Connection connection = null;
    PreparedStatement selectStmt = null;
    ResultSet results = null;
    try {
      connection = connectionManager.getConnection();
      selectStmt = connection.prepareStatement(selectUserFavorites);
      selectStmt.setInt(1, userFavoritesId);
      results = selectStmt.executeQuery();
      UserDao userDao = UserDao.getInstance();
      if(results.next()) {
        int resultUserFavoritesId = results.getInt("SongListId");
        int userId = results.getInt("UserId");

        User user = userDao.getUserByUserId(userId);
        UserFavorites userFavorites = new UserFavorites(resultUserFavoritesId, user);
        return userFavorites;
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

  public UserFavorites delete(UserFavorites userFavorites) throws SQLException {
    String deleteUserFavorites = "DELETE FROM deleteUserFavorites WHERE SongListId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteUserFavorites);
      deleteStmt.setInt(1, userFavorites.getSongListId());
      deleteStmt.executeUpdate();
      super.delete(userFavorites);

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
