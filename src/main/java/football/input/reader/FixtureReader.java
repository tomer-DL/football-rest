package football.input.reader;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;

import football.input.data.fixtures.FixtureWrapper;
import football.input.data.leagues.LeagueWrapper;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class FixtureReader {
	
	private static final String RAPIDAPI_HOST = "api-football-v1.p.rapidapi.com";
	private static final int MB = 1024*1024;
	RestTemplateBuilder restTemplateBuilder;
	
	public FixtureWrapper readFixtures(int seasonId, String token) {
		ExchangeStrategies exchangeStrategies = 
			ExchangeStrategies.builder()
				.codecs(configurer -> configurer
				.defaultCodecs()
				.maxInMemorySize(MB))
				.build();
		WebClient webClient = WebClient.builder()
				.exchangeStrategies(exchangeStrategies)
				.build();
		return webClient.get()
			.uri(uriBuilder -> uriBuilder
				.scheme("https")
				.host(RAPIDAPI_HOST)
				.path("/v2/fixtures/league/{id}")
				.build(seasonId))
			.header("x-rapidapi-host", RAPIDAPI_HOST)
			.header("x-rapidapi-key", token)
			.header("accept", MediaType.APPLICATION_JSON_VALUE)
			.retrieve()
			.bodyToMono(FixtureWrapper.class)
			.block();
	}
	
	public LeagueWrapper readLeagues(int seasonId, String token) {
		WebClient webClient = WebClient.create("https://" + RAPIDAPI_HOST);
		return webClient.get()
			.uri(uriBuilder -> uriBuilder
				.path("/v2/leagues/seasonsAvailable/{id}")
				.build(seasonId))
			.header("x-rapidapi-host", RAPIDAPI_HOST)
			.header("x-rapidapi-key", token)
			.header("accept", MediaType.APPLICATION_JSON_VALUE)
			.retrieve()
			.bodyToMono(LeagueWrapper.class)
			.block();
	}

	public LeagueWrapper readLeagueById(int seasonId, String token) {
		WebClient webClient = WebClient.create("https://" + RAPIDAPI_HOST);
		return webClient.get()
			.uri(uriBuilder -> uriBuilder
				.path("/v2/leagues/league/{id}")
				.build(seasonId))
			.header("x-rapidapi-host", RAPIDAPI_HOST)
			.header("x-rapidapi-key", token)
			.header("accept", MediaType.APPLICATION_JSON_VALUE)
			.retrieve()
			.bodyToMono(LeagueWrapper.class)
			.block();
	}

}
