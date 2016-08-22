package com.formation.anfr.ctr;

import java.io.File;
import java.util.ArrayList;

public class ListeMeuble2 extends ArrayList<Meuble> {
	private int TRI;

	public ListeMeuble2(int tri) {
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
