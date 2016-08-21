package com.formation.frva.exo;

import java.io.File;

public class TestEnuma {

	private String[] tabEtudiant = { "ambr", "anfr", "beba", "emma", "etga", "issa", "jeci", "made", "soka", "thcr", "thde", "fin" };

	public static void main(String[] args) {
		TestEnuma m = new TestEnuma();
		m.init();
	}

	public void init() {
		//		anfr testMoins (1/1):    | exo.solution(tab, cat, n)
		//		anfr testNull (1/1):    | exo.solution(null, cat, n)
		//		anfr testTrop (0/1): KO | exo.solution(tab, cat, n) le programme est trop long
		//		anfr testAnnormal (1/1):    | exo.solution(tab, cat, n)
		//		anfr testTrop (0/1): KO | exo.solution(tab, cat, n) le programme est trop long
		//		anfr testTrop (0/1): KO | exo.solution(tab, cat, n) le programme est trop long
		//		anfr testCatGrand (0/1): KO | exo.solution(null, cat, n) résultat incorrect
		//		anfr testCatPetit (0/1): KO | exo.solution(null, cat, n) résultat incorrect
		//		anfr testTrop (0/1): KO | exo.solution(tab, cat, n) le programme est trop long
		//		anfr testNormal1 (2/2):    | exo.solution(tab, cat, n)
		//		anfr testNormal2 (2/2):    | exo.solution(tab, cat, n)
		//		anfr NOTE : (7 / 14) = 10,00 / 20
		for (String sEtudiant : tabEtudiant) {
			File file = new File("C:/DevFormation/GITActivFormationParis/ProjectActivFormationParis/src/com/formation/phva/dos/"+sEtudiant+"/");
			
		}

	}
}
