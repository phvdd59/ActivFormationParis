package com.formation.made.exo;

public class NegatifException extends Exception {

	@Override
	public String getMessage() {
		return "Le nombre doit être positif";

	}
}
