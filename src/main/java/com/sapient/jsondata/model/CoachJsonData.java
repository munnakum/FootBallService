package com.sapient.jsondata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CoachJsonData{

	private String coachName ; 
	
	private String coachCountry;

	private String coachAge;

	@JsonProperty("coach_name")
	public String getCoachName() {
		return coachName;
	}

	@JsonProperty("coach_name")
	public void setCoachName(String coachName) {
		this.coachName = coachName;
	}

	@JsonProperty("coach_country")
	public String getCoachCountry() {
		return coachCountry;
	}

	@JsonProperty("coach_country")
	public void setCoachCountry(String coachCountry) {
		this.coachCountry = coachCountry;
	}

	@JsonProperty("coach_age")
	public String getCoachAge() {
		return coachAge;
	}

	@JsonProperty("coach_age")
	public void setCoachAge(String coachAge) {
		this.coachAge = coachAge;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((coachAge == null) ? 0 : coachAge.hashCode());
		result = prime * result + ((coachCountry == null) ? 0 : coachCountry.hashCode());
		result = prime * result + ((coachName == null) ? 0 : coachName.hashCode());
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
		CoachJsonData other = (CoachJsonData) obj;
		if (coachAge == null) {
			if (other.coachAge != null)
				return false;
		} else if (!coachAge.equals(other.coachAge))
			return false;
		if (coachCountry == null) {
			if (other.coachCountry != null)
				return false;
		} else if (!coachCountry.equals(other.coachCountry))
			return false;
		if (coachName == null) {
			if (other.coachName != null)
				return false;
		} else if (!coachName.equals(other.coachName))
			return false;
		return true;
	} 
	
}
