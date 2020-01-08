package football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import football.db.LeagueDb;

public interface LeagueRepository extends JpaRepository<LeagueDb, Integer> {
	
}
