package com.formation.emma.exo;

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
		char[][] cruci = null;

		if (width < 0) {
			throw new CruciWidthException();
		} else if (height < 0) {
			throw new CruciHeightException();
		} else {
			if (lst == null) {
				throw new CruciNullException();
			} else {
				cruci = new char[height][width];
				for (int i = 0; i < cruci.length; i++) {
					for (int j = 0; j < cruci[0].length; j++) {
						cruci[i][j] = ' ';
					}
				}
				int cpt = 0;
				for (Terme terme : lst) {

					if (cpt == 1) {
						break;
					} else {
						char[] tab = terme.getNom().toCharArray();
						if (terme.isSens() == Terme.HORIZONTAL) {
							for (int i = 0; i < tab.length; i++) {

								try {
									if (i + terme.getPos().x >= cruci.length) {
										throw new CruciDebordeException();
									} else if (cruci[terme.getPos().y][terme.getPos().x + i] != ' ') {
										throw new CruciCroisementException();
									} else {
										cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];

									}
								} catch (CruciDebordeException e) {
									cpt = 1;
									break;
								} catch (CruciCroisementException e1) {

								} finally {

								}
							}
						} else {
							for (int i = 0; i < tab.length; i++) {

								try {
									if (i + terme.getPos().y >= cruci.length) {
										throw new CruciDebordeException();
									} else if (cruci[terme.getPos().y + i][terme.getPos().x] != ' ') {
										throw new CruciCroisementException();
									} else {
										cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
									}
								} catch (CruciDebordeException e) {
									cpt = 1;
									break;
								} catch (CruciCroisementException e1) {

								} finally {

								}
							}

						}
					}
				}
			}
			return cruci;
		}
	}
}
