package dao;

import java.util.ArrayList;

import models.Account;

/**
 * Gestión de los usuarios en la base de datos
 * 
 * @author alumno
 *
 */
public class UserDAO {

	public ArrayList<Account> usernameList = new ArrayList<Account>();

	/**
	 * Muestra los usuarios por la consola
	 */
	public void showUsersConsole() {
		for (Account username : usernameList) {
			System.out.println(username);
		}
	}

	/**
	 * Crea un usuario
	 * 
	 * @param user Usuario
	 */
	public void createUsername(Account user) {
		usernameList.add(user);
	}

	/**
	 * Comprueba si el email existe
	 * 
	 * @param email Email
	 * @return Devuelve true si existe
	 */
	public boolean existsEmail(String email) {
		for (Account account : usernameList) {
			if (account.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprueba si el usuario puede iniciar sesión
	 * 
	 * @param usernameField Nombre de usuario
	 * @param passwordField Password del usuario
	 * @return Devuelve true si puede iniciar sesión
	 */
	public boolean login(String usernameField, String passwordField) {
		if (usernameList.isEmpty()) {
			return false;
		} else {
			for (Account account : usernameList) {
				if (usernameField.equalsIgnoreCase(account.getEmail())) {
					if (passwordField.equals(account.getPassword())) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Comprueba si cumple los requisitos
	 * 
	 * Requisitios: - Contener @ y un Dominio
	 * 
	 * @param emailField Nombre del email
	 * @return Devuelve true si no cumple los requisitos
	 */
	public boolean hasEmailRequirements(String emailField) {
		boolean atCharacter = emailField.contains("@"); // @
		boolean endDomain = emailField.endsWith(".com") || emailField.endsWith(".es") || emailField.endsWith(".net");

		if (atCharacter && endDomain) {
			return true;
		}

		return false;
	}

	/**
	 * Comprueba si la contraseña es mayor de 6 carácteres
	 * 
	 * @param text Texto
	 * @return Devuelve true si tiene más carácteres
	 */
	public boolean checkminiumCharacters(String text) {
		if (text.length() >= 6) {
			return true;
		}

		return false;
	}

	/**
	 * Comprueba si contiene mayúsculas
	 * 
	 * @param text Texto
	 * @return Devuelve true si contiene
	 */
	public boolean checkConstainsUppercase(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (Character.isUpperCase(text.charAt(i))) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Comprueba si contiene minúsculas
	 * 
	 * @param text Texto
	 * @return Devuelve true si contiene
	 */
	public boolean checkContainsLowercase(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (Character.isLowerCase(text.charAt(i))) {
				return true;
			}
		}
		return false;

	}

	/**
	 * Comprueba si contiene un número
	 * 
	 * @param text Texto
	 * @return Devuelve true si contiene
	 */
	public boolean checkContainsDigit(String text) {
		for (int i = 0; i < text.length(); i++) {
			if (Character.isDigit(text.charAt(i))) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprueba si contiene un carácter especial
	 * 
	 * @param text Texto
	 * @return Devuelve true si contiene
	 */
	public boolean checkContainsCharacterSpecial(String text) {

		if (text.contains("º") || text.contains("ª") || text.contains("!") || text.contains("\"") || text.contains(".")
				|| text.contains("·") || text.contains("$") || text.contains("%") || text.contains("&")
				|| text.contains("/") || text.contains("(") || text.contains("(") || text.contains("=")
				|| text.contains("\"") || text.contains("|") || text.contains("#") || text.contains("@")) {
			return true;
		}
		return false;
	}

	public boolean checkRequirementsPassword(String passwordField) {
		boolean minimumCharacters = checkminiumCharacters(passwordField);
		boolean containsUppercase = checkConstainsUppercase(passwordField);
		boolean containsLowercase = checkContainsLowercase(passwordField);
		boolean containsDigit = checkContainsDigit(passwordField);
		boolean characterSpecial = checkContainsCharacterSpecial(passwordField);

		if (minimumCharacters && containsUppercase && containsLowercase && containsDigit && characterSpecial) {
			return true;
		}
		return false;
	}

	/**
	 * Comprueba si puede registrar un usuario
	 * 
	 * @param emailField    Email
	 * @param passwordField Password
	 * @return Devuelve true si se ha creado
	 */
	public boolean register(String emailField, String passwordField) {
		for (Account username : usernameList) {
			if (emailField.equalsIgnoreCase(username.getEmail())) {
				if (passwordField.equals(username.getPassword())) {
					createUsername(new Account(emailField, passwordField));
					return true;
				}
			}
		}
		return false;
	}
}
