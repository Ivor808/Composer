package Composer.model;

public class AllLikedSongPlaylist extends SongList {


  public AllLikedSongPlaylist(int songListId, User userId) {
    super(songListId, userId);

  }

  public AllLikedSongPlaylist(User userId) {
    super(userId);

  }

  public AllLikedSongPlaylist(int songListId) {
    super(songListId);
  }

}
