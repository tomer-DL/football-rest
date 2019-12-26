package football.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import football.db.FixtureDb;
import football.db.enums.FixtureStatus;
import football.service.FixtureService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class FixtureController {
	private FixtureService fixtureService;
	
	@GetMapping("/football/fixture/season/{seasonId},{status}")
	public List<FixtureDb> getAllFixturesForSeason(
		@PathVariable int seasonId,
		@PathVariable Optional<Integer> status 
	) {
		FixtureStatus fixtureStatus = FixtureStatus.values()[status.orElse(0)];
		return fixtureService.getAllFixtures(seasonId, fixtureStatus);
	}
	
	@GetMapping("/football/fixture/season/{seasonId}/team/{teamId}")
	public List<FixtureDb> getAllFixturesForSeason(
		@PathVariable int seasonId,
		@PathVariable int teamId,
		@PathVariable Optional<Integer> status 
	) {
		FixtureStatus fixtureStatus = FixtureStatus.values()[status.orElse(0)];
		return fixtureService.getAllFixtures(seasonId, teamId);
		
	}
}
