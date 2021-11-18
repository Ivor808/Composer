package dal;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import model.CreditCards;
import model.User;

public class CreditCardsDao {
    protected ConnectionManager connectionManager;
    private static CreditCardsDao instance = null;
    protected CreditCardsDao() {
        connectionManager = new ConnectionManager();
    }


    public static CreditCardsDao getInstance(){
        if (instance == null) {
            instance = new CreditCardsDao();
        }
        return instance;
    }
    public CreditCards create(CreditCards creditCard) throws SQLException {
        String insertCreditCards =
                "INSERT INTO CreditCards(CardNumber,Expiration,UserID) " +
                        "VALUES(?,?,?);";
        Connection c = null;
        PreparedStatement insertStmt = null;

        try {
            c = connectionManager.getConnection();
            insertStmt = c.prepareStatement(insertCreditCards);
            insertStmt.setLong(1, creditCard.getCardNumber());
            insertStmt.setTimestamp(2, new Timestamp(creditCard.getExpiration().getTime()));
            insertStmt.setInt(3, creditCard.getUser().getUserId());

            insertStmt.executeUpdate();
            return creditCard;
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

        public CreditCards getCreditCardByCardNumber(long cardNumber) throws SQLException {
            String selectCard = "SELECT CardNumber,Expiration,UserID FROM CreditCards WHERE CardNumber=?;";
            Connection connection = null;
            PreparedStatement selectStmt = null;
            ResultSet results = null;

            try {
                connection = connectionManager.getConnection();
                selectStmt = connection.prepareStatement(selectCard);
                selectStmt.setLong(1, cardNumber);


                results = selectStmt.executeQuery();

                UserDao userDao = UserDao.getInstance();

                if (results.next()) {
                    Long num = results.getLong("CardNumber");
                    Timestamp exp = new Timestamp(results.getTimestamp("Expiration").getTime());
                    int userId = results.getInt("UserID");
                    User user = userDao.getUserByUserId(userId);
                    CreditCards card = new CreditCards(num, exp, user);
                    return card;
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

        public CreditCards delete(CreditCards creditCard) throws SQLException {
            String deleteCard = "DELETE FROM CreditCards WHERE CardNumber=?;";
            Connection connection = null;
            PreparedStatement deleteStmt = null;
            try {
                connection = connectionManager.getConnection();
                deleteStmt = connection.prepareStatement(deleteCard);
                deleteStmt.setLong(1, creditCard.getCardNumber());
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
