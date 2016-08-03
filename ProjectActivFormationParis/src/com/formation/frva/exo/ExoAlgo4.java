package com.formation.frva.exo;

import java.util.ArrayList;

import com.formation.phva.exo.Terme;

public class ExoAlgo4 implements com.formation.phva.exo.InterAlgo4 {

	@Override
	public char[][] solution(int width, int height, ArrayList<com.formation.phva.exo.Terme> lst) {
// 		HORIZONTAL (8 sur 12
//		"PISCINES","ANORMALES","GENOISE ","ER ATEMI"," TATA EN","PENITENT","O TEINTE", "ICI OR R","NO SNOBE","TUBE BIS","E USUELS", "RIS VELE"
// 
//		HORIZONTAL  
//     	"DATTIERS","EREINTEE","COMEDIEN","AMENER T"," ART API","OTA MIAM", "BEIGE RE","S REGAIN","EPELER T","DES VELA","ET METAL","REPU ESE" 
		
		char[][] tab = null;
		if (lst != null){
			tab = new char[height][width];
			for (int i = 0; i < width; i++) {
				for (int j = 0; j < height; j++) {
					tab[j][i] = ' ';
				}
			}
			for (int i = 0; i < lst.size(); i++) {
				Terme  term = lst.get(i);
				
				if (term.isSens() == Terme.HORIZONTAL){
					if (term.getPos().x + term.getNom().length() <= width && term.getPos().y < height){
						for (int j = 0; j < term.getNom().length(); j++) {
							tab[term.getPos().y][term.getPos().x + j] = term.getNom().charAt(j);					
						}
					}
				}else {
					if (term.getPos().y + term.getNom().length() <= height && term.getPos().x < width){
						for (int j = 0; j < term.getNom().length(); j++) {
							tab[term.getPos().y + j][term.getPos().x] = term.getNom().charAt(j);					
						}
					}
				}
			}
		}
		return tab;
	}
	
	
}
