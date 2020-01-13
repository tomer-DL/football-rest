package football.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import football.model.TeamDb;
import football.service.TeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@Api(tags="Team Controller")
@RestController
@AllArgsConstructor
@RequestMapping("/football")
public class TeamController {
	TeamService teamService;
	
	@GetMapping("/team/{teamId}")
	@ApiOperation("Get team by team id")
	public TeamDb getTeamById(@PathVariable int teamId) {
		TeamDb team = teamService.getTeam(teamId);
		return team;
	}

	@GetMapping("/teams/all")
	@ApiOperation("Get a list of all teams")
	public List<TeamDb> getAllTeams() {
		return teamService.getAllTeams();
	}

	@GetMapping("/teams/season/{seasonId}")
	@ApiOperation("Get a list of all teams for a specific season")
	public List<TeamDb> getAllTeamsForSeason(@PathVariable int seasonId) {
		return teamService.getTeamsBySeasonId(seasonId);
	}

}
