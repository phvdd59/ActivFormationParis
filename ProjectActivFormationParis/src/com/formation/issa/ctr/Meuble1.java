package com.formation.issa.ctr;

public class Meuble1 implements Comparable<Meuble1> {

	String ref;
	int nb;

	public Meuble1(String ref) {
		this.ref = ref;

	}
	public Meuble1(String ref, int nb){
		this.ref=ref;
		this.nb=0;
	}

	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public int getNb() {
		return nb;
	}
	public void setNb(int nb) {
		this.nb = nb;
	}
	
	@Override
	public int compareTo(Meuble1 o) {
		int retour=0;
		if(this.getNb()<o.getNb()){
			retour=1;
		}else if(this.getNb()>o.getNb()){
			retour=-1;
		}else{
			retour=(int)this.getRef().compareTo(o.getRef());
		}
		return retour;
	}
	public void plusUn(){
		this.nb+=1;
	}
	public boolean equals(Object obj){
		boolean retour=false;
		Meuble1 str=(Meuble1)obj;
		if(this.getRef().equals(str.getRef())){
			retour=true;
			
		}
		return retour;
		
	}

}
