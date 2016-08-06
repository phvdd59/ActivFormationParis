package com.formation.phva.exception;

import com.formation.phva.exo.Terme;

public class CruciCroisementException extends CruciException {

	private com.formation.phva.exo.Terme terme;
	private int pos;

	public CruciCroisementException() {
		super();
	}

	public CruciCroisementException(Terme terme, int pos) {
		super();
		this.terme = terme;
		this.pos = pos;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + "Croisement incorrect : " + ((terme != null)?"NULL":terme.toString()) + " position : " + pos + " ==> Lettre remplac�.";
	}

}
