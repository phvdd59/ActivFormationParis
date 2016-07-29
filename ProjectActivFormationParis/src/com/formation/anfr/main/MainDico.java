package com.formation.anfr.main;

import com.formation.anfr.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico mainDico = new MainDico();
		mainDico.init();
	}

	public void init() {
	 Dico dic = new Dico();
	 dic.ranger("Strange C�est un titre qui touche les gens profond�ment, et de tous les �ges expliquait dans un entretien accord� au site du Monde Oskar Guilbert, cofondateur et dirigeant du studio Dontnod. On nous a m�me envoy� une vid�o o� des joueurs d�une vingtaine de nationalit�s se sont film�s sur Skype, et nous ont dit �merci� dans leur langue, en polonais, en arabe, en anglais� J�avais les larmes aux yeux. C�est un vrai ph�nom�ne g�n�rationnel. Des fans ont m�me tent� de financer via Kickstarter le d�veloppement d'une suite, avant que Square Enix ne siffle la fin de la r�cr�ation et fasse valoir ses Droits sur le jeu, dont il poss�de la propri�t� intellectuelle.Histoire d'�voquer un peu ce projet de future s�rie, nous avons pu nous entretenir en exclusivit� par t�l�phone avec Raoul Barbet, le Game Director du jeu; et Michel Koch, le directeur artistique et co-directeur du jeu.");
	System.out.println(dic.getListeMot("d", 3));
	 System.out.println(dic.getListeMot("t", 4));
	 System.out.println(dic.getListeMot("t", 3));
	 System.out.println(dic.getListeMot("o", 3));
	 System.out.println(dic.getListeMot("s", 7));
 }
}
