package com.formation.thcr.exo;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		if (texte != null) {
			String tmp = epuration(texte);

			System.out.println(tmp);

			String[] tabMots = tmp.split(" ");

			ArrayList<Mot> mots = new ArrayList<Mot>();

			for (int i = 0; i < tabMots.length; i++) {
				Mot mot = new Mot(tabMots[i]);
				if (mots.indexOf(mot) == -1) {
					mots.add(mot);
				} else {
					mots.get(mots.indexOf(mot)).plusUn();
				}
			}

			//Creation des cledico
			//		for (int j = 1; j <= 26; j++) {
			//			for (int i = 'a'; i <= 'z'; i++) {
			//				CleDico cleDico = new CleDico(String.valueOf((char) i), j);
			//				this.put(cleDico, new ArrayList<Mot>());
			//			}
			//		}

			//Creation cle dico 2
			for (int i = 0; i < mots.size(); i++) {
				for (int j = 0; j < mots.get(i).getMot().length(); j++) {
					char c = mots.get(i).getMot().charAt(j);
					CleDico cle = new CleDico(String.valueOf(c), mots.get(i).getMot().length());
					if (this.get(cle) == null) {
						ArrayList<Mot> lst = new ArrayList<Mot>();
						this.put(cle, lst);
					}
				}
			}

			for (int i = 0; i < mots.size(); i++) {
				for (int k = 'a'; k < 'z'; k++) {
					if (mots.get(i).getMot().contains(String.valueOf((char) k))) {
						CleDico cle = new CleDico(String.valueOf((char) k), mots.get(i).getMot().length());
						this.get(cle).add(mots.get(i));
					}
				}
			}
		}else{
			
		}
	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		//Protection
		ArrayList<String> listString = new ArrayList<String>();
		ArrayList<Mot> listMot = new ArrayList<Mot>();
		CleDico cleDico = new CleDico(lettre, lngMot);
		listMot = this.get(cleDico);
		Collections.sort(listMot);
		for (int i = 0; i < this.get(cleDico).size(); i++) {
			listString.add(listMot.get(i).getMot());
		}
		return listString;
	}

	public String epuration(String texte) {

		String tmp = "";
		if (texte != null) {

			tmp = texte.toLowerCase();
			//			char[] c = tmp.toCharArray();
			//			for (int i = 0; i < c.length; i++) {
			//				if(c[i]>= 'à'&&c[i]<='å'){
			//					c[i] = 'a';
			//				}if()
			//			}
			tmp = Normalizer.normalize(tmp, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
			tmp = tmp.replaceAll("\\p{Punct}", " ");
			tmp = tmp.replaceAll("[0-9]", " ");
			tmp = tmp.replaceAll("\\p{Sc}", " ");
			tmp = tmp.replaceAll("\\s", " ");
			tmp = tmp.replaceAll("  ", " ");
			tmp = tmp.replaceAll("  ", " ");
			tmp = tmp.replaceAll("  ", " ");
			//			tmp = tmp.replace("'", " ");
			//			tmp = tmp.replace(",", " ");
			//			tmp = tmp.replace("é", "e");
			//			tmp = tmp.replace("è", "e");
			//			tmp = tmp.replace("ê", "e");
			//			tmp = tmp.replace("ç", "c");
			//			tmp = tmp.replace("à", "a");
			//			tmp = tmp.replace("?", " ");
			//			tmp = tmp.replace("!", " ");
			//			tmp = tmp.replace(".", " ");
			//			tmp = tmp.replace("\t", " ");
			//			tmp = tmp.replace("\n", " ");
			//			tmp = tmp.replace("   ", " ");
			//			tmp = tmp.replace("  ", " ");
		}

		return tmp;

	}

}
