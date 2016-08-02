package com.formation.emma.exo;

import java.util.ArrayList;

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
public class ExoAlgo3 {

	public ArrayList<Mouvement> solution(ArrayList<Mouvement> lst, int indice, String a, String b, String c) {
		ArrayList A = new ArrayList();
		ArrayList B = new ArrayList();
		ArrayList C = new ArrayList();

		for (int i = 0; i < indice; i++) {
			A.add(i);
		}
		
		//if(A[0]<B[0])
		
		return lst;
	}
}
