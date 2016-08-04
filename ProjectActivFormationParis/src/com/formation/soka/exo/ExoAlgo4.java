package com.formation.soka.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class ExoAlgo4 implements com.formation.phva.exo.InterAlgo4 {

	/**
	 * ma methode solution doit int�grer une liste de terme sous forme d'un
	 * tableau � deux dimensions
	 * 
	 * 
	 * example :
	 * 
	 * "DATTIERS" "EREINTEE" "COMEDIEN" "AMENER T" " ART API" "OTA MIAM"
	 * "BEIGE RE" "S REGAIN" "EPELER T" "DES VELA" "ET METAL" "REPU ESE"
	 *
	 * les cas annormaux seront trait� en grande partie sur la base des exeption
	 * cruciExeption.
	 * 
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		char[][] tabChar = null;

		tabChar = new char[height][width];
		for (int i = 0; i < lst.size(); i++) {
			int posX = lst.get(i).getPos().x;
			int posY = lst.get(i).getPos().y;
			if (lst.get(i).isSens() == Terme.HORIZONTAL) {
				for (int j = posX; j < posX + lst.get(i).getNom().length(); j++) {
					tabChar[j][posY] = lst.get(i).getNom().charAt(j - posX);
				}
			} else if (lst.get(i).isSens() == Terme.VERTICAL) {
				for (int j = posY; j < posY + lst.get(i).getNom().length(); j++) {
					tabChar[posX][j] = lst.get(i).getNom().charAt(j - posY);
				}
			}
		}
		return tabChar;
	}
}
