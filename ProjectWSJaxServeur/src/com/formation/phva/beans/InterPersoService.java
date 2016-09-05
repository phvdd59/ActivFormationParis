package com.formation.phva.beans;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding
public interface InterPersoService {

	@WebMethod
	public boolean addPerso(Perso p);

	@WebMethod
	public boolean deletePerso(int id);

	@WebMethod
	public Perso getPerso(int id);

	@WebMethod
	public Perso[] getAllPerso();
}
