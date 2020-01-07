package football.standing;

import football.db.TeamDb;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TeamRecord {
	private TeamDb team;
	private int homeGoalsFor;
	private int homeGoalsAgainst;
	private int awayGoalsFor;
	private int awayGoalsAgainst;
	private int homeWins;
	private int homeDraws;
	private int homeLosses;
	private int awayWins;
	private int awayDraws;
	private int awayLosses;
	
	public TeamRecord(TeamDb team) {
		this.team = team;
	}
	
	public int getHomePoints() {
		return homeWins*3 + homeDraws;
	}
	public int getAwayPoints() {
		return awayWins*3 + awayDraws;
	}
	
	public int getTotalPoints() {
		return getHomePoints() + getAwayPoints();
	}
	
	public int getHomeGoalDifference() {
		return homeGoalsFor - homeGoalsAgainst;
	}

	public int getAwayGoalDifference() {
		return awayGoalsFor - awayGoalsAgainst;
	}

	public int getTotalGoalDifference() {
		return getHomeGoalDifference() + getAwayGoalDifference();
	}
	
	public int getTotalGoalsFor() {
		return getAwayGoalsFor() + getHomeGoalsFor();
	}
}
