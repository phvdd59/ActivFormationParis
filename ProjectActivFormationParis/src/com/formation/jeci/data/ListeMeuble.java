package com.formation.jeci.data;

import java.io.File;
import java.util.ArrayList;

public class ListeMeuble extends ArrayList<Meuble> implements Comparable<Meuble>{
	private TRI tri;

	public ListeMeuble(TRI tri) {
		super();
		this.tri = tri;
	}

	public void chargeListeMeuble(File fRep) {

	}

	@Override
	public int compareTo(Meuble o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
