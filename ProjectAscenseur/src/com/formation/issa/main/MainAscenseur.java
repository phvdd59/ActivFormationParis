package com.formation.issa.main;

import com.formation.issa.metier.Ascenseur;
import com.formation.issa.metier.ListPersonne;
import com.formation.issa.metier.ListeAscenseur;
import com.formation.issa.metier.Personne;
import com.formation.phva.inter.InterPersonne;

public class MainAscenseur {

	public static void main(String[] args) {
		InterPersonne p=new Personne();
	//L'interface est le filtre d'une classe qu'elle implémente
		MainAscenseur mainAscenseur=new MainAscenseur();
		mainAscenseur.init();

	}

	public void init() {
		ListPersonne listPersonne=new ListPersonne();
		Thread listPersonneThread = new Thread(listPersonne,"listPersonne");
		//listPersonne est un runnable donc dans le main on crée un Thread et on effectue un start
		listPersonneThread.start();
		ListeAscenseur listAscenseur=new ListeAscenseur(listPersonne);
		Ascenseur ascenseur=new Ascenseur();
		
		
	}

}
