package football.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import football.service.StandingService;
import football.standing.TeamRecord;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags="Standings Controller")
@RestController
@AllArgsConstructor
@RequestMapping("/football/standing/season")
public class StandingController {
	private StandingService standingService;
	
	@GetMapping("/{seasonId}/all")
	@ApiOperation("Get full league standings")
	public List<TeamRecord> getStandings(@PathVariable int seasonId) {
		return standingService.getStandings(seasonId);
	}
	
	@GetMapping("/{seasonId}/home")
	@ApiOperation("Get league standings for home games")
	public List<TeamRecord> getHomeStandings(@PathVariable int seasonId) {
		return standingService.getHomeStandings(seasonId);
	}

	@GetMapping("/{seasonId}/away")
	@ApiOperation("Get league standings for away games")
	public List<TeamRecord> getAwayStandings(@PathVariable int seasonId) {
		return standingService.getAwayStandings(seasonId);
	}
}
