package football.standing.adder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import football.model.FixtureDb;
import football.model.TeamDb;
import football.standing.TeamRecord;

public class HomeTeamRecordAdder implements TeamRecordAdder {

	@Override
	public List<TeamRecord> sumUpFixtures(List<FixtureDb> fixtures) {
		Map<TeamDb, TeamRecord> teamToTeamRecord = new HashMap<TeamDb, TeamRecord>();
		for (FixtureDb fixtureDb : fixtures) {
			TeamDb homeTeam = fixtureDb.getHomeTeam();
			TeamRecord homeTeamRecord = teamToTeamRecord.get(homeTeam);
			if(homeTeamRecord == null) {
				homeTeamRecord = new TeamRecord(homeTeam);
				teamToTeamRecord.put(homeTeam, homeTeamRecord);
			}

			homeTeamRecord.setHomeGoalsFor(homeTeamRecord.getHomeGoalsFor() + fixtureDb.getGoalsHomeTeam());
			homeTeamRecord.setHomeGoalsAgainst(homeTeamRecord.getHomeGoalsAgainst() + fixtureDb.getGoalsAwayTeam());
		
			if(fixtureDb.getGoalsHomeTeam() > fixtureDb.getGoalsAwayTeam()) {
				homeTeamRecord.setHomeWins(homeTeamRecord.getHomeWins() + 1);
			}
			else if(fixtureDb.getGoalsHomeTeam() == fixtureDb.getGoalsAwayTeam()) {
				homeTeamRecord.setHomeDraws(homeTeamRecord.getHomeDraws() + 1);
			}
			else  {
				homeTeamRecord.setHomeLosses(homeTeamRecord.getHomeLosses() + 1);
			}
		}
		
		return new ArrayList<TeamRecord>(teamToTeamRecord.values());
	}

}
