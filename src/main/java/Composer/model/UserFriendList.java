package Composer.model;

public class UserFriendList {
    protected int userFriendListId;
    protected User user;
    protected User friend;
    public UserFriendList(int userFriendListID) {
        this.userFriendListId = userFriendListID;
    }

    public UserFriendList(int userFriendListID, User user, User friend) {
        this.userFriendListId = userFriendListID;
        this.user = user;
        this.friend = friend;
    }

    public UserFriendList(User user, User friend) {
        this.user = user;
        this.friend = friend;
    }

    public int getUserFriendListId() {
        return userFriendListId;
    }

    public void setUserFriendListId(int userFriendListId) {
        this.userFriendListId = userFriendListId;
    }

    public User getUser() {
        return user;
    }

    public void setUserID(User user) {
        this.user = user;
    }

    public User getFriend() {
        return friend;
    }

    public void setFriendID(User friend) {
        this.friend = friend;
    }
}