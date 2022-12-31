package bean;

public class User {
	
	private int id;
	private String lastname, firstname, email, password;

	public User()
	{
		
	}
	
	public User(String lastname, String firstname, String email, String password)
	{
		this.setLastname(lastname);
		this.setFirstname(firstname);
		this.setEmail(email);
		this.setPassword(password);
	}

	public User(int id, String lastname, String firstname, String email, String password)
	{
		this(lastname, firstname, email, password);
		this.setId(id);
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
