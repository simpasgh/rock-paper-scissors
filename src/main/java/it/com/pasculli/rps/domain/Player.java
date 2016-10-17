package it.com.pasculli.rps.domain;

import it.com.pasculli.rps.domain.enums.Move;

/**
 * Class representing a player for the Rock-Paper-Scissors game
 * @author simone
 *
 */
public class Player {
	
	private String name;
	private Move move;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Move getMove() {
		return move;
	}

	public void setMove(Move move) {
		this.move = move;
	}
	
}
