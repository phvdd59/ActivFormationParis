package com.formation.made.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import com.formation.made.inter.InterPersonneService;
import com.formation.made.metier.Personne;

@WebService(endpointInterface = "com.formation.made.inter.InterPersonneService")
@HandlerChain(file = "LogMessageHandler.xml")
public class PersonneService implements InterPersonneService {
	private Map<Integer, Personne> lstPerso;

	public PersonneService() {
		lstPerso = new HashMap<Integer, Personne>();

	}

	@Override
	public boolean addPersonne(Personne p) {
		boolean add = false;
		if (lstPerso.get(p.getId()) != null) {
			lstPerso.put(p.getId(), p);
			add = true;
		}
		return add;
	}

	@Override
	public boolean deletePersonne(int id) {
		boolean delete = false;
		if (lstPerso.get(id) != null) {
			lstPerso.remove(id);
			delete = true;
		}
		return delete;
	}

	@Override
	public Personne getPersonne(int id) {
		Personne personne = null;
		if (lstPerso.get(id) != null) {
			personne = lstPerso.get(id);
		}
		return personne;
	}

	@Override
	public Personne[] getAllPersonnes() {
		Personne[] tabPersonne = new Personne[lstPerso.size()];
		Set<Entry<Integer, Personne>> set = lstPerso.entrySet();
		int i = 0;
		for (Entry<Integer, Personne> entry : set) {

			tabPersonne[i] = entry.getValue();
		}
		return tabPersonne;
	}

}
