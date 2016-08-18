package com.formation.joca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Pattern;

public class ExoAlgo5 implements com.formation.phva.inter.InterAlgo5 {

	public String[] solution(String[] tab, String cat, int n) {
		String[] sortie = null;

		ArrayList<MeubleRecup> listemeuble = new ArrayList<MeubleRecup>();
		if (tab != null && Pattern.matches("\\d{6}", cat) && estBon(tab)) {
			for (int i = 0; i < tab.length; i++) {
				String serie = tab[i].substring(0, 6);

				if (serie.equals(cat)) {
					MeubleRecup meuble = new MeubleRecup(tab[i]);
					meuble.EstDansListe(listemeuble);
				}
			}
			Collections.sort(listemeuble);
			if (n > 0 && n <= listemeuble.size()) {
				sortie = new String[n];
				for (int i = 0; i < n; i++) {
					sortie[i] = listemeuble.get(listemeuble.size() - 1 - i).getNumserie();
				}
			}

		}

		return sortie;
	}

	public boolean estBon(String[] tab) {
		boolean sortie = true;
		for (int i = 0; i < tab.length; i++) {
			if (!Pattern.matches("\\d{9}", tab[i])) {
				sortie = false;
			}
		}

		return sortie;
	}
}
