package edu.inclusiv.servlet;

import java.io.IOException;
import java.util.List;

import edu.inclusiv.model.bean.User;
import edu.inclusiv.model.dao.DaoFactory;
import edu.inclusiv.model.dao.UserImpDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	UserImpDAO userImpDAO;
	
    /**
     * Default constructor. 
     */
    public HomeServlet() {
    	
    }

    @Override
    public void init() throws ServletException {
    	DaoFactory daoFactory = DaoFactory.getInstance();
    	userImpDAO = daoFactory.getUserImpDAO();
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User> listeUser = userImpDAO.findAll();
		request.setAttribute("listeUser", listeUser);
		request.getRequestDispatcher("/pages/add_user.jsp").include(request, response);
		request.getRequestDispatcher("/pages/list_users.jsp").include(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User(0,
				request.getParameter("nom"),
				request.getParameter("prenom"),
				request.getParameter("mot_de_passe"));
		
		userImpDAO.save(user);
		doGet(request, response);
	}

}
