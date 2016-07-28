package com.formation.etga.exo;

import java.util.ArrayList;

import com.formation.phva.exo.ImplAlgo3;
import com.formation.phva.exo.Mouvement;

/**
 * R�aliser un algorithme qui respecte le comportement des tours de Hanoi
 * 
 * il n'est possible de bouger que 1 �l�ment a la fois un �l�ment ne peut �tre
 * d�plac� que sur la base d'une autre tour ou d'un �l�ment de taille plus grand
 * 
 * D�plac� tout les �l�ments d'une tour vers une autre tour pour les retrouver
 * dans l'ordre.
 * 
 * @author philippe
 *
 */
public class ExoAlgo3 implements ImplAlgo3 {

	public ArrayList<Mouvement> solution(ArrayList<Mouvement> lst, int nbElements, String a, String b, String c) {
		if (nbElements <= 0) {
		} else if (nbElements > 1) {
			//on passe la pile vers B
			solution(lst, nbElements - 1, a, c, b);
			//on bouge le plus gros vers C
			lst.add(new Mouvement(nbElements, a, c));
			//on remet tout sur C
			solution(lst, nbElements - 1, b, a, c);

		} else {
			//on passe l'element 1 vers C
			lst.add(new Mouvement(nbElements, a, c));
		}
		return lst;
	}
}
