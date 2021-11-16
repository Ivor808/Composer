package Composer.model;

public class User {
    protected int userId;
    protected String firstName;
    protected String lastName;
    protected UsersFavorites userFavorite;

    public User(int userId) {
        this.userId = userId;
    }

    public User(int userId, String firstName, String lastName, UsersFavorites userFavorite) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userFavorite = userFavorite;
    }

    public User(String firstName, String lastName, UsersFavorites userFavorite) {
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

    public UsersFavorites getUserFavorite() {
        return userFavorite;
    }

    public void setUserFavoriteId(UsersFavorites userFavorite) {
        this.userFavorite = userFavorite;
    }
}
