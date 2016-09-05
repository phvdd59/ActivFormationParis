package com.formation.issa.beans;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding (style=SOAPBinding.Style.RPC)

public interface InterPersonJService {
	
	@WebMethod
	public boolean addPersonJ(PersonJ p);
	@WebMethod
	public boolean deletePersonJ(int id);
	@WebMethod
	public PersonJ getPersonJ(int id);
	@WebMethod
	public PersonJ[] getAllPersonJs();

}
