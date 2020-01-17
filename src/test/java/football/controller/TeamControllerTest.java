package football.controller;

import static org.junit.jupiter.api.Assertions.*;
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
import football.model.TeamDb;
import football.service.TeamService;

@WebMvcTest(TeamController.class)
class TeamControllerTest {

	@MockBean
	TeamService service;
	
	@Autowired
	MockMvc mockMvc;
	
	@AfterEach
	void tearDown() throws Exception {
		reset(service);
	}

	@Test
	void testGetTeamById() throws Exception {
		given(service.getTeam(1))
		.willReturn(new TeamDb());
		given(service.getTeam(2))
		.willThrow(ResourceNotFoundException.class);
		
		mockMvc.perform(get("/football/team/{teamId}", 1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		mockMvc.perform(get("/football/team/{teamId}", 2))
		.andExpect(status().isNotFound());
	}

	@Test
	void testGetAllTeams() throws Exception {
		List<TeamDb> teams = new ArrayList<TeamDb>();
		given(service.getAllTeams())
		.willReturn(teams);
		
		mockMvc.perform(get("/football/teams/all"))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));

		given(service.getAllTeams())
		.willThrow(ResourceNotFoundException.class);
		
		mockMvc.perform(get("/football/teams/all"))
		.andExpect(status().isNotFound());
	}

	@Test
	void testGetAllTeamsForSeason() throws Exception {
		List<TeamDb> teams = new ArrayList<TeamDb>();
		given(service.getTeamsBySeasonId(1))
		.willReturn(teams);
		given(service.getTeamsBySeasonId(2))
		.willThrow(ResourceNotFoundException.class);
		
		mockMvc.perform(get("/football/teams//season/{seasonId}", 1))
		.andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		mockMvc.perform(get("/football/teams//season/{seasonId}", 2))
		.andExpect(status().isNotFound());
	}

}
