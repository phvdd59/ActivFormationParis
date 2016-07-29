package com.formation.ambr.main;

import java.util.ArrayList;

import com.formation.ambr.metier.Corneille;
import com.formation.etga.Interface.Lapper;
import com.formation.jeci.interfacea.Ovipare;
import com.formation.jeci.interfacea.Recueille;
import com.formation.jeci.metier.Aigle;
import com.formation.jeci.metier.Oiseaux;
import com.formation.joca.metier.Pangolin;
import com.formation.thcr.metier.Saumon;

public class MainAnimal {
	public static void main(String[] args) {
		//Animal corneille = new Corneille(2, "blanc");
		Oiseaux corneille = new Corneille(2, "blanc");
		System.out.println(corneille);
		corneille.crier();
		corneille.recueille();

		ArrayList<Lapper> lstLapper = new ArrayList<Lapper>(); // 
		lstLapper.add(new Pangolin(30, "Blanc"));
		for (int i = 0; i < lstLapper.size(); i++) {
			lstLapper.get(i).lapper(); // applique la méthode lapper (qui est dans Pholidote par override, et cette classe implements l'interface Lapper) et l'applique à l'élément i de l'ArrayList lstLapper
		}
		ArrayList<Recueille> lstRecueille = new ArrayList<>();
		lstRecueille.add(new Corneille(2, "Grise"));
		for (int i = 0; i < lstRecueille.size(); i++) {
			lstRecueille.get(i).recueille();
		}

		ArrayList<Ovipare> lstOvipare = new ArrayList<Ovipare>();
		lstOvipare.add(new Saumon(1, "rose"));
		lstOvipare.add(new Aigle(1, "rose"));
		for (int i = 0; i < lstOvipare.size(); i++) {
			lstOvipare.get(i).pondre();
		}

	}
}
