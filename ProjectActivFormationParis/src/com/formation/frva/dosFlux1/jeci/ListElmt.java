package com.formation.phva.dosFlux1.jeci;

import java.util.ArrayList;

public class ListElmt extends ArrayList<Elmt> {
	private TRI tri;

	public ListElmt(TRI tri) {
		super();
		this.tri = tri;
	}

	public TRI getTri() {
		return tri;
	}

	public void setTri(TRI tri) {
		this.tri = tri;
	}

	
}
