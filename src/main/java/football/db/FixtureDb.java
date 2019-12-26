package football.db;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import football.db.enums.FixtureStatus;
import lombok.Getter;
import lombok.Setter;

@Entity(name="Fixture")
@Getter
@Setter
public class FixtureDb {
    @Id
	private Integer id;
    @JoinColumn(name="leagueId")
    @ManyToOne
    private LeagueDb league;
    private Date eventDate;
    private int round;
    private String venue;
    @JoinColumn(name="homeTeamId")
    @ManyToOne
    private TeamDb homeTeam;
    @JoinColumn(name="awayTeamId")
    @ManyToOne
    private TeamDb awayTeam;
    private int goalsHomeTeam;
    private int goalsAwayTeam;
	@Enumerated(EnumType.ORDINAL)
    private FixtureStatus status;
    
}
