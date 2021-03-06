package com.formation.ambr.main;

import com.formation.ambr.metier.ListeAscenseur;
import com.formation.ambr.metier.ListePersonne;
import com.formation.ambr.metier.Personne;
import com.formation.phva.inter.InterPersonne;

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
	 * @param args
	 */
	public static void main(String[] args) {
		MainAscenseur m = new MainAscenseur();
		m.init();
	}

	private void init() {
		
		InterPersonne p = new Personne(); // on ne peut pas instancier une interface. I.e. on ne peut pas �crire InterPersonne p = new InterPersonne();
		//p.set // notre instanciation de Personne (objet p) b�n�ficiera des m�thodes de InterPersonne, mais pas de celles de Personne.
		
		ListePersonne listPers = new ListePersonne(); // ListPersonne implements un runnable, v.s. extends un thread. Donc oblig� faire comme ci-dessous
		Thread tLstPers = new Thread(listPers, "LISTE DE PERSONNES");
		tLstPers.start();
		
		ListeAscenseur listAsc = new ListeAscenseur(listPers);
		System.out.println(listAsc);
		
	}
}
