package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.UserDAO;
import models.Account;

/**
 * Conjunto de test para los usuarios usando JUnit
 * 
 * @author alumno
 * @see <a>https://junit.org/junit5/</a>
 */
class UserTest {

	private UserDAO userDAO;
	private Account account;
	private String email, invalidEmail, password, invalidPassword;

	@BeforeEach
	@Test
	void setupDefaults() {
		this.userDAO = new UserDAO();
		this.email = "email@gmail.com";
		this.password = "Password123!";
		this.invalidEmail = "asd";
		this.invalidPassword = "asd";
		this.account = new Account(email, password);

		this.userDAO.createUsername(account);
	}

	@BeforeEach
	@Test
	void existsEmail() {
		assertTrue(userDAO.existsEmail(email));
		assertFalse(userDAO.existsEmail(invalidEmail));
	}

	@Test
	void login() {
		assertTrue(userDAO.login(email, password));
		assertFalse(userDAO.login(invalidEmail, password));
		assertFalse(userDAO.login(email, invalidPassword));
	}

	@Test
	void checkRequirementsEmail() {
		assertTrue(userDAO.hasEmailRequirements(email));
		assertFalse(userDAO.hasEmailRequirements(invalidEmail));
	}

	@Test
	void checkminiumCharacters() {
		assertTrue(userDAO.checkminiumCharacters("123456"));
		assertFalse(userDAO.checkminiumCharacters("12345"));
	}

	@Test
	void checkConstainsUppercase() {
		assertTrue(userDAO.checkConstainsUppercase("Password"));
		assertFalse(userDAO.checkConstainsUppercase("password"));
	}

	@Test
	void checkContainsLowercase() {
		assertTrue(userDAO.checkContainsLowercase("password"));
		assertFalse(userDAO.checkContainsLowercase("PASSWORD"));
	}

	@Test
	void checkContainsDigit() {
		assertTrue(userDAO.checkContainsDigit("password1"));
		assertFalse(userDAO.checkContainsDigit("password"));
	}

	@Test
	void checkContainsCharacterSpecial() {
		assertTrue(userDAO.checkContainsCharacterSpecial("password$"));
		assertFalse(userDAO.checkContainsCharacterSpecial("password"));
	}

	@Test
	void checkRequirementsPassword() {
		assertTrue(userDAO.checkRequirementsPassword(password));
		assertFalse(userDAO.checkRequirementsPassword(invalidPassword));
	}

	@Test
	void register() {
		assertTrue(userDAO.register(email, password));
		assertFalse(userDAO.register(invalidEmail, password));
		assertFalse(userDAO.register(email, invalidPassword));
	}
}
