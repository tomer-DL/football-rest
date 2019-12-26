package football.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import football.db.LeagueDb;
import football.service.LeagueService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class LeagueController {
	private LeagueService leagueService;
	
	@GetMapping("/football/league/all")
	public List<LeagueDb> getAllLeagues() {
		return leagueService.getAllLeagues();
	}
	
	
}
