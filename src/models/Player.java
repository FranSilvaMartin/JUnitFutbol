package models;

/**
 * Modelo de player
 * 
 * @author alumno
 *
 */
public class Player {

	private String name;
	private int dorsal;
	private int age;
	private float weight;
	private float height;
	private String country;
	private String img;

	/**
	 * Creación de un jugador
	 * 
	 * @param name    Nombre
	 * @param dorsal  Dorsal
	 * @param age     Edad
	 * @param weight  Peso
	 * @param height  Altura
	 * @param country Nacionalidad
	 * @param img     Imagen
	 */
	public Player(String name, int dorsal, int age, float weight, float height, String country, String img) {
		super();
		this.dorsal = dorsal;
		this.name = name;
		this.age = age;
		this.weight = weight;
		this.height = height;
		this.country = country;
		this.img = img;
	}

	public int getDorsal() {
		return dorsal;
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

	public int getAge() {
		return age;
	}

	public String getImg() {
		return img;
	}

	public String getCountry() {
		return country;
	}

}
