package Composer.servlet;

import Composer.dal.*;
import Composer.model.*;


import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet
public class ReadUserAllLikedSongsPlayList extends HttpServlet {
  protected AllLikedSongPlaylistDao allLikedSongPlaylistDao;

  @Override
  public void init() throws ServletException {
    allLikedSongPlaylistDao = AllLikedSongPlaylistDao.getInstance();
  }
  @Override
  // display the all liked song playlist
  public void doGet(HttpServletRequest req, HttpServletResponse resp)
	      throws ServletException, IOException {
	    // Map for storing messages.
	    Map<String, String> messages = new HashMap<String, String>();
	    req.setAttribute("messages", messages);
	    // get user's allikeplaylist form user name to playlist
	    List<AllLikedSongPlaylist> allLikedSongPlaylists = new ArrayList<AllLikedSongPlaylist>();
	    //List<BlogUsers> blogUsers = new ArrayList<BlogUsers>();

	    // Retrieve and validate name.
	    // firstname is retrieved from the URL query string.
	    String userIdString = req.getParameter("userid");

	      if (userIdString == null || userIdString.trim().isEmpty()) {
	        messages.put("title", "Invalid username.");
	      } else {
	        // Retrieve allikeplaylist, and store as a message.
	        try {
	          int userId = Integer.parseInt(userIdString);
	          // get user
	          UserDao userDao = UserDao.getInstance();
	          User user = userDao.getUserByUserId(userId);
	          // get user's playlist id
	          //getSongListByUserId
	          SongListDao songListDao = SongListDao.getInstance();
	          List<SongList> songLists = songListDao.getSongListByUserId(userId);
	          for(SongList songList: songLists) {
	            int songListId= songList.getSongListId();
	            AllLikedSongPlaylist allLikedSongPlaylist = allLikedSongPlaylistDao.getAllLikedSongPlaylistById(songListId);
	            allLikedSongPlaylists.add(allLikedSongPlaylist);
	          }
	        } catch (SQLException e) {
	          e.printStackTrace();
	          throw new IOException(e);
	        }
	        messages.put("title", "Displaying results for " + userIdString);
	        // Save the previous search term, so it can be used as the default
	        // in the input box when rendering FindUsers.jsp.
	      }
	    req.setAttribute("allLikedSongPlaylists", allLikedSongPlaylists);

	    req.getRequestDispatcher("/ReadUserAllLikedSongsPlayList.jsp").forward(req, resp);
	  }
  

}
