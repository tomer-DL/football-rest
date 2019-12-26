package football.db;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "Team")
@Getter
@Setter
public class TeamDb {
	@Id
	Integer id;
	String teamName;
	
}
