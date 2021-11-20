package Composer.servlet;

import Composer.dal.*;
import Composer.model.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.annotation.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet
public class CreateAllLikedSongsPlayList extends HttpServlet {
	
	protected AllLikedSongPlaylistDao playListDao;
	protected UserDao userDao;

	@Override
	public void init() throws ServletException {
		
		playListDao = AllLikedSongPlaylistDao.getInstance();
		userDao = UserDao.getInstance();
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        
          
        String userId = req.getParameter("userId");
        if (userId == null || userId.trim().isEmpty()) {
        	messages.put("success", "Please enter a valid UserId.");
        } else {
        	try {
        		int userIdInt = Integer.parseInt(userId);
        		User user = userDao.getUserByUserId(userIdInt);
        		if(user == null) {
        			messages.put("success", "UserId does not exist.");
        		} else {
        			AllLikedSongPlaylist playList = new AllLikedSongPlaylist(user);
        			playList = playListDao.create(playList);
        			messages.put("success", "Successfully created an AllLikedSongsPlaylist for userId " + userId);
        			req.setAttribute("playList", playList);
        		}
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        req.getRequestDispatcher("/CreateAllLikedSongsPlayList.jsp").forward(req, resp);
    }
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        //Just render the JSP.   
        req.getRequestDispatcher("/CreateAllLikedSongsPlayList.jsp").forward(req, resp);
	}
	
	

}
