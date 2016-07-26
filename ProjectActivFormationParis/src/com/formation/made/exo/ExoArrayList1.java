package com.formation.made.exo;

import java.util.ArrayList;

import com.formation.phva.exo.InterExoArrayList1;

public class ExoArrayList1 implements InterExoArrayList1 {

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
	public ArrayList<Integer> remplirTableau(int d, int n, int p) {
		ArrayList<Integer> listValeurs = null;
		if ((long) d + (long) p * n > Integer.MAX_VALUE || (long) d + (long) p * n < Integer.MIN_VALUE || n < 0) {
			// System.out.println("n doit être un entier positif. De plus, le résultat de d+p*n doit être compris dans un int.");
		} else {
			listValeurs = new ArrayList<>();
			listValeurs.add(d);
			// System.out.println(listValeurs.get(0));
			for (int i = 1; i < n; i++) {
				listValeurs.add(i, listValeurs.get(i - 1) + p);
				// System.out.println(listValeurs.get(i));
			}
		}

		return listValeurs;
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
	public ArrayList<Integer> intervertirDeuxElementsTableau(ArrayList<Integer> tab, int i1, int i2) {
		if (tab == null) {
		}
		ArrayList<Integer> tabintervetie = (ArrayList<Integer>) tab.clone();
		if (i1 < 0 || i1 > tab.size() || i2 > tab.size() || i2 < 0) {
			// System.out.println("i1 et i2 sont des int positifs, et inférieurs à la longueur du tableau.");
		} else {
			int variabletemp1 = tabintervetie.remove(i1);
			int variabletemp2 = tabintervetie.remove(i2 - 1);
			tabintervetie.add(i1, variabletemp2);
			tabintervetie.add(i2, variabletemp1);
		}
		return tabintervetie;
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
	public ArrayList<Integer> insererUnElementDansTableau(ArrayList<Integer> tab, int p, int a) {
		ArrayList<Integer> tableauAjout = null;
		if (p > tab.size() || p < 0) {
			tableauAjout = (ArrayList<Integer>) tab.clone();// System.out.println("P compris entre0 et la longueur de la liste");
		} else {
			tableauAjout = (ArrayList<Integer>) tab.clone();
			tableauAjout.add(p, a);
		}
		return tableauAjout;
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
	public ArrayList<Integer> insererUnTableauDansUnAutreAvecRemplacement(ArrayList<Integer> tab, int p, ArrayList<Integer> tab1) {
		ArrayList<Integer> tableaufinal = null;
		if (tab == null) {
		} else if (tab1 == null || tab1.size() > tab.size() || p < 0 || tab1.size() + p > tab.size()||tab1.size() == tab.size() && p != 0) {
			tableaufinal = (ArrayList) tab.clone();
			// System.out.println("pas les bonnes valeurs");
		} else {
			tableaufinal = (ArrayList<Integer>) tab.clone();
			for (int i = p; i < tab1.size() + p; i++) {
				tableaufinal.add(i, tab1.get(i-p));
				tableaufinal.remove(i + 1);
			}
		}
		return tableaufinal;
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
	public ArrayList<Integer> rotationTableau(ArrayList<Integer> tab, int p) {
		ArrayList<Integer> tableaurot = null;

		int reste = (p % tab.size());
		if (reste < 0) {
			reste = tab.size() + reste;
			tableaurot = (ArrayList<Integer>) tab.clone();
			for (int i = 0; i < reste; i++) {
				tableaurot.add(0, tableaurot.remove(tab.size() - 1));
			}
		}

		else if (reste == 0) {
			tableaurot = (ArrayList<Integer>) tab.clone();
		} else if (reste > 0) {
			tableaurot = (ArrayList<Integer>) tab.clone();
			for (int i = 0; i < reste; i++) {
				tableaurot.add(0, tableaurot.remove(tab.size() - 1));
			}
		}
		return tableaurot;
	}
}