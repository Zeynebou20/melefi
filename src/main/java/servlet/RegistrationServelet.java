package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.User;
import form.UserForm;

/**
 * Servlet implementation class RegistrationServelet
 */
@WebServlet("/inscription")
public class RegistrationServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String SIGNUP_VIEW = "/WEB-INF/security/signup.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(SIGNUP_VIEW).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		UserForm form = new UserForm(request);
		
		request.setAttribute("status", form.Status());
		request.setAttribute("statusMessage", form.getStatusMessage());
		
		if (form.registration()) 
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
