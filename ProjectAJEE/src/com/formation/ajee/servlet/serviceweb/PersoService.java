package com.formation.ajee.servlet.serviceweb;

import java.util.ArrayList;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.formation.ajee.dao.DaoBDD;

@WebService(endpointInterface = "com.formation.beans.InterPersoService")
@HandlerChain(file = "LogMessageHandler.xml")
public class PersoService implements InterPersoService {

	@Override
	public Perso getPerso(int id) {
		Perso perso=new Perso();
		perso.setIdPersonne(id);
		perso.setNom("yoollllooo");
		
		return perso;
	}

	@Override
	public Perso[] getPersos() {
DaoBDD dao1=new DaoBDD();
		ArrayList<Perso> lst=dao1.lectureTableBackUpPerso();

		Perso[] tabPerso=new Perso[lst.size()];
	
	for (int i = 0; i < tabPerso.length; i++) {
		tabPerso[i]=lst.get(i);
	}
		return tabPerso;
	}
}
