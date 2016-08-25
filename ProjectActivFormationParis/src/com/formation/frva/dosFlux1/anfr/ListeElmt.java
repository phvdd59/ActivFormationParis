package com.formation.phva.dosFlux1.anfr;

import java.util.ArrayList;

public class ListeElmt extends ArrayList<Elmt> {
	private TRI tri;

	public TRI getTRI() {
		return tri;
	}

	public void setTRI(TRI tri) {
		this.tri = tri;
	}

	public ListeElmt() {
		super();
	}

	public ListeElmt(TRI tri) {
		super();
		setTRI(tri);
	}
	
	
}
