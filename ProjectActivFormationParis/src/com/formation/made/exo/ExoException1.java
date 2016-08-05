package com.formation.made.exo;

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
		if (width <= 0) {
			throw new CruciWidthException();
		} else if (height <= 0) {
			throw new CruciHeightException();
		}
		char[][] cruci = new char[height][width];
		for (int i = 0; i < cruci.length; i++) {
			for (int j = 0; j < cruci[0].length; j++) {
				cruci[i][j] = ' ';
			}
		}
		if (lst == null) {
			throw new CruciNullException();
		} else {

			for (Terme terme : lst) {
				char[] tab = terme.getNom().toCharArray();
				if (terme.isSens() == Terme.HORIZONTAL) {
					if (tab.length > width || tab.length + terme.getPos().x > width) {
						throw new CruciDebordeException(terme);
					} else {
						for (int i = 0; i < tab.length; i++) {
							try {
								if (cruci[terme.getPos().y][terme.getPos().x + i] != ' ') {
									throw new CruciCroisementException(terme, terme.getPos().x);
								}
							} catch (CruciCroisementException e) {
								e.getMessage();
							} finally {
								cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
							}
						}
					}

				} else {
					if (tab.length > height || tab.length + terme.getPos().y > height) {
						throw new CruciDebordeException(terme);
					} else {
						for (int i = 0; i < tab.length; i++) {
							try {
								if (cruci[terme.getPos().y + i][terme.getPos().x] != ' ') {
									throw new CruciCroisementException(terme, terme.getPos().y);
								}
							} catch (CruciCroisementException e) {
								e.getMessage();
							} finally {
								cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
							}
						}
					}
				}
			}
			return cruci;
		}

	}
}
