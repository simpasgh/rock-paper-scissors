package it.com.pasculli.rps.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import it.com.pasculli.rps.domain.enums.Result;
import it.com.pasculli.rps.exceptions.GameException;

/**
 * Test class for {@link it.com.pasculli.rps.domain.ComputerVsComputerGame}
 * @author simone
 *
 */
public class ComputerVsComputerGameTest {

	@Test
	public void playTest() throws GameException {

		Game game = new ComputerVsComputerGame();
		checksOnPlayers(game);
		
		Player winner = game.play();
		
		if(winner == null) {
			assertEquals(game.getPlayerOne().getMove(), game.getPlayerTwo().getMove());
			assertEquals(Result.TIE, game.getPlayerOne().getMove().challenge(game.getPlayerTwo().getMove()));
		} else if(winner.equals(game.getPlayerOne())) {
			assertEquals(Result.WIN, game.getPlayerOne().getMove().challenge(game.getPlayerTwo().getMove()));
			assertEquals(Result.LOSE, game.getPlayerTwo().getMove().challenge(game.getPlayerOne().getMove()));
		} else if(winner.equals(game.getPlayerTwo())) {
			assertEquals(Result.LOSE, game.getPlayerOne().getMove().challenge(game.getPlayerTwo().getMove()));
			assertEquals(Result.WIN, game.getPlayerTwo().getMove().challenge(game.getPlayerOne().getMove()));
		} else {
			throw new AssertionError("Wrong winner");
		}
	}
	
	/**
	 * Checks the launch of exception in case of null move for
	 * player one during play
	 * @throws GameException
	 */
	@Test(expected = GameException.class)
	public void nullMovePlayOneTest() throws GameException {
		
		Game game = new ComputerVsComputerGame();
		game.getPlayerOne().setMove(null);
		
		game.play();
	}
	
	/**
	 * Checks the launch of exception in case of null move for
	 * player two during play
	 * @throws GameException
	 */
	@Test(expected = GameException.class)
	public void nullMovePlayTwoTest() throws GameException {
		
		Game game = new ComputerVsComputerGame();
		game.getPlayerTwo().setMove(null);
		
		game.play();
	}
	
	/*
	 * Basic checks on players
	 */
	private void checksOnPlayers(Game game) {
		// checks on P1
		assertNotNull(game.getPlayerOne());
		assertNotNull(game.getPlayerOne().getName());
		assertNotNull(game.getPlayerOne().getMove());

		// checks on P2
		assertNotNull(game.getPlayerTwo());
		assertNotNull(game.getPlayerTwo().getName());
		assertNotNull(game.getPlayerTwo().getMove());
	}

}
