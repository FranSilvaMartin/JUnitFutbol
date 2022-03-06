package tests;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.TeamDAO;
import models.Player;
import models.Team;

class TeamTest {

	private TeamDAO teamDAO;
	private Team team, teamFull;
	
	@BeforeEach
	@Test
	void setupDefaults() {
		this.teamDAO = new TeamDAO();
		this.team = new Team("name", "stadium", "league", "coach", new ArrayList<>(), "img");
		teamDAO.createTeam(team);
		
		this.teamFull = new Team("name2", "stadium2", "league2", "coach2", new ArrayList<>(), "img2");
		for (int i = 0; i < 12; i++) {
			Player player = new Player("name" + i, i + 1, i + 20, i + 50, 1.60F * 0.1F * i, "", "");
			this.teamFull.getPlayerList().add(player);
		}
	}

	@Before
	@Test
	void createTeam() {
		assertTrue(teamDAO.createTeam(team));
	}
	
	@Test
	void deleteTeam() {
		assertTrue(teamDAO.deleteTeam(team));
	}
	
	@Test
	void exceedsPlayerNumbers() {
		assertTrue(teamDAO.exceedsPlayerNumbers(teamFull));
		assertFalse(teamDAO.exceedsPlayerNumbers(team));
	}
	
	@Test
	void existsTeamName() {
		assertTrue(teamDAO.existsTeamName("name"));
		assertFalse(teamDAO.existsTeamName("invalid team"));
	}
	
	@Test
	void existsCoachName() {
		assertTrue(teamDAO.existsCoachName("coach"));
		assertFalse(teamDAO.existsCoachName("invalid coach"));
	}
	
	@Test
	void existsStadiumName() {
		assertTrue(teamDAO.existsStadiumName("stadium"));
		assertFalse(teamDAO.existsStadiumName("invalid stadium"));
	}
	
}
