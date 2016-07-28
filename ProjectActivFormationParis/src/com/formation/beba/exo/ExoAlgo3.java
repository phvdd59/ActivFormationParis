package com.formation.beba.exo;

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
		ArrayList<Integer> aa = new ArrayList<Integer>();
		ArrayList<Integer> bb = new ArrayList<Integer>();
		ArrayList<Integer> cc = new ArrayList<Integer>();

		for (int i = 0; i < nbElements; i++) {
			int val = nbElements - i;
			aa.add((Integer) val);
		}
		int nbOperation = (int) Math.pow(2, nbElements) - 1;
		int nbCycle = (nbOperation - 7) / 8;
		if (nbOperation >= 8) {

		}
		int tours = 0;
		for (int i = 1; i < nbCycle + 1; i++) {
			tours++;
			if (tours == 4) {
				tours = 1;
			}
			if (tours == 1) {

				bb.add(aa.remove(aa.size() - 1));
				cc.add(aa.remove(aa.size() - 1));
				cc.add(bb.remove(bb.size() - 1));
				bb.add(aa.remove(aa.size() - 1));

				aa.add(cc.remove(cc.size() - 1));
				bb.add(cc.remove(cc.size() - 1));
				bb.add(aa.remove(aa.size() - 1));
				cc.add(aa.remove(aa.size() - 1));
			}
			if (tours == 2) {

				cc.add(bb.remove(bb.size() - 1));
				aa.add(bb.remove(bb.size() - 1));
				aa.add(cc.remove(cc.size() - 1));
				cc.add(bb.remove(bb.size() - 1));

				bb.add(aa.remove(aa.size() - 1));
				cc.add(aa.remove(aa.size() - 1));
				cc.add(bb.remove(bb.size() - 1));
				bb.add(aa.remove(aa.size() - 1));
			}
			if (tours == 3) {

				aa.add(cc.remove(cc.size() - 1));
				bb.add(cc.remove(cc.size() - 1));
				bb.add(aa.remove(aa.size() - 1));
				aa.add(cc.remove(cc.size() - 1));

				cc.add(bb.remove(bb.size() - 1));
				aa.add(bb.remove(bb.size() - 1));
				aa.add(cc.remove(cc.size() - 1));
				bb.add(cc.remove(cc.size() - 1));
			}
		}
		switch (tours) {
		case 1:
			cc.add(bb.remove(bb.size() - 1));
			aa.add(bb.remove(bb.size() - 1));
			aa.add(cc.remove(cc.size() - 1));
			cc.add(bb.remove(bb.size() - 1));

			bb.add(aa.remove(aa.size() - 1));
			cc.add(aa.remove(aa.size() - 1));
			cc.add(bb.remove(bb.size() - 1));
			break;

		case 2:
			aa.add(cc.remove(cc.size() - 1));
			bb.add(cc.remove(cc.size() - 1));
			bb.add(aa.remove(aa.size() - 1));
			aa.add(cc.remove(cc.size() - 1));

			cc.add(bb.remove(bb.size() - 1));
			aa.add(bb.remove(bb.size() - 1));
			aa.add(cc.remove(cc.size() - 1));
			break;
		case 3:
			bb.add(aa.remove(aa.size() - 1));
			cc.add(aa.remove(aa.size() - 1));
			cc.add(bb.remove(bb.size() - 1));
			bb.add(aa.remove(aa.size() - 1));

			aa.add(cc.remove(cc.size() - 1));
			bb.add(cc.remove(cc.size() - 1));
			bb.add(aa.remove(aa.size() - 1));
			break;
		default:
			break;
		}
		return null;
	}
}
