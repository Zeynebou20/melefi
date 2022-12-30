package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/")
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SIGNIN_VIEW = "/WEB-INF/security/signin.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		getServletContext().getRequestDispatcher(SIGNIN_VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		
		if ("".equals(login) || "".equals(password))
		{
			request.setAttribute("message", "Informations incorrectes");
			response.sendRedirect("connexion");
		}
		else
		{
			User user = UserDao.getUser(login, password);
		}
	}

}
