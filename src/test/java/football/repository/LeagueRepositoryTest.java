package football.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import football.model.LeagueDb;

@DataJpaTest
class LeagueRepositoryTest {
	@Autowired
	LeagueRepository repository;
	
	@Test
	void testCount() {
		assertEquals(2, repository.count());
	}
	
	@Test
	void testFindById() {
		Optional<LeagueDb> existing = repository.findById(699);
		Optional<LeagueDb> nonExisting = repository.findById(1);
		
		assertTrue(existing.isPresent());
		assertFalse(nonExisting.isPresent());
	}

}
