package com.sapient.FootBallService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.sapient.jsondata.model.CountryJsonData;
import com.sapient.jsondata.model.LeagueJsonData;
import com.sapient.jsondata.model.TeamJsonData;

@Service
public class FootBallService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(FootBallService.class);
	
	@Autowired
	RestTemplate restTemplate; 
	
	@Autowired
	FootBallCaching footBallCaching;
	
	@Value("${api.key}")
	String apiKey; 
	
	public List<CountryJsonData> getCountryList() {
		List<CountryJsonData> result = new ArrayList<>();
		ResponseEntity<List<CountryJsonData>> responseEntity = restTemplate.exchange("https://apiv2.apifootball.com/?action=get_countries&APIkey="+apiKey,HttpMethod.GET,
				null, new ParameterizedTypeReference<List<CountryJsonData>>(){}); 
		result = responseEntity.getBody(); 
		LOGGER.info("size of getCountryList ::"+result.size());
		return result.size() == 0 ? new ArrayList<CountryJsonData>() : result ;
	}
	
	public List<LeagueJsonData> getLeaguesByCountryId(String countryId) {
		List<LeagueJsonData> result = new ArrayList<>();  
		
		if(footBallCaching.contains("league",countryId)){
		//if(false){
			result = footBallCaching.getLeagueList(countryId);
		}else{
			ResponseEntity<List<LeagueJsonData>> responseEntity = restTemplate.exchange("https://apiv2.apifootball.com/?action=get_leagues&country_id="+countryId+"&APIkey="+apiKey,HttpMethod.GET,
					null, new ParameterizedTypeReference<List<LeagueJsonData>>(){}); 
			result = responseEntity.getBody(); 
			footBallCaching.setLeagueList(countryId, result);
			LOGGER.info("size of getLeaguesByCountryId ::"+result.size()+",for countryId :"+countryId);
		}

		
		return result.size() == 0 ? new ArrayList<LeagueJsonData>() : result ;
	}
	
	public List<TeamJsonData> getTeamsByLeagueId(String leagueId) {
		List<TeamJsonData> result = new ArrayList<>();  
		
		if(footBallCaching.contains("league",leagueId)){
		//if(false){
			result = footBallCaching.getTeamList(leagueId);
		}else{
			ResponseEntity<List<TeamJsonData>> responseEntity = restTemplate.exchange("https://apiv2.apifootball.com/?action=get_teams&league_id="+leagueId+"&APIkey="+apiKey,HttpMethod.GET,
					null, new ParameterizedTypeReference<List<TeamJsonData>>(){}); 
			result = responseEntity.getBody(); 
			LOGGER.info("size of getLeaguesByCountryId ::"+result.size()+",for leagueId :"+leagueId);
			footBallCaching.setTeamList(leagueId, result);
		}
		return result.size() == 0 ? new ArrayList<TeamJsonData>() : result ;
	}
}
