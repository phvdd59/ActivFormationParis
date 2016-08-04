package com.formation.soka.exo;

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
	 * les cas annormaux seront traité en grande partie sur la base des exeption
	 * cruciExeption.
	 * 
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		char[][] tabChar = null;

		tabChar = new char[height][width];
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).isSens() == Terme.HORIZONTAL) {
				for (int j = lst.get(i).getPos().x; j < lst.get(i).getNom().length() + lst.get(i).getPos().x; j++) {
					tabChar[j][lst.get(i).getPos().y] = lst.get(i).getNom().charAt(j - lst.get(i).getPos().x);
				}
			} else if (lst.get(i).isSens() == Terme.VERTICAL) {
				for (int j = lst.get(i).getPos().y; j < lst.get(i).getNom().length() + lst.get(i).getPos().y; j++) {
					tabChar[lst.get(i).getPos().x][j] = lst.get(i).getNom().charAt(j - lst.get(i).getPos().y);
				}
			}
		}

		return tabChar;
	}

}
