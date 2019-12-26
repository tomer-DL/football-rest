package football.converter;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import football.db.FixtureDb;
import football.input.data.fixtures.Fixture;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Service
@Getter
@Setter
@AllArgsConstructor
public class FixtureToFixtureDb implements Converter<Fixture, FixtureDb> {
	private TeamToTeamDb teamConverter;
	private StringToFixtureStatus statusConverter;


	@Override
	public FixtureDb convert(Fixture fixture) {
		FixtureDb fixtureDb = new FixtureDb();
		fixtureDb.setAwayTeam(teamConverter.convert(fixture.getAwayTeam()));
		fixtureDb.setEventDate(Date.valueOf(fixture.getEventDate().substring(0, 10)));
		fixtureDb.setGoalsAwayTeam(fixture.getGoalsAwayTeam() != null?fixture.getGoalsAwayTeam():0);
		fixtureDb.setGoalsHomeTeam(fixture.getGoalsHomeTeam() != null?fixture.getGoalsHomeTeam():0);
		fixtureDb.setHomeTeam(teamConverter.convert(fixture.getHomeTeam()));
		fixtureDb.setId(fixture.getFixtureId());
		fixtureDb.setRound(extractRound(fixture.getRound()));
		fixtureDb.setVenue(fixture.getVenue());
		fixtureDb.setStatus(statusConverter.convert(fixture.getStatusShort()));
		return fixtureDb;
	}

	private int extractRound(String round) {
		Pattern pat = Pattern.compile("\\D*(\\d{1,2})\\D*");
		Matcher mat = pat.matcher(round);
		if(mat.find())
			return Integer.parseInt(mat.group(1));
		else
			return 0;
	}

}
