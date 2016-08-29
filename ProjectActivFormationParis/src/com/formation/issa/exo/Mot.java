package com.formation.issa.exo;

import java.util.ArrayList;

public class Mot implements InterExoMot1, Comparable<Mot> {

	private String mot;
	private int nb;

	public Mot(String mot) {
		this.mot=mot;
		nb=1;		
		
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
		if(this.getNb()>o.getNb()){
			retour=-1;
		}else if(this.getNb()<o.getNb()){
			retour=1;
		}else{
			retour=(int)this.getMot().compareTo(o.getMot());
		}
		return retour;
	}

	@Override
	public void plusUn() {
	this.nb+=1;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean bRet=false;
		Mot temp=(Mot) obj;
		if(this.getMot().equals(temp.getMot())){
			bRet=true;
		}
		return bRet;
	}

	@Override
	public String toString() {
		return "Mot [mot=" + mot + ", nb=" + nb + "]";
	}


}
