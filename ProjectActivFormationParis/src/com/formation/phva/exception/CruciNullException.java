package com.formation.phva.exception;

public class CruciNullException  extends CruciException{

	@Override
	public String getMessage() {
		return super.getMessage()+"Pas de liste de Terme";
	}

}
