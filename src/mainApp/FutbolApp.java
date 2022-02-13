package mainApp;

import dao.UserDAO;
import ui.LoginView;

public class FutbolApp {
	
	private UserDAO userDAO;

	public FutbolApp() {
		this.userDAO = new UserDAO();
		new LoginView(this);
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
}
