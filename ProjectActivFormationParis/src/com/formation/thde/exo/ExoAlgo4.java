package com.formation.thde.exo;

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

		if (height <= 0) {
			throw new CruciHeightException();
		}
		if (width <= 0) {
			throw new CruciWidthException();
		}

		char[][] tableauFini = new char[height][width];

		char[] nomChar;
		int x;
		int y;
		boolean sens;

		for (int i = 0; i < lst.size(); i++) {
			nomChar = lst.get(i).getNom().toCharArray();
			x = (int) lst.get(i).getPos().getX();
			y = (int) lst.get(i).getPos().getY();

			if (x < 0 || x > height || y < 0 || y > width) {
				throw new CruciNullException();
			}

			sens = lst.get(i).isSens();
			//vertical TRUE

			for (int j = 0; j < nomChar.length; j++) {
				//debordement on sort
				if (x > height || y > width) {
					i++;
					throw new CruciDebordeException(lst.get(i));
				}
				try {
					if (tableauFini[y][x] != nomChar[j] && tableauFini[y][x] != 0) {
						//croisement, on continue mais l'ancienne est bonne
						throw new CruciCroisementException(lst.get(i), j);
					}
				} catch (CruciCroisementException e) {
					System.out.println(e.getMessage());
					System.out.println(e.getStackTrace());
				} finally {
					tableauFini[y][x] = nomChar[j];

					if (sens == true) {
						y++;
					} else {
						x++;
					}
				}
			}
		}

		return tableauFini;
	}

}
