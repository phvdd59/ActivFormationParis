package com.formation.etga.exo;

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

		try {
			if (height <= 0) {
				throw new CruciHeightException();
			}
			if (width <= 0) {
				throw new CruciWidthException();
			}

			for (int i = 0; i < cruci.length; i++) {
				for (int j = 0; j < cruci[0].length; j++) {
					cruci[i][j] = ' ';
				}
			}

			if (lst == null) {
				throw new CruciNullException();
			}

			for (Terme terme : lst) {
				char[] tab = terme.getNom().toCharArray();

				if (terme.isSens() == Terme.HORIZONTAL) {
					for (int i = 0; i < tab.length; i++) {
						cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
						if ((tab.length > width) || (terme.getPos().y + tab.length > width)) {
							throw new CruciDebordeException();
						}
					}
				} else {
					for (int i = 0; i < tab.length; i++) {
						cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
						if ((tab.length > height) || (terme.getPos().x + tab.length > height)) {
							throw new CruciDebordeException();
						}
					}
				}
			}
		} catch (CruciHeightException e) {
		} catch (CruciWidthException e) {
		} catch (CruciNullException e) {
		} catch (CruciDebordeException e) {
		}

		return cruci;
	}
}
