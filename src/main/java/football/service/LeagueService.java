package football.service;

import java.util.List;

import org.springframework.data.domain.Sort;
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
		return leagueRepository.findAll(Sort.by(Sort.Direction.DESC, "seasonYear"));
	}
	
	public LeagueDb getLeagueById(int id) {
		return leagueRepository.findById(id).orElse(null);
	}
}
