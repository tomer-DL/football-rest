package football.standing;

import java.util.List;

import football.db.FixtureDb;

public interface TeamRecordAdder {
	List<TeamRecord> sumUpFixtures(List<FixtureDb> fixtures);
}
