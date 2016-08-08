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

		int res=-Integer.valueOf(getNb()).compareTo(o.getNb());
		if(res==0){
			res=getMot().compareTo(o.getMot());
		}
		return res;
	}

	@Override
	public void plusUn() {
	nb++;
		
	}

	@Override
	public boolean equals(Object obj) {
		
		boolean bRet=false;
		if(obj instanceof Mot){
			Mot mMot=(Mot) obj;
			bRet=getMot().equals(mMot.getMot());
		}
		return bRet;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getMot()+"("+getNb()+")";
	}
}
