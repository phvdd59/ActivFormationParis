package com.formation.thde.main;

import java.util.ArrayList;

import com.formation.ambr.metier.Corneille;
import com.formation.anfr.metier.Poney;
import com.formation.beba.metier.Tigre;
import com.formation.etga.Interface.Lapper;
import com.formation.issa.metier.Loup;
import com.formation.jeci.interfacea.Ovipare;
import com.formation.jeci.interfacea.Recueille;
import com.formation.jeci.metier.Aigle;
import com.formation.jeci.metier.Oiseaux;
import com.formation.joca.metier.Pangolin;
import com.formation.soka.metier.Lion;
import com.formation.thcr.metier.Saumon;
import com.formation.thde.metier.Animal;

public class MainAnimal {
	public static void main(String[] args) {

		MainAnimal mainAnimal = new MainAnimal();
		mainAnimal.init();
	}

	public void init() {
		Animal nouvelAnimal = new Poney(400, "brun");
		nouvelAnimal.boire();
		Animal nouvelAnimal2 = new Tigre(220, "orange rayé");
		nouvelAnimal2.boire();
		Animal nouvelAnimal3 = new Corneille(1, "noir");
		nouvelAnimal3.boire();
		Animal nouvelAnimal4 = new Loup(50, "gris");
		nouvelAnimal4.boire();
		Oiseaux nouvelAnimal5 = new Aigle(1, "'murica");
		nouvelAnimal5.boire();
		nouvelAnimal5.recueille();
		Recueille re1 = new Aigle(2, "noir");
		Lapper la1 = new Lion();
		ArrayList<Lapper> lstLapper = new ArrayList<Lapper>();
		//lstLapper.add(new Tigre(120, "Roux"));
		lstLapper.add(new Pangolin(30, "Blanc"));
		for (int i = 0; i < lstLapper.size(); i++) {
			lstLapper.get(i).lapper();
		}
		ArrayList<Ovipare> lstOvipare = new ArrayList<Ovipare>();
		lstOvipare.add(new Saumon(1, "rose"));
		lstOvipare.add(new Aigle(1, "rose"));
		for (int i = 0; i < lstOvipare.size(); i++) {
			lstOvipare.get(i).pondre();
		}
	}

}
