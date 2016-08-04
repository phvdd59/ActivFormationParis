package com.formation.anfr.exo;

import java.awt.Point;
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
		/*
		 * Bloc creation du tableau
		 */
		if (width <= 0) {
			throw new CruciWidthException();
		}
		if (height <= 0) {
			throw new CruciHeightException();
		}
		if (lst == null) {
			throw new CruciNullException();
		}


		char[][] soluce = new char[height][width];

		/*
		 * Bloc for temres
		 */
		for (Terme terme : lst) {
			int posx = (int) terme.getPos().getX();
			int posy = (int) terme.getPos().getY();
			String mot = terme.getNom();
			int k = 0;
			char[] tab = mot.trim().toCharArray();
			for (char c : tab) {
				if (terme.isSens()) {
					try {
						if (posx + k >= height) {
							throw new CruciDebordeException(terme);
						} else if ((soluce[posx + k][posy] >= 'A') && (soluce[posx + k][posy] <= 'Z')) {
							throw new CruciCroisementException(terme, k);
						} else {
							soluce[posx + k][posy] = c;
						}
					} catch (CruciCroisementException e) {
						System.out.println(e.getMessage());
					} catch (CruciDebordeException e1) {
						System.out.println(e1.getMessage());
					} finally {
						k++;
					}
				} else {
					try {
						if (posy + k >= width) {
							throw new CruciDebordeException(terme);
						} else if ((soluce[posx][posy+k] >= 'A') && (soluce[posx][posy+k] <= 'Z')) {
							throw new CruciCroisementException(terme, k);
						} else {
							soluce[posx][posy+k] = c;
						}
					} catch (CruciCroisementException e) {
						System.out.println(e.getMessage());
					} catch (CruciDebordeException e1) {
						System.out.println(e1.getMessage());
					} finally {
						k++;
					}
				}
			}

		}
		return soluce;

	}
}
