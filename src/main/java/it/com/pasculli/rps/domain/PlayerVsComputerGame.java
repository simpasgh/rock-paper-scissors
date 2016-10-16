package it.com.pasculli.rps.domain;

import it.com.pasculli.rps.domain.enums.State;

/**
 * Represent a game of the player against the computer
 * @author simone
 *
 */
public class PlayerVsComputerGame extends Game {
	
	
	public PlayerVsComputerGame() {
		this.playerOne = new Player();
	}


	/*
	 * (non-Javadoc)
	 * @see it.com.pasculli.rps.domain.Game#play()
	 */
	@Override
	public void play() {
		
		//check the state of the game and goes on
		switch (currentState) {
		case STARTED:
			currentState = State.WAITING_PLAYER_NAME;
			return;
		case WAITING_PLAYER_NAME:
			return;
		default:
			break;
		}

		
	}

}
