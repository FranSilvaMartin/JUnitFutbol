package mainApp;

import java.util.ArrayList;

import dao.TeamDAO;
import dao.UserDAO;
import models.Account;
import models.Player;
import models.Team;
import ui.LoginView;
import ui.PlayerView;
import ui.TeamView;

public class FutbolApp {
	
	private UserDAO userDAO;
	private TeamDAO teamDAO;
	
	private TeamView teamview;
	private PlayerView playerview;

	public void setTeamview(TeamView teamview) {
		this.teamview = teamview;
	}

	public FutbolApp() {
		this.userDAO = new UserDAO();
		this.teamDAO = new TeamDAO();
		addAccounts();
		addTeams();
		addPlayers();
		new LoginView(this);
	}
	
	public TeamView getTeamview() {
		return teamview;
	}
	
	public PlayerView getPlayerview() {
		return playerview;
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
	
	public void addPlayers() {
		getTeamDAO().teamList.get(0).getPlayerList().add(new Player("Toni Kross", 30, 76, 183, "Alemania", "https://assets.laliga.com/squad/2021/t186/p44989/256x278/p44989_t186_2021_1_001_000.png"));
		getTeamDAO().teamList.get(0).getPlayerList().add(new Player("Karim Benzema", 30, 81, 185, "Francia", "https://assets.laliga.com/squad/2021/t186/p19927/256x278/p19927_t186_2021_1_001_000.png"));
		getTeamDAO().teamList.get(1).getPlayerList().add(new Player("Sergio Busquets", 30, 76, 189, "España", "https://assets.laliga.com/squad/2021/t178/p54104/256x278/p54104_t178_2021_1_001_000.png"));
		getTeamDAO().teamList.get(1).getPlayerList().add(new Player("Ter Stegen", 30, 85, 187, "Alemania", "https://assets.laliga.com/squad/2021/t178/p77318/256x278/p77318_t178_2021_1_001_000.png"));
	}
	
	public void addAccounts() {
		getUserDAO().createUsername(new Account("fran", "1234"));
		getUserDAO().createUsername(new Account("mohamed@gmail.com", "JUnitFutbol1234-"));
	}
}
