package com.formation.thcr.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciCroisementException;
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
	 * @throws CruciNullException
	 * 
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		char[][] sol = null;
		if (lst != null) {
			sol = new char[width][height];
			for (int i = 0; i < sol.length; i++) {
				for (int j = 0; j < sol[0].length; j++) {
					sol[i][j] = ' ';
				}
			}

			for (int i = 0; i < lst.size(); i++) {
				if (lst.get(i).isSens() == Terme.VERTICAL) {
					if (lst.get(i).getNom().length() > height) {
						throw new CruciHeightException();
					}
				} else if (lst.get(i).isSens() == Terme.HORIZONTAL) {
					if (lst.get(i).getNom().length() > width) {
						throw new CruciWidthException();
					}
				}
			}

			for (int i = 0; i < lst.size(); i++) {
				//				System.out.println(lst.get(i).toString());
				if (lst.get(i).isSens() == Terme.HORIZONTAL) {
					int verifDepassement = (int) lst.get(i).getPos().getX() + lst.get(i).getNom().length();
					if (verifDepassement > width) {
						throw new CruciDebordeException(lst.get(i));
					} else {
						for (int j = 0; j < lst.get(i).getNom().length(); j++) {
							if (sol[(int) lst.get(i).getPos().getY()][(int) lst.get(i).getPos().getX() + j] == ' '
									|| lst.get(i).getNom().charAt(j) == sol[(int) lst.get(i).getPos().getY()][(int) lst.get(i).getPos().getX() + j]) {
								sol[(int) lst.get(i).getPos().getY()][(int) lst.get(i).getPos().getY() + j] = lst.get(i).getNom().charAt(j);
							} else {
								try {
									throw new CruciCroisementException(lst.get(i), j);
								} catch (CruciCroisementException e) {
									System.out.println(e.getMessage());
								}
							}

						}
					}
				} else if (lst.get(i).isSens() == Terme.VERTICAL) {
					int verifDepassement = (int) lst.get(i).getPos().getY() + lst.get(i).getNom().length();
					if (verifDepassement > height) {
						throw new CruciDebordeException(lst.get(i));
					} else {
						for (int j = 0; j < lst.get(i).getNom().length(); j++) {
							if (sol[(int) lst.get(i).getPos().getY() + j][(int) lst.get(i).getPos().getX()] == ' '
									|| lst.get(i).getNom().charAt(j) == sol[(int) lst.get(i).getPos().getY() + j][(int) lst.get(i).getPos().getX()]) {
								sol[(int) lst.get(i).getPos().getY() + j][(int) lst.get(i).getPos().getY()] = lst.get(i).getNom().charAt(j);
							} else {
								try {
									throw new CruciCroisementException(lst.get(i), j);
								} catch (CruciCroisementException e) {
									System.out.println(e.getMessage());
								}
							}
						}
					}
				}
			}
		} else {
			throw new CruciNullException();
		}
		return sol;
	}

}
