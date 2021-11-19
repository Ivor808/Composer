package Composer.servlet;

import Composer.dal.*;
import Composer.model.*;
import Composer.model.Song.GenreType;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/deletesong")
public class DeleteSongFromAllLikedSongsPlayList extends HttpServlet {

	protected SongDao songDao;
	
	@Override
	public void init() throws ServletException {
		 songDao = SongDao.getInstance();
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String songTitle = req.getParameter("SongTitle");
        if (songTitle == null || songTitle.trim().isEmpty()) {
            messages.put("success", "Invalid SongTitle or SongTitle");
        } else {
        	String artistName = req.getParameter("ArtistName");
        	int artistId = Integer.parseInt(req.getParameter("ArtistID"));
        	int releaseYear = Integer.parseInt(req.getParameter("ReleaseYear"));
        	String genreType = req.getParameter("GenreType");
        	
        	try {
        		Song song = new Song(songTitle, artistName, artistId, releaseYear, GenreType.valueOf(genreType));
        		song = songDao.create(song);
        		messages.put("success", "Successfully deleted " + songTitle);
        	} catch (SQLException e) {
        		e.printStackTrace();
        		throw new IOException(e);
        	}
        }
        req.getRequestDispatcher("/DeleteSongFromAllLikedSongsPlayList.jsp").forward(req, resp);
    }
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/DeleteSongFromAllLikedSongsPlayList.jsp").forward(req, resp);
	}
	

}
