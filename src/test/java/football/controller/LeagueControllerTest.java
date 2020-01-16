package football.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import football.exception.ResourceNotFoundException;
import football.model.LeagueDb;
import football.service.LeagueService;

@WebMvcTest(LeagueController.class)
class LeagueControllerTest {
	@MockBean
	LeagueService leagueService;
	
	@Autowired
	MockMvc mockMvc;
	
	@AfterEach
	public void tearDown() {
		reset(leagueService);
	}
	
	@Test
	void testGetAllLeaguesSuccessful() throws Exception {
		List<LeagueDb> leagues = new ArrayList<>();
		given(leagueService.getAllLeagues())
			.willReturn(leagues);
		
		mockMvc.perform(get("/football/league/all"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON));
			
	}

	@Test
	void testGetAllLeaguesUnsuccessful() throws Exception {
		given(leagueService.getAllLeagues())
			.willThrow(ResourceNotFoundException.class);
		
		mockMvc.perform(get("/football/league/all"))
			.andExpect(status().isNotFound());
			
	}

}
