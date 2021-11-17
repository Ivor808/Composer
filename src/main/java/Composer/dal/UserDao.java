package Composer.dal;

import Composer.model.*;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    protected ConnectionManager connectionManager;
    private static UserDao instance = null;
    protected UserDao() {
        connectionManager = new ConnectionManager();
    }

    public static UserDao getInstance() {
        if (instance == null) {
            instance = new UserDao();
        }

        return instance;
    }

    public User create(User user) throws SQLException  {
        String insertUser = "INSERT INTO User(FirstName,LastName) VALUES(?,?);";
        Connection connection = null;
        PreparedStatement insertStmt = null;
        ResultSet resultKey = null;
        try {
            connection = connectionManager.getConnection();
            insertStmt = connection.prepareStatement(insertUser);

            insertStmt.setString(1, user.getFirstName());
            insertStmt.setString(2, user.getLastName());

            insertStmt.executeUpdate();

            resultKey = insertStmt.getGeneratedKeys();
            int userId = -1;
            if (resultKey.next()) {
                userId = resultKey.getInt(1);
            } else {
                throw new SQLException("Unable to retrieve auto-generated key.");
            }
            user.setUserId(userId);


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (insertStmt != null) {
                insertStmt.close();
            }
        }
        return user;
    }

    public User getUserByUserId(int userID) throws SQLException {
        String selectUser = "SELECT UserID,FirstName,LastName FROM User WHERE UserID=?;";
        Connection connection = null;
        PreparedStatement selectStmt = null;
        ResultSet results = null;

        try {
            connection = connectionManager.getConnection();
            selectStmt = connection.prepareStatement(selectUser);
            selectStmt.setInt(1, userID);

            results = selectStmt.executeQuery();

            if (results.next()) {
                int resultUserName = results.getInt("UserID");
                String firstName = results.getString("FirstName");
                String lastName = results.getString("LastName");
                User user = new User(resultUserName, firstName, lastName);
                return user;
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



    public User delete(User user) throws SQLException {
        String deleteUser = "DELETE FROM User WHERE UserID=?;";
        Connection connection = null;
        PreparedStatement deleteStmt = null;

        try {
            connection = connectionManager.getConnection();
            deleteStmt = connection.prepareStatement(deleteUser);
            deleteStmt.setInt(1, user.getUserId());
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
