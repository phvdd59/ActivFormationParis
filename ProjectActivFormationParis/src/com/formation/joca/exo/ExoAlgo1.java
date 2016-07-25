package com.formation.joca.exo;

import java.util.ArrayList;

import com.formation.phva.exo.ImpAlgo1;

public class ExoAlgo1 implements ImpAlgo1 {

	/**
	 * soit p entier tel que : 0 <= p < n tableau tab de n elements
	 * 
	 * la somme des elements des plus petits indice doit etre egal a la somme
	 * des elements des plus grand indice
	 * 
	 * la somme d'aucun element est egal a zero (p==0 || p==n-1) exemple
	 * 
	 * n=8 tab=[-1,3,-4,5,1,-6,2,1]
	 * 
	 * p=1 est un point d'equilibre ==> -1 = somme(-4,5,1,-6,2,1) p=3 est un
	 * point d'equilibre somme(-1,3,-4) = somme(1,-6,2,1) = -2 p=7 est un point
	 * d'equilibre somme(-1,3,-4,5,1,-6,2) = somme() = 0 p=8 n'est pas un point
	 * d'equilibre
	 * 
	 * n [0 --> 100000] chaque element du tableau est un int
	 */

	// cet algo fait toutes les it�rations et renvoit le dernier point d'�qulibre calcul�
	// il renvoit -1 s'il n'y a pas de point d'�quilibre
	public int solution2(int[] tab) {

		int result = -1;
		for (int j = 0; j < tab.length; j++) { 	// on teste toutes les positions j que peut avoir le point d'�quilibre (entre 0 et tab.length-1) 
			int somme1 = 0; 				   	// le but de l'algo est de determiner la somme des elements � gauche du point d'�quilibre (somme1)          
			int somme2 = 0;                    	// et la somme des �l�ments � droite (somme2), afin de les comparer

			for (int i = 0; i < j; i++) { 		// calcul de somme1 = somme des �l�ments � gauche de j 
				somme1 += tab[i]; 				// ce sont les �l�ments de tab de 0 � j-1
			} 									// si j=0, cette boucle est ignor�e car i=0 < j=0 est bien faux
												// Donc somme1 ne change pas et =0
			
			for (int i = j + 1; i < tab.length; i++) { 	// calcul de somme2 = somme des �l�ments � droite de j
				somme2 += tab[i]; 						// ce sont les �l�ments de j+1 � tab.length-1
			} 											// si j=tab.length-1, cette boucle est ignor�e car i=tab.length < tab.length est bien faux
														// Donc somme2 ne change pas et =0

			if (somme1 == somme2) { 					// si somme1 = somme2 alors j est un point d'�quilibre
				result = j; 							// il faut noter que cet algo �crase result � chaque fois qu'un point d'�quilibre est trouv�
			}											// par cons�quent, result aura la valeur du dernier point  d'�quilibre calcul�				
		}
		return result;
	}

	// cet algo s'arrete une fois un point d'�quilibre trouv� 
	// et renvoit par cons�quent le premier point d'�quilibre
	// il renvoit -1 s'il n'y a pas de point d'�quilibre

	public int solution(int[] tab) {

		int result = -1;
		int j = 0;
		boolean trouve = false; 					// boolean utilis� pour sortir de la boucle,
		while (j < tab.length && trouve == false) { // principale difference avec l'algo pr�c�dent :
													// on boucle tant qu'on a pas trouv� 
			int somme1 = 0; 						// et tant qu'on a pas test� toutes les positions possibles de j
			int somme2 = 0; 					

			for (int i = 0; i < j; i++) { 			// aucun changement pour les calculs de somme1 et somme2
				somme1 += tab[i];
			}
			for (int i = j + 1; i < tab.length; i++) {
				somme2 += tab[i];
			}
			if (somme1 == somme2) {
				result = j; 						// d�s qu'on trouve un point d'�quilibre, on passe le boolean "trouve" � true
				trouve = true; 						// on sort donc de la boucle
			}
			j++; 									// TRES IMPORTANT : ne pas oublier d'incrementer j � la fin de l'algo
		} 											// sinon, on bouclerait sur la m�me position de j=0 � l'infini 
													// et on ne sortirait jamais de la boucle
		return result;
	}

	// m�me chose que la premiere solution
	// mais cette fois on stocke tout les points d'�quilibre dans une liste
	public ArrayList<Integer> solution3(int[] tab) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int j = 0; j < tab.length; j++) {
			int somme1 = 0;
			int somme2 = 0;

			for (int i = 0; i < j; i++) {
				somme1 += tab[i];
			}
			for (int i = j + 1; i < tab.length; i++) {
				somme2 += tab[i];
			}

			if (somme1 == somme2) {
				result.add(j);
			}
		}
		return result;
	}

}