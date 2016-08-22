package com.formation.thde.ctr;

import java.io.File;
import java.util.ArrayList;

public class ListeMeuble extends ArrayList<Meuble> {
	private Tri TRI;

	public ListeMeuble(Tri TRI) {
		this.TRI = TRI;
	}

	public ListeMeuble chargeListeMeuble(File fRep) {
		return null;
	}

	@Override
	public boolean add(Meuble e) {
		e.setTri(this.TRI);
		return super.add(e);
	}
}
