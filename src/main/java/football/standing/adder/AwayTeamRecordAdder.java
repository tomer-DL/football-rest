package football.standing.adder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import football.model.FixtureDb;
import football.model.TeamDb;
import football.standing.TeamRecord;

public class AwayTeamRecordAdder implements TeamRecordAdder {

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

			awayTeamRecord.setAwayGoalsFor(awayTeamRecord.getAwayGoalsFor() + fixtureDb.getGoalsAwayTeam());
			awayTeamRecord.setAwayGoalsAgainst(awayTeamRecord.getAwayGoalsAgainst() + fixtureDb.getGoalsHomeTeam());
		
			if(fixtureDb.getGoalsHomeTeam() > fixtureDb.getGoalsAwayTeam()) {
				awayTeamRecord.setAwayLosses(awayTeamRecord.getAwayLosses() + 1);
			}
			else if(fixtureDb.getGoalsHomeTeam() == fixtureDb.getGoalsAwayTeam()) {
				awayTeamRecord.setAwayDraws(awayTeamRecord.getAwayDraws() + 1);
			}
			else  {
				awayTeamRecord.setAwayWins(awayTeamRecord.getAwayWins() + 1);
			}
		}
		
		return new ArrayList<TeamRecord>(teamToTeamRecord.values());
	}

}
