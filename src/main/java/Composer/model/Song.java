package Composer.model;

/**
 * Abstract class Restaurants has 3 concrete classes of restaurant
 */
public class Song {
    protected int SongId;
    protected String SongTitle;
    protected String ArtistName;
    protected int ArtistID;
    protected int ReleaseYear;
    protected GenreType GenreType;

    public enum GenreType {
	    ALTERNATIVE,
	    BLUES,
	    HIPHOP,
	    INDIEALT,
	    METAL,
	    POP,
	    ROCK,
	    R_AND_B
	    
	}
    
    public Song(int songId) {
    	this.SongId = songId;
    }
    public Song(String songTitle, String artistName, int artistID, int releaseYear, GenreType genreType) {
        this.SongTitle = songTitle;
        this.ArtistName = artistName;
        this.ArtistID = artistID;
        this.ReleaseYear = releaseYear;
        this.GenreType = genreType;
    }
    
    
    
    
    
    
	public Song(int songId, String songTitle, int releaseYear) {
		super();
		SongId = songId;
		SongTitle = songTitle;
		ReleaseYear = releaseYear;
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

    public GenreType getGenreType() {
        return this.GenreType;
    }

    public void setGenreType(GenreType genre) {
        this.GenreType = genre;
    }

}
