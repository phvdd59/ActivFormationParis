package com.formation.joca.sauvegarde;

import java.io.File;
import java.util.ArrayList;

public class ListeMeuble extends ArrayList<Meuble> implements Comparable {

	private TRI tri;

	public ListeMeuble(TRI tri) {
		super();
		this.tri = tri;
	}

	public void chargeListeMeuble(File Frep) {

	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}



}
