package com.formation.joca.exo;

import java.awt.Point;
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

		char[][] cruci = new char[height][width];
		for (int i = 0; i < cruci.length; i++) {
			for (int j = 0; j < cruci[0].length; j++) {
				cruci[i][j] = ' ';
			}
		}

		if (lst == null) {

			throw new CruciNullException();

		} else if (longueurPlusGrandTerme(lst) > width) {

			throw new CruciWidthException();

		} else if (hauteurPlusGrandTerme(lst) > height) {

			throw new CruciHeightException();

		} else {

			for (Terme terme : lst) {
				char[] tab = terme.getNom().toCharArray();

				if (terme.isSens() == Terme.HORIZONTAL) {

					for (int i = 0; i < tab.length; i++) {

						if ((terme.getPos().x + i) >= width) {

							throw new CruciDebordeException(terme);

						} else {

							try {
								if (cruci[terme.getPos().y][terme.getPos().x + i] != tab[i]
										&& cruci[terme.getPos().y][terme.getPos().x + i] != ' ') {

									throw new CruciCroisementException(terme, i);

								} else {

									cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];

								}
							} catch (CruciCroisementException e) {
								System.out.println(e.getMessage());
							}
						}
					}

				} else {

					for (int i = 0; i < tab.length; i++) {

						if ((terme.getPos().y + i) >= height) {

							throw new CruciDebordeException(terme);

						} else {

							try {
								if (cruci[terme.getPos().y + i][terme.getPos().x] != tab[i]
										&& cruci[terme.getPos().y + i][terme.getPos().x] != ' ') {

									throw new CruciCroisementException(terme, i);

								} else {

									cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];

								}
							} catch (CruciCroisementException e) {
								System.out.println(e.getMessage());
							}

						}
					}
				}
			}
			return cruci;
		}
	}

	public int longueurPlusGrandTerme(ArrayList<Terme> lst) {
		int result = 0;
		Terme temp = new Terme("", new Point(0, 0), false);
		for (int i = 0; i < lst.size(); i++) {
			if (!lst.get(i).isSens() && lst.get(i).getNom().length() > temp.getNom().length()) {
				temp = lst.get(i);
				result = temp.getNom().length();
			}
		}
		return result;
	}

	public int hauteurPlusGrandTerme(ArrayList<Terme> lst) {
		int result = 0;
		Terme temp = new Terme("", new Point(0, 0), true);
		for (int i = 0; i < lst.size(); i++) {
			if (lst.get(i).isSens() && lst.get(i).getNom().length() > temp.getNom().length()) {
				temp = lst.get(i);
				result = temp.getNom().length();
			}
		}
		return result;
	}
}
