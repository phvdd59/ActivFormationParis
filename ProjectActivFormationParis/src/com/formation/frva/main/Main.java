package com.formation.frva.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.frva.exo.ExoAlgo4;
import com.formation.phva.exo.Terme;

public class Main {

	public static void main(String[] args) {
// 		HORIZONTAL (8 sur 12
//		"PISCINES","ANORMALES","GENOISE ","ER ATEMI"," TATA EN","PENITENT","O TEINTE", "ICI OR R","NO SNOBE","TUBE BIS","E USUELS", "RIS VELE"
// 
//		HORIZONTAL  
//     	"DATTIERS","EREINTEE","COMEDIEN","AMENER T"," ART API","OTA MIAM", "BEIGE RE","S REGAIN","EPELER T","DES VELA","ET METAL","REPU ESE" 
		
		ExoAlgo4 e = new ExoAlgo4();
		char[][] resultat = null;
		ArrayList<Terme> lst = new ArrayList<Terme>();
		Terme t01 = new Terme("DATTIERS",new Point(0,0),false);
		Terme t02 = new Terme("EREINTEE",new Point(0,1),false);
		Terme t03 = new Terme("COMEDIEN",new Point(0,2),false);
		Terme t04 = new Terme("AMENER",new Point(0,3),false);
		Terme t05 = new Terme("ART",new Point(1,4),false);
		Terme t06 = new Terme("OTA",new Point(0,5),false);
		Terme t07 = new Terme("BEIGE",new Point(0,6),false);
		Terme t08 = new Terme("REGAIN",new Point(2,7),false);
		Terme t09 = new Terme("EPELER",new Point(0,8),false);
		Terme t10 = new Terme("DES",new Point(0,9),false);
		Terme t11 = new Terme("ET",new Point(0,10),false);
		Terme t12 = new Terme("REPU",new Point(0,11),false);
		Terme t13 = new Terme("SENTIMENTALE",new Point(7,0),true);
		Terme t14 = new Terme("PARI",new Point(6,4),true);
		Terme t15 = new Terme("LAS",new Point(6,9),true);
		Terme t16 = new Terme("ETIRAI",new Point(5,0),true);
		Terme t17 = new Terme("ARETE",new Point(5,7),true);
		Terme t18 = new Terme("MEGEVE",new Point(4,5),true);
		Terme t19 = new Terme("OBSEDER",new Point(0,5),true);
		Terme t20 = new Terme("MU",new Point(3,10),true);
		lst.add(t01);
		lst.add(t02);
		lst.add(t03);
		lst.add(t04);
		lst.add(t05);
		lst.add(t06);
		lst.add(t07);
		lst.add(t08);
		lst.add(t09);
		lst.add(t10);
		lst.add(t11);
		lst.add(t12);
		lst.add(t13);
		lst.add(t14);
		lst.add(t15);
		lst.add(t16);
		lst.add(t17);
		lst.add(t18);
		lst.add(t19);
		lst.add(t20);
		
//		Terme ter1 = new Terme();
//		ter1.setNom("TOTO");
//		ter1.setPos(new Point(0,0));
//		ter1.setSens(Terme.HORIZONTAL);
//		lst.add(ter1);
//		Terme ter2 = new Terme();
//		ter2.setNom("TITI");
//		ter2.setPos(new Point(0,0));
//		ter2.setSens(Terme.VERTICAL);
//		lst.add(ter2);
//		Terme ter3 = new Terme();
//		ter3.setNom("TROIS");
//		ter3.setPos(new Point(2,0));
//		ter3.setSens(Terme.VERTICAL);
//		lst.add(ter3);
//		Terme ter4 = new Terme();
//		ter4.setNom("TROLL");
//		ter4.setPos(new Point(0,2));
//		ter4.setSens(Terme.HORIZONTAL);
//		lst.add(ter4);
//		Terme ter5 = new Terme();
//		ter5.setNom("LONGTEMPS");
//		ter5.setPos(new Point(4,2));
//		ter5.setSens(Terme.VERTICAL);
//		lst.add(ter5);
//		Terme ter6 = new Terme();
//		ter6.setNom("CIBLE");
//		ter6.setPos(new Point(0,6));
//		ter6.setSens(Terme.HORIZONTAL);
//		lst.add(ter6);
//		Terme ter7 = new Terme();
//		ter7.setNom("BRAS");
//		ter7.setPos(new Point(2,6));
//		ter7.setSens(Terme.VERTICAL);
//		lst.add(ter7);
//		
//
//		ter7.setNom("BRAS");
//		ter7.setPos(new Point(2,6));
//		ter7.setSens(Terme.VERTICAL);
//		lst.add(ter7);

		
		int tabx = 8;
		int taby = 12;
		resultat = e.solution(tabx, taby, lst);
		
		for (int j = 0; j < taby; j++) {
			for (int i = 0; i < tabx; i++) {
				System.out.print(resultat[j][i] + " | " );
			}
			System.out.println(" " );
		}
	}
	
	
}
