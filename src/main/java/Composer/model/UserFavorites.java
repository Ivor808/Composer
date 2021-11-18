package model;

public class UserFavorites extends SongList {


  public UserFavorites(int songListId, User userId) {
    super(songListId, userId);
  }

  public UserFavorites(User userId) {
    super(userId);
  }
}
