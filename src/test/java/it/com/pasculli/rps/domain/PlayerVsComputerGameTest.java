package it.com.pasculli.rps.domain;

import org.junit.Test;

import it.com.pasculli.rps.domain.enums.Move;
import it.com.pasculli.rps.exceptions.GameException;
import static org.junit.Assert.*;

/**
 * Test class for {@link it.com.pasculli.rps.domain.PlayerVsComputerGame}
 * @author simone
 *
 */
public class PlayerVsComputerGameTest {

	private final static String PLAYER_NAME = "Test Name";

	/**
	 * Checks the game with rock move
	 * @throws GameException
	 */
	@Test
	public void rockMoveTest() throws GameException {
		
		Game game = new PlayerVsComputerGame(PLAYER_NAME, Move.ROCK);

		checksOnPlayers(game);
		assertEquals(Move.ROCK, game.getPlayerOne().getMove());
		
		Player winner = game.play();
		
		if(winner == null) {
			assertEquals(Move.ROCK, game.getPlayerTwo().getMove());
		} else if(winner.equals(game.getPlayerOne())) {
			assertEquals(Move.SCISSORS, game.getPlayerTwo().getMove());
		} else if(winner.equals(game.getPlayerTwo())) {
			assertEquals(Move.PAPER, game.getPlayerTwo().getMove());
		} else {
			throw new AssertionError("Wrong winner");
		}

	}
	
	/**
	 * Checks the game with paper move
	 * @throws GameException
	 */
	@Test
	public void paperMoveTest() throws GameException {
		
		Game game = new PlayerVsComputerGame(PLAYER_NAME, Move.PAPER);

		checksOnPlayers(game);
		assertEquals(Move.PAPER, game.getPlayerOne().getMove());
		
		Player winner = game.play();
		
		if(winner == null) {
			assertEquals(Move.PAPER, game.getPlayerTwo().getMove());
		} else if(winner.equals(game.getPlayerOne())) {
			assertEquals(Move.ROCK, game.getPlayerTwo().getMove());
		} else if(winner.equals(game.getPlayerTwo())) {
			assertEquals(Move.SCISSORS, game.getPlayerTwo().getMove());
		} else {
			throw new AssertionError("Wrong winner");
		}

	}
	
	/**
	 * Checks the game with scissor move
	 * @throws GameException
	 */
	@Test
	public void scissorsMoveTest() throws GameException {
		
		Game game = new PlayerVsComputerGame(PLAYER_NAME, Move.SCISSORS);

		checksOnPlayers(game);
		assertEquals(Move.SCISSORS, game.getPlayerOne().getMove());
		
		Player winner = game.play();
		
		if(winner == null) {
			assertEquals(Move.SCISSORS, game.getPlayerTwo().getMove());
		} else if(winner.equals(game.getPlayerOne())) {
			assertEquals(Move.PAPER, game.getPlayerTwo().getMove());
		} else if(winner.equals(game.getPlayerTwo())) {
			assertEquals(Move.ROCK, game.getPlayerTwo().getMove());
		} else {
			throw new AssertionError("Wrong winner");
		}

	}
	
	/**
	 * Checks the launch of exception in case of null name
	 * @throws GameException
	 */
	@Test(expected = GameException.class)
	public void nullNameTest() throws GameException {
		
		new PlayerVsComputerGame(null, Move.SCISSORS);
	}

	/**
	 * Checks the launch of exception in case of null move
	 * @throws GameException
	 */
	@Test(expected = GameException.class)
	public void nullMoveTest() throws GameException {
		
		new PlayerVsComputerGame(PLAYER_NAME, null);
	}
	
	/**
	 * Checks the launch of exception in case of null move for
	 * player one during play
	 * @throws GameException
	 */
	@Test(expected = GameException.class)
	public void nullMovePlayOneTest() throws GameException {
		
		Game game = new PlayerVsComputerGame(PLAYER_NAME, Move.SCISSORS);
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
		
		Game game = new PlayerVsComputerGame(PLAYER_NAME, Move.SCISSORS);
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
		assertEquals(PLAYER_NAME, game.getPlayerOne().getName());

		// checks on P2
		assertNotNull(game.getPlayerTwo());
		assertNotNull(game.getPlayerTwo().getName());
		assertNotNull(game.getPlayerTwo().getMove());
	}

}
