package com.formation.emma.main;

import java.util.ArrayList;
import com.formation.emma.exo.Dico;
import com.formation.emma.exo.Mot;

public class MainMot {

	public static void main(String[] args) {
		Dico dico = new Dico();
		dico.ranger("Bonjour � tous! J'esp�re que vous allez bien, � bient�t.");
		ArrayList<String> lst = dico.getListeMot("o", 4);
		for (String s : lst){
			System.out.println(s+",");
		}
 
		
		
	}
	

}
