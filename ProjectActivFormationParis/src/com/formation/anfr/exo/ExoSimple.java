package com.formation.anfr.exo;
public class ExoSimple {

	/**
	 * Exemple tab = [1,5,7,6,8,9,4,2,3] résultat : 45
	 * 
	 * @param tab
	 * @return
	 */
	public static void main(String[] args) {
		ExoSimple mainGit = new ExoSimple();
		mainGit.init();

	}
	
	
	public void init() {
		int[] tab = {1,5,7,6,8,9,4,2,3};
		System.out.println("Résultat : " + sumTableau(tab));
		 int[] tableau = {-1,3,5,9,5,14,28,3,6,9};
		System.out.println("Résultat : " + sumTableau(tableau));
	}

	public int sumTableau(int[] tab) {
		int somme = 0;
		for (int i = 0; i < tab.length; i++) {
			somme = somme + tab[i];
		}
		return somme;
	}
}