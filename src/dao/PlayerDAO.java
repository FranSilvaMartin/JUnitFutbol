package dao;

import models.Player;
import models.Team;

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
	 * @param team Equipo
	 * @param player Jugador
	 * @return Devuelve true si se ha eliminado
	 */
	public boolean deletePlayer(Team team, Player player) {
		return team.getPlayerList().remove(player);
	}

	/**
	 * Comprueba si el nombre del 
	 * @param team
	 * @param playerName
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

	public boolean exceedsPlayerName(String playerName) {
		if (playerName.length() > 30) {
			return true;
		}
		return false;
	}

	public boolean existsPlayerDorsal(Team team, int number) {

		for (Player player : team.getPlayerList()) {
			if (player.getDorsal() == number) {
				return true;
			}
		}
		return false;
	}

	public boolean exceedsPlayerDorsal(int number) {

		if (number >= 1 && number <= 99) {
			return false;
		}
		return true;
	}

}
