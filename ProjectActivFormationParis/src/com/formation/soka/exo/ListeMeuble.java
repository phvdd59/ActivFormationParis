package com.formation.soka.exo;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;

import com.formation.anfr.ctr.TRI;

public class ListeMeuble extends ArrayList<Meuble> implements Comparable<Meuble> {
	private TRI tri;

	ArrayList<Meuble> lst = new ArrayList<Meuble>();

	public ListeMeuble(TRI tri) {
		super();
		this.tri = tri;
	}

	public void chargerListeMeuble(File fRep) {

	}

	public TRI getTri() {
		return tri;
	}

	public void setTri(TRI tri) {
		this.tri = tri;
	}

	@Override
	public int compareTo(Meuble o) {
		// TODO Auto-generated method stub
	
		if (tri.equals(TRI.VOLUME)) {
			Collections.sort(lst);
		} else if (tri.equals(TRI.ALPHA)) {
			Collections.sort(lst);
		} else if (tri.equals(TRI.REF)) {
			Collections.sort(lst);
		}
		return modCount;
	}
}
