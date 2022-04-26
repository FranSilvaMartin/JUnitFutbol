package dao;

import models.Player;
import models.Team;

/**
 * Gestión de los jugadores en la base de datos
 * 
 * @author Fran Silva
 *
 */
public class PlayerDAO {

	/**
	 * Agregar un jugador a un equipo
	 * 
	 * @param team   Equipo
	 * @param player Jugador
	 * @return Devuelve true si se ha agregado
	 */
	public boolean addPlayer(Team team, Player player) {
		return team.getPlayerList().add(player);
	}

	/**
	 * Elimina un jugador de un equipo
	 * 
	 * @param team   Equipo
	 * @param player Jugador
	 * @return Devuelve true si se ha eliminado
	 */
	public boolean deletePlayer(Team team, Player player) {
		return team.getPlayerList().remove(player);
	}

	/**
	 * Comprueba si el nombre del jugador existe en un equipo
	 * 
	 * @param team       Nombre del equipo
	 * @param playerName Nombre del jugador
	 * @return
	 */
	public boolean existsPlayerNameTeam(Team team, String playerName) {
		for (Player player : team.getPlayerList()) {
			if (player.getName().equalsIgnoreCase(playerName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprueba si el nombre del jugador es menor que 30
	 * 
	 * @param playerName Nombre del jugador
	 * @return Devuelve true si sobrepasa el limite de 30
	 */
	public boolean exceedsPlayerName(String playerName) {
		if (playerName.length() > 30) {
			return true;
		}
		return false;
	}

	/**
	 * Comprueba si el dorsal existe en el equipo
	 * 
	 * @param team   Equipo
	 * @param number Numero de dorsal
	 * @return Devuelve true si ya existe ese dorsal equipado
	 */
	public boolean existsPlayerDorsal(Team team, int number) {
		for (Player player : team.getPlayerList()) {
			if (player.getDorsal() == number) {
				return true;
			}
		}

		return false;
	}

	/**
	 * Comprueba si el dorsal esta entre el 1 y 99
	 * 
	 * @param number Numero de dorsal
	 * @return Devuelve true si sobrepasa el limite
	 */
	public boolean exceedsPlayerDorsal(int number) {
		if (number >= 1 && number <= 99) {
			return false;
		}

		return true;
	}

}
