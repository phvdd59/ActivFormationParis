package com.formation.joca.ctr;

import java.util.ArrayList;

public class ListeElmt extends ArrayList<Elmt> implements Comparable{

	private TRI tri;

	public ListeElmt(TRI tri) {
		super();
		this.tri = tri;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
