package Composer.model;

public class User {
    protected int userId;
    protected String firstName;
    protected String lastName;
    protected UserFavorites userFavorite;

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, String firstName, String lastName, UserFavorites userFavorite) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userFavorite = userFavorite;
    }

    public User(String firstName, String lastName, UserFavorites userFavorite) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userFavorite = userFavorite;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public UserFavorites getUserFavorite() {
        return userFavorite;
    }

    public void setUserFavoriteId(UserFavorites userFavorite) {
        this.userFavorite = userFavorite;
    }
}
