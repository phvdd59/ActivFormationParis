package com.formation.anfr.exo;

public class ExoSimple {

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */
	private int[] tab;

	public ExoSimple() {
		int[] tabDefaut = { 1, 5, 7, 6, 8, 9, 4, 2, 3 };
		setTab(tabDefaut);
	}
	
	public ExoSimple(int[] tab){
		setTab(tab);
	}
	
	public int[] getTab() {
		return tab;
	}

	public void setTab(int[] tab) {
		this.tab = tab;
	}



	public int sumTableau() {
		int somme = 0;
		for (int i = 0; i < tab.length; i++) {
			somme = somme + tab[i];
		}
		return somme;
	}
}