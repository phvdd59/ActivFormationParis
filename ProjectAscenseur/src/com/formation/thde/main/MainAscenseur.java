package com.formation.thde.main;

import com.formation.thde.metier.ListeAscenseur;
import com.formation.thde.metier.ListePersonne;

public class MainAscenseur {
	/**
	 * 1° Creer un Enum ETAT comprend :
	 * ETAT_ATTENTE,ETAT_DEPART,ETAT_MOVE,ETAT_ARRIVE
	 * 
	 * 
	 * 
	 * 2° Creer un object Personne
	 * --------------------------------------------------- | Personne |
	 * |-------------------------------------------------| | +static CPT = 0 | |
	 * +static NB_ETAGE=20 | | | | -nom : String | | -etat: int | | -depart: int
	 * | | -arrive : int | |-------------------------------------------------| |
	 * +Personne() | |-------------------------------------------------| |
	 * getters,setters + toString() |
	 * |-------------------------------------------------|
	 * 
	 * --------------------------------------------------- | ListePersonne
	 * hérite de ArrayList<Personne> | | interface Runnable |
	 * |-------------------------------------------------| | -sortie : boolean |
	 * |-------------------------------------------------| | +ListePersonne() |
	 * |-------------------------------------------------| | getters,setters +
	 * toString() | |-------------------------------------------------|
	 *
	 * --------------------------------------------------- | Ascenseur hérite de
	 * Thread | |-------------------------------------------------| | +static
	 * CPT = 0 :int | | +static TEMPS=10 :int | | +static HAUTEUR_ETAGE=30 : int
	 * | | -etage : int | | -progression: int | | -fin : boolean | | -Personne :
	 * personne | |-------------------------------------------------| |
	 * +Ascenseur() | |-------------------------------------------------| |
	 * getters,setters + toString() |
	 * |-------------------------------------------------|
	 * 
	 * --------------------------------------------------- | ListeAscenseur
	 * hérite de ArrayList<Ascenseur> |
	 * |-------------------------------------------------|
	 * |-------------------------------------------------| | +ListeAscenseur() |
	 * |-------------------------------------------------| | toString() |
	 * |-------------------------------------------------|
	 * 
	 * faire un générateur de personnes aléatoires - étage de départ - étage
	 * d'arrivé création personne à des temps aléatoires
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		MainAscenseur main = new MainAscenseur();
		main.init();
	}

	private void init() {
		ListeAscenseur listAscenseur = new ListeAscenseur();
		ListePersonne listPersonne = new ListePersonne();
		Thread thread = new Thread(listPersonne);
		thread.start();
		System.out.println("fin");
	}
}
