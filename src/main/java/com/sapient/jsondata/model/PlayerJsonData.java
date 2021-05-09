package com.sapient.jsondata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PlayerJsonData {

	private String playerKey ; 
	
	private String playerName;
	
	private String playerNumber;

	private String playerCountry; 
	
    private String playerType ; 
	
	private String playerAge;

	private String playerMatchPlayed; 
	
	private String playerGoals;
	
	private String playerYellowCards;

	private String playerRedCards;

	@JsonProperty("player_key")
	public String getPlayerKey() {
		return playerKey;
	}

	@JsonProperty("player_key")
	public void setPlayerKey(String playerKey) {
		this.playerKey = playerKey;
	}

	@JsonProperty("player_name")
	public String getPlayerName() {
		return playerName;
	}

	@JsonProperty("player_name")
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	@JsonProperty("player_number")
	public String getPlayerNumber() {
		return playerNumber;
	}

	@JsonProperty("player_number")
	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}

	@JsonProperty("player_country")
	public String getPlayerCountry() {
		return playerCountry;
	}

	@JsonProperty("player_country")
	public void setPlayerCountry(String playerCountry) {
		this.playerCountry = playerCountry;
	}

	@JsonProperty("player_type")
	public String getPlayerType() {
		return playerType;
	}

	@JsonProperty("player_type")
	public void setPlayerType(String playerType) {
		this.playerType = playerType;
	}

	@JsonProperty("player_age")
	public String getPlayerAge() {
		return playerAge;
	}

	@JsonProperty("player_age")
	public void setPlayerAge(String playerAge) {
		this.playerAge = playerAge;
	}

	@JsonProperty("player_match_played")
	public String getPlayerMatchPlayed() {
		return playerMatchPlayed;
	}

	@JsonProperty("player_match_played")
	public void setPlayerMatchPlayed(String playerMatchPlayed) {
		this.playerMatchPlayed = playerMatchPlayed;
	}

	@JsonProperty("player_goals")
	public String getPlayerGoals() {
		return playerGoals;
	}

	@JsonProperty("player_goals")
	public void setPlayerGoals(String playerGoals) {
		this.playerGoals = playerGoals;
	}

	@JsonProperty("player_yellow_cards")
	public String getPlayerYellowCards() {
		return playerYellowCards;
	}

	@JsonProperty("player_yellow_cards")
	public void setPlayerYellowCards(String playerYellowCards) {
		this.playerYellowCards = playerYellowCards;
	}

	@JsonProperty("player_red_cards")
	public String getPlayerRedCards() {
		return playerRedCards;
	}

	@JsonProperty("player_red_cards")
	public void setPlayerRedCards(String playerRedCards) {
		this.playerRedCards = playerRedCards;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerAge == null) ? 0 : playerAge.hashCode());
		result = prime * result + ((playerCountry == null) ? 0 : playerCountry.hashCode());
		result = prime * result + ((playerGoals == null) ? 0 : playerGoals.hashCode());
		result = prime * result + ((playerKey == null) ? 0 : playerKey.hashCode());
		result = prime * result + ((playerMatchPlayed == null) ? 0 : playerMatchPlayed.hashCode());
		result = prime * result + ((playerName == null) ? 0 : playerName.hashCode());
		result = prime * result + ((playerNumber == null) ? 0 : playerNumber.hashCode());
		result = prime * result + ((playerRedCards == null) ? 0 : playerRedCards.hashCode());
		result = prime * result + ((playerType == null) ? 0 : playerType.hashCode());
		result = prime * result + ((playerYellowCards == null) ? 0 : playerYellowCards.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PlayerJsonData other = (PlayerJsonData) obj;
		if (playerAge == null) {
			if (other.playerAge != null)
				return false;
		} else if (!playerAge.equals(other.playerAge))
			return false;
		if (playerCountry == null) {
			if (other.playerCountry != null)
				return false;
		} else if (!playerCountry.equals(other.playerCountry))
			return false;
		if (playerGoals == null) {
			if (other.playerGoals != null)
				return false;
		} else if (!playerGoals.equals(other.playerGoals))
			return false;
		if (playerKey == null) {
			if (other.playerKey != null)
				return false;
		} else if (!playerKey.equals(other.playerKey))
			return false;
		if (playerMatchPlayed == null) {
			if (other.playerMatchPlayed != null)
				return false;
		} else if (!playerMatchPlayed.equals(other.playerMatchPlayed))
			return false;
		if (playerName == null) {
			if (other.playerName != null)
				return false;
		} else if (!playerName.equals(other.playerName))
			return false;
		if (playerNumber == null) {
			if (other.playerNumber != null)
				return false;
		} else if (!playerNumber.equals(other.playerNumber))
			return false;
		if (playerRedCards == null) {
			if (other.playerRedCards != null)
				return false;
		} else if (!playerRedCards.equals(other.playerRedCards))
			return false;
		if (playerType == null) {
			if (other.playerType != null)
				return false;
		} else if (!playerType.equals(other.playerType))
			return false;
		if (playerYellowCards == null) {
			if (other.playerYellowCards != null)
				return false;
		} else if (!playerYellowCards.equals(other.playerYellowCards))
			return false;
		return true;
	}
}
