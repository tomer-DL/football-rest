package football.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import football.converter.FixtureToFixtureDb;
import football.exception.ResourceNotFoundException;
import football.model.FixtureDb;
import football.model.TeamDb;
import football.model.enums.FixtureStatus;
import football.repository.FixtureRepository;
import football.repository.TeamRepository;

@ExtendWith(MockitoExtension.class)
class FixtureServiceTest {
	private static final int NUMBER_OF_TEAMS = 5;

	@InjectMocks
	FixtureService service;

	@Mock
	FixtureRepository fixtureRepository;
	@Mock
	TeamRepository teamRepository;
	@Mock
	FixtureToFixtureDb fixtureConverter;

	@AfterEach
	void tearDown() throws Exception {
		reset(fixtureRepository, teamRepository, fixtureConverter);
	}

	@Test
	void testSaveFixturesDb() {
		List<FixtureDb> fixtures = createFixtures();

		service.saveFixturesDb(fixtures);

		verify(teamRepository, times(NUMBER_OF_TEAMS))
		.saveAndFlush(any(TeamDb.class));
		verify(fixtureRepository, times(fixtures.size()))
		.save(any(FixtureDb.class));

	}

	private List<FixtureDb> createFixtures() {
		List<FixtureDb> fixtureDbs = new ArrayList<>();
		TeamDb [] teams = new TeamDb[NUMBER_OF_TEAMS];
		for(int i=0; i<teams.length; i++) {
			teams[i] = new TeamDb();
			teams[i].setId(i+1);
		}
		for(int i=0; i<teams.length; i++) {
			for(int j=0; j<teams.length; j++) {
				if(i != j) {
					FixtureDb fixture = new FixtureDb();
					fixture.setHomeTeam(teams[i]);
					fixture.setAwayTeam(teams[j]);
					fixtureDbs.add(fixture);
				}
			}
		}

		return fixtureDbs;
	}

	@Test
	void testGetAllFixturesIntFixtureStatus() {
		List<FixtureDb> fixtures = new ArrayList<>();
		given(fixtureRepository.
				findByLeagueIdAndStatus(
						anyInt(), any(FixtureStatus.class)))
		.willReturn(fixtures);

		// fixtures.size() == 0 
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getAllFixtures(2, FixtureStatus.FULL_TIME));

		fixtures.add(new FixtureDb());

		// fixtures.size() > 0 
		List<FixtureDb> found = service.getAllFixtures(2, FixtureStatus.FULL_TIME);
		assertEquals(found, fixtures);
	}

	@Test
	void testGetAllFixturesIntInt() {
		List<FixtureDb> fixtures = new ArrayList<>();
		given(fixtureRepository.
				findByLeagueIdAndTeamId(anyInt(), anyInt()))
		.willReturn(fixtures);

		// fixtures.size() == 0 
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getAllFixtures(2, 1));

		fixtures.add(new FixtureDb());

		// fixtures.size() > 0 
		List<FixtureDb> found = service.getAllFixtures(2, 1);
		assertEquals(found, fixtures);
	}

	@Test
	void testGetTeamVsTeamFixtures() {
		List<FixtureDb> fixtures = new ArrayList<>();
		given(fixtureRepository.
				findTeamVsTeam(anyInt(), anyInt()))
		.willReturn(fixtures);

		// fixtures.size() == 0 
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getTeamVsTeamFixtures(2, 1));

		fixtures.add(new FixtureDb());

		// fixtures.size() > 0 
		List<FixtureDb> found = service.getTeamVsTeamFixtures(2, 1);
		assertEquals(found, fixtures);
	}

}
