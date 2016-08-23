package com.formation.beba.save;

import java.util.ArrayList;

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
		ArrayList<String> lst2 = new ArrayList<String>();
		String[] tabRet = new String[n];

		for (int i = 0; i < tab.length; i++) {
			String temp = tab[i].substring(0, 6);
			if (temp.compareTo(cat) == 0) {
				lst.add(tab[i].concat("000"));
			}
		}
		for (int i = 0; i < lst.size(); i++) {
			if (i == 1) {
				lst2.add(tab[i]);
			} else {
				for (int j = i + 1; j < lst.size() + 1; j++) {
					if (j == lst.size()) {
						lst2.add(lst.get(i));
					} else if (lst.get(i).equals(lst.get(j))) {
						break;
					}
				}
			}
		}
		for (int i = 0; i < lst2.size(); i++) {
			long temp = Long.valueOf(lst2.get(i));
			for (int j = 0; j < lst.size(); j++) {
				if (lst2.get(i).equals(lst.get(j))) {
					temp++;
				}
			}
			lst2.add(i, Long.toString(temp));
			lst2.remove(i + 1);
		}
		for (int i = 0; i <= (lst2.size() - 2); i++)
			for (int j = i + 1; j < lst2.size() - 1; j++) {
				String test = lst2.get(j - 1).substring(9, 12);
				String test2 = lst2.get(j).substring(9, 12);
				if (Integer.valueOf(test) < Integer.valueOf(test2)) {
					lst2.add(j - 1, lst2.remove(j));
				}
			}
		for (int i = 0; i < n; i++) {
			tab[i] = Integer.toString(Integer.valueOf(lst.get(i)) / 1000);
		}

		return tab;
	}
}
