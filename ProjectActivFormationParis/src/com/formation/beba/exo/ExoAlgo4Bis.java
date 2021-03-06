package com.formation.beba.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciCroisementException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.exo.Terme;

public class ExoAlgo4Bis implements com.formation.phva.exo.InterAlgo4 {

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

		if (width <= 0) {
			throw new CruciWidthException();
		}
		if (height <= 0) {
			throw new CruciHeightException();
		}

		char[][] cruci = new char[width][height];
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).isSens()) {

				for (int j = lst.get(i).getPos().y; j < lst.get(i).getNom().length() + lst.get(i).getPos().y; j++) {
					cruci[lst.get(i).getPos().x][j] = lst.get(i).getNom().charAt(j - lst.get(i).getPos().y);
				}

			} else {
//try {
//	if (lst.get(i).getPos().x+lst.get(i).getNom().length()>width) {
//		throw new CruciWidthException();
//	}
//} catch (CruciWidthException e) {
//	System.out.println(e.getMessage());
//}
				for (int j = lst.get(i).getPos().x; j < lst.get(i).getNom().length() + lst.get(i).getPos().x; j++) {
					try {
						if (((cruci[j][lst.get(i).getPos().y] >= 'A' && cruci[j][lst.get(i).getPos().y] <= 'Z') || (cruci[j][lst.get(i).getPos().y] >= 'a' && cruci[j][lst.get(i).getPos().y] <= 'z')) && cruci[j][lst.get(i).getPos().y] != lst.get(i).getNom().charAt(j - lst.get(i).getPos().x)) {
							throw new CruciCroisementException(lst.get(i), i);
						} else {
							cruci[j][lst.get(i).getPos().y] = lst.get(i).getNom().charAt(j - lst.get(i).getPos().x);
						}
					} catch (CruciCroisementException e) {
						System.out.println(e.getMessage());
					}
				}
			}
		}
		return null;
	}

}
