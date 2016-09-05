package com.formation.issa.beans;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.jws.HandlerChain;
import javax.jws.WebService;

import java.util.Set;

@WebService(endpointInterface="com.formation.issa.beans.InterPersonJService")
@HandlerChain(file="LogMessageHandler.xml")
public class ServicePersonJ implements InterPersonJService{
	
	private Map <Integer, PersonJ> listPersonJ=new HashMap<Integer, PersonJ>();
	
	public ServicePersonJ(){
		
		
	}

	@Override
	public boolean addPersonJ(PersonJ p) {
		boolean retour=false;
		if(listPersonJ.get(p.getId())==null){
			listPersonJ.put(p.getId(),p);
			retour=true;
		}
		return retour;
	}

	@Override
	public boolean deletePersonJ(int id) {
		boolean retour=false;
		if (listPersonJ.get(id)!=null){
			listPersonJ.remove(id);
			retour=true;
		}
		return retour;
	}

	@Override
	public PersonJ getPersonJ(int id) {
		
		return listPersonJ.get(id);
	}

	@Override
	public PersonJ[] getAllPersonJs() {
		Set<Entry<Integer, PersonJ>>set=listPersonJ.entrySet();
		PersonJ[]tabPer=new PersonJ[set.size()];
		int i=0;
		for (Entry<Integer, PersonJ> ent: set) {
			tabPer[i]=ent.getValue();
			i++;
			
		}
		return tabPer;
	}

}
