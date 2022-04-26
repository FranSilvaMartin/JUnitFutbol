package models;

import java.util.ArrayList;
import java.util.List;

/**
 * Modelo de equipo
 * 
 * @author Fran Silva
 *
 */
public class Team {

	private String name;
	private String stadium;
	private String league;
	private String coach;
	private List<Player> playerList;
	private String img;

	/**
	 * Creación de un equipo
	 * 
	 * @param name       Nombre
	 * @param stadium    Estadio
	 * @param league     Liga
	 * @param coach      Entrenador
	 * @param playerList Lista de jugadores
	 * @param img        Imagen
	 */
	public Team(String name, String stadium, String league, String coach, List<Player> playerList, String img) {
		super();
		this.name = name;
		this.stadium = stadium;
		this.league = league;
		this.coach = coach;
		this.playerList = new ArrayList<Player>();
		this.img = img;
	}

	/**
	 * Obtiene el nombre del equipo
	 * 
	 * @return Devuelve el nombre
	 */
	public String getName() {
		return name;
	}

	/**
	 * Obtiene el estadio del equipo
	 * 
	 * @return Devuelve el estadio
	 */
	public String getStadium() {
		return stadium;
	}

	/**
	 * Obtiene la liga del equipo
	 * 
	 * @return Devuelve la liga
	 */
	public String getLeague() {
		return league;
	}

	/**
	 * Obtiene el entrenador del equipo
	 * 
	 * @return Devuelve el entrenador
	 */
	public String getCoach() {
		return coach;
	}

	/**
	 * Obtiene una lista con todos los jugadores del equipo
	 * 
	 * @return Devuelve una lista
	 */
	public List<Player> getPlayerList() {
		return playerList;
	}

	/**
	 * Obtiene la imagen del equipo
	 * 
	 * @return Devuelve la imagen
	 */
	public String getImg() {
		return img;
	}

	/*
	 * Muestra el equipo por pantalla
	 */
	@Override
	public String toString() {
		return "Team [name=" + name + ", stadium=" + stadium + ", league=" + league + ", coach=" + coach
				+ ", playerList=" + playerList + ", img=" + img + "]";
	}

}
