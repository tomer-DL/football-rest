package football.model;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "Team")
@Getter
@Setter
@ToString
public class TeamDb {
	@Id
	Integer id;
	String teamName;
	
}
