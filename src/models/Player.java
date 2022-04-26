package models;

/**
 * Modelo de player
 * 
 * @author Fran Silva
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

	/**
	 * Obtiene el dorsal del jugador
	 * 
	 * @return Devuelve el dorsal
	 */
	public int getDorsal() {
		return dorsal;
	}

	/**
	 * Obtiene el peso del jugador
	 * 
	 * @return Devuelve el peso
	 */
	public float getWeight() {
		return weight;
	}

	/**
	 * Obtiene la altura del jugador
	 * 
	 * @return Devuelve la altura
	 */
	public float getHeight() {
		return height;
	}

	/**
	 * Obtiene el nombre del jugador
	 * 
	 * @return Devuelve el nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * Obtiene la edad del jugador
	 * 
	 * @return Devuelve la edad
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Obtiene la imagen del jugador
	 * 
	 * @return Devuelve la imagen
	 */
	public String getImg() {
		return img;
	}

	/**
	 * Obtiene la nacionalidad del jugador
	 * 
	 * @return Devuelve la nacionalidad
	 */
	public String getCountry() {
		return country;
	}

	/*
	 * Muestra el jugador por pantalla
	 */
	@Override
	public String toString() {
		return "Player [name=" + name + ", dorsal=" + dorsal + ", age=" + age + ", weight=" + weight + ", height="
				+ height + ", country=" + country + ", img=" + img + "]";
	}

}
