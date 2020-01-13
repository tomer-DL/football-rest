package football.service;

import org.springframework.stereotype.Service;

import football.model.metaData.RecordCounts;
import football.repository.FixtureRepository;
import football.repository.LeagueRepository;
import football.repository.TeamRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MetaDataService {
	private FixtureRepository fixtureRepository;
	private LeagueRepository leagueRepository;
	private TeamRepository teamRepository;
	
	public RecordCounts readRecordCounts() {
		int fixtureCount = (int)fixtureRepository.count();
		int teamCount = (int)teamRepository.count();
		int leagueCount = (int)leagueRepository.count();
		return new RecordCounts(leagueCount, teamCount, fixtureCount);
	}
}
