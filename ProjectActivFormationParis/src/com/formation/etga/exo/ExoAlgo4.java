package com.formation.etga.exo;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class ExoAlgo4 implements com.formation.phva.exo.InterAlgo4 {

	/**
	 * ma methode solution doit intégrer une liste de terme sous forme d'un
	 * tableau à deux dimensions
	 * 
	 * 
	 * example :
	 * 
	 * "DATTIERS" "EREINTEE" "COMEDIEN" "AMENER T" " ART API" "OTA MIAM"
	 * "BEIGE RE" "S REGAIN" "EPELER T" "DES VELA" "ET METAL" "REPU ESE"
	 *
	 * les cas annormaux seront traité en grande partie sur la base des
	 * exeption cruciExeption.
	 * 
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		Terme t1 = new Terme("AB", new Point(0, 0), Terme.HORIZONTAL);
		lst.add(t1);
		Terme t2 = new Terme("AC", new Point(0, 0), Terme.VERTICAL);
		lst.add(t2);
		Terme t3 = new Terme("CD", new Point(0, 1), Terme.HORIZONTAL);
		lst.add(t3);
		Terme t4 = new Terme("BD", new Point(1, 1), Terme.VERTICAL);
		lst.add(t4);

		for (int i = 0; i < lst.size(); i++) {
			char[] nomChar = lst.get(i).getNom().toCharArray();
		}

		char[][] tabSolution = new char[height][width];
		int val = 0;
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				//				tabSolution[i][j] = lst.get(val).getNom();
				val++;
			}

		}

		return null;
	}
}
