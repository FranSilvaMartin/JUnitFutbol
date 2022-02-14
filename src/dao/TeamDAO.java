package dao;

import java.util.ArrayList;
import java.util.List;

import models.Account;
import models.Team;

public class TeamDAO {

	public ArrayList<Team> teamList = new ArrayList<Team>();

	public void createTeam(Team team) {
		teamList.add(team);
	}
	
	public void deleteTeam(Team team) {
		teamList.remove(team);
	}
	
}
