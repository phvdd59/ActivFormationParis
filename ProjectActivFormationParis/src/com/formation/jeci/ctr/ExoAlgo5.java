package com.formation.jeci.ctr;

import java.util.ArrayList;
import java.util.Collections;

public class ExoAlgo5 implements com.formation.phva.inter.InterAlgo5 {
	/*
	 * Besoin : Le service marketing de IKAE souhaite connaître ses n meubles,
	 * d'un certain type, les plus vendues il a à sa disposition issue de la bbd
	 * un tableau contenant tous les articles vendu depuis 10 ans représenté par
	 * son seul numéro de référence :
	 * 
	 * - chaque référence est un nombre de 9 chiffres - les 6 premiers chiffres
	 * représentent un groupe de meuble. - les 3 derniers chiffres correspond
	 * dans ce groupe un type particulier de meuble. - exemple : table basse
	 * "435678004" table haute "435678158" armoire haute 3 portes "001451054"
	 * armoire basse 2 portes "001451007" On ne s'interessera qu'au meubles par
	 * exemple d'armoire : "001451...")
	 * 
	 * en parametre - tab : tableau de référence des articles vendus - cat : le
	 * numéro a 6 chiffres des meubles qui nous intéresse. - n : nombre
	 * d'armoires souhaitée retourner - le tableau dans l'odre décroissant des n
	 * armoires les plus vendus
	 * 
	 * méthode public String[] solution(String[] tab,String cat, int n);
	 * 
	 * exemple : tab =
	 * ["123456001","123456002","123456001","456789001","123456003","123456001",
	 * "123456003","123456003","456789002","654987001","654987003","123456005",
	 * "456789002","456789002","456789510","456789510","789456245","123456001"]
	 * cat = "123456" n = 2; tabRetour = ["123456001","123456003"]
	 * 
	 * autre exemple : tab =
	 * ["123456001","123456002","123456001","456789001","123456003","123456001",
	 * "123456003","123456003","456789002","654987001","654987003","123456005",
	 * "456789002","456789002","456789510","456789510","789456245","123456001"]
	 * cat = "456789" n = 2; tabRetour = ["456789002","456789510"]
	 * 
	 * 
	 * Nota : toutes les précautions devront être prises pour que le programme
	 * soit fiable.
	 * 
	 */

	public String[] solution(String[] tab, String cat, int n) {
		ArrayList<String> lst = new ArrayList<String>();
		ArrayList<Poids> lst2 = new ArrayList<Poids>();
		ArrayList<Poids> lst3 = new ArrayList<Poids>();
		String[] retour = new String[n];
		if (cat != null && n > 0 && tab != null) {
			for (int i = 0; i < tab.length; i++) {
				if (cat.equals(tab[i].substring(0, 6))) {
					lst.add(tab[i].substring(6));

				}
			}

			for (int i = 0; i < lst.size(); i++) {
				String mot = lst.get(i);
				Poids p = new Poids(mot);
				lst2.add(p);
			}

			for (int i = 0; i < lst2.size(); i++) {
				for (int j = 0; j < lst2.size(); j++) {

					if (lst2.get(i).getMot().equals((lst2.get(j).getMot())) && i != j) {
						lst2.remove(j);
						int nb=lst2.get(i).getNb();
						lst2.get(i).setNb(nb+1);
						j--;
					}
				}
			}

			Collections.sort(lst2);
			if (lst2.size() >= n) {
				for (int i = 0; i < n; i++) {
					retour[i] = cat + lst2.get(i).getMot();
				}
			} else {
				retour = null;
			}

		} else {
			retour = null;
		}

		return retour;
	}
}
