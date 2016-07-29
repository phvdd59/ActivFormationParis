package com.formation.thcr.main;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.formation.thcr.exo.CleDico;
import com.formation.thcr.exo.Dico;

public class MainDico {

	public static void main(String[] args) {
		MainDico main = new MainDico();
		main.init();

	}

	private void init() {
		
		
		String s = "Bonjour, bananes, abricot, melons, origan"
				+ " JAsmin?, lARd, lard, lard, Loup, lArd, louP, loup.";
//		String s2 = "a aa aaa abb aa aaa b abb abb aaa b bb bbb abb aaba bab bbab";
		Dico dico = new Dico();
		
		System.out.println(s);
		dico.ranger(s);
		System.out.println();
		CleDico cle = new CleDico("l",4);
		System.out.println(dico.getListeMot(cle.getLettre(), cle.getLngMot()));
		System.out.println(dico.get(cle));
		
		
	}
	
}
