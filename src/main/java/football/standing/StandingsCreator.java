package football.standing;

import java.util.Collections;
import java.util.List;

import football.db.FixtureDb;

public class StandingsCreator {
	private TeamRecordAdder adder;
	private TeamRecordComparatorAccumulator comparator;
	
	public List<TeamRecord> createStandings(List<FixtureDb> fixtures) {
		List<TeamRecord> records = adder.sumUpFixtures(fixtures);
		Collections.sort(records, comparator);
		return records;
	}


}
