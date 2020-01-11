package football.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import football.db.metaData.RecordCounts;
import football.service.MetaDataService;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class MetaDataController {
	private MetaDataService MetaDataService;
	
	@GetMapping("/football/metadata")
	public RecordCounts getMetaData() {
		return MetaDataService.readRecordCounts();
	}
}
