package models;

/**
 * Modelo de Account
 * 
 * @author Fran Silva
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

	/**
	 * Obtiene el email de la cuenta
	 * 
	 * @return Devuelve el email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Obtiene la contraseña de la cuenta
	 * 
	 * @return Devuelve la contraseña
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Muestra la cuenta por pantalla
	 */
	@Override
	public String toString() {
		return "Account [email=" + email + ", password=" + password + "]";
	}

}
