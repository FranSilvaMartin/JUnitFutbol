package models;

public class Username {

	private String username;
	private String password;

	public Username(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "[username = " + username + ", password = " + password + "]";
	}

	
	
}
