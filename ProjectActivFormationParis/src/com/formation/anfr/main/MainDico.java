package com.formation.anfr.main;

import com.formation.anfr.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico mainDico = new MainDico();
		mainDico.init();
	}

	public void init() {
	 Dico dic = new Dico();
	 dic.ranger("Strange C’est un titre qui touche les gens profondément, et de tous les âges expliquait dans un entretien accordé au site du Monde Oskar Guilbert, cofondateur et dirigeant du studio Dontnod. On nous a même envoyé une vidéo où des joueurs d’une vingtaine de nationalités se sont filmés sur Skype, et nous ont dit “merci” dans leur langue, en polonais, en arabe, en anglais… J’avais les larmes aux yeux. C’est un vrai phénomène générationnel. Des fans ont même tenté de financer via Kickstarter le développement d'une suite, avant que Square Enix ne siffle la fin de la récréation et fasse valoir ses Droits sur le jeu, dont il possède la propriété intellectuelle.Histoire d'évoquer un peu ce projet de future série, nous avons pu nous entretenir en exclusivité par téléphone avec Raoul Barbet, le Game Director du jeu; et Michel Koch, le directeur artistique et co-directeur du jeu.");
	System.out.println(dic.getListeMot("d", 3));
	 System.out.println(dic.getListeMot("t", 4));
	 System.out.println(dic.getListeMot("t", 3));
	 System.out.println(dic.getListeMot("o", 3));
	 System.out.println(dic.getListeMot("s", 7));
 }
}
