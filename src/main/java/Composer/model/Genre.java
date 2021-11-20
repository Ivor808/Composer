package Composer.model;
/**
 * Abstract class Restaurants has 3 concrete classes of restaurant
 */
public class Genre {
    protected int GenreId;
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
    public Genre(GenreType genre) {
        this.GenreType = genre;
    }
    public Genre(int genreId) {
        this.GenreId = genreId;
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
