package football.service;

import java.util.List;

import org.springframework.stereotype.Service;

import football.db.TeamDb;
import football.repository.TeamRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TeamService {
	private TeamRepository teamRepository;
	
	public TeamDb getTeam(int id) {
		return teamRepository.findById(id).orElse(null);
	}
	
	public TeamDb getByTeamName(String teamName) {
		return teamRepository.findByTeamName(teamName).orElse(null);
	}
	
	public List<TeamDb> getAllTeams() {
		return teamRepository.findAll();
	}
	
	public List<TeamDb> getTeamsBySeasonId(int seasonId) {
		return teamRepository.findBySeason(seasonId);
	}
}
