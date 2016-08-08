package com.formation.soka.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
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
		char[][] tabChar = null;
		if (lst == null) {
			throw new CruciNullException();
		}
		tabChar = new char[height][width];
		for (int i = 0; i < lst.size(); i++) {
			Terme terme = lst.get(i);
			int posX = terme.getPos().x;
			int posY = terme.getPos().y;
			int lngMot = lst.get(i).getNom().length();
			String nom = terme.getNom();
			if (posX + lngMot > height || posY + lngMot > width) {
				throw new CruciDebordeException();
			} else {
				if (lst.get(i).isSens() == Terme.HORIZONTAL) {
					for (int j = 0; j < lngMot; j++) {
						tabChar[posY][j + posX] = nom.charAt(j);

					}
				} else if (lst.get(i).isSens() == Terme.VERTICAL) {
					for (int j = 0; j < lngMot; j++) {
						tabChar[j + posY][posX] = nom.charAt(j);

					}
				}
			}
		}

		if (height <= 0) {
			throw new CruciHeightException();
		}
		if (width <= 0) {
			throw new CruciWidthException();
		}
		return tabChar;
	}
}
