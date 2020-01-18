package football;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import football.standing.TeamRecord;


@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class RestDemoApplicationTests {
	@LocalServerPort
    private int port;
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	void contextLoads() {
		TeamRecord[] records = restTemplate.getForObject(
				"http://localhost:" + port + "/football/standing/season/700/all", 
				TeamRecord[].class);
		List<String> teams = Arrays.stream(records)
				.map(record->record.getTeam().getTeamName())
				.collect(Collectors.toList());
		List<String> rightOrder = Arrays.asList("Manchester City", "Manchester United", "Arsenal", 
				"Tottenham", "Newcastle", "Chelsea", "Everton", "Liverpool", "Fulham", 
				"West Brom", "Swansea", "Norwich", "Sunderland", "Stoke City", 
				"Wigan", "Aston Villa", "QPR", "Bolton", "Blackburn", "Wolves");
		assertTrue(teams.equals(rightOrder));
	}

}
