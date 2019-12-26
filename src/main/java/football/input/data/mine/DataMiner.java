package football.input.data.mine;

import org.springframework.stereotype.Service;

import football.converter.LeagueToLeagueDb;
import football.db.LeagueDb;
import football.input.data.fixtures.FixtureWrapper;
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
	
	public void readMultipleSeasons(int seasonKey) {
		LeagueWrapper leagueWrapper = fixtureReader.readLeagues(seasonKey);
		for (League league: leagueWrapper.getApi().getLeagues()) {
			LeagueDb leagueDb = leagueConverter.convert(league);
			leagueService.saveLeague(leagueDb);
			FixtureWrapper fixtureWrapper = fixtureReader.readFixtures(league.getLeagueId());
			fixtureService.saveFixtures(fixtureWrapper.getApi().getFixtures(), leagueDb);;
		}

	}
}
