package football.standing.adder;

import java.util.List;

import football.model.FixtureDb;
import football.standing.TeamRecord;

public interface TeamRecordAdder {
	List<TeamRecord> sumUpFixtures(List<FixtureDb> fixtures);
}
