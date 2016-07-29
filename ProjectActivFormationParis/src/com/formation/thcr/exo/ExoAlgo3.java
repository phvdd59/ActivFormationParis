package com.formation.thcr.exo;

import java.util.ArrayList;

import com.formation.phva.exo.ImplAlgo3;
import com.formation.phva.exo.Mouvement;

/**
 * Réaliser un algorithme qui respecte le comportement des tours de Hanoi
 * 
 * il n'est possible de bouger que 1 élément a la fois
 * un élément ne peut être déplacé que sur la base d'une autre tour ou d'un élément de taille plus grand
 * 
 * Déplacé tout les éléments d'une tour vers une autre tour pour les retrouver dans l'ordre.
 * 
 * @author philippe
 *
 */
public class ExoAlgo3 implements ImplAlgo3 {
	
	public ArrayList<Mouvement> solution(ArrayList<Mouvement> lst, int nbElements, String a, String b, String c) {
		
		ArrayList<Integer> A = new ArrayList<Integer>();
		for (int i = 1; i <= nbElements; i++) {
			A.add(Integer.valueOf(nbElements - i));
		}
		// Initialisation de la première colonne
		ArrayList<Integer> B = new ArrayList<Integer>();
		ArrayList<Integer> C = new ArrayList<Integer>();
		while(B.size() != nbElements || C.size() != nbElements){
			if(B.size()==0){
				if(A.get(A.size()-1)< B.get(B.size())){
					B.add(B.size(), A.remove(A.size()));
				}
			}
		}
		return null;
	}

}
