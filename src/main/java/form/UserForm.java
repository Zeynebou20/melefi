package form;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import bean.User;
import dao.UserDao;
import service.PBKDF2Hash;

public class UserForm 
{

	private static final String LASTNAME = "lastname";
	private static final String FIRSTNAME = "firstname";
	private static final String EMAIL = "email";
	private static final String PASSWORD = "password";
	private static final String PASSWORD_CONFIRM = "password_confirm";
	
	
	private static final String ERROR_MESSAGE = "Informations incorrectes";
	private static final String SUCCESS_MESSAGE = "Connexion reussie";
	private static final String EMPTY_FIELD_ERROR_MESSAGE = "Vous devez renseigner ce champ";
	private static final String PASSWORD_CONFIRMATION_FAILED = "Veuillez saisir des mots de passe identiques";
	
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
		
		PBKDF2Hash hash = new PBKDF2Hash();
		
		this.inputsValidation(EMAIL, PASSWORD);

		if (this.errors.isEmpty()) 
		{	
			this.user = UserDao.getUser(email);
			
			try {
				if (null != this.user && hash.validatePassword(password, this.user.getPassword())) {
					this.statusMessage = SUCCESS_MESSAGE;
					this.status = true;
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvalidKeySpecException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return this.status;
	}
	
	public boolean registration() 
	{
		String lastname = this.getParameter(LASTNAME);
		String firstname = this.getParameter(FIRSTNAME);
		String email = this.getParameter(EMAIL);
		String password = this.getParameter(PASSWORD);
		String password_confirm = this.getParameter(PASSWORD_CONFIRM);
		
		PBKDF2Hash hash = new PBKDF2Hash();
		
		this.inputsValidation(LASTNAME, FIRSTNAME, EMAIL, PASSWORD, PASSWORD_CONFIRM);
		this.passwordValidation();
		
		try {
			password = hash.generateStorngPasswordHash(password);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (this.errors.isEmpty()) 
		{	
			this.user = new User(lastname, firstname, email, password);
			this.status = UserDao.add(user);
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
	
	public void passwordValidation()
	{
		String password = this.getParameter(PASSWORD);
		String passwordConfirm = this.getParameter(PASSWORD_CONFIRM);
		
		if (password != null && !password.equals(passwordConfirm)) 
		{
			errors.put(PASSWORD, PASSWORD_CONFIRMATION_FAILED);
			errors.put(PASSWORD_CONFIRM, PASSWORD_CONFIRMATION_FAILED);	
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
