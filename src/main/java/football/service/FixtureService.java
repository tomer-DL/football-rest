package football.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import football.converter.FixtureToFixtureDb;
import football.db.FixtureDb;
import football.db.LeagueDb;
import football.db.enums.FixtureStatus;
import football.input.data.fixtures.Fixture;
import football.repository.FixtureRepository;
import football.repository.TeamRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FixtureService {
	private FixtureRepository fixtureRepository;
	private TeamRepository teamRepository;
	private FixtureToFixtureDb fixtureConverter;
	
	public void saveFixturesDb(List<FixtureDb> fixtures) {
		Set<Integer> teams = new HashSet<Integer>();
		for (FixtureDb fixtureDb : fixtures) {
			if(!teams.contains(fixtureDb.getHomeTeam().getId())) {
				teamRepository.saveAndFlush(fixtureDb.getHomeTeam());
				teams.add(fixtureDb.getHomeTeam().getId());
			}
			if(!teams.contains(fixtureDb.getAwayTeam().getId())) {
				teamRepository.saveAndFlush(fixtureDb.getAwayTeam());
				teams.add(fixtureDb.getAwayTeam().getId());
			}
			fixtureRepository.save(fixtureDb);
		}

	}
	
	public void saveFixtures(List<Fixture> fixtures, LeagueDb league) {
		List<FixtureDb> fixtureDbs = new ArrayList<FixtureDb>();
		for (Fixture fixture : fixtures) {
			FixtureDb fixtureDb = fixtureConverter.convert(fixture);
			fixtureDb.setLeague(league);
			fixtureDbs.add(fixtureDb);
		}
		saveFixturesDb(fixtureDbs);
	}

	public List<FixtureDb> getAllFixtures(int seasonId, FixtureStatus fixtureStatus) {
		return fixtureRepository.findByLeagueIdAndStatus(seasonId, fixtureStatus);
	}

	public List<FixtureDb> getAllFixtures(int seasonId, int teamId) {
		return fixtureRepository.findByLeagueIdAndTeamId(seasonId, teamId);
	}

	public List<FixtureDb> getTeamVsTeamFixtures(int team1, int team2) {
		return fixtureRepository.findTeamVsTeam(team1, team2);
	}
}
