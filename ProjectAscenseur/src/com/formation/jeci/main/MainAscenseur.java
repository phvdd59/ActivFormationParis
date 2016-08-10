package com.formation.jeci.main;

import com.formation.jeci.metier.ListePersonne;

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
	 * @param args
	 */
	// faire un générateur de personne aléatoire;
	// étage de départ
	// état d'arrivée
	// nom

	public static void main(String[] args) {
		MainAscenseur m = new MainAscenseur();
		m.init();
	}

	private void init() {
		ListePersonne a=new ListePersonne();
		Thread t =new Thread(a);
		t.start();
		
	}
}
