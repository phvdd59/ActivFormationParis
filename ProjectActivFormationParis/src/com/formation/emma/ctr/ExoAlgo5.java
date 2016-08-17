package com.formation.emma.ctr;

import java.util.ArrayList;
import java.util.Collections;

import com.formation.emma.ctr.RepetitionMot;

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
		String[] tabRetour = null;
		//ArrayList<RepetitionMot> liste = null;
		ArrayList<RepetitionMot> tabInt = null;
		int a = 0;
		int d = 0;

		if (tab == null || cat.length() != 6 || n > tab.length) {

		} else {
			tabInt = new ArrayList<RepetitionMot>();
		//	liste = new ArrayList<RepetitionMot>();
			for (int i = 0; i < tab.length; i++) {
				if (cat.equals(tab[i].substring(0, 6))) {
					RepetitionMot meuble = new RepetitionMot(tab[i], 1);
					//					liste.add(meuble);
					if (tabInt.contains(meuble)) {
						a = tabInt.indexOf(meuble);
						d = tabInt.get(a).getRepetition() + 1;
						tabInt.remove(a);
						tabInt.add(new RepetitionMot(tabInt.get(a).getCategorie(), d));
						break;
					} else {
						tabInt.add(meuble);
					}
				}
			}
		}
		//
		//			for (int k = 0; k < liste.size(); k++) {

		tabRetour = new String[n];

		//}

		return tabRetour;
	}

}
