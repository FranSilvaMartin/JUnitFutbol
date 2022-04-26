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

/**
 * Conjunto de test sobre los teams usando JUnit
 * 
 * @author Fran Silva y Mohamed
 * @see <a>https://junit.org/junit5/</a>
 */
class TeamTest {

	private TeamDAO teamDAO;
	private Team team, teamFull;

	/**
	 * Settings por defecto
	 */
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

	/**
	 * Test para agregar un equipo
	 */
	@Before
	@Test
	void createTeam() {
		assertTrue(teamDAO.createTeam(team));
	}

	/**
	 * Test para eliminar un equipo
	 */
	@Test
	void deleteTeam() {
		assertTrue(teamDAO.deleteTeam(team));
	}

	/**
	 * Test para comprobar si excede el límite de jugadores por equipo
	 */
	@Test
	void exceedsPlayerNumbers() {
		assertTrue(teamDAO.exceedsPlayerNumbers(teamFull));
		assertFalse(teamDAO.exceedsPlayerNumbers(team));
	}

	/**
	 * Test para comprobar si ya existe el nombre del equipo
	 */
	@Test
	void existsTeamName() {
		assertTrue(teamDAO.existsTeamName("name"));
		assertFalse(teamDAO.existsTeamName("invalid team"));
	}

	/**
	 * Test para comprobar si ya existe un entrenador con este nombre
	 */
	@Test
	void existsCoachName() {
		assertTrue(teamDAO.existsCoachName("coach"));
		assertFalse(teamDAO.existsCoachName("invalid coach"));
	}

	/**
	 * Test para comprobar si ya existe un estadio con este nombre
	 */
	@Test
	void existsStadiumName() {
		assertTrue(teamDAO.existsStadiumName("stadium"));
		assertFalse(teamDAO.existsStadiumName("invalid stadium"));
	}

}
