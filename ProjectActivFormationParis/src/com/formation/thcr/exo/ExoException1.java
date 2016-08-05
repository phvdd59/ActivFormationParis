package com.formation.thcr.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.exo.InterException1;
import com.formation.phva.exo.Terme;

public class ExoException1 implements InterException1 {

	public char[][] solution(int width, int height, ArrayList<com.formation.phva.exo.Terme> lst) throws CruciException {
		char[][] cruci = new char[height][width];
		if (lst != null) {

			for (Terme terme : lst) {
				if (terme.isSens() == Terme.VERTICAL) {
					if (terme.getNom().length() > height) {
						throw new CruciHeightException();
					}
				} else if (terme.isSens() == Terme.HORIZONTAL) {
					if (terme.getNom().length() > width) {
						throw new CruciWidthException();
					}
				}
			}

			for (int i = 0; i < cruci.length; i++) {
				for (int j = 0; j < cruci[0].length; j++) {
					cruci[i][j] = ' ';
				}
			}

			for (Terme terme : lst) {
				char[] tab = terme.getNom().toCharArray();
				if (terme.isSens() == Terme.HORIZONTAL) {
					int verifDepassement = (int) terme.getPos().getX() + terme.getNom().length();
					if (verifDepassement > width) {
						throw new CruciDebordeException();
					} else {
						for (int i = 0; i < tab.length; i++) {
							cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
						}
					}
				} else {
					int verifDepassement = (int) terme.getPos().getY() + terme.getNom().length();
					if (verifDepassement > height) {
						throw new CruciDebordeException();
					} else {
						for (int i = 0; i < tab.length; i++) {
							cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
						}
					}
				}
			}

		} else {
			throw new CruciNullException();
		}
		return cruci;
	}
}
