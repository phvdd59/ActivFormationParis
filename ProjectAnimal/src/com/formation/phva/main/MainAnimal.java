package com.formation.phva.main;

import java.util.ArrayList;

import com.formation.anfr.metier.Poney;
import com.formation.beba.metier.Tigre;
import com.formation.etga.Interface.Lapper;
import com.formation.issa.metier.Loup;
import com.formation.jeci.interfacea.Ovipare;
import com.formation.jeci.interfacea.Recueille;
import com.formation.jeci.metier.Aigle;
import com.formation.jeci.metier.Oiseaux;
import com.formation.joca.metier.Pangolin;
import com.formation.made.metier.Panda;
import com.formation.soka.metier.Lion;
import com.formation.thcr.metier.Saumon;
import com.formation.thde.metier.Animal;

public class MainAnimal {
	public static void main(String[] args) {
		Animal poney = new Poney(500, "Maron");
		poney.crier();
		Oiseaux aigle = new Aigle(1, "blanc");
		aigle.crier();
		Animal loup = new Loup(80, "noir");
		Animal lion = new Lion(250, "jaune");
		Recueille re = aigle;
		re.recueille();
		Recueille re1 = new Aigle(2, "noir");
		Lapper la1 = new Lion();
		ArrayList<Lapper> lstLapper = new ArrayList<Lapper>();
		lstLapper.add(new Tigre(120, "Roux"));
		lstLapper.add(new Pangolin(30, "Blanc"));
		lstLapper.add(new Panda(30, "Blanc"));

		ArrayList<Ovipare> lstOvipare = new ArrayList<Ovipare>();
		lstOvipare.add(new Saumon(1, "rose"));
		lstOvipare.add(new Aiqle(1, "rose"));
		for (int i = 0; i < lstOvipare.size(); i++) {
			lstOvipare.get(i).pondre();
		}

		for (int i = 0; i < lstLapper.size(); i++) {
			lstLapper.get(i).lapper();
		}
	}
}
