package com.formation.etga.exo;

import java.util.ArrayList;

public class ExoAlgo3Explique {
	public static void main(String[] args) {
		ExoAlgo3Explique exoAlgo3Explique = new ExoAlgo3Explique();
		exoAlgo3Explique.init();
	}

	public void init() {
		ArrayList<Mouvement> lst = new ArrayList<Mouvement>();
		int niveau = 4;
		// deplacer tous les elements n-1 de from sur to
		lst = saveNMoins1(lst, niveau - 1, "N", "B", "R");
		//		// deplacer l'element n de from vers to
		//		lst = deplaceN(lst, niveau, "N", "B", "R");
		//		// replacer tous les elements n-1....0 de temp sur to
		//		lst = recupNMoins1(lst, niveau - 1, "N", "B", "R");
	}

	public ArrayList<Mouvement> saveNMoins1(ArrayList<Mouvement> lst, int n, String from, String to, String temp) {
		if (n >= 0) {
			// deplacer tous les elements n-1 de from vers temp
			lst = saveNMoins1(lst, n - 1, from, temp, to); // quand n = -1, ca fait rien cette ligne
			// deplacer l'element n de from vers to
			lst = deplaceN(lst, n, from, to, temp);
			// replacer tous les elements n-1....0 de temp sur to
			lst = recupNMoins1(lst, n - 1, temp, to, from);
		}
		return lst;
	}

	public ArrayList<Mouvement> deplaceN(ArrayList<Mouvement> lst, int n, String from, String to, String temp) {
		System.out.println("deplacer " + n + " de " + from + " vers " + to);
		return lst;
	}

	public ArrayList<Mouvement> recupNMoins1(ArrayList<Mouvement> lst, int n, String from, String to, String temp) {
		if (n >= 0) {
			// deplacer tous les elements n-1 de from vers temp
			lst = saveNMoins1(lst, n - 1, from, temp, to);
			// deplacer l'element n de from vers to
			lst = deplaceN(lst, n, from, to, temp);
			// replacer tous les elements n-1....0 de temp sur to
			lst = recupNMoins1(lst, n - 1, temp, to, from);
		}
		return lst;
	}
}