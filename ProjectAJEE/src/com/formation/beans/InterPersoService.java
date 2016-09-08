package com.formation.beans;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding
public interface InterPersoService {

	@WebMethod
	public Perso getPerso(int id);

	@WebMethod
	public Perso[] getPersos();

}
