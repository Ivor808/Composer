package model;

import Composer.model.SongList;
import blog.model.Song;

public class AddSongToSongList {
  protected blog.model.Song song;
  protected Composer.model.SongList songList;

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
