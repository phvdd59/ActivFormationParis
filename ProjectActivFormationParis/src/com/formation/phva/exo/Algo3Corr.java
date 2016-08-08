package com.formation.phva.exo;

import java.util.ArrayList;

public class Algo3Corr {
	public static void main(String[] args) {
		Algo3Corr a = new Algo3Corr();
		a.init();
	}

	public void init() {
		ArrayList<Mouvement> lst = new ArrayList<Mouvement>();
		int niveau = 2;
		lst = deplace(lst, niveau, "N", "B", "R");
//		
//		// deplacer tous les elements n-1 de "from" sur "temp"
//		lst = saveNMoins1(lst, niveau-1, "N", "B", "R");
//		// deplacer l'element n de "from" vers "to"
//		lst=deplaceN(lst,niveau,"N","B","R");
//		// replacer tous les elements n-1..0 de "temp" sur "to"
//		lst=recupNMoins1(lst,niveau-1,"N","B","R");
	}

	public ArrayList<Mouvement> deplace( //
			ArrayList<Mouvement> lst, //
			int n, //
			String from, //
			String to, //
			String temp) {
		if (n >= 0) {
			// deplacer tout les elements n-1 de "from" vers "temp"
			lst = deplace(lst, n - 1, from, temp, to);
			// deplacer l'element n de "from" vers "to"
			System.out.println("deplacer " + n + " de " + from + " vers " + to);
			// replacer tous les elements n-1..0 de "temp" sur "to"
			lst = deplace(lst, n - 1, temp, to, from);
		}
		return lst;
	}

	public ArrayList<Mouvement> saveNMoins1( //
			ArrayList<Mouvement> lst, //
			int n, //
			String from, //
			String to, //
			String temp) {
		if (n > 0) {
			// deplacer tout les elements n-1 de "from" vers "temp"
			lst = saveNMoins1(lst, n - 1, from, temp, to);
			// deplacer l'element n de "from" vers "to"
			lst = deplaceN(lst, n, from, to, temp);
			// replacer tous les elements n-1..0 de "temp" sur "to"
			lst = recupNMoins1(lst, n - 1, temp, to, from);
		} else {
			lst = deplaceN(lst, n, from, to, temp);
		}
		return lst;
	}

	public ArrayList<Mouvement> deplaceN( //
			ArrayList<Mouvement> lst, //
			int n, //
			String from, //
			String to, //
			String temp) {
		System.out.println("deplacer " + n + " de " + from + " vers " + to);
		return lst;
	}

	public ArrayList<Mouvement> recupNMoins1( //
			ArrayList<Mouvement> lst, //
			int n, //
			String from, //
			String to, //
			String temp) {
		if (n >= 0) {
			// deplacer tout les elements n-1 de "from" vers "temp"
			lst = saveNMoins1(lst, n - 1, from, temp, to);
			// deplacer l'element n de "from" vers "to"
			lst = deplaceN(lst, n, from, to, temp);
			// replacer tous les elements n-1..0 de "temp" sur "to"
			lst = recupNMoins1(lst, n - 1, temp, to, from);
		}
		return lst;
	}
}
