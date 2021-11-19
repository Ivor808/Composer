package Composer.model;


public class AddSongToSongList {
  protected Song song;
  protected SongList songList;

  public AddSongToSongList(Song song, SongList songList) {
    this.song = song;
    this.songList = songList;
  }

  public Song getSong() {
    return song;
  }

  public void setSong(Song song) {
    this.song = song;
  }

  public SongList getSongList() {
    return songList;
  }

  public void setSongList(SongList songList) {
    this.songList = songList;
  }
}
