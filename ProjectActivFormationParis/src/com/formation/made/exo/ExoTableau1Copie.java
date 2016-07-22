package com.formation.made.exo;

import com.formation.phva.exo.InterExoTableau1;

public class ExoTableau1Copie implements InterExoTableau1 {

	/**
	 * Exemple d=7 , n=5 p=3 --> [7,10,13,16,19]
	 * 
	 * @param d
	 *            = valeur de départ
	 * @param n
	 *            = nb d'élément
	 * @param p
	 *            = pas entre chaque élément
	 * @return = nouveau tableau rempli
	 */

	public int[] remplirTableau(int d, int n, int p) {
		// attention toujours initialiser la valeur que l'on veut retourner au début. en générale, la plus neutre possible
		int[] tableauvaleurs = new int[n];
		if ((long) d + (long) p * n > Integer.MAX_VALUE || (long) d + (long) p * n < Integer.MIN_VALUE || n < 0) { // ici le but est de proteger son code en limantant les valeurs de l'int
		} else {
			// tableauvaleurs[0] = d;
			// System.out.println(tableauvaleurs[0]);
			for (int i = 1; i < n; i++) {
				tableauvaleurs[i] = tableauvaleurs[i - 1] + p;
				System.out.println(tableauvaleurs[i]);
			}
		}
		return tableauvaleurs;
	}

	/**
	 * Exemple tab = [7,10,13,16,19,21,24,27,30] i1=3 , i2=8 tab = [7,10,27,16,19,21,24,13,30]
	 * 
	 * @param tab
	 *            tableau en entrée
	 * @param i1
	 *            première position pour l'interversion
	 * @param i2
	 *            deuxième position pour l'interversion
	 * @return
	 */
	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2) {
		int[] tableauinversé = tab;
		int variabletemp = tab[i1 - 1]; // on creer une variable temporaire pour stocker la valeur du tableau indice i1
		tab[i1 - 1] = tableauinversé[i2 - 1];
		tableauinversé[i2 - 1] = variabletemp;
		// System.out.println(tab[i1-1]+" et "+tableauinversé[i2-1]);
		return tableauinversé;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=3,a=8 --> [1,4,6,8,2,4,6]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position après laquelle il faut ajouter la valeur a
	 * @param a
	 *            valeur à ajouter
	 * @return
	 */
	public int[] insererUnElementDansTableau(int[] tab, int p, int a) {
		int[] tableauajout = new int[tab.length + 1];
		int temp = 0;
		for (int i = 0; i < p; i++) {
			tableauajout[i] = tab[i];
			temp = i + 1;
			// System.out.println(tableauajout[i]);
		}
		// System.out.println("temp=" + temp);
		tableauajout[temp] = a;
		// System.out.println(tableauajout[temp]);
		for (int i = p + 1; i < tableauajout.length; i++) {
			tableauajout[i] = tab[i - 1];
			// System.out.println(tableauajout[i]);
		}
		return tableauajout;
	}

	/**
	 * Exemple 1 [1,4,6,2,4,7] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,7] Exemple 2 [22,11,0,77,88,99] : p=2, tab1=[3,4,5,6] --> [22,11,3,4,5,6]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position où il faut remplacer les valeurs du premier tableau par celles du second
	 * @param tab1
	 *            tableau contenant les valeurs de remplacement
	 * @return tableau
	 */
	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1) {
		int[] tableauinverse = tab;
		int k = 0;
		for (int i = p; i < tab.length + p; i++) {
			tableauinverse[i] = tab1[k];
			k++;
		}
		for (int i = 0; i < tableauinverse.length; i++) {
			// System.out.println(tableauinverse[i]);
		}
		return tableauinverse;
	}

	/**
	 * Exemple 1 tab [1,4,6,2,4,6] : p = 2 --> tab résultat [4,6,1,4,6,2] Exemple 2 tab [1,4,6,2,4,6] : p = 4 --> tab résultat [6,2,4,6,1,4]
	 * 
	 * @param tab
	 *            tableau de départ
	 * @param p
	 *            position : décaler le tableau vers la droite de p positions et les p élements de la fin du tableau reviennent en début de tableau
	 * @return
	 */
	public int[] rotationTableau(int[] tab, int p) {
		int[] tableaurot = new int[tab.length];
		for (int i = p; i < tableaurot.length; i++) {
			tableaurot[i] = tab[i - p];
		}
		for (int i = 0; i < p; i++) {
			tableaurot[i] = tab[tab.length - p + i];
		}
		for (int i = 0; i < tableaurot.length; i++) {
			// System.out.println(tableaurot[i]);
		}
		return tableaurot;
	}
}