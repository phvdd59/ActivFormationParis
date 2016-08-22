package com.formation.anfr.ctr;

import java.util.ArrayList;

public class ListeElmt extends ArrayList<Elmt> {
	private int TRI;

	public int getTRI() {
		return TRI;
	}

	public void setTRI(int tri) {
		TRI = tri;
	}

	public ListeElmt(int tri) {
		super();
		setTRI(tri);
	}
	
	
}
