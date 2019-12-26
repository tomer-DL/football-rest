package football.converter;

import java.sql.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import football.db.LeagueDb;
import football.input.data.leagues.League;

@Service
public class LeagueToLeagueDb implements Converter<League, LeagueDb> {

	@Override
	public LeagueDb convert(League league) {
		LeagueDb leagueDb = new LeagueDb();
		leagueDb.setCountry(league.getCountry());
		leagueDb.setName(league.getName());
		leagueDb.setId(league.getLeagueId());
		leagueDb.setSeasonEnd(Date.valueOf(league.getSeasonEnd()));
		leagueDb.setSeasonStart(Date.valueOf(league.getSeasonStart()));
		leagueDb.setSeasonYear(league.getSeason());
		return leagueDb;
	}

}
