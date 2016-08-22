package com.formation.jeci.data;

import java.util.ArrayList;

public class ListElmt extends ArrayList<Elmt> implements Comparable<Elmt> {
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

	@Override
	public int compareTo(Elmt o) {
		// TODO Auto-generated method stub
		return 0;
	}
}
