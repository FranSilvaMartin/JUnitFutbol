package mainApp;

import java.util.ArrayList;

import dao.TeamDAO;
import dao.UserDAO;
import models.Account;
import models.Player;
import models.Team;
import ui.LoginView;
import ui.TeamView;

public class FutbolApp {
	
	private UserDAO userDAO;
	private TeamDAO teamDAO;
	
	private TeamView teamview;
	
	public TeamView getTeamview() {
		return teamview;
	}

	public void setTeamview(TeamView teamview) {
		this.teamview = teamview;
	}

	public FutbolApp() {
		this.userDAO = new UserDAO();
		this.teamDAO = new TeamDAO();
		addTeams();
		addAccounts();
		new LoginView(this);
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public TeamDAO getTeamDAO() {
		return teamDAO;
	}
	
	public void addTeams() {
		getTeamDAO().createTeam(new Team("Real Madrid", "Estadio Santiago Bernabéu", "LIGA BBVA", "Carlo Ancelotti", new ArrayList<Player>(), "http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/1.png"));
		getTeamDAO().createTeam(new Team("FC Barcelona", "Camp Nou", "LIGA BBVA", "Xavi Hernández", new ArrayList<Player>(), "https://lh3.googleusercontent.com/OQZi4ckWAs7UrOlZEPefXZgJOcdJuSM5FSH9zqD5rMg6c2MOaxcKpV5IMrb1Tju98fWyNmcI33E4RGb0uC09Ej4W"));
	}
	
	public void addAccounts() {
		getUserDAO().createUsername(new Account("fran@gmail.com", "JUnitFutbol1234-"));
		getUserDAO().createUsername(new Account("mohamed@gmail.com", "JUnitFutbol1234-"));
	}
}
