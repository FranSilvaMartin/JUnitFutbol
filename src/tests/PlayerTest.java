package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import dao.PlayerDAO;
import models.Player;
import models.Team;

/**
 * Conjunto de test sobre los jugadores usando JUnit
 * 
 * @author Fran Silva y Mohamed
 * @see <a>https://junit.org/junit5/</a>
 */
class PlayerTest {

	private PlayerDAO playerDAO;
	private Team team;
	private Player player;

	/**
	 * Settings por defecto
	 */
	@BeforeEach
	@Test
	void setupDefaults() {
		this.playerDAO = new PlayerDAO();
		this.team = new Team("test", "test", "test", "test", new ArrayList<>(), "test");
		this.player = new Player("test", 1, 18, 70.0F, 1.68F, "test", "test");
		playerDAO.addPlayer(team, player);
	}

	/**
	 * Test para agregar un jugador a un equipo
	 */
	@Test
	void addPlayerTest() {
		assertTrue(playerDAO.addPlayer(team, player));
	}

	/**
	 * Test para eliminar a un jugador a un equipo
	 */
	@Test
	void deletePlayerTest() {
		assertTrue(playerDAO.deletePlayer(team, player));
	}

	/**
	 * Test para comprobar si el nombre del jugador ha excedido el límite
	 */
	@Test
	void exceedsPlayerName() {
		String playerName = "Nicolás";
		String longPlayerName = "Francisco Nicolás de la Rosa Jiménez Vázquez";
		assertTrue(playerDAO.exceedsPlayerName(longPlayerName));
		assertFalse(playerDAO.exceedsPlayerName(playerName));
	}

	/**
	 * Test para comprobar si ya existe ese dorsal en el equipo
	 */
	@Test
	void existsPlayerDorsal() {
		assertTrue(playerDAO.existsPlayerDorsal(team, 1));
		assertFalse(playerDAO.existsPlayerDorsal(team, 2));
	}

	/**
	 * Test para comprobar si ya excecido el límite de dorsal elegido
	 */
	@Test
	void exceedsPlayerDorsal() {
		assertTrue(playerDAO.exceedsPlayerDorsal(100));
		assertFalse(playerDAO.exceedsPlayerDorsal(55));
	}

}
