package com.formation.joca.exo;

import java.util.ArrayList;

import com.formation.phva.exo.ImplAlgo3;
import com.formation.phva.exo.Mouvement;

/**
 * Réaliser un algorithme qui respecte le comportement des tours de Hanoi
 * 
 * il n'est possible de bouger que 1 élément a la fois un élément ne peut être
 * déplacé que sur la base d'une autre tour ou d'un élément de taille plus grand
 * 
 * Déplacé tout les éléments d'une tour vers une autre tour pour les retrouver
 * dans l'ordre.
 * 
 * @author philippe
 *
 */
public class ExoAlgo3 implements ImplAlgo3 {

	public ArrayList<Mouvement> solution(ArrayList<Mouvement> lst, int nbElements, String a, String b, String c) {
		int indice = nbElements;
		ArrayList<Mouvement> tabMouvement = new ArrayList<Mouvement>();

		if (indice == 1) {

			tabMouvement.add(new Mouvement(indice, a, c));
		} else {
			indice--;
			solution(tabMouvement, indice, a, c, b);
			tabMouvement.add(new Mouvement(indice, a, c));
			indice--;
			solution(tabMouvement, indice, b, a, c);
		}
		return tabMouvement;
	}

	/*
	 * 
	 * public ArrayList<Mouvement> solution(ArrayList<Mouvement> lst, int
	 * nbElements, String a, String b, String c) {
	 * 
	 * ArrayList<Mouvement> tabMouvement = new ArrayList<Mouvement>();
	 * 
	 * ArrayList<Integer> tour1 = new ArrayList<Integer>(); for (int
	 * i=1;i<=nbElements;i++){ tour1.add(i); } ArrayList<Integer> tour2 = new
	 * ArrayList<Integer>(); ArrayList<Integer> tour3 = new
	 * ArrayList<Integer>();
	 * 
	 * while (tour3.size()!=nbElements){ if (comparerTour(tour1, tour2)){
	 * retirerEtage(tour1, tour2); tabMouvement.add(new
	 * Mouvement(tour2.get(0),a,b)); } else if (comparerTour(tour1, tour3)){
	 * retirerEtage(tour1, tour3); tabMouvement.add(new
	 * Mouvement(tour3.get(0),a,c)); } else if (comparerTour(tour2, tour3)){
	 * retirerEtage(tour2, tour3); tabMouvement.add(new
	 * Mouvement(tour3.get(0),b,c)); } else if (comparerTour(tour3, tour1)){
	 * retirerEtage(tour3, tour1); tabMouvement.add(new
	 * Mouvement(tour3.get(0),c,a)); }
	 * 
	 * 
	 * }
	 * 
	 * 
	 * return tabMouvement; }
	 */

	public void retirerEtage(ArrayList<Integer> tourDepart, ArrayList<Integer> tourArrive) {
		tourArrive.add(0, tourDepart.remove(0));
	}

	public boolean comparerTour(ArrayList<Integer> tourParam1, ArrayList<Integer> tourParam2) {
		boolean result = false;
		if (tourParam2.size() == 0) {
			result = true;
		} else if (tourParam1.get(0) < tourParam2.get(0)) {
			result = true;
		}
		return result;
	}
}
