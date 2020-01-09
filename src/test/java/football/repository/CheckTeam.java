package football.repository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CheckTeam {
//	private DataSource dataSource;
//	private JdbcTemplate jdbcTemplate;
//	private EntityManager entityManager;
	private TeamRepository teamRepository;

	

	void checkInjections() {
//		assertNotNull(dataSource);
//		assertNotNull(jdbcTemplate);
//		assertNotNull(entityManager);
		assertNotNull(teamRepository);
	}
	
}
