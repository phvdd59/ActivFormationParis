package com.formation.ambr.exo;

import com.formation.phva.exo.InterExoTableau1;

public class ExoTableau1 implements InterExoTableau1 {

	//0.Cr�ation de tableaux
	//public int[] cr�erTableau

	//1
	/**
	 * Exemple d=7 , n=5 p=3 --> [7,10,13,16,19]
	 * 
	 * @param d
	 *            = valeur de d�part
	 * @param n
	 *            = nb d'�l�ment
	 * @param p
	 *            = pas entre chaque �l�ment
	 * @return = nouveau tableau rempli
	 */

	// 1.Variables
	int d;
	int n;
	int p;

	// 1.m�thode remplirTableau
	public int[] remplirTableau(int d, int n, int p) {
		int[] tab1 = new int[n];
		tab1[0] = d;
		for (int i = 0; i < n; i++) {
			if (tab1[i] == d) {
				tab1[i] = d;
			} else {
				tab1[i] = d + (p * i);
			}
			//System.out.println(tab1[i]);
		}
		return tab1;
	}

	// correction thomas
	public int[] remplirTableau1(int d, int n, int p) {
		int[] tab = null;
		tab[0] = d;

		if ((long)d + (long)p * n > Integer.MAX_VALUE || (long)d + (long)p * n < Integer.MIN_VALUE) {

		} else {
			tab = new int[n];
			tab[0] = d;
			for (int i = 1; i < tab.length; i++) {
				tab[i] = tab[i - 1] + p;
			}
		}
		return tab;
	}

	//2
	/**
	 * Exemple tab = [7,10,13,16,19,21,24,27,30] i1=3 , i2=8 tab =
	 * [7,10,27,16,19,21,24,13,30]
	 * 
	 * @param tab
	 *            tableau en entr�e
	 * @param i1
	 *            premi�re position pour l'interversion
	 * @param i2
	 *            deuxi�me position pour l'interversion
	 * @return
	 */

	// 2.variables
	int[] tabOriginel;
	int i1;
	int i2;

	// 2.m�thode intervertirDeuxElementsTableau
	public int[] intervertirDeuxElementsTableau(int[] tabOriginel, int i1, int i2) {
		int[] tab1 = new int[n];
		int[] tab2 = new int[n];
//		public int[] tab1.remplirTableau(int d, int n, int p);
		
		
		
		
		int[] tabInterverti = new int[tabOriginel.length];

		return tabInterverti;
	}

	//correction thomas
	public int[] intervertirDeuxElementsTableau1(int[] tab, int i1, int i2) {
		int[] tab2 = null;
		if (tab == null) {

		} else if (i1 < 0 || i2 < 0 || i1 >= tab.length || i2 >= tab.length) {

		} else {
			//clone tab2 pour pas
			tab2 = tab.clone();
			tab2[i1 - 1] = tab2[i2 - 1];
			tab2[i2 - 1] = tab[i1 - 1];
		}
		return null;
	}

	//3
	/**
	 * Exemple [1,4,6,2,4,6] : p=3,a=8 --> [1,4,6,8,2,4,6]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param p
	 *            position apr�s laquelle il faut ajouter la valeur a
	 * @param a
	 *            valeur � ajouter
	 * @return
	 */

	// 3. m�thode insererUnElementDansTableau
	public int[] insererUnElementDansTableau(int[] tab, int p, int a) {
		return null;
	}

	// 3.variables
	int a;

	//4
	/**
	 * Exemple 1 [1,4,6,2,4,7] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,7] Exemple 2
	 * [22,11,0,77,88,99] : p=2, tab1=[3,4,5,6] --> [22,11,3,4,5,6]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param p
	 *            position o� il faut remplacer les valeurs du premier tableau
	 *            par celles du second
	 * @param tab1
	 *            tableau contenant les valeurs de remplacement
	 * @return tableau
	 */

	// 4.m�thode insererUnTableauDansUnAutreAvecRemplacement
	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1) {
		return null;
	}

	// 4. variables
	int[] tab1;

	// 5
	/**
	 * Exemple 1 tab [1,4,6,2,4,6] : p = 2 --> tab r�sultat [4,6,1,4,6,2]
	 * Exemple 2 tab [1,4,6,2,4,6] : p = 4 --> tab r�sultat [6,2,4,6,1,4]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param p
	 *            position : d�caler le tableau vers la droite de p positions et
	 *            les p �lements de la fin du tableau reviennent en d�but de
	 *            tableau
	 * @return
	 */

	// 5.m�thode rotationTableau
	public int[] rotationTableau(int[] tab, int p) {
		return null;
	}
}