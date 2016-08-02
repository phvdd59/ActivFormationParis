package com.formation.issa.exo;

import java.util.ArrayList;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String mot;
	private int nb;

	public Mot(String mot) {
		// TODO 
	}

	public String getMot() {
		return mot;
	}

	public void setMot(String mot) {
		this.mot = mot;
	}

	public int getNb() {
		return nb;
	}

	public void setNb(int nb) {
		this.nb = nb;
	}

	@Override
	public int compareTo(Mot o) {
		int retour=0;
		if(this.mot==getMot()){
			retour=0;
		}
		else if(this.mot.compareTo(getMot())<0){
			retour=-1;
		}
		else{
			retour=1;
		}
		
		return retour;
	}

	@Override
	public void plusUn() {
		ArrayList<Mot>listing=new ArrayList<Mot>();
	if(this.mot.equals(getMot())){
		//listing.add(listing.getMot()+1);
	}
		
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}
