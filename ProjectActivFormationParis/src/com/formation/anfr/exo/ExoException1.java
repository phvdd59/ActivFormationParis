package com.formation.anfr.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciCroisementException;
import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.exo.InterException1;

public class ExoException1 implements InterException1 {

	public char[][] solution(int width, int height, ArrayList<com.formation.phva.exo.Terme> lst) throws CruciException {

		char[][] cruci = null;
		if (width <= 0) {
			throw new CruciWidthException();
		} else if (height <= 0) {
			throw new CruciHeightException();
		} else if (lst == null) {
			throw new CruciNullException();
		} else {

			cruci = new char[height][width];
			for (int i = 0; i < cruci.length; i++) {
				for (int j = 0; j < cruci[0].length; j++) {
					cruci[i][j] = ' ';
				}
			}
			for (com.formation.phva.exo.Terme terme : lst) {
				char[] tab = terme.getNom().toCharArray();
				if (terme.isSens() == Terme.HORIZONTAL) {
					if (terme.getPos().x + tab.length < width) {
						throw new CruciDebordeException(terme);
					}
					for (int i = 0; i < tab.length; i++) {
							if (cruci[terme.getPos().y][terme.getPos().x + i] != ' ') {
								throw new CruciCroisementException(terme, i);
							} else {
								cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
							}
					}
				} else {
					if (terme.getPos().y + tab.length > height) {
						throw new CruciDebordeException(terme);
					}
					for (int i = 0; i < tab.length; i++) {
						try {
							if (cruci[terme.getPos().y + i][terme.getPos().x] != ' ') {
								throw new CruciCroisementException(terme, i);
							} else {
								cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
							}
						} catch (CruciCroisementException e) {
							// e.getMessage();
						}

					}
				}
			}
		}
		return cruci;

	}
}
