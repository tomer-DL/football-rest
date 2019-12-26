package football.standing;

import java.util.Comparator;
import java.util.List;

import football.db.FixtureDb;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TeamRecordComparatorAccumulator implements TeamRecordComparator, Comparator<TeamRecord> {
	List<TeamRecordComparator> comparatorList;
	List<FixtureDb> fixtures;
	
	@Override
	public int compare(TeamRecord t1, TeamRecord t2, List<FixtureDb> fixtures) {
		int val = 0;
		for (TeamRecordComparator comparator : comparatorList) {
			val = comparator.compare(t1, t2, fixtures);
			if(val != 0)
				return val;
		}
		return val;
	}

	@Override
	public int compare(TeamRecord t1, TeamRecord t2) {
		return compare(t1, t2, fixtures);
	}

}
