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
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags="Fixture Controller")
@RestController
@AllArgsConstructor
@RequestMapping("/football/fixture")
public class FixtureController {
	private FixtureService fixtureService;
	
	@GetMapping("/season/{seasonId}/{status}")
	@ApiOperation("Get all fixtures for a specific season by status")
	public List<FixtureDb> getAllFixturesForSeason(
		@PathVariable int seasonId,
		@PathVariable Optional<Integer> status 
	) {
		FixtureStatus fixtureStatus = FixtureStatus.values()[status.orElse(0)];
		return fixtureService.getAllFixtures(seasonId, fixtureStatus);
	}
	
	@GetMapping("/season/{seasonId}/team/{teamId}")
	@ApiOperation("Get all fixtures for a specific team for a specific season")
	public List<FixtureDb> getAllFixturesForSeason(
		@PathVariable int seasonId,
		@PathVariable int teamId
	) {
		return fixtureService.getAllFixtures(seasonId, teamId);
		
	}
	
	@GetMapping("/teamVteam/{team1}/{team2}")
	@ApiOperation("Get all fixtures that involves the two teams specified")
	public List<FixtureDb> getTeamVsTeam(@PathVariable int team1, @PathVariable int team2) {
		return fixtureService.getTeamVsTeamFixtures(team1, team2);
	}
	
}
