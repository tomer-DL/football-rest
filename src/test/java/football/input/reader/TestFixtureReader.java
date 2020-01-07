package football.input.reader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import football.input.data.fixtures.FixtureWrapper;

public class TestFixtureReader {
	FixtureReader fixtureReader;
	
	@Test
	public void readPremierLeague() {
		FixtureWrapper e = fixtureReader.readFixtures(2);
		assertEquals(380, e.getApi().getResults());
		assertEquals(380, e.getApi().getFixtures().size());
		
	}
}
