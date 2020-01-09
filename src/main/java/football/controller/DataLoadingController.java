package football.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import football.input.data.mine.DataMiner;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class DataLoadingController {
	private DataMiner dataMiner;
	
	@PostMapping("/football/loadData/{seasonId}/all")
	@ResponseStatus(HttpStatus.CREATED)
	public void loadAll(@PathVariable int seasonId, @RequestParam String token) {
		dataMiner.readMultipleSeasons(seasonId, token);
		
	}

	@PostMapping("/football/loadData/{seasonId}/one")
	@ResponseStatus(HttpStatus.CREATED)
	public void loadSpecificSeason(@PathVariable int seasonId, @RequestParam String token) {
		dataMiner.readSpecificSeason(seasonId, token);
		
	}

}
