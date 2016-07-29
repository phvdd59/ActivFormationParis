package com.formation.comportement;

import com.formation.made.inter.Deplacement;

public class DeplacementEtgaFurtif implements Deplacement {

	@Override
	public void deplacer() {
		System.out.println("Quand je bouge, on me voit, on me voit un peu, on me voit plus! On me voit un peu, puis on ne me voit plus");
	}

}
