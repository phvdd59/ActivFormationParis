package com.formation.etga.ctr;

import java.io.File;
import java.util.ArrayList;

public class ListMeuble extends ArrayList<Meuble> {
	private TRI tri;
	
	public ListMeuble(TRI tri) {
		this.tri = tri;
	}
	
	public void chargeListeMeuble(File fRep){
	}
}
