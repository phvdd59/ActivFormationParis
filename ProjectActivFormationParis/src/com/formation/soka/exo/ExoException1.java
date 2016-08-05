package com.formation.soka.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
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
		for (Terme terme : lst) {
			char[] tab = terme.getNom().toCharArray();
			if (terme.isSens() == Terme.HORIZONTAL) {
				for (int i = 0; i < tab.length; i++) {
					cruci[terme.getPos().y][terme.getPos().x + i] = tab[i];
				}
			} else {
				for (int i = 0; i < tab.length; i++) {
					cruci[terme.getPos().y + i][terme.getPos().x] = tab[i];
				}
			}
		}
		return cruci;
	}
}
