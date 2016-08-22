package com.formation.anfr.ctr;

import java.io.File;
import java.util.ArrayList;

public class ListeMeuble extends ArrayList<Meuble> {
	private TRI tri;

	public ListeMeuble(TRI tri) {
		super();
		setTRI(tri);
	}

	public TRI getTRI() {
		return tri;
	}

	public void setTRI(TRI tri) {
		this.tri = tri;
	}
	public void chargeListeMeuble(File fRep)   {
		
	}
	
}
