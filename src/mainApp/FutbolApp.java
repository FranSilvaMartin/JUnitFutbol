package mainApp;

import dao.TeamDAO;
import dao.UserDAO;
import models.Team;
import ui.LoginView;

public class FutbolApp {
	
	private UserDAO userDAO;
	private TeamDAO teamDAO;
	
	public FutbolApp() {
		this.userDAO = new UserDAO();
		this.teamDAO = new TeamDAO();
		new LoginView(this);
	}
	
	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public TeamDAO getTeamDAO() {
		return teamDAO;
	}
	
	public void addTeams() {
		getTeamDAO().createTeam(new Team("Real Madrid", "Estadio Santiago Bernabéu", "LIGA BBVA", "Carlo Ancelotti", null, "http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/1.png"));
		getTeamDAO().createTeam(new Team("FC Barcelona", "Estadio Santiago Bernabéu", "LIGA BBVA", "Carlo Ancelotti", null, "https://lh3.googleusercontent.com/OQZi4ckWAs7UrOlZEPefXZgJOcdJuSM5FSH9zqD5rMg6c2MOaxcKpV5IMrb1Tju98fWyNmcI33E4RGb0uC09Ej4W"));
		getTeamDAO().createTeam(new Team("2", "Estadio Santiago Bernabéu", "LIGA BBVA", "Carlo Ancelotti", null, "http://as01.epimg.net/img/comunes/fotos/fichas/equipos/large/1.png"));
		getTeamDAO().createTeam(new Team("3", "Estadio Santiago Bernabéu", "LIGA BBVA", "Carlo Ancelotti", null, "https://lh3.googleusercontent.com/OQZi4ckWAs7UrOlZEPefXZgJOcdJuSM5FSH9zqD5rMg6c2MOaxcKpV5IMrb1Tju98fWyNmcI33E4RGb0uC09Ej4W"));
	}
}
