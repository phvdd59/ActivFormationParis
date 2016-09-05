package com.formation.beans;

import java.util.HashMap;
import java.util.Map;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface = "com.formation.beans.InterPersoService")
@HandlerChain(file = "LogMessageHandler.xml")
public class PersoService implements InterPersoService {

	@Override
	public Perso getPerso(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Perso[] getPersos() {
		// TODO Auto-generated method stub
		return null;
	}
}
