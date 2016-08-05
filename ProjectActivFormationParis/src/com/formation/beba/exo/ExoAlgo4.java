package com.formation.beba.exo;

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
		char[][] cruci = new char[width][height];

		for (int i = 0; i < cruci.length; i++) {
			for (int j = 0; j < cruci[0].length; j++) {
				cruci[i][j] = ' ';
			}
		}

		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).isSens()) {
				for (int j = lst.get(i).getPos().y; j < lst.get(i).getNom().length() + lst.get(i).getPos().y; j++) {
					cruci[lst.get(i).getPos().x][j] = lst.get(i).getNom().charAt(j - lst.get(i).getPos().y);
				}
			} else {
				for (int j = lst.get(i).getPos().x; j < lst.get(i).getNom().length() + lst.get(i).getPos().x; j++) {
					cruci[j][lst.get(i).getPos().y] = lst.get(i).getNom().charAt(j - lst.get(i).getPos().x);
				}
			}

		}
		return cruci;
	}

}
