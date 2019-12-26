package football.standing;

import java.util.List;

import football.db.FixtureDb;

public class GoalDifferenceComparator implements TeamRecordComparator{

	@Override
	public int compare(TeamRecord t1, TeamRecord t2, List<FixtureDb> fixtures) {
		return t2.getTotalGoalDifference() - t1.getTotalGoalDifference();
	}

}
