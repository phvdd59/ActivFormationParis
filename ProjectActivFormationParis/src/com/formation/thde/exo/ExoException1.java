package com.formation.thde.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciCroisementException;
import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.exo.InterException1;
import com.formation.phva.exo.Terme;

public class ExoException1 implements InterException1 {

	public char[][] solution(int width, int height, ArrayList<com.formation.phva.exo.Terme> lst) throws CruciException {

		if (height <= 0) {
			throw new CruciHeightException();
		}
		if (width <= 0) {
			throw new CruciWidthException();
		}

		char[][] cruci = new char[height][width];
		for (int i = 0; i < cruci.length; i++) {
			for (int j = 0; j < cruci[0].length; j++) {
				cruci[i][j] = ' ';
			}
		}
		try {
			for (Terme terme : lst) {

				if (terme.getPos().x < 0 || terme.getPos().x > height || terme.getPos().y < 0 || terme.getPos().y > width) {
					throw new CruciNullException();
				}
				char[] tab = terme.getNom().toCharArray();

				if (terme.isSens() == Terme.HORIZONTAL) {

					for (int i = 0; i < tab.length; i++) {
						if (terme.getPos().x + i > height) {
							throw new CruciDebordeException(lst.get(i));
						}
						if (cruci[terme.getPos().y][terme.getPos().x + i] != tab[i] && tab[i] != ' ') {
							throw new CruciCroisementException(terme, i);
						}
						cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
					}

				} else {

					for (int i = 0; i < tab.length; i++) {
						if (terme.getPos().y + i > width) {
							throw new CruciDebordeException(terme);
						}
						if (cruci[terme.getPos().y + i][terme.getPos().x] != tab[i] && tab[i] != ' ') {
							throw new CruciCroisementException(terme, i);
						}
						cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
					}
				}
			}
		} catch (CruciCroisementException e) {

		} finally {

		}
		return cruci;
	}
}
