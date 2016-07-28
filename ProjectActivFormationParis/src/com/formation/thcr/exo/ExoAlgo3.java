package com.formation.thcr.exo;

import java.util.ArrayList;

import com.formation.phva.exo.ImplAlgo3;
import com.formation.phva.exo.Mouvement;

/**
 * R�aliser un algorithme qui respecte le comportement des tours de Hanoi
 * 
 * il n'est possible de bouger que 1 �l�ment a la fois
 * un �l�ment ne peut �tre d�plac� que sur la base d'une autre tour ou d'un �l�ment de taille plus grand
 * 
 * D�plac� tout les �l�ments d'une tour vers une autre tour pour les retrouver dans l'ordre.
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
		// Initialisation de la premi�re colonne
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
