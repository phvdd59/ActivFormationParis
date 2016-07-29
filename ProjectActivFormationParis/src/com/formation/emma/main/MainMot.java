package com.formation.emma.main;

import java.util.ArrayList;
import com.formation.emma.exo.Dico;
import com.formation.emma.exo.Mot;

public class MainMot {

	public static void main(String[] args) {
		Dico dico = new Dico();
		dico.ranger("Bonjour à tous! J'espère que vous allez bien, à bientôt.");
		ArrayList<String> lst = dico.getListeMot("o", 4);
		for (String s : lst){
			System.out.println(s+",");
		}
 
		
		
	}
	

}
