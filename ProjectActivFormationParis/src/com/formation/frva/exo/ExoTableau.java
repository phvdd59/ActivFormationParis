package com.formation.frva.exo;

import com.formation.phva.exo.InterExoTableau1;

public class ExoTableau implements InterExoTableau1 {

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
	public int[] remplirTableau(int d, int n, int p) {
		return null;
	}

	/**
	 * Exemple tab = [1,4,6,-5,7,5]
	 * 
	 * @param tab
	 *            tableau en entr�e
	 * @return tab = [5,7,-5,6,4,1]
	 */
	public int[] inverserTableau(int[] tab) {
		return null;
	}

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
	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2) {
		return null;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : a=8 --> [1,4,6,2,4,6,8]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param a
	 *            valeur � ajouter � la fin
	 * @return
	 */
	public int[] rallongerTableauDeUnElement(int[] tab, int a) {
		return null;
	}

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
	public int[] insererUnElementDansTableau(int[] tab, int p, int a) {
		return null;
	}

	/**
	 * Exemple [1,4,6,2,4,6] : p=2, tab1=[4,9,0] --> [1,4,4,9,0,6,2,4,6]
	 * 
	 * @param tab
	 *            tableau de d�part
	 * @param p
	 *            position o� il faut ins�rer le 2�me tableau
	 * @param tab1
	 *            tableau � ins�rer
	 * @return tableau
	 */
	public int[] insererUnTableauDansUnAutre(int[] tab, int p, int[] tab1) {
		return null;
	}

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
	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tab, int p, int[] tab1) {
		return null;
	}

	/**
	 * Exemple 1 [1,7,8,2,4,6] : d=2 --> [1,7] [8,2] [4,6] Exemple 2
	 * [1,7,8,2,4,6] : d=3 -->[1,7,8] [2,4,6]
	 * 
	 * @param tab
	 *            tableau en entr�e
	 * @param d
	 *            dimension de base
	 * @return tableau de n dimensions de base
	 */
	public int[][] changerDimensionTableau(int[] tab, int d) {
		return null;
	}

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
	public int[] rotationTableau(int[] tab, int p) {
		return null;
	}

	/**
	 * Exemple v=18 --> r�sultat [1,0,0,1,0]
	 * 
	 * @param v
	 *            valeur en entr�e
	 * @return tableau repr�sentant cette valeur mais en binaire
	 */
	public int[] tabBaseDeux(int v) {
		return null;
	}
}