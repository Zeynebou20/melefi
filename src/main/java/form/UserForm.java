package form;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.User;
import dao.UserDao;

public class UserForm 
{
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	
	private static final String ERROR_MESSAGE = "Informations incorrectes";
	private static final String SUCCESS_MESSAGE = "Connexion reussie";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez renseigner ce champ";
	
	private HttpServletRequest request;
	private Map<String, String> errors;
	private User user;
	private boolean status;
	private String statusMessage;

	public UserForm(HttpServletRequest request)
	{
		this.request = request;
		this.status = false;
		this.statusMessage = ERROR_MESSAGE;
		this.errors = new HashMap<String, String>();
	}

	public boolean login() 
	{
		String email = this.getParameter(EMAIL);
		String password = this.getParameter(PASSWORD);
		
		this.inputsValidation(EMAIL, PASSWORD);

		if (this.errors.isEmpty()) 
		{	
			this.user = UserDao.getUser(email, password);
			if (null != this.user) {
				this.statusMessage = SUCCESS_MESSAGE;
				this.status = true;
			}
		}

		return this.status;
	}
 
	public String getParameter(String parameter)
	{
		String value = this.request.getParameter(parameter);
		
		return (value == null || value.trim().isEmpty()) ? null : value.trim();
	}

	public void inputsValidation(String...inputs)
	{
		for (String input : inputs) {
			if (this.getParameter(input) == null) 
			{
				errors.put(input, EMPTY_FIELD_ERROR_MESSAGE);	
			}
		}
	}

	public User getUser() 
	{
		return user;
	}

	public boolean Status()
	{
		return status;
	}

	public String getStatusMessage() 
	{
		return statusMessage;	
	}

	public Map<String, String> getErrors()
	{
		return errors;
	}

}
