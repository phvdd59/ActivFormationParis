package com.formation.emma.main;

import com.formation.emma.metier.Ascenseur;
import com.formation.emma.metier.ETAT;
import com.formation.emma.metier.ListeAscenseur;
import com.formation.emma.metier.ListePersonne;
import com.formation.emma.metier.Personne;
import com.formation.phva.inter.InterAscenseur;

public class MainAscenseur {
	/**
	 * 1° Creer un Enum ETAT
	 * 		comprend : ETAT_ATTENTE,ETAT_DEPART,ETAT_MOVE,ETAT_ARRIVE
	 * 					
	 * 						
	 * 
	 * 2° Creer un object Personne
	 * ---------------------------------------------------
	 * |               Personne                          |
	 * |-------------------------------------------------|
	 * |        +static CPT = 0                          |
	 * |		+static NB_ETAGE=20                      |
	 * |                                                 |
	 * |		-nom :    String                         |
	 * |		-etat:    int                            |
	 * |		-depart:  int                            |
	 * |		-arrive : int                            |
	 * |-------------------------------------------------|
	 * |            +Personne()                          |
	 * |-------------------------------------------------|
	 * |         getters,setters + toString()            |
	 * |-------------------------------------------------|
	 * 
	 * ---------------------------------------------------
	 * |    ListePersonne hérite de ArrayList<Personne>  |
	 * |     interface Runnable                          |
	 * |-------------------------------------------------|
	 * |        -sortie : boolean                        |
	 * |-------------------------------------------------|
	 * |            +ListePersonne()                     |
	 * |-------------------------------------------------|
	 * |         getters,setters + toString()            |
	 * |-------------------------------------------------|
	 *
	 * ---------------------------------------------------
	 * |               Ascenseur hérite de Thread        |
	 * |-------------------------------------------------|
	 * |        +static CPT = 0 :int                     |
	 * |		+static TEMPS=10 :int                    |
	 * |        +static HAUTEUR_ETAGE=30 : int           |
	 * |		-etage : int                             |
	 * |		-progression: int                        |
	 * |		-fin : boolean                           |
	 * |		-Personne : personne                     |
	 * |-------------------------------------------------|
	 * |            +Ascenseur()                         |
	 * |-------------------------------------------------|
	 * |         getters,setters + toString()            |
	 * |-------------------------------------------------|
	 * 
	 * ---------------------------------------------------
	 * |   ListeAscenseur hérite de ArrayList<Ascenseur> |
	 * |-------------------------------------------------|
	 * |-------------------------------------------------|
	 * |            +ListeAscenseur()                    |
	 * |-------------------------------------------------|
	 * |         toString()                              |
	 * |-------------------------------------------------|
	 * @param args
	 */
	public static void main(String[] args) {

		ListePersonne lstP = new ListePersonne(); // "implements runnable" doit appeler thread pour le lancer
		Thread thread = new Thread(lstP);
		thread.start();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		System.out.println(lstP);
	
		ListeAscenseur listA = new ListeAscenseur(lstP);
		//InterAscenseur ascenseur = new Ascenseur(lstP, null); // "extends thread" prend la classe pour faire le start
	
	//	System.out.println(ascenseur);
	}
}
