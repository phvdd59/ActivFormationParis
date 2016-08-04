package com.formation.anfr.main;

import java.awt.Point;
import java.util.ArrayList;

import com.formation.anfr.exo.ExoAlgo4;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exo.Terme;

public class MainCruci {

	public static void main(String[] args) {
		MainCruci mainCruci = new MainCruci();
		mainCruci.init();
	}

	private void init() {
		ExoAlgo4 exo = new ExoAlgo4();
		ArrayList<Terme> lst = new ArrayList<Terme>();
		Point p = new Point(0,0);
		lst.add(new Terme("lol",p,Terme.HORIZONTAL));
		lst.add(new Terme("tu",new Point(1,0),Terme.VERTICAL));
		lst.add(new Terme("vasy",new Point(0,1),Terme.VERTICAL));
		lst.add(new Terme("bu",new Point(1,2),Terme.VERTICAL));
		char[][] sol = null;
		try {
		 sol = exo.solution(3, 3, lst);
		} catch (CruciException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
	}

}
