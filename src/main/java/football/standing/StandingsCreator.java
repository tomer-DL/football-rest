package football.standing;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import football.model.FixtureDb;
import football.standing.adder.TeamRecordAdder;
import football.standing.comparator.TeamRecordComparator;
import football.standing.comparator.TeamRecordComparatorAccumulator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class StandingsCreator {	
	
	public List<TeamRecord> createStandings(TeamRecordAdder adder, 
			List<TeamRecordComparator> comparatorList, List<FixtureDb> fixtures) {
		TeamRecordComparatorAccumulator comparator = new TeamRecordComparatorAccumulator(comparatorList, fixtures);
		List<TeamRecord> records = adder.sumUpFixtures(fixtures);
		Collections.sort(records, comparator);
		return records;
	}


}
