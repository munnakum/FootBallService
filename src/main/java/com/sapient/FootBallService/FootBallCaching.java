package com.sapient.FootBallService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sapient.jsondata.model.CountryJsonData;
import com.sapient.jsondata.model.LeagueJsonData;
import com.sapient.jsondata.model.ModelJsonData;
import com.sapient.jsondata.model.TeamJsonData;

@Service
public class FootBallCaching {
	
	private List<CountryJsonData> countryList = new ArrayList<>() ; 
	
	private Map<String, List<LeagueJsonData>> leagueList = new HashMap<>(); 
	
	private Map<String, List<TeamJsonData>> teamList = new HashMap<>(); 


	public List<CountryJsonData> getCountryList() {
		return countryList;
	}


	public void setCountryList(List<CountryJsonData> countryList) {
		this.countryList = countryList;
	}
	
	public List<TeamJsonData> getTeamList(String teamId) {
		return teamList.get(teamId);
	}


	public void setTeamList(String teamId,List<TeamJsonData> list) {
		teamList.put(teamId, list);
	}


	public  List<LeagueJsonData> getLeagueList(String countryId) {
		return leagueList.get(countryId);
	}

	public void setLeagueList(String countryId,List<LeagueJsonData> list) {
		leagueList.put(countryId, list) ;
	}

	
	public boolean contains(String className,String id){
		if("league".equalsIgnoreCase(className)){
			return leagueList.containsKey(id); 
		}else{
			return teamList.containsKey(id); 
		}
	}
	

}
