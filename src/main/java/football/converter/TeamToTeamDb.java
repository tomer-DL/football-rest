package football.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

import football.db.TeamDb;
import football.input.data.fixtures.AwayTeam;
import football.input.data.fixtures.HomeTeam;

@Service
public class TeamToTeamDb implements Converter<HomeTeam, TeamDb> {

	@Override
	public TeamDb convert(HomeTeam team) {
		TeamDb teamDb = new TeamDb();
		teamDb.setId(team.getTeamId());
		teamDb.setTeamName(team.getTeamName());
		return teamDb;
	}

	public TeamDb convert(AwayTeam team) {
		TeamDb teamDb = new TeamDb();
		teamDb.setId(team.getTeamId());
		teamDb.setTeamName(team.getTeamName());
		return teamDb;
	}
}
