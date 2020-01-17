package football.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import football.exception.ResourceNotFoundException;
import football.model.TeamDb;
import football.repository.TeamRepository;

@ExtendWith(MockitoExtension.class)
class TeamServiceTest {
	
	@InjectMocks
	TeamService service;
	
	@Mock
	TeamRepository repository;
	
	@AfterEach
	void tearDown() throws Exception {
		reset(repository);
	}

	@Test
	void testGetTeam() {
		TeamDb team = new TeamDb();
		team.setId(1);
		given(repository.findById(1))
		.willReturn(Optional.of(team));
		given(repository.findById(2))
		.willReturn(Optional.empty());
		
		TeamDb found = service.getTeam(1);
		assertEquals(1, found.getId());
		
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getTeam(2));
	}
	
	@Test
	void testGetByTeamName() {
		TeamDb team = new TeamDb();
		team.setId(1);
		given(repository.findByTeamName("A"))
		.willReturn(Optional.of(team));
		given(repository.findByTeamName("B"))
		.willReturn(Optional.empty());
		
		TeamDb found = service.getByTeamName("A");
		assertEquals(1, found.getId());
		
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getByTeamName("B"));
	}
	
	@Test
	void testGetAllTeams() {
		List<TeamDb> teams = new ArrayList<TeamDb>();
		given(repository.findAll())
		.willReturn(teams);
		
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getAllTeams());
		
		teams.add(new TeamDb());
		teams.add(new TeamDb());
		
		List<TeamDb> found = service.getAllTeams();
		assertEquals(2, found.size());
	}

	
	@Test
	void testGetTeamsBySeasonId() {
		List<TeamDb> emptyList = new ArrayList<TeamDb>();
		List<TeamDb> notEmptyList = new ArrayList<TeamDb>();
		notEmptyList.add(new TeamDb());
		given(repository.findBySeason(1))
		.willReturn(emptyList);
		given(repository.findBySeason(2))
		.willReturn(notEmptyList);
		
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getTeamsBySeasonId(1));
		
		List<TeamDb> found = service.getTeamsBySeasonId(2);
		assertEquals(1, found.size());
	}
}
