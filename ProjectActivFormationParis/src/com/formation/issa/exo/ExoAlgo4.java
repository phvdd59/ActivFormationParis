package com.formation.issa.exo;

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

		char[][]charTab=null;
		charTab = new char[height][width];

		for (int i = 0; i < charTab.length; i++) {
			for (int j = 0; j < charTab[0].length; j++) {
				charTab[i][j] = ' ';
			}
		}

		for (Terme terme : lst) {
			char[] charArray = terme.getNom().toCharArray();
			if (terme.isSens() == terme.HORIZONTAL) {
				for (int j = 0; j < charArray.length; j++) {
					charArray[j] = charTab[terme.getPos().y][terme.getPos().x + j];
				}
			} else {
				for (int j = 0; j < charArray.length; j++) {
					charArray[j] = charTab[terme.getPos().y + j][terme.getPos().x];

				}
			}

		}

		return charTab;
	}

}
