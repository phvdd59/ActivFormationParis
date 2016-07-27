package com.formation.phva.att;
import java.util.ArrayList;

import com.formation.issa.exo.ExoArrayList1;

public class MainInsertionTabdansTabArray {

	public static void main(String[] args) {
		MainInsertionTabdansTabArray tabDansTab=new MainInsertionTabdansTabArray();
		tabDansTab.init();

	}

	private void init() {
		ExoArrayList1 tabdansTabListe=new ExoArrayList1();
		ArrayList<Integer> listeFin = new ArrayList<Integer>();
		ArrayList<Integer> listeF = new ArrayList<Integer>();
		
		listeFin.add(new Integer(1));
		listeFin.add(new Integer(4));
		listeFin.add(new Integer(6));
		listeFin.add(new Integer(2));
		listeFin.add(new Integer(4));
		listeFin.add(new Integer(7));
		
		listeF.add(new Integer(4));
		listeF.add(new Integer(9));
		listeF.add(new Integer(0));
		int p=2;
		
		System.out.println(tabdansTabListe.insererUnTableauDansUnAutreAvecRemplacement(listeFin, p, listeF));
		
		
	}

}
