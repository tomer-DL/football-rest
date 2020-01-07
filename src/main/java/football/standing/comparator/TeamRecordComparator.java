package football.standing.comparator;

import java.util.List;

import football.db.FixtureDb;
import football.standing.TeamRecord;

public interface TeamRecordComparator {
	public int compare(TeamRecord t1, TeamRecord t2, List<FixtureDb> fixtures);
}
