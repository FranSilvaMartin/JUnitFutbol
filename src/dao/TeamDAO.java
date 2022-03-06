package dao;

import java.util.ArrayList;

import models.Team;

public class TeamDAO {

	public ArrayList<Team> teamList = new ArrayList<Team>();

	/**
	 * Crea un equipo
	 * 
	 * @param team Equipo
	 * @return Devuelve true si se ha creado
	 */
	public boolean createTeam(Team team) {
		return teamList.add(team);
	}

	/**
	 * Elimina un equipo
	 * 
	 * @param team Equipo
	 * @return Devuelve true si se ha eliminado
	 */
	public boolean deleteTeam(Team team) {
		return teamList.remove(team);
	}

	/**
	 * Comprueba si sobrepasa el limite de jugadores en un equipo
	 * 
	 * @param team Equipo
	 * @return Devuelve true si ha sobrepasado el limite
	 */
	public boolean exceedsPlayerNumbers(Team team) {
		if (team.getPlayerList().size() > 11) {
			return true;
		}
		return false;
	}

	/**
	 * Comprueba si existe el nombre del equipo
	 * 
	 * @param teamName Nombre del equipo
	 * @return Devuelve true si existe
	 */
	public boolean existsTeamName(String teamName) {
		for (Team team : teamList) {
			if (team.getName().equals(teamName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprueba si existe el nombre del entrenador
	 * 
	 * @param coachName Nombre del entrenador
	 * @return Devuelve true si existe
	 */
	public boolean existsCoachName(String coachName) {
		for (Team team : teamList) {
			if (team.getCoach().equals(coachName)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Comprueba si existe el nombre del estadio
	 * 
	 * @param stadiumName Nombre del estadio
	 * @return Devuelve true si existe
	 */
	public boolean existsStadiumName(String stadiumName) {
		for (Team team : teamList) {
			if (team.getStadium().equals(stadiumName)) {
				return true;
			}
		}
		return false;
	}
}
