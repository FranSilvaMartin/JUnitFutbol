package dao;

import java.util.ArrayList;
import java.util.List;

import models.Username;

public class UsernameDAO {

	private List<Username> usernameList = new ArrayList<Username>();

	public List<Username> getUsernameList() {
		return usernameList;
	}	
	
	public void createUsername(Username user) {
		usernameList.add(user);
	}
	
	public void showUsersConsole() {
		for (Username username : usernameList) {
			System.out.println(username);
		}
	}
	
	public boolean login(String usernameField, String passwordField) {
		
		if (usernameList.isEmpty()) {
			return false;
		} else {
			for (Username username : usernameList) {
				if (usernameField.equalsIgnoreCase(username.getUsername())) {
					if (passwordField.equals(username.getPassword())) {
						return true;
					}
				} 
			}
		}
		return false;
	}
}
