package football.input.data;

import org.springframework.stereotype.Service;

import football.converter.LeagueToLeagueDb;
import football.db.LeagueDb;
import football.input.data.leagues.League;
import football.input.data.leagues.LeagueWrapper;
import football.input.reader.FixtureReader;
import football.service.FixtureService;
import football.service.LeagueService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DataMiner {
	private FixtureReader fixtureReader;
	private LeagueService leagueService;
	private FixtureService fixtureService;
	private LeagueToLeagueDb leagueConverter;

	public void readMultipleSeasons(int seasonKey, String token) {
		LeagueWrapper leagueWrapper = fixtureReader.readLeagues(seasonKey, token);
		for (League league: leagueWrapper.getApi().getLeagues()) {
			LeagueDb leagueDb = leagueConverter.convert(league);
			leagueService.saveLeague(leagueDb);
			fixtureReader.readFixturesAsynch(league.getLeagueId(), token, fw -> 
				fixtureService.saveFixtures(fw.getApi().getFixtures(), leagueDb));
		}

	}

	public void readSpecificSeason(int seasonKey, String token) {
		LeagueDb leagueDb = createLeagueDb(seasonKey, token);
		leagueService.saveLeague(leagueDb);
		fixtureReader.readFixturesAsynch(seasonKey, token, fw -> 
			fixtureService.saveFixtures(fw.getApi().getFixtures(), leagueDb));
	}
	
	private LeagueDb createLeagueDb(int seasonKey, String token) {
		LeagueDb leagueDb = leagueService.getLeagueById(seasonKey);
		if(leagueDb == null) {
			LeagueWrapper leagueWrapper = fixtureReader.readLeagueById(seasonKey, token);
			League league = leagueWrapper.getApi().getLeagues().get(0);
			leagueDb = leagueConverter.convert(league);
		}
		return leagueDb;
	}
	
	
}
