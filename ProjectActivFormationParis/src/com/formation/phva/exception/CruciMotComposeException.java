package com.formation.phva.exception;

import com.formation.phva.exo.Terme;

public class CruciMotComposeException extends CruciException {

	private com.formation.phva.exo.Terme terme;
	private int pos;

	public CruciMotComposeException() {
		super();
	}

	public CruciMotComposeException(Terme terme,int pos) {
		super();
		this.terme = terme;
	}

	@Override
	public String getMessage() {
		return super.getMessage() + "Attention mot compose : ["+terme.toString()+"] position : "+pos+" ==> Lettre remplacé.";
	}

}
