package com.formation.phva.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService(endpointInterface = "com.formation.phva.beans.InterPersoService")
@HandlerChain(file = "LogMessageHandler.xml")
public class PersoService implements InterPersoService {

	private Map<Integer, Perso> persos = new HashMap<Integer, Perso>();

	@Override
	public boolean addPerso(Perso p) {
		boolean ret = false;
		if (persos.get(p.getId()) == null) {
			persos.put(p.getId(), p);
			ret = true;
		}
		return ret;
	}

	@Override
	public boolean deletePerso(int id) {
		boolean ret = false;
		if (persos.get(id) != null) {
			persos.remove(id);
			ret = true;
		}
		return ret;
	}

	@Override
	public Perso getPerso(int id) {
		return persos.get(id);
	}

	@Override
	public Perso[] getAllPerso() {
		Set<Entry<Integer, Perso>> set = persos.entrySet();
		Perso[] tabPer = new Perso[set.size()];
		int i = 0;
		for (Entry<Integer, Perso> ent : set) {
			tabPer[i] = ent.getValue();
			i++;
		}
		return tabPer;
	}

}
