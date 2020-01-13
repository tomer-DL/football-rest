package football.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import football.model.LeagueDb;

public interface LeagueRepository extends JpaRepository<LeagueDb, Integer> {
	
}
