package com.formation.made.inter;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.*;
import com.formation.made.metier.Personne;


@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public interface InterPersonneService {

	
	@WebMethod
	public boolean addPersonne(Personne p);
	
	
	@WebMethod
	public boolean deletePersonne(int id);
	
	@WebMethod
	public Personne getPersonne(int id);
	
	@WebMethod
	public Personne[] getAllPersonnes();
	
}
