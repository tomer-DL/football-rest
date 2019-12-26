package football.standing;

import java.util.List;

import football.db.FixtureDb;

public interface TeamRecordComparator {
	public int compare(TeamRecord t1, TeamRecord t2, List<FixtureDb> fixtures);
}
