package com.formation.emma.exo;

import java.util.ArrayList;

import com.formation.phva.exception.CruciDebordeException;
import com.formation.phva.exception.CruciException;
import com.formation.phva.exception.CruciHeightException;
import com.formation.phva.exception.CruciNullException;
import com.formation.phva.exception.CruciWidthException;
import com.formation.phva.exo.Terme;

public class ExoAlgo4 implements com.formation.phva.exo.InterAlgo4 {

	/**
	 * ma methode solution doit intégrer une liste de terme sous forme 
	 * d'un tableau à deux dimensions 
	 * 
	 * 
	 * example :
	 * 
     * "DATTIERS"
     * "EREINTEE"
     * "COMEDIEN"
     * "AMENER T"
     * " ART API"
     * "OTA MIAM"
     * "BEIGE RE"
     * "S REGAIN"
     * "EPELER T"
     * "DES VELA"
     * "ET METAL"
     * "REPU ESE"
	 *
 	 * les cas annormaux seront traité en grande partie sur la base des 
	 * exeption cruciExeption.
	 *  
	 */
	@Override
	public char[][] solution(int width, int height, ArrayList<Terme> lst) throws CruciException {
		char[][] tableau = null;
		tableau = new char [width][height];
		
		for (int j = 0; j < lst.size(); j++) {
			int x = (int) lst.get(j).getPos().getX();
			int y = (int) lst.get(j).getPos().getY();
			
			char[] motEpele =lst.get(j).getNom().trim().toLowerCase().toCharArray();
			
			if (lst.get(j).isSens()==true){
				for (int i = 0; i < motEpele.length; i++) {
					tableau [x][y] = motEpele[i];
					x++;
				}	
			}else{
				for (int i = 0; i < motEpele.length; i++) {
					tableau [x][y] = motEpele[i];
					y++;
				}	
			}
		}
		
		return tableau;
	}

}
