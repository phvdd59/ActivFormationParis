package com.formation.beba.main;

import java.util.ArrayList;

import com.formation.beba.metier.Personne;

public class Test {

	public static void main(String[] args) {

		Test test = new Test();
		test.init();
	}

	public void init() {

		ArrayList<Personne> lst = new ArrayList<Personne>();
		for (int i = 0; i < 20; i++) {
			lst.add(new Personne());

		}
		System.out.println(lst);
	}

}
