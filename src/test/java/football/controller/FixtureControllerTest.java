package football.controller;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import football.exception.ResourceNotFoundException;
import football.model.FixtureDb;
import football.model.enums.FixtureStatus;
import football.service.FixtureService;

@WebMvcTest(FixtureController.class)
class FixtureControllerTest {
	@MockBean
	FixtureService service;
	
	@Autowired
	MockMvc mockMvc;

	@AfterEach
	void tearDown() throws Exception {
		reset(service);
	}

	@Test
	void testGetAllFixturesForSeasonIntOptionalOfInteger() throws Exception {
		List<FixtureDb> fixtures = new ArrayList<FixtureDb>();
		given(service.getAllFixtures(2,FixtureStatus.FULL_TIME))
		.willReturn(fixtures);
		given(service.getAllFixtures(12,FixtureStatus.FULL_TIME))
		.willThrow(ResourceNotFoundException.class);
		
		mockMvc.perform(get("/football/fixture/season/{seasonId}/{status}", 2, FixtureStatus.FULL_TIME.ordinal()))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));

		// without the optional parameter
		mockMvc.perform(get("/football/fixture/season/{seasonId}/", 2))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		
		mockMvc.perform(get("/football/fixture/season/{seasonId}/{status}", 12, FixtureStatus.FULL_TIME.ordinal()))
		.andExpect(status().isNotFound());
		
	}

	@Test
	void testGetAllFixturesForSeasonForTeam() throws Exception {
		List<FixtureDb> fixtures = new ArrayList<FixtureDb>();
		given(service.getAllFixtures(2,1))
		.willReturn(fixtures);
		given(service.getAllFixtures(12,11))
		.willThrow(ResourceNotFoundException.class);
		
		mockMvc.perform(get("/football/fixture/season/{seasonId}/team/{teamId}", 2, 1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		mockMvc.perform(get("/football/fixture/season/{seasonId}/team/{teamId}", 12, 11))
		.andExpect(status().isNotFound());
	}

	@Test
	void testGetTeamVsTeam() throws Exception {
		List<FixtureDb> fixtures = new ArrayList<FixtureDb>();
		given(service.getTeamVsTeamFixtures(2,1))
		.willReturn(fixtures);
		given(service.getTeamVsTeamFixtures(12,11))
		.willThrow(ResourceNotFoundException.class);
		
		mockMvc.perform(get("/football/fixture/teamVteam/{team1}/{team2}", 2, 1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		mockMvc.perform(get("/football/fixture/teamVteam/{team1}/{team2}", 12, 11))
		.andExpect(status().isNotFound());
	}

}
