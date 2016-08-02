package com.formation.jeci.main;

import java.util.ArrayList;

import com.formation.beba.metier.Tigre;
import com.formation.etga.Interface.Lapper;
import com.formation.issa.metier.Loup;
import com.formation.jeci.autre.I1;
import com.formation.jeci.autre.X;
import com.formation.jeci.autre.Y;
import com.formation.jeci.interfacea.Recueille;
import com.formation.jeci.metier.Aigle;
import com.formation.jeci.metier.Oiseaux;
import com.formation.joca.metier.Pangolin;
import com.formation.soka.metier.Lion;
import com.formation.thde.metier.Animal;

public class MainAnimal {

	public static void main(String[] args) {
		MainAnimal main = new MainAnimal();
		main.init();
		// main.init2();

	}

	private void init2() {
		X x1 = new X();
		x1.methodeA();
		I1 i1 = new X();
		Y y1 = new Y();
		I1 i2 = new Y();
		i1.methodeA();
		ArrayList<I1> lst = new ArrayList<I1>();
		lst.add(i1);
		lst.add(i2);
		for (I1 i : lst) {
			i.methodeA();

		}
		i2.methodeA();

	}

	private void init() {
		Oiseaux aigle = new Aigle(20, "jaune");
		Animal looup = new Loup(80, "noir");
		Animal lion = new Lion(250, "jaune");
		Recueille re = aigle;
		re.recueille();
		Recueille re1 = new Aigle(2, "noir");
		Lapper la1 = new Lion();
		ArrayList<Lapper> lstLapper = new ArrayList<Lapper>();
		lstLapper.add(new Tigre(120, "roux"));
		lstLapper.add(new Pangolin(30, "blanc"));
		for (int i = 0; i < lstLapper.size(); i++) {
			lstLapper.get(i).lapper();
		}
	}

}
