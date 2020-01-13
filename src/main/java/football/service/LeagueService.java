package football.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import football.exception.ResourceNotFoundException;
import football.model.LeagueDb;
import football.repository.LeagueRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LeagueService {
	private LeagueRepository leagueRepository;
	
	public void saveLeague(LeagueDb leagueDb) {
		leagueRepository.save(leagueDb);
	}
	
	public List<LeagueDb> getAllLeagues() {
		List<LeagueDb> leagues = leagueRepository.findAll(Sort.by(Sort.Direction.DESC, "seasonYear"));
		if(leagues.size() > 0)
			return leagues;
		else
			throw new ResourceNotFoundException("No leagues are currently available");
	}
	
	public LeagueDb getLeagueById(int id) {
	 	 return leagueRepository.findById(id).
	 			 orElseThrow(() -> 
	 			 new ResourceNotFoundException("No such league is currently available"));
	}
	public LeagueDb getLeagueByIdOrNull(int id) {
	 	 return leagueRepository.findById(id).
	 			 orElse(null);
	}
}
