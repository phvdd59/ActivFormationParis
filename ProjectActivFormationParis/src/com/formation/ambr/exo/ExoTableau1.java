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
		// protection: e.g. si on donne un n n�gatif, �a ne fonctionne pas
		//int tableauRempli[] = null;
		if (n < 0) {
			return null;
		}
		if ((long) d + (long) n * p > Integer.MAX_VALUE || (long) d + (long) n * p < Integer.MIN_VALUE) { /// si on prot�ge pas p, on pourra avoir des valeurs sup�rieures � un int (e.g. 1+214748437). Par contre je vois pas trop pkoi prot�ger n. Et d non plus. Si on entre, un int, il est d�j� prot�g� lors de la cr�ation de d non? Sauf que si je le caste pas et que je teste avc les valeurs du prof, �a renvoie "y'a un probl�me"...
			return null;
		}
		// fin de la protection. N.B.: si n=0, la m�thode nous sort un tableau avec 0 �l�ments. Ca existe, il a un pointeur, mais il est vide
		int[] tab1 = new int[n];
		for (int i = 0; i < n; i++) {
			tab1[i] = d + (p * i);
		}
		return tab1;
	}
	//		tab1[0]=7;
	//		tab1[1]=7+3;
	//		tab1[2]=7+(3*2);

	// ancienne version
	//int[] tab1 = new int[n];
	//		tab1[0] = d;
	//		for (int i = 0; i < n; i++) {
	//			if (tab1[i] == d) {
	//				tab1[i] = d;
	//			} else {
	//				tab1[i] = d + (p * i);
	//			}
	//System.out.println(tab1[i]);
	//		}

	// correction thomas
	//	public int[] remplirTableau(int d, int n, int p) {
	//		int[] tab = null;
	//		tab[0] = d;
	//
	//		if ((long)d + (long)p * n > Integer.MAX_VALUE || (long)d + (long)p * n < Integer.MIN_VALUE) {
	//
	//		} else {
	//			tab = new int[n];
	//			tab[0] = d;
	//			for (int i = 1; i < tab.length; i++) {
	//				tab[i] = tab[i - 1] + p;
	//			}
	//		}
	//		return tab;
	//	}

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
	int[] tabOrig;
	int i1;
	int i2;

	// 2.m�thode intervertirDeuxElementsTableau
	public int[] intervertirDeuxElementsTableau(int[] tabOrig, int i1, int i2) {
		//protection
		if (i1 > tabOrig.length || i2 > tabOrig.length) {
			return tabOrig.clone();
		}
		if (i1 < 0 || i2 < 0) { // pour i1=-3, et i2=8; je comprends pkoi �a passe pas dans exoRes. Car �a me renvoie "Y'a un  probl�me"
			return tabOrig.clone();
		}
		//fin protection
		int[] tabInterv = new int[tabOrig.length];
		for (int i = 0; i < tabInterv.length; i++) {
			if (i == i1 - 1) {
				tabInterv[i] = tabOrig[i + i2 - i1];
			} else if (i == i2 - 1) {
				tabInterv[i] = tabOrig[i - (i2 - i1)];
			} else {
				tabInterv[i] = tabOrig[i];
			}
		}
		return tabInterv;
	}

	//		tabInterv[0]=tabOrig[0];
	//		tabInterv[1]=tabOrig[1];
	//		tabInterv[2]=tabOrig[7];
	//		tabInterv[3]=tabOrig[3];
	//		tabInterv[4]=tabOrig[4];
	//		tabInterv[5]=tabOrig[5];
	//		tabInterv[6]=tabOrig[6];
	//		tabInterv[7]=tabOrig[2];

	//correction thomas
	//	public int[] intervertirDeuxElementsTableau(int[] tab, int i1, int i2) {
	//		int[] tab2 = null;
	//		if (tab == null) {
	//
	//		} else if (i1 < 0 || i2 < 0 || i1 >= tab.length || i2 >= tab.length) {
	//
	//		} else {
	//			//clone tab2 pour pas
	//			tab2 = tab.clone();
	//			tab2[i1 - 1] = tab2[i2 - 1];
	//			tab2[i2 - 1] = tab[i1 - 1];
	//		}
	//	}

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

	// 3.variables
	int a;

	// 3. m�thode insererUnElementDansTableau
	public int[] insererUnElementDansTableau(int[] tabOrig2, int p, int a) {
		int[] tabRes2 = new int[tabOrig2.length + 1];
		//protection
		if (p < 0 || p > tabOrig2.length) {
			return tabOrig2.clone();
		}
		//fin protection
		for (int i = 0; i <= p; i++) {

			if (i == p) {
				tabRes2[i] = a;
			} else {
				tabRes2[i] = tabOrig2[i];
			}
		}
		for (int i = p + 1; i < tabRes2.length; i++) {
			tabRes2[i] = tabOrig2[i - 1];
		}
		return tabRes2;
	}

	//	tabRes2[0]=tabOrig2[0];
	//	tabRes2[1]=tabOrig2[1];
	//	tabRes2[2]=tabOrig2[2];
	//	tabRes2[3]=tabOrig2[3];
	//	tabRes2[4]=a;
	//	tabRes2[5]=tabOrig2[4];
	//	tabRes2[6]=tabOrig2[5];

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
	public int[] insererUnTableauDansUnAutreAvecRemplacement(int[] tabOrig3, int p, int[] tabDeRemp) {
		int[] tabRes3 = new int[tabOrig3.length]; // comment faire pour faire une longueur cumulative?

		// contr�les
		if (p < 0 || p >= tabOrig3.length) {
			return tabOrig3.clone();
		} else {
			if (tabDeRemp.length > tabOrig3.length - p) {
				return tabOrig3.clone();
			}

		}
		//fin contr�les

		for (int i = 0; i < p; i++) {
			tabRes3[i] = tabOrig3[i];
		}
		for (int i = p; i < p + tabDeRemp.length; i++) {
			tabRes3[i] = tabDeRemp[i - p];
		}
		for (int i = p + tabDeRemp.length; i < tabRes3.length; i++) {
			tabRes3[i] = tabOrig3[i];
		}
		return tabRes3;
	}

	// 4. variables
	//int[] tab1;
	int b;
	int j;

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
	public int[] rotationTableau(int[] tabOrig4, int p) {
		int[] tabRota = new int[tabOrig4.length];
		//protection
		if (p > tabOrig4.length || p < 0) {
			return tabOrig4.clone();
		}
		//fin protection
		for (int i = 0; i < p; i++) {
			tabRota[i] = tabOrig4[tabOrig4.length - p + i];
		}
		for (int i = p; i < tabRota.length; i++) {
			tabRota[i] = tabOrig4[i - p];
		}

		// ancienne m�thode
		//		for (int i = 0; i < p; i++) {
		//			tabRota[i] = tabOrig4[i];
		//		}
		//		for (int i = p; i < tabRota.length; i++) {
		//			tabRota[p] = tabRota[i - 2]; // pas fini
		//
		//		}

		return tabRota;
	}
}