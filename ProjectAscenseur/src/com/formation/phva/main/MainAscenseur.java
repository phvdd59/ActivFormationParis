package com.formation.phva.main;

public class MainAscenseur {
	/**
	 * 1� Creer un Enum ETAT
	 * 		comprend : ETAT_ATTENTE,ETAT_DEPART,ETAT_MOVE,ETAT_ARRIVE
	 * 					
	 * 						
	 * 
	 * 2� Creer un object Personne
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
	 * |    ListePersonne h�rite de ArrayList<Personne>  |
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
	 * |               Ascenseur h�rite de Thread        |
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
	 * |   ListeAscenseur h�rite de ArrayList<Ascenseur> |
	 * |-------------------------------------------------|
	 * |-------------------------------------------------|
	 * |            +ListeAscenseur()                    |
	 * |-------------------------------------------------|
	 * |         toString()                              |
	 * |-------------------------------------------------|
	 * 
	 * faire un g�n�rateur de personnes al�atoires
	 * 		- �tage de d�part
	 * 		- �tage d'arriv�
	 * 		cr�ation personne � des temps al�atoires
	 *  
	 * @param args
	 */
	public static void main(String[] args) {

	}
}
