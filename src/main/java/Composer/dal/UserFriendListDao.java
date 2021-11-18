package Composer.dal;

import Composer.model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class UserFriendListDao {
    protected ConnectionManager connectionManager;
    private static UserFriendListDao instance = null;
    protected UserFriendListDao() {
        connectionManager = new ConnectionManager();
    }

    public static UserFriendListDao getInstance(){
        if (instance == null) {
            instance = new UserFriendListDao();
        }
        return instance;
    }

    public UserFriendList create(UserFriendList userFriendList) throws SQLException {
        String insertUserFriendList =
                "INSERT INTO userfriendlist(UserId,FriendId) " +
                        "VALUES(?,?);";
        Connection c = null;
        PreparedStatement insertStmt = null;

        try {
            c = connectionManager.getConnection();
            insertStmt = c.prepareStatement(insertUserFriendList);
            insertStmt.setInt(1, userFriendList.getUser().getUserId());
            insertStmt.setInt(2, userFriendList.getFriend().getUserId());

            insertStmt.executeUpdate();
            return userFriendList;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if (c != null) {
                c.close();
            }
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
    }

    public UserFriendList getUserFriendListByID(int friendListID) throws SQLException {
        String selectFriendList = "SELECT userFriendListID,UserID,FriendID FROM userfriendlist WHERE userFriendListID=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectFriendList);
            selectStmt.setInt(1, friendListID);
            results = selectStmt.executeQuery();

            UserDao userDao = UserDao.getInstance();
            UserDao friendDao = UserDao.getInstance();

            if (results.next()) {
                int resultfriendListID = results.getInt("userFriendListID");
                int userId = results.getInt("UserID");
                int friendID = results.getInt("FriendID");
                User user = userDao.getUserByUserId(userId);
                User friend = friendDao.getUserByUserId(friendID);
                UserFriendList friendList = new UserFriendList(resultfriendListID, user, friend);
                return friendList;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
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

    public List<UserFriendList> getUserFriendListByUserID(int userID) throws SQLException {
        List<UserFriendList> userFriendList = new ArrayList<UserFriendList>();
        String selectFriendList = "SELECT userFriendListID,UserID,FriendID FROM userfriendlist WHERE userID=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectFriendList);
            selectStmt.setInt(1, userID);
            results = selectStmt.executeQuery();

            UserDao userDao = UserDao.getInstance();
            UserDao friendDao = UserDao.getInstance();

            if (results.next()) {
                int friendListID = results.getInt("userFriendListID");
                int userId = results.getInt("UserID");
                int friendID = results.getInt("FriendID");
                User user = userDao.getUserByUserId(userId);
                User friend = friendDao.getUserByUserId(friendID);
                UserFriendList friendList = new UserFriendList(friendListID, user, friend);
                userFriendList.add(friendList);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        } finally {
            if(connection != null) {
                connection.close();
            }
            if (selectStmt != null) {
                selectStmt.close();
            }
            if (results != null) {
                results.close();
            }
        }
        return userFriendList;
    }

    
    public UserFriendList delete(UserFriendList userFriendList) throws SQLException {
        String deleteFriendList = "DELETE FROM UserFriendList WHERE userFriendListId=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;
        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteFriendList);
            deleteStmt.setint(1, UserFriendList.getUserFriendListId());
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

}
