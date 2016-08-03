package com.formation.phva.exception;

public class CruciHeightException  extends CruciException {

	@Override
	public String getMessage() {
		return super.getMessage()+"Hauteur Incorrect";
	}

}
