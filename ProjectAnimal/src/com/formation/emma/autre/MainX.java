package com.formation.emma.autre;

import java.util.ArrayList;

public class MainX {

	public static void main(String[] args) {
		MainX m = new MainX();
		m.init();
	}

	public void init() {
		X x1 = new X();
		x1.methodeA();
		I1 i1 = new X();
		Y y1 = new Y();
		I1 i2 = new Y();
		i1.methodeA();
		i2.methodeA();
		ArrayList<I1> lst = new ArrayList<I1>();
		lst.add(i1);
		lst.add(i2);
		for (I1 i : lst) {
			i.methodeA();
		}

	}
}
