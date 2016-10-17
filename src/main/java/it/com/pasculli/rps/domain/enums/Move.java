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
	
	private Move(Integer id, Integer... defeat) {
		this.id = id;
		this.defeat = Arrays.asList(defeat);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public List<Integer> getDefeat() {
		return this.defeat;
	}
	
	public Result challenge(Move move) {
		
		if(defeat.contains(move.getId())) {
			return Result.WIN;
		} else if(move.getDefeat().contains(this.id)) {
			return Result.LOSE;
		} 
		
		return Result.TIE;
	}
	
	public static Move valueOf(Integer id) {
		
		for(Move move: values()) {
			if(move.getId().equals(id)) {
				return move;
			}
		}
		return null;
	}


}
