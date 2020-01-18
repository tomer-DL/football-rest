package football.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import football.model.TeamDb;

@DataJpaTest
class TeamRepositoryTest {
	@Autowired
	TeamRepository repository;
	
	@Test
	void testFindByTeamName() {
		Optional<TeamDb> existing = repository.findByTeamName("Liverpool");
		Optional<TeamDb> nonExisting = repository.findByTeamName("Barcelona");
		
		assertTrue(existing.isPresent());
		assertFalse(nonExisting.isPresent());
	}

	@Test
	void testFindBySeason() {
		assertEquals(20, repository.findBySeason(700).size());
		assertEquals(20, repository.findBySeason(699).size());
		assertEquals(0, repository.findBySeason(0).size());
	}

	@Test
	void testCount() {
		assertEquals(23, repository.count());
	}

}
