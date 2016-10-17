package it.com.pasculli.rps.domain.strategies;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import it.com.pasculli.rps.domain.enums.Move;

/**
 * Test class for {@link it.com.pasculli.rps.domain.strategies.RandomAIStrategy}
 * @author simone
 *
 */
public class RandomAIStrategyTest {

	@Test
	public void computeChoiceTest() {

		AIStrategy strategy = new RandomAIStrategy();
		
		Move move = strategy.computeChoice();
		
		assertNotNull(move);
		assertTrue(Arrays.asList(Move.values()).contains(move));
		
	}

}
