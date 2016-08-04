package com.formation.made.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.made.exo.ExoAlgo4;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class MainexoAlgo4 {

	public static void main(String[] args) {
		MainexoAlgo4 mainexoAlgo4 = new MainexoAlgo4();
		mainexoAlgo4.init();
	}

	private void init() {
		ExoAlgo4 exoAlgo4 = new ExoAlgo4();
		Point monPoint = new Point(0, 0);
		Terme terme = new Terme("bon obo", monPoint, false);
		Terme terme2 = new Terme("boubou", monPoint, true);
		ArrayList<Terme> lstTerme = new ArrayList<Terme>();
		lstTerme.add(terme);
		lstTerme.add(terme2);
		try {
			exoAlgo4.solution(7, 8, lstTerme);
		} catch (CruciException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
