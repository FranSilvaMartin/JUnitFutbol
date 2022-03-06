package dao;

import java.util.ArrayList;

import models.Team;

public class TeamDAO {

	public ArrayList<Team> teamList = new ArrayList<Team>();

	public boolean createTeam(Team team) {
		return teamList.add(team);
	}
	
	public boolean deleteTeam(Team team) {
		return teamList.remove(team);
	}
	
	public boolean exceedsPlayerNumbers(Team team) {
		if (team.getPlayerList().size() > 11) {
			return true;
		}
		return false;
	}

	public boolean existsTeamName(String teamName) {
		for (Team team : teamList) {
			if (team.getName().equals(teamName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existsCoachName(String coachName) {
		for (Team team : teamList) {
			if (team.getCoach().equals(coachName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean existsStadiumName(String stadiumName) {
		for (Team team : teamList) {
			if (team.getStadium().equals(stadiumName)) {
				return true;
			}
		}
		return false;
	}
}
