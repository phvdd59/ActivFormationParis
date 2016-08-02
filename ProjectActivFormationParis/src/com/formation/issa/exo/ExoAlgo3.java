package com.formation.issa.exo;

import java.util.ArrayList;

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
	
	public ArrayList<Mouvement> solution(ArrayList<Mouvement> lst, int indice, String a, String b, String c) {
		indice=5;
		if(indice==0){
			return null;
		}
		else if(indice==1){
			lst.add(new Mouvement(1, "a", "c"));
		}
		else{
			lst.add(new Mouvement(indice-1, "a", "b"));
			lst.add(new Mouvement(indice, "a", "c"));
			lst.add(new Mouvement(indice-1, "b", "c"));
		}
		return lst;
	}
}
