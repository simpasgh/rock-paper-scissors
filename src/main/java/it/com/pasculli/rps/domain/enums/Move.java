package it.com.pasculli.rps.domain.enums;

import java.util.Arrays;
import java.util.List;

/**
 * Represent a playable move
 * @author simone
 *
 */
public enum Move {
	
	ROCK(1, 3), PAPER(2, 1), SCISSORS(3, 2);
	
	private Integer id;
	private List<Integer> defeat;
	
	/**
	 * Constructor of the move
	 * @param id identifier of the move
	 * @param defeat identifiers of the moves that this move beats
	 */
	private Move(Integer id, Integer... defeat) {
		this.id = id;
		this.defeat = Arrays.asList(defeat);
	}

	/**
	 * Challenge another move
	 * @param move the opponent move
	 * @return the {@link it.com.pasculli.rps.domain.enums.Result} of the challenge
	 */
	public Result challenge(Move move) {
		
		Result result = null;
		
		if(move != null) {
			if(defeat.contains(move.getId())) {
				result = Result.WIN;
			} else if(move.getDefeat().contains(this.id)) {
				result = Result.LOSE;
			} else {
				result = Result.TIE;
			}
		}
		
		return result;
	}
	
	/**
	 * Returns the corresponding enum value of the passed id
	 * @param id
	 * @return
	 */
	public static Move valueOf(Integer id) {
		
		for(Move move: values()) {
			if(move.getId().equals(id)) {
				return move;
			}
		}
		return null;
	}
	

	public Integer getId() {
		return id;
	}
	
	public List<Integer> getDefeat() {
		return this.defeat;
	}

}
