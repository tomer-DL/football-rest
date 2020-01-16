package football.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Sort;

import football.exception.ResourceNotFoundException;
import football.model.LeagueDb;
import football.repository.LeagueRepository;

@ExtendWith(MockitoExtension.class)
class LeagueServiceTest {
	@InjectMocks
	LeagueService service;
	
	@Mock
	LeagueRepository leagueRepository;
	
	@Test
	void testGetAllLeaguesWhenExists() {
		List<LeagueDb> leagues = new ArrayList<>();
		leagues.add(new LeagueDb());
		given(leagueRepository.findAll(any(Sort.class)))
			.willReturn(leagues);
		
		List<LeagueDb> found = service.getAllLeagues();
		
		assertEquals(1, found.size());
	}

	@Test
	void testGetAllLeaguesWhenNotExists() {
		List<LeagueDb> leagues = new ArrayList<>();
		given(leagueRepository.findAll(any(Sort.class)))
			.willReturn(leagues);
		
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getAllLeagues());
	}

	@Test
	void testGetExistingLeagueById() {
		LeagueDb league = new LeagueDb();
		league.setId(5);
		given(leagueRepository.findById(5))
			.willReturn(Optional.of(league));
		
		LeagueDb found = service.getLeagueById(5);
		assertNotNull(found);
	}

	@Test
	void testGetNonExistingLeagueById() {
		given(leagueRepository.findById(5))
			.willReturn(Optional.empty());
		
		Assertions.assertThrows(ResourceNotFoundException.class, 
				() -> service.getLeagueById(5));
	}

}
