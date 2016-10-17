package it.com.pasculli.rps.domain.strategies;

import it.com.pasculli.rps.domain.enums.Move;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Compute the choose using a random strategy
 * @author simone
 *
 */
public class RandomAIStrategy implements AIStrategy {

	/*
	 * (non-Javadoc)
	 * @see it.com.pasculli.rps.domain.strategies.AIStrategy#computeChoice()
	 */
	public Move computeChoice() {
		
		int randomIndex = ThreadLocalRandom.current().nextInt(0, Move.values().length);
		Move result = Move.values()[randomIndex];
		
		return result;
	}

}
