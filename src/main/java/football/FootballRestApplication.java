package football;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import football.input.data.leagues.League;
import football.input.data.leagues.LeagueWrapper;
import football.input.data.mine.DataMiner;
import football.input.reader.FixtureReader;
import football.service.FixtureService;
import football.service.LeagueService;

@SpringBootApplication
public class FootballRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballRestApplication.class, args);
//		ApplicationContext context = SpringApplication.run(FootballRestApplication.class, args);
//		DataMiner dataMiner = context.getBean(DataMiner.class);
//		dataMiner.readMultipleSeasons(2);
		
	}

}
