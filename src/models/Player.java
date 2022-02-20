package models;

public class Player {

	private String name;
	private int years;
	private float weight;
	private float height;
	private String country;
	private String img;

	public Player(String name, int years, float weight, float height, String country, String img) {
		super();
		this.name = name;
		this.years = years;
		this.weight = weight;
		this.height = height;
		this.country = country;
		this.img = img;
	}

	public float getWeight() {
		return weight;
	}

	public float getHeight() {
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
