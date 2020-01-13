package football.service;

import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.stereotype.Service;

import football.exception.ResourceNotFoundException;
import football.model.TeamDb;
import football.repository.TeamRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamService {
	private TeamRepository teamRepository;
	
	public TeamDb getTeam(int id) {
		return teamRepository.findById(id)
				.orElseThrow(()->
				new ResourceNotFoundException("Can't find a team with the current id"));
	}
	
	public TeamDb getByTeamName(String teamName) {
		return teamRepository.findByTeamName(teamName)
				.orElseThrow(()->
				new ResourceNotFoundException("Can't find a team with the current name"));
	}
	
	public List<TeamDb> getAllTeams() {
		List<TeamDb> teams = teamRepository.findAll(); 
		if(teams.size() > 0)
			return teams;
		else
			throw new ResourceNotFoundException("No teams are available");
	}
	
	public List<TeamDb> getTeamsBySeasonId(int seasonId) {
		List<TeamDb> teams = teamRepository.findBySeason(seasonId);
		if(teams.size() > 0)
			return teams;
		else
			throw new ResourceNotFoundException("No teams are available for this season");
	}
}
