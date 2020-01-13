package football.converter;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import football.model.enums.FixtureStatus;

@Service
public class StringToFixtureStatus implements Converter<String, FixtureStatus> {
	private static Map<String, FixtureStatus> mapper;
	
	static {
		mapper = new HashMap<String, FixtureStatus>();
		mapper.put("FT", FixtureStatus.FULL_TIME);
		mapper.put("NS", FixtureStatus.NOT_STARTED);
	}
	
	@Override
	public FixtureStatus convert(String source) {
		FixtureStatus fs = mapper.get(source);
		if(fs == null)
			fs = FixtureStatus.IN_PROGRESS;
		return fs;
	}

}
