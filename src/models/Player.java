package models;

public class Player {

	private String name;
	private String years;
	private String country;
	private Team team;

	public Player(String name, String years, String country, Team team) {
		super();
		this.name = name;
		this.years = years;
		this.country = country;
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public String getYears() {
		return years;
	}

	public String getCountry() {
		return country;
	}

	public Team getTeam() {
		return team;
	}

}
