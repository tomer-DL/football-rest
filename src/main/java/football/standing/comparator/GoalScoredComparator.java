package football.standing.comparator;

import java.util.List;

import football.model.FixtureDb;
import football.standing.TeamRecord;

public class GoalScoredComparator implements TeamRecordComparator {

	@Override
	public int compare(TeamRecord t1, TeamRecord t2, List<FixtureDb> fixtures) {
		return t2.getTotalGoalsFor() - t1.getTotalGoalsFor();
	}

}
