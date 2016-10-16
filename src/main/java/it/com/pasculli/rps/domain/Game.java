package it.com.pasculli.rps.domain;

import it.com.pasculli.rps.domain.enums.State;

/**
 * Represent an abstract game
 * 
 * @author simone
 *
 */
public abstract class Game {

	protected Player playerOne;
	protected Player playerTwo;
	protected State currentState = State.STARTED;
	protected Player winner;

	/**
	 * Play the game
	 */
	public abstract void play();

	/**
	 * Returns the {@link it.com.pasculli.rps.domain.Player} one
	 * 
	 * @return
	 */
	public Player getPlayerOne() {
		return playerOne;
	}

	/**
	 * Returns the {@link it.com.pasculli.rps.domain.Player} two
	 * 
	 * @return
	 */
	public Player getPlayerTwo() {
		return playerTwo;
	}

	/**
	 * Returns the current {@link it.com.pasculli.rps.domain.enums.State} 
	 * of the game
	 * @return 
	 */
	public State getCurrentState() {
		return currentState;
	}

	/**
	 * Returns the winner {@link it.com.pasculli.rps.domain.Player}
	 * 
	 * @return
	 */
	public Player getWinner() {
		return winner;
	}

}
