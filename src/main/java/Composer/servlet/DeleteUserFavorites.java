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
public class DeleteUserFavorites extends HttpServlet {
	protected UserDao userDao;
	protected UserFavoritesDao favDao;

	@Override
	public void init() throws ServletException {
		userDao = UserDao.getInstance();
		favDao = UserFavoritesDao.getInstance();
	}
	
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);
        // Provide a title and render the JSP.
        messages.put("title", "Delete UserFavorites PlayList");        
        req.getRequestDispatcher("/DeleteUserFavorites.jsp").forward(req, resp);
	}
	
	@Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
        // Map for storing messages.
        Map<String, String> messages = new HashMap<String, String>();
        req.setAttribute("messages", messages);

        // Retrieve and validate name.
        String userId = req.getParameter("userId");
        if (userId  == null || userId.trim().isEmpty()) {
            messages.put("title", "Invalid UserId");
            messages.put("disableSubmit", "true");
        } else {
        	try {
        		int userIdInt = Integer.parseInt(userId);
    	        User user = userDao.getUserByUserId(userIdInt);
    	        if (user == null) {
    	        	messages.put("success", "UserId does not exist. No update to perform.");
    	        } else {
    	        	UserFavorites favorites = new UserFavorites(user);
		        	favorites = favDao.delete(favorites);
		        	// Update the message.
			        if (favorites == null) {
			            messages.put("success", "Successfully deleted this playlist");
			            messages.put("disableSubmit", "true");
			        } else {
			        	messages.put("success", "Failed to delete this playlist");
			        	messages.put("disableSubmit", "false");
			        }
    	        }	
        	} catch (SQLException e) {
				e.printStackTrace();
				throw new IOException(e);
	        }
        }
        req.getRequestDispatcher("/DeleteUserFavorites.jsp").forward(req, resp);
    }
        	

	

}
