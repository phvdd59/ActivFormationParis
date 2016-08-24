package com.formation.issa.save;

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

		String ini = "001451001,001451002,001451001,456789002,001451005,001451004,001451001,001451008,001451004";
		cat = "001451";
		ArrayList<Meuble1> lst = null;
		//ArrayList<Integer>nbOccur=null;
		lst=new ArrayList<Meuble1>();
		//nbOccur=new ArrayList<Integer>();

		String tabini[] = ini.split(",");
		//int[] l = new int[tabini.length];
		for (int i = 0; i < tabini.length; i++) {
			if (cat.equals(tabini[i].substring(0, 6))) {
				Meuble1 str=new Meuble1(tabini[i]);
				if(lst.indexOf(str)!=-1){
					lst.get(lst.indexOf(str)).plusUn();
				}else{
					lst.add(str);
				}
			}

		}
		Collections.sort(lst);
		if (n<=lst.size()){
			tab=new String[n];
		}else{
			tab=new String[lst.size()];
		}
		for (int i = 0; i < tab.length; i++) {
			tab[i]=lst.get(i).getRef();
		}

		
//		boolean trouve = false;
//		//int[] tabL = new int[l.length];
//		int nb = 1;
//		for (int i = 0; i < lst.size(); i++) {
//			// tabF[i]=cat;
//			
//			trouve = false;
//						
//				if (!trouve) {
//					nb = 1;
//
//					for (int j = i + 1; j < lst.size(); j++) {
//						if (lst.get(i).equals(lst.get(j))) {
//							nb++;
//								
//		
//						} 
//						//tabL[i] = nb;
//					}
//					
//				}
//				nbOccur.add(nb);
//
//			}

		
		return tab;
	}
}
