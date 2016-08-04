package com.formation.thcr.exo;

import java.util.ArrayList;

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
	 * @throws CruciNullException
	 * 
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		char[][] sol = new char[width][height];

		//Verification null

		if (lst != null) {

			for (int i = 0; i < lst.size(); i++) {
				System.out.println(lst.get(i).toString());
				if (lst.get(i).isSens() == Terme.HORIZONTAL) {
					int verifDepassement = (int) lst.get(i).getPos().getX() + lst.get(i).getNom().length();
					if (verifDepassement > width) {
						throw new CruciWidthException();
					}
					for (int j = 0; j < lst.get(i).getNom().length(); j++) {
						sol[(int) lst.get(i).getPos().getX() + j][(int) lst.get(i).getPos().getY()] = lst.get(i).getNom().charAt(j);
					}
				} else {
					int verifDepassement = (int) lst.get(i).getPos().getY() + lst.get(i).getNom().length();
					if (verifDepassement > height) {
						throw new CruciHeightException();
					}
					for (int j = 0; j < lst.get(i).getNom().length(); j++) {
						sol[(int) lst.get(i).getPos().getX()][(int) lst.get(i).getPos().getY() + j] = lst.get(i).getNom().charAt(j);
					}
				}
			}
		} else {
			sol = null;
			throw new CruciNullException();
		}
		return sol;
	}

}
