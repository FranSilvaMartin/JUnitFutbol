package dao;

import models.Player;
import models.Team;

public class PlayerDAO {

	public boolean addPlayer(Team team, Player player) {
		return team.getPlayerList().add(player);
	}
	
	public boolean deletePlayer(Team team, Player player) {
		return team.getPlayerList().remove(player);
	}

	public boolean checkPlayerNameTeam(Team team, String playerName) {
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

	public boolean checkPlayerDorsal(Team team, int number) {

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
