package football.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration
@DataJpaTest()
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
