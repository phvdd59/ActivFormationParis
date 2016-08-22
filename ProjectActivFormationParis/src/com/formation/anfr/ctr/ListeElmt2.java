package com.formation.anfr.ctr;

import java.util.ArrayList;

public class ListeElmt2 extends ArrayList<Elmt> {
	private int TRI;

	public int getTRI() {
		return TRI;
	}

	public void setTRI(int tri) {
		TRI = tri;
	}

	public ListeElmt2(int tri) {
		super();
		setTRI(tri);
	}
	
	
}
