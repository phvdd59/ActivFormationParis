package com.formation.thcr.exo;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import com.formation.phva.exo.InterExoDico1;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {

		String tmp = epuration(texte);

		String[] texte2 = new String[tmp.length()];
		for (int i = 0; i < texte2.length; i++) {
			texte2[i] = tmp.substring(i, i + 1);
		}
		int cpt = 0;
		for (int i = 0; i < tmp.length(); i++) {
			if (texte2[i].equals(" "))
				cpt++;
		}
		int[] nbLettre = new int[cpt];
		int j = 0;
		for (int i = 1; i < tmp.length(); i++) {
			nbLettre[j]++;
			if (texte2[i].equals(" "))
				j++;
		}
		for (int i = 1; i < nbLettre.length; i++) {
			nbLettre[i] = nbLettre[i] + nbLettre[i - 1];
			System.out.println(nbLettre[i]);
		}

		ArrayList<Mot> mots = new ArrayList<Mot>();
		mots.add(new Mot(tmp.substring(0, nbLettre[0])));

		for (int i = 0; i < cpt - 1; i++) {
			Mot mot = new Mot(tmp.substring(nbLettre[i] + 1, nbLettre[i + 1]));
			if (mots.indexOf(mot) == -1)
				mots.add(mot);
			else
				mots.get(mots.indexOf(mot)).plusUn();
			System.out.println(mot.getMot().toString());
			//Faire la cledico ici
		}
		//Creation des cledico
//				for (int i = 'a'; i < 'z'; i++) {
//					for (int k = 1; k < 26; k++) {
//						CleDico cleDico = new CleDico(String.valueOf((char) i), k);
//						this.put(cleDico, null);
//					}
//				}


		for (int i = 0; i < mots.size(); i++) {
			for (int k = 'a'; k < 'z'; k++) {
				if (mots.get(i).getMot().contains(String.valueOf((char) k))) {
					ArrayList<Mot> listMot = new ArrayList<Mot>();
					listMot.add(mots.get(i));
					CleDico cle = new CleDico(String.valueOf((char) k),
							mots.get(i).getMot().length());
					//vérifié l'existence de la cledico
					if (this.containsKey(cle)) {
						this.get(cle).add(mots.get(i));
					} else {
						this.put(cle, listMot);
					}
				}
			}
		}

//		Set<Entry<CleDico, ArrayList<Mot>>> set = entrySet();
//		for (Entry<CleDico, ArrayList<Mot>> entry : set) {
//			System.out.println(entry);
//		}

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		// TODO Auto-generated method stub
		// ressortir liste des mots qui auront lngMot en nb de lettres et contenant la lettre lettre
		// par ordre d'utilisation et puis par ordre alphabétique
		return null;
	}

	public String epuration(String texte) {

		String tmp = "";

		tmp = texte.toLowerCase(); // ne rendre que des minuscules
		//remplacement caractère spéciaux 
		tmp = tmp.replace("'", " ");
		tmp = tmp.replace(",", " ");
		tmp = tmp.replace("é", "e");
		tmp = tmp.replace("è", "e");
		tmp = tmp.replace("ê", "e");
		tmp = tmp.replace("ç", "c");
		tmp = tmp.replace("à", "a");
		tmp = tmp.replace("?", " ");
		tmp = tmp.replace("!", " ");
		tmp = tmp.replace(".", " ");
		tmp = tmp.replace("\t", " ");
		tmp = tmp.replace("\n", " ");
		tmp = tmp.replace("   ", " ");
		tmp = tmp.replace("  ", " ");

		return tmp;

	}

}
