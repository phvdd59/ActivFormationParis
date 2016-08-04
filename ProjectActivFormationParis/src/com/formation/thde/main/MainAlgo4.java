package com.formation.thde.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;
import com.formation.thde.exo.ExoAlgo4;

public class MainAlgo4 {

	public static void main(String[] args) {
		MainAlgo4 mainAlgo4 = new MainAlgo4();
		mainAlgo4.init();
	}
//
	public void init() {
		ExoAlgo4 exo = new ExoAlgo4();
		ArrayList<Terme> lst = new ArrayList<Terme>();
		Point point1 = new Point(0, 0);
		Terme term1 = new Terme("AB", point1, false);
		Point point2 = new Point(0, 0);
		Terme term2 = new Terme("JC", point2, true);
		Point point3 = new Point(1, 0);
		Terme term3 = new Terme("BD", point3, true);
		lst.add(term1);
		lst.add(term2);
		lst.add(term3);

		try {
			char[][] tab = exo.solution(2, 2, lst);
			System.out.println(tab);
		} catch (CruciException e) {
			e.printStackTrace();
		}

	}

}
