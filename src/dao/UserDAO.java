package dao;

import java.util.ArrayList;

import models.Account;

public class UserDAO {

	public ArrayList<Account> usernameList = new ArrayList<Account>();

	public void showUsersConsole() {
		for (Account username : usernameList) {
			System.out.println(username);
		}
	}

	public void createUsername(Account user) {
		usernameList.add(user);
	}

	public boolean checkEmail(String email) {
		for (Account account : usernameList) {
			if (account.getEmail().equals(email)) {
				return true;
			}
		}
		return false;
	}

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

	public boolean checkRequirementsEmail(String emailField) {

		boolean noExists = checkEmail(emailField);
		boolean characterSpecial = false; // @
		boolean endDomain = false; // .com, .es y .net

		if (emailField.contains("@")) {
			characterSpecial = true;
		}

		if (emailField.endsWith(".com") || emailField.endsWith(".es") || emailField.endsWith(".net")) {
			endDomain = true;
		}

		if (!characterSpecial || !endDomain || noExists) {
			return false;
		} else {
			return true;
		}
	}

	public boolean checkRequirementsPassword(String passwordField) {

		boolean minimumCharacters = false;
		boolean containsUppercase = false;
		boolean containsLowercase = false;
		boolean containsDigit = false;
		boolean characterSpecial = false;

		if (passwordField.length() >= 6) {
			minimumCharacters = true;
			for (int i = 0; i < passwordField.length(); i++) {
				if (Character.isUpperCase(passwordField.charAt(i))) {
					containsUppercase = true;
				}

				if (Character.isLowerCase(passwordField.charAt(i))) {
					containsLowercase = true;
				}

				if (Character.isDigit(passwordField.charAt(i))) {
					containsDigit = true;
				}

				// Characters Specials
				// ºª!"·$%&/()=\|#@
			}

			if (passwordField.contains("º") || passwordField.contains("ª") || passwordField.contains("!")
					|| passwordField.contains("\"") || passwordField.contains(".") || passwordField.contains("·")
					|| passwordField.contains("$") || passwordField.contains("%") || passwordField.contains("&")
					|| passwordField.contains("/") || passwordField.contains("(") || passwordField.contains("(")
					|| passwordField.contains("=") || passwordField.contains("\"") || passwordField.contains("|")
					|| passwordField.contains("#") || passwordField.contains("@")) {
				characterSpecial = true;
			}
		} else {
			minimumCharacters = false;
		}

		if (minimumCharacters && containsUppercase && containsLowercase && containsDigit && characterSpecial) {
			return true;
		}
		return false;
	}

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