package Composer.model;

public class LeastPlayedSongs extends SongList {

  public LeastPlayedSongs(int songListId, User userId) {
    super(songListId, userId);
  }

  public LeastPlayedSongs(User userId) {
    super(userId);
  }

}
