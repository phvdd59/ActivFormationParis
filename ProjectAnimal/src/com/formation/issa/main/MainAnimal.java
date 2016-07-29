package com.formation.issa.main;

import java.util.ArrayList;

import com.formation.beba.metier.Tigre;
import com.formation.etga.Interface.Lapper;
import com.formation.issa.metier.Loup;
import com.formation.jeci.interfacea.Ovipare;
import com.formation.jeci.interfacea.Recueille;
import com.formation.jeci.metier.Aigle;
import com.formation.joca.metier.Canin;
import com.formation.joca.metier.Pangolin;
import com.formation.made.metier.Panda;
import com.formation.soka.metier.Lion;
import com.formation.thcr.metier.Saumon;
import com.formation.thde.metier.Animal;

public class MainAnimal {

	public MainAnimal() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		MainAnimal mainAnimal = new MainAnimal();
		mainAnimal.init();

	}

	private void init() {

		Animal loup = new Loup(80, "noir");
		Lapper la1 = new Lion(250, "jaune");
		Animal lion = new Lion(250, "jaune");
		Animal aigle = new Aigle(1,"blanc");
		Recueille re = new Aigle(1,"Blanc");
		re.recueille();
		Recueille re1 = new Aigle(2, "noir");
		ArrayList<Lapper> lstLapper = new ArrayList<Lapper>();
		lstLapper.add(new Tigre(120, "Roux"));
		lstLapper.add(new Pangolin(50,"Blanc"));
		lstLapper.add(new Panda(65,"Blanc"));
		
		ArrayList<Ovipare>lstOvipare=new ArrayList<Ovipare>();
		lstOvipare.add(new Aigle(1,"rose"));
		for (int i = 0; i < lstOvipare.size(); i++) {
			lstOvipare.get(i).pondre();
		}
		
		
		for (int i = 0; i < lstLapper.size(); i++) {
			lstLapper.get(i).lapper();
		}
		

		

	}

}
