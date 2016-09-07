package com.formation.bait.dao;

public class MainDaoTest {

	public static void main(String[] args) {
		MainDaoTest main = new MainDaoTest();
		main.init();

	}

	private void init() {
		AccesBDDPersonne2 acces = new AccesBDDPersonne2();
		acces.savePersonneEmpruntee(acces.getPersonne("10"));
		System.out.println("done");

	}

}
