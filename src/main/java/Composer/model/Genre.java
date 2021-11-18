package model;
import java.util.concurrent.atomic.AtomicInteger;
/**
 * Abstract class Restaurants has 3 concrete classes of restaurant
 */
public class Genre {
    protected int GenreId;
    protected GenreType GenreType;
    protected static final AtomicInteger count = new AtomicInteger(0); 

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
    public Genre(GenreType genre) {
        this.GenreId = count.incrementAndGet(); ;
        this.GenreType = genre;
    }
    public Genre(int genreId, GenreType genre) {
        this.GenreId = genreId;
        this.GenreType = genre;
    }

    public int getGenreId() {
        return this.GenreId;
    }

    public void setGenrenId(int genreId) {
        this.GenreId = genreId;
    }

  
    public GenreType getGenreType() {
        return this.GenreType;
    }

    public void setGenreType(GenreType genre) {
        this.GenreType = genre;
    }

}
