package football.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import football.db.FixtureDb;
import football.db.enums.FixtureStatus;


public interface FixtureRepository extends JpaRepository<FixtureDb, Integer> {

	
	List<FixtureDb> findByLeagueIdAndStatus(int seasonId, FixtureStatus fixtureStatus);
	
	@Query("SELECT f from Fixture f where f.league.id=:seasonId and (f.homeTeam.id= :teamId or f.awayTeam.id = :teamId)")
	List<FixtureDb> findByLeagueIdAndTeamId(int seasonId, int teamId);

}
