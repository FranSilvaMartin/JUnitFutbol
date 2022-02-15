package models;

import java.util.ArrayList;
import java.util.List;

public class Team {

	private String name;
	private String stadium;
	private String league;
	private String coach;
	private List<Player> playerList;
	private String img;

	public Team(String name, String stadium, String league, String coach, List<Player> playerList, String img) {
		super();
		this.name = name;
		this.stadium = stadium;
		this.league = league;
		this.coach = coach;
		this.playerList = new ArrayList<Player>();
		this.img = img;
	}

	public String getName() {
		return name;
	}

	public String getStadium() {
		return stadium;
	}

	public String getLeague() {
		return league;
	}

	public String getCoach() {
		return coach;
	}

	public List<Player> getPlayerList() {
		return playerList;
	}

	public String getImg() {
		return img;
	}

}
