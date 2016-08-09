package com.formation.joca.main;

import com.formation.joca.metier.ListePersonne;

public class MainAscenseur {
public static void main(String[] args) {
	
	ListePersonne lst = new ListePersonne();
	Thread essai=new Thread(lst);
	essai.start();
	try {
		Thread.currentThread().sleep(10);
	} catch (InterruptedException e) {
	}
	lst.setSortie(true);
	for (int i=0;i<lst.size();i++){
		System.out.println(lst.get(i).toString());
	}
	
}
}
