package football.input.reader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import football.input.data.fixtures.FixtureWrapper;
import football.input.data.leagues.LeagueWrapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FixtureReader {
	
	RestTemplateBuilder restTemplateBuilder;
	
	public FixtureWrapper readFixtures(int seasonId, String token) {
		HttpHeaders headers = new HttpHeaders();
		String url = "https://api-football-v1.p.rapidapi.com/v2/fixtures/league/{id}";
		headers.add("x-rapidapi-host", "api-football-v1.p.rapidapi.com");
		headers.add("x-rapidapi-key", token);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", Integer.toString(seasonId));
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<FixtureWrapper> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, FixtureWrapper.class, params);
		return responseEntity.getBody();
	}
	
	
	public LeagueWrapper readLeagues(int seasonId, String token) {
		HttpHeaders headers = new HttpHeaders();
		String url = "https://api-football-v1.p.rapidapi.com/v2/leagues/seasonsAvailable/{id}";
		headers.add("x-rapidapi-host", "api-football-v1.p.rapidapi.com");
		headers.add("x-rapidapi-key", token);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", Integer.toString(seasonId));
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<LeagueWrapper> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, LeagueWrapper.class, params);
		return responseEntity.getBody();
		
	}
	
	public LeagueWrapper readLeagueById(int seasonId, String token) {
		HttpHeaders headers = new HttpHeaders();
		String url = "https://api-football-v1.p.rapidapi.com/v2/leagues/league/{id}";
		headers.add("x-rapidapi-host", "api-football-v1.p.rapidapi.com");
		headers.add("x-rapidapi-key", token);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
		Map<String, String> params = new HashMap<String, String>();
		params.put("id", Integer.toString(seasonId));
		RestTemplate restTemplate = restTemplateBuilder.build();
		ResponseEntity<LeagueWrapper> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, LeagueWrapper.class, params);
		return responseEntity.getBody();
	}
	
}
