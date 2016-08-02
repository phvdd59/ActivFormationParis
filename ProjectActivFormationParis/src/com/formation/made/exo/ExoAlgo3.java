package com.formation.made.exo;

import java.util.ArrayList;
import java.util.TreeMap;

import com.formation.phva.exo.ImplAlgo3;
import com.formation.phva.exo.Mouvement;

/**
 * R�aliser un algorithme qui respecte le comportement des tours de Hanoi
 * 
 * il n'est possible de bouger que 1 �l�ment a la fois un �l�ment ne peut �tre d�plac� que sur la base d'une autre tour ou d'un �l�ment de taille plus grand
 * 
 * D�plac� tout les �l�ments d'une tour vers une autre tour pour les retrouver dans l'ordre.
 * 
 * @author philippe
 *
 */
public class ExoAlgo3 implements ImplAlgo3 {

	public ArrayList<Mouvement> solution(ArrayList<Mouvement> lst, int nbElements, String a, String b, String c) {
		ArrayList<Mouvement> lstMouvement = new ArrayList<Mouvement>();
		TreeMap<String, ArrayList<Integer>> mapJeu = new TreeMap<String, ArrayList<Integer>>();
		ArrayList<Integer> lista = new ArrayList<Integer>();
		ArrayList<Integer> listb = new ArrayList<Integer>();
		ArrayList<Integer> listc = new ArrayList<Integer>();
		mapJeu.put("a", lista);
		mapJeu.put("b", listb);
		mapJeu.put("c", listc);

		for (int i = 0; i < nbElements; i++) { // on initialise le jeu. la pile a contient 5 �l�ments num�rot�s de 1 � 5
			mapJeu.get("a").add(i);
		}

		while (mapJeu.get(c).size() < nbElements) {

			mapJeu.get(c).add(mapJeu.get(a).remove(0));
			// Mouvement mvt=new com.formation.made.exo.Mouvement(mapJeu.get(c)., from, to)
		}
		mapJeu.get("c").add(mapJeu.get("a").remove(0)); // on retire l'�l�ment 0 de la liste A (1) qu'on met dans la liste c. On le retire en meme temps

		// if (mvtab.getFrom() != mvtab.getTo()) {
		// if (mvtab.getTaille()>) {

		// }
		// }

		// lstMouvement.add(mvt); en th�orie ce qu'on cherche a avoir une liste de mouvement.

		return lstMouvement;
	}
}
