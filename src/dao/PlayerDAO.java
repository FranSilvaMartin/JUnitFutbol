package dao;

import models.Player;
import models.Team;

public class PlayerDAO {

	public void deletePlayer(Team team, Player player) {
		team.getPlayerList().remove(player);
	}
	
	public boolean checkPlayerNameTeam(Team team, String playerName) {
		for (Player player : team.getPlayerList()) {
			if (player.getName().equalsIgnoreCase(playerName)) {
				return true;
			}
		}
		return false;
		
	}
	
}
