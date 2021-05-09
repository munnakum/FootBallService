package com.sapient.jsondata.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CountryJsonData extends ModelJsonData {

	private String countryId ; 
	
	private String countryName;

	private String countryLogo; 
	
	@JsonProperty("country_logo")
	public String getCountryLogo() {
		return countryLogo;
	}

	@JsonProperty("country_logo")
	public void setCountryLogo(String countryLogo) {
		this.countryLogo = countryLogo;
	}

	@JsonProperty("country_id")
	public String getCountryId() {
		return countryId;
	}

	@JsonProperty("country_id")
	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@JsonProperty("country_name")
	public String getCountryName() {
		return countryName;
	}

	@JsonProperty("country_name")
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((countryId == null) ? 0 : countryId.hashCode());
		result = prime * result + ((countryLogo == null) ? 0 : countryLogo.hashCode());
		result = prime * result + ((countryName == null) ? 0 : countryName.hashCode());
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
		CountryJsonData other = (CountryJsonData) obj;
		if (countryId == null) {
			if (other.countryId != null)
				return false;
		} else if (!countryId.equals(other.countryId))
			return false;
		if (countryLogo == null) {
			if (other.countryLogo != null)
				return false;
		} else if (!countryLogo.equals(other.countryLogo))
			return false;
		if (countryName == null) {
			if (other.countryName != null)
				return false;
		} else if (!countryName.equals(other.countryName))
			return false;
		return true;
	}
}
