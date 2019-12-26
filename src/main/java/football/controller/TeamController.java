package football.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import football.db.TeamDb;
import football.service.TeamService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class TeamController {
	TeamService teamService;
	
	@GetMapping("/football/team/{teamId}")
	public TeamDb getTeamById(@PathVariable int teamId) {
		TeamDb team = teamService.getTeam(teamId);
		System.out.println(team);
		return team;
	}

	@GetMapping("/football/teams/all")
	public List<TeamDb> getAllTeams() {
		return teamService.getAllTeams();
	}

	@GetMapping("/football/teams/season/{seasonId}")
	public List<TeamDb> getAllTeamsForSeason(@PathVariable int seasonId) {
		return teamService.getTeamsBySeasonId(seasonId);
	}

}
