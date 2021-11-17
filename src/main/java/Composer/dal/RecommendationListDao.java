package Composer.dal;

import Composer.model.RecommendationList;
import Composer.model.SongList;
import Composer.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RecommendationListDao extends SongListDao {

  private static RecommendationListDao instance = null;
  protected RecommendationListDao() {
    super();
  }
  public static RecommendationListDao getInstance() {
    if(instance == null) {
      instance = new RecommendationListDao();
    }
    return instance;
  }

  public RecommendationList create(RecommendationList recommendationList) throws SQLException {

    SongList res = create(
        new SongList(recommendationList.getSongListId(), recommendationList.getUserId()));
    recommendationList.setSongListId(res.getSongListId());
    String insertRecommendationList = "INSERT INTO RecommendationList(SongListId,ListName,RecommendationListDescription) VALUES(?,?,?);";
    Connection connection = null;
    PreparedStatement insertStmt = null;
    try {
      connection = connectionManager.getConnection();
      insertStmt = connection.prepareStatement(insertRecommendationList);
      insertStmt.setInt(1, recommendationList.getSongListId());
      insertStmt.setString(2, recommendationList.getListName());
      insertStmt.setString(3, recommendationList.getRecommendationListDescription());
      insertStmt.executeUpdate();
      return recommendationList;
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

    public RecommendationList getRecommendationListById(int RecommendationListId) throws SQLException {
      String selectRecommendationList =
          "SELECT RecommendationList.SongListId AS RecommendationListId, UserId, ListName, RecommendationListDescription " +
              "FROM RecommendationList INNER JOIN SongList " +
              "  ON RecommendationList.SongListId = SongList.SongListId " +
              "WHERE RecommendationList.SongList=?;";
      Connection connection = null;
      PreparedStatement selectStmt = null;
      ResultSet results = null;
      try {
        connection = connectionManager.getConnection();
        selectStmt = connection.prepareStatement(selectRecommendationList);
        selectStmt.setInt(1, RecommendationListId);
        results = selectStmt.executeQuery();
        UserDao userDao = UserDao.getInstance();
        if(results.next()) {
          int resultRecommendationListId = results.getInt("RecommendationListId");
          int userId = results.getInt("UserId");
          User user = userDao.getUserByUserId(userId);

          String listName = results.getString("ListName");
          String recommendationListDescription= results.getString("RecommendationListDescription");

          RecommendationList recommendationList = new RecommendationList(resultRecommendationListId, user, listName, recommendationListDescription);
          return recommendationList;
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

  public RecommendationList delete(RecommendationList recommendationList) throws SQLException {
    String deleteRecommendationList = "DELETE FROM RecommendationList WHERE SongListId=?;";
    Connection connection = null;
    PreparedStatement deleteStmt = null;
    try {
      connection = connectionManager.getConnection();
      deleteStmt = connection.prepareStatement(deleteRecommendationList);
      deleteStmt.setInt(1, recommendationList.getSongListId());
      deleteStmt.executeUpdate();
      super.delete(recommendationList);

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
