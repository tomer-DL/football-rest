package football.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import football.model.metaData.RecordCounts;
import football.service.MetaDataService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@Api(tags="Meta Data Controller")
public class MetaDataController {
	private MetaDataService MetaDataService;
	
	@GetMapping("/football/metadata")
	@ApiOperation("Get the number of records in key DB tables")
	public RecordCounts getMetaData() {
		return MetaDataService.readRecordCounts();
	}
}
