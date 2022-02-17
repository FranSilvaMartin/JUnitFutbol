package models;

public class Player {

	private String name;
	private int years;
	private int weight;
	private int height;
	private String country;
	private String img;

	public Player(String name, int years, int weight, int height, String country, String img) {
		super();
		this.name = name;
		this.years = years;
		this.weight = weight;
		this.height = height;
		this.country = country;
		this.img = img;
	}

	public int getWeight() {
		return weight;
	}

	public int getHeight() {
		return height;
	}

	public String getName() {
		return name;
	}

	public int getYears() {
		return years;
	}

	public String getImg() {
		return img;
	}
	
	public String getCountry() {
		return country;
	}

}
