package com.sapient.jsondata.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TeamJsonData extends ModelJsonData{

	private String teamKey ; 
	
	private String teamName;

	private String teamBadge; 
	
    private List<PlayerJsonData> players;
    
    private List<CoachJsonData> coaches;

	@JsonProperty("coaches")
	public List<CoachJsonData> getCoaches() {
		return coaches;
	}

	@JsonProperty("coaches")
	public void setCoaches(List<CoachJsonData> coaches) {
		this.coaches = coaches;
	}

	@JsonProperty("team_key")
	public String getTeamKey() {
		return teamKey;
	}

	@JsonProperty("team_key")
	public void setTeamKey(String teamKey) {
		this.teamKey = teamKey;
	}

	@JsonProperty("team_name")
	public String getTeamName() {
		return teamName;
	}

	@JsonProperty("team_name")
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	@JsonProperty("team_badge")
	public String getTeamBadge() {
		return teamBadge;
	}

	@JsonProperty("team_badge")
	public void setTeamBadge(String teamBadge) {
		this.teamBadge = teamBadge;
	}

	@JsonProperty("players")
	public List<PlayerJsonData> getPlayers() {
		return players;
	}

	@JsonProperty("players")
	public void setPlayers(List<PlayerJsonData> players) {
		this.players = players;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coaches == null) ? 0 : coaches.hashCode());
		result = prime * result + ((players == null) ? 0 : players.hashCode());
		result = prime * result + ((teamBadge == null) ? 0 : teamBadge.hashCode());
		result = prime * result + ((teamKey == null) ? 0 : teamKey.hashCode());
		result = prime * result + ((teamName == null) ? 0 : teamName.hashCode());
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
		TeamJsonData other = (TeamJsonData) obj;
		if (coaches == null) {
			if (other.coaches != null)
				return false;
		} else if (!coaches.equals(other.coaches))
			return false;
		if (players == null) {
			if (other.players != null)
				return false;
		} else if (!players.equals(other.players))
			return false;
		if (teamBadge == null) {
			if (other.teamBadge != null)
				return false;
		} else if (!teamBadge.equals(other.teamBadge))
			return false;
		if (teamKey == null) {
			if (other.teamKey != null)
				return false;
		} else if (!teamKey.equals(other.teamKey))
			return false;
		if (teamName == null) {
			if (other.teamName != null)
				return false;
		} else if (!teamName.equals(other.teamName))
			return false;
		return true;
	}
}
