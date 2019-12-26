package football.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import football.db.TeamDb;

public interface TeamRepository extends JpaRepository<TeamDb, Integer> {
	public Optional<TeamDb> findByTeamName(String teamName);
	
	@Query("SELECT DISTINCT t from Team t inner join Fixture f on t.id=f.homeTeam where f.league.id=:seasonId")
	public List<TeamDb> findBySeason(@Param("seasonId") int seasonId);
} 
