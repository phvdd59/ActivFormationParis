package com.formation.beba.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.beba.exo.ExoAlgo4Bis;
import com.formation.phva.exo.Terme;

public class MainAlgo4 {

	public static void main(String[] args) {

		MainAlgo4 mainAlgo4 = new MainAlgo4();
		mainAlgo4.init();
	}

	private void init() {
		Point pos1 = new Point(2, 2);
		Terme terme = new Terme("oooo", pos1, false);
		ArrayList<Terme> lstTerme = new ArrayList<Terme>();
		ExoAlgo4Bis exo = new ExoAlgo4Bis();
		lstTerme.add(terme);
		Point pos2 = new Point(3, 1);
		Terme terme2 = new Terme("nnnn", pos2, true);
		lstTerme.add(terme2);
		exo.solution(8, 8, lstTerme);

	}

}
