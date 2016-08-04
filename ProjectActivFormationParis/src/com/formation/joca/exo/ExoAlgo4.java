package com.formation.joca.exo;

import java.awt.Point;
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

		char[][] tabFinal = new char[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				tabFinal[i][j] = ' ';
			}
		}

		if (lst == null) {

			throw new CruciNullException();

		} else if (longueurPlusGrandTerme(lst) > width) {

			throw new CruciWidthException();

		} else if (hauteurPlusGrandTerme(lst) > height) {

			throw new CruciHeightException();

		} else {

			for (int i = 0; i < lst.size(); i++) {

				Terme termeTraite = new Terme();
				termeTraite = lst.get(i);

				char[] tabTerme = termeTraite.getNom().toCharArray();
				for (int j = 0; j < tabTerme.length; j++) {
					if (termeTraite.isSens()) {
						if ((termeTraite.getPos().y + j) >= height) {
							throw new CruciDebordeException(termeTraite);
						} else {
							tabFinal[termeTraite.getPos().x][termeTraite.getPos().y + j] = tabTerme[j];
						}
					} else if (!termeTraite.isSens()) {
						if ((termeTraite.getPos().x + j) >= width) {
							throw new CruciDebordeException(termeTraite);
						} else {
							tabFinal[termeTraite.getPos().x + j][termeTraite.getPos().y] = tabTerme[j];
						}
					}

				}

			}
		}

		return tabFinal;
	}

	public int longueurPlusGrandTerme(ArrayList<Terme> lst) {
		int result = 0;
		Terme temp = new Terme("", new Point(0, 0), false);
		for (int i = 0; i < lst.size(); i++) {
			if (!lst.get(i).isSens() && lst.get(i).getNom().length() > temp.getNom().length()) {
				temp = lst.get(i);
				result = temp.getNom().length();
			}
		}
		return result;
	}

	public int hauteurPlusGrandTerme(ArrayList<Terme> lst) {
		int result = 0;
		Terme temp = new Terme("", new Point(0, 0), true);
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).isSens() && lst.get(i).getNom().length() > temp.getNom().length()) {
				temp = lst.get(i);
				result = temp.getNom().length();
			}
		}
		return result;
	}

}
