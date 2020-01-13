package football.model.metaData;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RecordCounts {
	private int seasons;
	private int teams;
	private int fixtures;
}
