package com.formation.jeci.exo;

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

		if (width <= 0)
			throw new CruciWidthException();
		if (height <= 0)
			throw new CruciHeightException();
		if (lst == null)
			throw new CruciNullException();
		char[][] cruci = new char[height][width];
		for (int i = 0; i < cruci.length; i++) {
			for (int j = 0; j < cruci[0].length; j++) {
				cruci[i][j] = ' ';
			}
		}

		for (Terme terme : lst) {
			char[] tab = terme.getNom().toCharArray();
			if (terme.isSens() == Terme.HORIZONTAL) {
				for (int i = 0; i < tab.length; i++) {
					if (terme.getNom().length() <= cruci[0].length - terme.getPos().x)
						throw new CruciDebordeException();
					try {
						if (tab[i] == ' ') {
							cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
						} else if (tab[i] != terme.getNom().charAt(terme.getPos().x + i))
							throw new CruciCroisementException();
						else {
							cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
						}
					} catch (CruciCroisementException e) {

					}
				}

			} else {
				for (int i = 0; i < tab.length; i++) {
					if (terme.getNom().length() <= cruci.length - terme.getPos().y)
						throw new CruciDebordeException();
					try {
						if (tab[i] == ' ') {
							cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
						} else if (tab[i] != terme.getNom().charAt(terme.getPos().y + i))
							throw new CruciCroisementException();
						else {
							cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
						}
					} catch (CruciCroisementException e) {

					}
				}
			}
		}
		return cruci;
	}
}
