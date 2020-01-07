package football.standing.comparator;

import java.util.List;

import football.db.FixtureDb;
import football.standing.TeamRecord;

public class PointsComparator implements TeamRecordComparator {

	@Override
	public int compare(TeamRecord t1, TeamRecord t2, List<FixtureDb> fixtures) {
		return t2.getTotalPoints() - t1.getTotalPoints();
	}

}
