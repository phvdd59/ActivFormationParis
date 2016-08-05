package com.formation.emma.exo;

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
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		char[][] tableau = null;

		if (width < 0) {
			throw new CruciWidthException();
		} else if (height < 0) {
			throw new CruciHeightException();
		} else {
			if (lst == null) {
				throw new CruciNullException();
			} else {
				tableau = new char[width][height];

				for (int j = 0; j < lst.size(); j++) {
					int x = (int) lst.get(j).getPos().getX();
					int y = (int) lst.get(j).getPos().getY();
					char[] motEpele = lst.get(j).getNom().toCharArray();

					if (lst.get(j).isSens() == Terme.VERTICAL) {
						for (int i = 0; i < motEpele.length; i++) {
							try {
								if (i + x > tableau.length) {
									throw new CruciDebordeException();
								} else if (tableau[x][y]>'a' && tableau[x][y]<'z') {
									throw new CruciCroisementException();
								} else {
									tableau[x+i][y] = motEpele[i];
									
								}
							} catch (CruciDebordeException e) {

							} catch (CruciCroisementException e1) {

							} finally {

							}
						}

					} else {
						for (int i = 0; i < motEpele.length; i++) {
							try {
								if (i + y > tableau.length) {
									throw new CruciDebordeException();
								} else if (tableau[x][y]>'a' && tableau[x][y]<'z') {
									throw new CruciCroisementException();
								} else {
									tableau[x+i][y] = motEpele[i];
								
								}
							} catch (CruciDebordeException e) {

							} catch (CruciCroisementException e1) {

							} finally {

							}
						}

					}
				}
			}
		}

		return tableau;

	}
}
