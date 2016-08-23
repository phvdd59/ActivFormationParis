package com.formation.thde.exo;

import java.util.ArrayList;

public class ListeElmt extends ArrayList<Elmt> {
	private Tri TRI;

	public ListeElmt(Tri TRI) {
		this.TRI = TRI;
	}

	@Override
	public boolean add(Elmt e) {
		e.setTri(this.TRI);
		return super.add(e);
	}
}
