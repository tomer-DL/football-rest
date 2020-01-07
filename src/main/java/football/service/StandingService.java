package football.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import football.db.FixtureDb;
import football.db.enums.FixtureStatus;
import football.repository.FixtureRepository;
import football.standing.StandingsCreator;
import football.standing.TeamRecord;
import football.standing.adder.AwayTeamRecordAdder;
import football.standing.adder.FullTeamRecordAdder;
import football.standing.adder.HomeTeamRecordAdder;
import football.standing.adder.TeamRecordAdder;
import football.standing.comparator.GoalDifferenceComparator;
import football.standing.comparator.GoalScoredComparator;
import football.standing.comparator.PointsComparator;
import football.standing.comparator.TeamRecordComparator;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StandingService {
	private FixtureRepository fixtureRepository;
	private StandingsCreator standingsCreator;
	
	//TODO replace this static code with DB data
	private static Map<String, TeamRecordAdder> adderTypes;
	private static Map<String, List<TeamRecordComparator>> tieBreakRulesByCountry;
	
	//TODO replace this static code with DB data
	static {
		adderTypes = new HashMap<String, TeamRecordAdder>();
		adderTypes.put("ALL", new FullTeamRecordAdder());
		adderTypes.put("HOME", new HomeTeamRecordAdder());
		adderTypes.put("AWAY", new AwayTeamRecordAdder());
		List<TeamRecordComparator> compList = new ArrayList<TeamRecordComparator>();
		compList.add(new PointsComparator());
		compList.add(new GoalDifferenceComparator());
		compList.add(new GoalScoredComparator());
		tieBreakRulesByCountry = new HashMap<String, List<TeamRecordComparator>>();
		tieBreakRulesByCountry.put("England", compList);
	}

	public List<TeamRecord> getStandings(int seasonId) {
		return getStandings(seasonId, "ALL");
	}
	
	public List<TeamRecord> getHomeStandings(int seasonId) {
		return getStandings(seasonId, "HOME");
	}
	
	public List<TeamRecord> getAwayStandings(int seasonId) {
		return getStandings(seasonId, "AWAY");
	}
	
	private List<TeamRecord> getStandings(int seasonId, String standingType) {
		List<FixtureDb> fixtures = fixtureRepository.findByLeagueIdAndStatus(seasonId, FixtureStatus.FULL_TIME);
		if(fixtures != null && fixtures.size() > 0) {
			TeamRecordAdder adder = adderTypes.get(standingType);
			String country = fixtures.get(0).getLeague().getCountry();
			List<TeamRecordComparator> compList = tieBreakRulesByCountry.get(country);
			return standingsCreator.createStandings(adder, compList, fixtures);
		}
		else
			return null;
	}
}
