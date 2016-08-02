package com.formation.anfr.exo;

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
		String[] nomTours = { a, b, c };
		ArrayList<Integer> t1 = new ArrayList<Integer>();
		ArrayList<Integer> t2 = new ArrayList<Integer>();
		ArrayList<Integer> t3 = new ArrayList<Integer>();
		t1.add(nbElements + 1);
		for (int i = nbElements; i >= 1; i--) {
			t1.add(i);
		}
		t2.add(nbElements + 1);
		t3.add(nbElements + 1);
		int indice = 0;
		String pos1 = a;
		if (nbElements % 2 != 0) {
			ArrayList<Integer> q1 = null;
			ArrayList<Integer> q2 = null;
			String de="";
			String vers="";
			while ((t3.size() < nbElements + 1)) {
				if (pos1.equals(nomTours[0])) {
					indice = t1.remove(t1.size() - 1);
					t3.add(indice);
					lst.add(new Mouvement(indice, a, c));
					pos1 = c;
					if (t3.size() == nbElements + 1)
						break;
					q1=t1;
					q2=t2;
					de=a;
					vers=b;
				} else if (pos1.equals(nomTours[1])) {
					indice = t2.remove(t2.size() - 1);
					t1.add(indice);
					lst.add(new Mouvement(indice, b, a));
					pos1 = a;
					q1=t2;
					q2=t3;
					de=b;
					vers=c;
				} else {
					indice = t3.remove(t3.size() - 1);
					t2.add(indice);
					lst.add(new Mouvement(indice, c, b));
					pos1 = b;
					q1=t1;
					q2=t3;
					de=a;
					vers=c;
				}
				
				if (comparaison(q1, q2)) {
					indice = q1.remove(q1.size() - 1);
					q2.add(indice);
					lst.add(new Mouvement(indice, de, vers));
				} else {
					indice = q2.remove(q2.size() - 1);
					q1.add(indice);
					lst.add(new Mouvement(indice, vers, de));
				}
				
				
				if (comparaison(t1, t2)) {
					indice = t1.remove(t1.size() - 1);
					t2.add(indice);
					lst.add(new Mouvement(indice, a, b));
				} else if (comparaison(t1, t3)) {
					indice = t1.remove(t1.size() - 1);
					t3.add(indice);
					lst.add(new Mouvement(indice, a, c));
				} else if (comparaison(t2, t3)) {
					indice = t2.remove(t2.size() - 1);
					t3.add(indice);
					lst.add(new Mouvement(indice, b, c));
				} else if (comparaison(t3, t1)) {
					indice = t3.remove(t3.size() - 1);
					t1.add(indice);
					lst.add(new Mouvement(indice, c, a));
				} else if (comparaison(t2, t1)) {
					indice = t2.remove(t2.size() - 1);
					t1.add(indice);
					lst.add(new Mouvement(indice, b, a));
				} else if (comparaison(t3, t2)) {
					indice = t3.remove(t3.size() - 1);
					t2.add(indice);
					lst.add(new Mouvement(indice, c, b));
				}
			}
		} else {
			while ((t3.size() < nbElements + 1)) {
				if (pos1.equals(nomTours[0])) {
					indice = t1.remove(t1.size() - 1);
					t2.add(indice);
					lst.add(new Mouvement(indice, a, b));
					pos1 = b;

				} else if (pos1.equals(nomTours[1])) {
					indice = t2.remove(t2.size() - 1);
					t3.add(indice);
					lst.add(new Mouvement(indice, b, c));
					pos1 = c;
					if (t3.size() == nbElements + 1)
						break;
				} else {
					indice = t3.remove(t3.size() - 1);
					t1.add(indice);
					lst.add(new Mouvement(indice, c, a));
					pos1 = a;
				}
				if (comparaison(t1, t2)) {
					indice = t1.remove(t1.size() - 1);
					t2.add(indice);
					lst.add(new Mouvement(indice, a, b));
				} else if (comparaison(t1, t3)) {
					indice = t1.remove(t1.size() - 1);
					t3.add(indice);
					lst.add(new Mouvement(indice, a, c));
				} else if (comparaison(t2, t3)) {
					indice = t2.remove(t2.size() - 1);
					t3.add(indice);
					lst.add(new Mouvement(indice, b, c));
				} else if (comparaison(t3, t1)) {
					indice = t3.remove(t3.size() - 1);
					t1.add(indice);
					lst.add(new Mouvement(indice, c, a));
				} else if (comparaison(t2, t1)) {
					indice = t2.remove(t2.size() - 1);
					t1.add(indice);
					lst.add(new Mouvement(indice, b, a));
				} else if (comparaison(t3, t2)) {
					indice = t3.remove(t3.size() - 1);
					t2.add(indice);
					lst.add(new Mouvement(indice, c, b));
				}
			}
		}
		return lst;
	}

	public int getLast(ArrayList<Integer> tour) {
		int dernier = 0;
		int taille = tour.size();
		dernier = tour.get(taille - 1);
		return dernier;
	}

	public boolean comparaison(ArrayList<Integer> tour1, ArrayList<Integer> tour2) {
		boolean permutable = false;
		if ((getLast(tour1) != tour1.get(0)) && ((getLast(tour1) != 1))) {
			if (getLast(tour1) < getLast(tour2)) {
				permutable = true;
			}
		}
		return permutable;
	}

}
