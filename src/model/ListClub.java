/**
 * @author abhit - aryan9
 * CIS175 - Spring 2023
 * Jan 30, 2023
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="clubs")
public class ListClub {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="CITY")
	private String city;
	@Column(name="CLUB")
	private String club;
	@Column(name="TEAMMANAGER")
	private String teamManager;
	@Column(name="FOOTBALLRANKING")
	private int footballRanking;
	
	public ListClub() {
		super();
	}
	
	public ListClub(String city, String club, String teamManager, int footballRanking) {
		super();
		this.city = city;
		this.club = club;
		this.teamManager = teamManager;
		this.footballRanking = footballRanking;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the club
	 */
	public String getClub() {
		return club;
	}

	/**
	 * @param club the club to set
	 */
	public void setClub(String club) {
		this.club = club;
	}

	/**
	 * @return the footballRanking
	 */
	public int getFootballRanking() {
		return footballRanking;
	}

	/**
	 * @param footballRanking the footballRanking to set
	 */
	public void setFootballRanking(int numOfPlayers) {
		this.footballRanking = numOfPlayers;
	}
	
	public String returnClubDetails() {
		return this.city + ": " + this.club + ": " + this.teamManager + ": " + this.footballRanking;
	}

}
