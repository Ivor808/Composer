package Composer.model;

public class SongList {
  protected int songListId;
  protected User userId;

  public SongList(int songListId, User userId) {
    this.songListId = songListId;
    this.userId = userId;
  }

  public SongList(int songListId) {
    this.songListId = songListId;
  }

  public SongList(User userId) {
    this.userId = userId;
  }

  public int getSongListId() {
    return songListId;
  }

  public void setSongListId(int songListId) {
    this.songListId = songListId;
  }

  public User getUserId() {
    return userId;
  }

  public void setUserId(User userId) {
    this.userId = userId;
  }
}
