package com.formation.phva.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.exo.Terme;

public class ExoAlgo4 implements com.formation.phva.exo.InterAlgo4 {

	public char[][] solution(int width, int height, ArrayList<com.formation.phva.exo.Terme> lst) throws CruciException {
		if (width <= 0) {
			throw new CruciWidthException();
		}
		if (height <= 0) {
			throw new CruciHeightException();
		}
		if (lst == null) {
			throw new CruciNullException();
		}
		char[][] cruci = new char[height][width];
		for (int i = 0; i < cruci.length; i++) {
			for (int j = 0; j < cruci[0].length; j++) {
				cruci[i][j] = ' ';
			}
		}
		for (Terme terme : lst) {
			char[] tab = terme.getNom().toCharArray();
			if (terme.isSens() == Terme.HORIZONTAL) {
				if (terme.getPos().y >= height) {
					throw new CruciDebordeException(terme);
				}
				if (terme.getPos().x+tab.length >= width) {
					throw new CruciDebordeException(terme);
				}
				for (int i = 0; i < tab.length; i++) {
					cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
				}
			} else {
				if (terme.getPos().x >= width) {
					throw new CruciDebordeException(terme);
				}
				if (terme.getPos().y+tab.length >= height) {
					throw new CruciDebordeException(terme);
				}
				for (int i = 0; i < tab.length; i++) {
					cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
				}
			}
		}
		return cruci;
	}
}
