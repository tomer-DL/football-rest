package football.standing.adder;

import java.util.List;

import football.db.FixtureDb;
import football.standing.TeamRecord;

public interface TeamRecordAdder {
	List<TeamRecord> sumUpFixtures(List<FixtureDb> fixtures);
}
