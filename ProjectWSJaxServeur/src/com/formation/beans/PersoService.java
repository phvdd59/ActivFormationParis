package com.formation.beans;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface = "com.formation.beans.InterPersoService")
@HandlerChain(file = "LogMessageHandler.xml")
public class PersoService implements InterPersoService {

	@Override
	public Perso getPerso(int id) {
		Perso perso=new Perso();
		perso.setIdPersonne(id);
		perso.setNom("NomPH");
		
		return perso;
	}

	@Override
	public Perso[] getPersos() {
		// TODO Auto-generated method stub
		return null;
	}
}
