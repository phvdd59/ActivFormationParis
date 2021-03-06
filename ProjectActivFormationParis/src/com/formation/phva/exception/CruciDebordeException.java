package com.formation.phva.exception;

import com.formation.phva.exo.Terme;

public class CruciDebordeException extends CruciException {

	private com.formation.phva.exo.Terme terme;

	public CruciDebordeException() {
		super();
	}

	public CruciDebordeException(Terme terme) {
		super();
		this.terme = terme;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + "Debordement du terme : " + ((terme == null) ? "NULL" : terme.toString()) + " Incorrect";
	}

}
