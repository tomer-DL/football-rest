package football.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import football.model.FixtureDb;
import football.model.enums.FixtureStatus;
import football.service.FixtureService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/football/fixture")
public class FixtureController {
	private FixtureService fixtureService;
	
	@GetMapping("/season/{seasonId}/{status}")
	public List<FixtureDb> getAllFixturesForSeason(
		@PathVariable int seasonId,
		@PathVariable Optional<Integer> status 
	) {
		FixtureStatus fixtureStatus = FixtureStatus.values()[status.orElse(0)];
		return fixtureService.getAllFixtures(seasonId, fixtureStatus);
	}
	
	@GetMapping("/season/{seasonId}/team/{teamId}")
	public List<FixtureDb> getAllFixturesForSeason(
		@PathVariable int seasonId,
		@PathVariable int teamId
	) {
		return fixtureService.getAllFixtures(seasonId, teamId);
		
	}
	
	@GetMapping("/teamVteam/{team1}/{team2}")
	public List<FixtureDb> getTeamVsTeam(@PathVariable int team1, @PathVariable int team2) {
		return fixtureService.getTeamVsTeamFixtures(team1, team2);
	}
	
}
