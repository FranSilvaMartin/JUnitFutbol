package models;

public class Account {

	private String email;
	private String password;

	public Account(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getUsername() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + "]";
	}

}
