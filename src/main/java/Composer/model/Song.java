package blog.model;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Abstract class Restaurants has 3 concrete classes of restaurant
 */
public class Song {
    protected int SongId;
    protected String SongTitle;
    protected String ArtistName;
    protected int ArtistID;
    protected int ReleaseYear;
    protected int GenreID;
    protected static final AtomicInteger count = new AtomicInteger(0); 

    public Song(int songId,String songTitle, String artistName, int artistID, int releaseYear, int genreID) {
    	this.SongId = songId;
        this.SongTitle = songTitle;
        this.ArtistName = artistName;
        this.ArtistID = artistID;
        this.ReleaseYear = releaseYear;
        this.GenreID = genreID;
    }
    public Song(String songTitle, String artistName, int artistID, int releaseYear, int genreID) {
    	this.SongId = count.incrementAndGet(); 
        this.SongTitle = songTitle;
        this.ArtistName = artistName;
        this.ArtistID = artistID;
        this.ReleaseYear = releaseYear;
        this.GenreID = genreID;
    }

    public int getSongId() {
        return this.SongId;
    }

    public void setSongId(int songId) {
        this.SongId = songId;
    }

    public String getSongTitle() {
        return this.SongTitle;
    }

    public void setSongtitle(String songTitle) {
        this.SongTitle = songTitle;
    }

    public String getArtistName() {
        return this.ArtistName;
    }

    public void setArtistName(String artistName) {
        this.ArtistName = artistName;
    }

    public int getArtistID() {
        return this.ArtistID;
    }

    public void setArtistID(int artistID) {
        this.ArtistID = artistID;
    }

    public int getReleaseYear() {
        return ReleaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.ReleaseYear = releaseYear;
    }




    public int getGenreID() {
        return this.GenreID;
    }

    public void setGenreID(int genreID) {
        this.GenreID = genreID;
    }

}
