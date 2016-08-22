package com.formation.anfr.ctr;

import java.io.File;
import java.util.ArrayList;

public class ListeMeuble extends ArrayList<Meuble> {
	private int TRI;

	public ListeMeuble(int tri) {
		super();
		setTRI(tri);
	}

	public int getTRI() {
		return TRI;
	}

	public void setTRI(int tri) {
		TRI = tri;
	}
	public void chargeListeMeuble(File fRep)   {
		
	}
	
}
