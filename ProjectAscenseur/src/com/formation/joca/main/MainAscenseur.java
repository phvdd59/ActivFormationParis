package com.formation.joca.main;

import com.formation.joca.metier.ListeAscenseur;
import com.formation.joca.metier.ListePersonne;

public class MainAscenseur {
public static void main(String[] args) {
	
	ListePersonne lst = new ListePersonne();
	Thread essai=new Thread(lst);
	essai.start();
	try {
		Thread.currentThread().sleep(30000);
	} catch (InterruptedException e) {
	}
	lst.setSortie(true);
	System.out.println(lst);
	System.out.println("");
	ListeAscenseur lstAsc = new ListeAscenseur(lst);
	//System.out.println(lstAsc);
	System.out.println("");
	
	
}
}
