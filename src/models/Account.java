package models;

/**
 * Modelo de Account
 * 
 * @author alumno
 *
 */
public class Account {

	private String email;
	private String password;

	/**
	 * Creación de una cuenta
	 * 
	 * @param email    Email
	 * @param password Contraseña
	 */
	public Account(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
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
