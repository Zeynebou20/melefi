package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import dao.UserDao;
import form.UserForm;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet({"/connexion", "/deconnexion"})
public class AuthenticationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SIGNIN_VIEW = "/WEB-INF/security/signin.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getServletPath().equals("/connexion")) {
			getServletContext().getRequestDispatcher(SIGNIN_VIEW).forward(request, response);
		}
		else
		{
			HttpSession session = request.getSession();
			session.invalidate();
			response.sendRedirect("connexion");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		UserForm form = new UserForm(request);
		
		request.setAttribute("status", form.Status());
		request.setAttribute("statusMessage", form.getStatusMessage());
		
		if (form.login()) 
		{
			session.setAttribute("isConnected", true);
			session.setAttribute("user", form.getUser());
			response.sendRedirect("accueil");
		}
		else
		{
			request.setAttribute("user", form.getUser());
			request.setAttribute("errors", form.getErrors());
			this.doGet(request, response);
		}
		
	}

}
