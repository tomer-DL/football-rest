package football.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import football.model.LeagueDb;
import football.service.LeagueService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(tags="League Controller")
public class LeagueController {
	private LeagueService leagueService;
	
	@GetMapping("/football/league/all")
	@ApiOperation("Get a list of all leagues available")
	public List<LeagueDb> getAllLeagues() {
		return leagueService.getAllLeagues();
	}
	
	
}
