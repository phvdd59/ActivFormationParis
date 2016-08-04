package com.formation.beba.main;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

import com.formation.beba.exo.ExoAlgo4;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class MainAlgo4 {

	public static void main(String[] args) {

		MainAlgo4 mainAlgo4 = new MainAlgo4();
		mainAlgo4.init();
	}

	private void init() {
		Point pos1 = new Point(2, 2);
		Terme terme = new Terme("nom", pos1, false);
		ArrayList<Terme> lstTerme = new ArrayList<Terme>();
		ExoAlgo4 exo = new ExoAlgo4();
		lstTerme.add(terme);
		try {
			exo.solution(8, 8, lstTerme);
		} catch (CruciException e) {
			e.printStackTrace();
		}
		System.out.println(exo);

	}

}
