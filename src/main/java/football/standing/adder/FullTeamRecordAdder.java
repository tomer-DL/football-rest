package football.standing.adder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import football.db.FixtureDb;
import football.db.TeamDb;
import football.standing.TeamRecord;

public class FullTeamRecordAdder implements TeamRecordAdder {

	@Override
	public List<TeamRecord> sumUpFixtures(List<FixtureDb> fixtures) {
		Map<TeamDb, TeamRecord> teamToTeamRecord = new HashMap<TeamDb, TeamRecord>();
		for (FixtureDb fixtureDb : fixtures) {
			TeamDb awayTeam = fixtureDb.getAwayTeam();
			TeamRecord awayTeamRecord = teamToTeamRecord.get(awayTeam);
			if(awayTeamRecord == null) {
				awayTeamRecord = new TeamRecord(awayTeam);
				teamToTeamRecord.put(awayTeam, awayTeamRecord);
			}
			TeamDb homeTeam = fixtureDb.getHomeTeam();
			TeamRecord homeTeamRecord = teamToTeamRecord.get(homeTeam);
			if(homeTeamRecord == null) {
				homeTeamRecord = new TeamRecord(homeTeam);
				teamToTeamRecord.put(homeTeam, homeTeamRecord);
			}

			homeTeamRecord.setHomeGoalsFor(homeTeamRecord.getHomeGoalsFor() + fixtureDb.getGoalsHomeTeam());
			homeTeamRecord.setHomeGoalsAgainst(homeTeamRecord.getHomeGoalsAgainst() + fixtureDb.getGoalsAwayTeam());
			awayTeamRecord.setAwayGoalsFor(awayTeamRecord.getAwayGoalsFor() + fixtureDb.getGoalsAwayTeam());
			awayTeamRecord.setAwayGoalsAgainst(awayTeamRecord.getAwayGoalsAgainst() + fixtureDb.getGoalsHomeTeam());
		
			if(fixtureDb.getGoalsHomeTeam() > fixtureDb.getGoalsAwayTeam()) {
				homeTeamRecord.setHomeWins(homeTeamRecord.getHomeWins() + 1);
				awayTeamRecord.setAwayLosses(awayTeamRecord.getAwayLosses() + 1);
			}
			else if(fixtureDb.getGoalsHomeTeam() == fixtureDb.getGoalsAwayTeam()) {
				homeTeamRecord.setHomeDraws(homeTeamRecord.getHomeDraws() + 1);
				awayTeamRecord.setAwayDraws(awayTeamRecord.getAwayDraws() + 1);
			}
			else  {
				homeTeamRecord.setHomeLosses(homeTeamRecord.getHomeLosses() + 1);
				awayTeamRecord.setAwayWins(awayTeamRecord.getAwayWins() + 1);
			}
		}
		
		return new ArrayList<TeamRecord>(teamToTeamRecord.values());
	}

}
