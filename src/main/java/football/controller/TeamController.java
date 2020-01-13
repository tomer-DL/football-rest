package football.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import football.model.TeamDb;
import football.service.TeamService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/football")
public class TeamController {
	TeamService teamService;
	
	@GetMapping("/team/{teamId}")
	public TeamDb getTeamById(@PathVariable int teamId) {
		TeamDb team = teamService.getTeam(teamId);
		return team;
	}

	@GetMapping("/teams/all")
	public List<TeamDb> getAllTeams() {
		return teamService.getAllTeams();
	}

	@GetMapping("/teams/season/{seasonId}")
	public List<TeamDb> getAllTeamsForSeason(@PathVariable int seasonId) {
		return teamService.getTeamsBySeasonId(seasonId);
	}

}
