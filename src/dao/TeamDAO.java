package dao;

import java.util.ArrayList;

import models.Team;

public class TeamDAO {

	public ArrayList<Team> teamList = new ArrayList<Team>();

	public void createTeam(Team team) {
		teamList.add(team);
	}
	
	public void deleteTeam(Team team) {
		teamList.remove(team);
	}
	
	public boolean exceedsPlayerNumbers(Team team) {
		if (team.getPlayerList().size() > 11) {
			return true;
		}
		return false;
	}

	public boolean checkTeamName(String teamName) {
		for (Team team : teamList) {
			if (team.getName().equals(teamName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkCoachName(String coachName) {
		for (Team team : teamList) {
			if (team.getCoach().equals(coachName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean checkStadiumName(String stadiumName) {
		for (Team team : teamList) {
			if (team.getStadium().equals(stadiumName)) {
				return true;
			}
		}
		return false;
	}
}
