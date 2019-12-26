package football.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import football.FootballRestApplication;
import lombok.AllArgsConstructor;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AllArgsConstructor
@ContextConfiguration
public class CheckTeam {
//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplate;
//	private EntityManager entityManager;
	private TeamRepository teamRepository;
	
	@Test
	void checkInjections() {
//		assertNotNull(dataSource);
//		assertNotNull(jdbcTemplate);
//		assertNotNull(entityManager);
		assertNotNull(teamRepository);
	}
	
}
