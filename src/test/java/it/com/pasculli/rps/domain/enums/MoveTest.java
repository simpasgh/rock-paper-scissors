package it.com.pasculli.rps.domain.enums;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Test class for {@link it.com.pasculli.rps.domain.enums.Move}
 * @author simone
 *
 */
public class MoveTest {

	@Test
	public void rockChallengeTest() {

		assertEquals(Result.WIN, Move.ROCK.challenge(Move.SCISSORS));
		assertEquals(Result.LOSE, Move.ROCK.challenge(Move.PAPER));
		assertEquals(Result.TIE, Move.ROCK.challenge(Move.ROCK));
	}

	@Test
	public void paperChallengeTest() {
		
		assertEquals(Result.WIN, Move.PAPER.challenge(Move.ROCK));
		assertEquals(Result.LOSE, Move.PAPER.challenge(Move.SCISSORS));
		assertEquals(Result.TIE, Move.PAPER.challenge(Move.PAPER));
	}

	@Test
	public void scissorsChallengeTest() {
		
		assertEquals(Result.WIN, Move.SCISSORS.challenge(Move.PAPER));
		assertEquals(Result.LOSE, Move.SCISSORS.challenge(Move.ROCK));
		assertEquals(Result.TIE, Move.SCISSORS.challenge(Move.SCISSORS));
	}
	
	@Test
	public void nullChallengeTest() {
		
		assertNull(Move.ROCK.challenge(null));
		assertNull(Move.PAPER.challenge(null));
		assertNull(Move.SCISSORS.challenge(null));
	}

}
