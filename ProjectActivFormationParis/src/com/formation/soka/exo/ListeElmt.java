package com.formation.soka.exo;

import java.util.ArrayList;
import java.util.Collections;

public class ListeElmt extends ArrayList<Elmt> implements Comparable<Elmt>{

	private TRI tri;

	public ListeElmt(TRI tri) {
		this.tri = tri;
	}

	public TRI getTri() {
		return tri;
	}

	public void setTri(TRI tri) {
		this.tri = tri;
	}

	

	@Override
	public int compareTo(Elmt o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
