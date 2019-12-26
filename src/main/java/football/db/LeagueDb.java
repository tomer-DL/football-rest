package football.db;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="League")
@Getter
@Setter
public class LeagueDb {
	@Id
	private Integer id;
	private String name;
	private String country;
	private int seasonYear;
	private Date seasonStart;
	private Date seasonEnd;
}
