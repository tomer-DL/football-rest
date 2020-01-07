package football;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FootballRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FootballRestApplication.class, args);
//		ApplicationContext context = SpringApplication.run(FootballRestApplication.class, args);
//		DataMiner dataMiner = context.getBean(DataMiner.class);
//		dataMiner.readMultipleSeasons(2);
		
	}

}
