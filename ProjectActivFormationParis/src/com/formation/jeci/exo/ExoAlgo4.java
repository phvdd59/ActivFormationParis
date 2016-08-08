package com.formation.jeci.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciWidthException;
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
		if (height <= 0)
			throw new CruciHeightException();
		if (width <= 0)
			throw new CruciWidthException();
		char[][] tabfinal = new char[width][height];
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).isSens() == Terme.HORIZONTAL) {
				for (int j = 0; j < height; j++) {
					if (lst.get(i).getPos().y == j) {
						for (int k = lst.get(i).getPos().x; k < lst.get(i).getNom().length(); k++) {
							tabfinal[j][k] = (char) lst.get(i).getNom().charAt(k);
						}

					}
				}
			}

			if (lst.get(i).isSens() == true) {
				for (int j = 0; j < width; j++) {
					if (lst.get(i).getPos().x == j) {
						for (int k = lst.get(i).getPos().y; k < lst.get(i).getNom().length(); k++) {
							tabfinal[k][j] = lst.get(i).getNom().charAt(k);
						}

					}
				}
			}

		}
		// for (int i = 0; i < width; i++) {
		// for (int j = 0; j <height; j++) {
		// if (tabfinal[i][j]=='0') {
		// tabfinal[i]=' ';
		// }
		// }
		//
		// }

		return tabfinal;
	}

}
