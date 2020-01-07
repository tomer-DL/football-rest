package football.service;

import java.util.List;

import org.springframework.stereotype.Service;

import football.db.LeagueDb;
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
		return leagueRepository.findAll();
	}
}
