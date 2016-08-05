package com.formation.beba.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.beba.exo.ExoException1;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class MainAlgo4 {

	public static void main(String[] args) throws CruciException {

		MainAlgo4 mainAlgo4 = new MainAlgo4();
		mainAlgo4.init();
	}

	private void init() throws CruciException {
		Point pos1 = new Point(2, 2);
		Terme terme = new Terme("oooo", pos1, false);
		ArrayList<Terme> lstTerme = new ArrayList<Terme>();
		ExoException1 exo = new ExoException1();
		lstTerme.add(terme);
		Point pos2 = new Point(3, 1);
		Terme terme2 = new Terme("nnnn", pos2, true);
		lstTerme.add(terme2);
		exo.solution(5, -5, lstTerme);

	}

}
