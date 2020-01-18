package football.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import football.model.enums.FixtureStatus;

@DataJpaTest
class FixtureRepositoryTest {
	@Autowired
	FixtureRepository repository;

	@Test
	void testFindByLeagueIdAndStatus() {
		assertEquals(380, repository.findByLeagueIdAndStatus(699, 
				FixtureStatus.FULL_TIME).size());
	}

	@Test
	void testFindByLeagueIdAndTeamId() {
		assertEquals(38, 
				repository.findByLeagueIdAndTeamId(700, 40).size()); 

	}

	@Test
	void testFindTeamVsTeam() {
		assertEquals(4, repository.findTeamVsTeam(40, 42).size());
	}

	@Test
	void testCountExampleOfS() {
		assertEquals(760, repository.count());
	}

}
