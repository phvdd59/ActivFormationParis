package com.formation.issa.exo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.TreeMap;

public class Dico extends TreeMap<CleDico, ArrayList<Mot>> implements InterExoDico1 {

	@Override
	public void ranger(String texte) {
		// TODO Auto-generated method stub
		System.out.println(texte);
		String texteEpurer= epuration(texte);
		String[] tabmot = texteEpurer.split(" ");
		for (String mt: tabmot){
			Mot mot=new Mot(mt);
			boolean premiere=true;
			for (int i = 0; i < mt.length(); i++) {
				CleDico cleDico=new CleDico(mt.substring(i, i+1),mt.length());
				if(containsKey(cleDico)){
					//contains appelle la méthode equals
					ArrayList<Mot>lst=get(cleDico);
					if(lst.contains(mot)){
					mot=lst.get(lst.indexOf(mot));
					if(premiere){
						mot.plusUn();
					}
					
				}else{
					lst.add(mot);
				}
				}
					else{
						ArrayList<Mot>lst=new ArrayList<Mot>();
						lst.add(mot);
						put(cleDico, lst);
						
					}
				premiere=false;
			}
		}

		for (int i = 0; i < tabmot.length; i++) {
			String motTexte = tabmot[i];
			for (int j = 0; j < motTexte.length(); j++) {
				String lettre = motTexte.substring(j, j + 1);
				CleDico cleDico = new CleDico(lettre, motTexte.length());
				ArrayList<Mot> listing=get(cleDico);
			   
			}
		}

	}

	@Override
	public ArrayList<String> getListeMot(String lettre, int lngMot) {
		ArrayList<String>listmot=new ArrayList<String>();
		String let=epuration(lettre);
		if(let.length()==1 && !let.equals(" ")){
			CleDico cleDico=new CleDico(lettre, lngMot);
			if(containsKey(cleDico)){
				ArrayList<Mot > lst=get(cleDico);
				Collections.sort(lst);
					
				for (Mot mot : lst) {
					listmot.add(mot.getMot());
				}
			}
			
		}
		
		return listmot ;
	}

	public String epuration(String texteAepurer) {

		String texteEpurer = texteAepurer;
		texteEpurer = texteEpurer.toLowerCase();
		texteEpurer = texteEpurer.replace("é", "e");
		texteEpurer = texteEpurer.replace("-", " " );
		texteEpurer = texteEpurer.toLowerCase();
		texteEpurer = texteEpurer.replace("è", "e");
		texteEpurer = texteEpurer.replace("ç", "c");
		texteEpurer = texteEpurer.replace("’", " ");
		texteEpurer=texteEpurer.replace(".", " ");
		texteEpurer=texteEpurer.replace("à", "a");
		texteEpurer=texteEpurer.replace("\\s+", " ");
		texteEpurer=texteEpurer.replace("\\p[Punc]", " ");
		

		return texteEpurer;
	}

}
