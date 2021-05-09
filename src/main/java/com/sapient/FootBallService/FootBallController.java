package com.sapient.FootBallService;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.jsondata.model.CountryJsonData;
import com.sapient.jsondata.model.LeagueJsonData;
import com.sapient.jsondata.model.TeamJsonData;

@RestController
public class FootBallController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FootBallController.class);

	@Autowired
	FootBallService footBallService; 
	
	// URL :: http://localhost:9091/getCountry
	@RequestMapping(value="/getCountry")
	public List<CountryJsonData>  getCountryList(){
		List<CountryJsonData> result = new ArrayList<>();
		result = footBallService.getCountryList(); 
		return result; 
	}
	
	//URL :: http://localhost:9091/getLeaguesByCountryId?countryId=41
	@Cacheable(value = "league", key = "#countryId")
	@RequestMapping(value="/getLeaguesByCountryId")
	public List<LeagueJsonData>  getLeaguesByCountryId(@RequestParam("countryId") String countryId){
		List<LeagueJsonData> result = new ArrayList<>();
		result = footBallService.getLeaguesByCountryId(countryId); 
		return result; 
	}
	
	// URL :: http://localhost:9091/getTeamsByLeagueId?leagueId=149
	@Cacheable(value = "team", key = "#leagueId")
	@RequestMapping(value="/getTeamsByLeagueId")
	public List<TeamJsonData>  getTeamsByLeagueId(@RequestParam("leagueId") String leagueId){
		List<TeamJsonData> result = new ArrayList<>();
		result = footBallService.getTeamsByLeagueId(leagueId); 
		return result; 
	}
}