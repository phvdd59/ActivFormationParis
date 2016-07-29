package com.formation.thcr.main;

import java.util.ArrayList;

import com.formation.ambr.metier.Corneille;
import com.formation.anfr.metier.Poney;
import com.formation.beba.metier.Tigre;
import com.formation.etga.Interface.Lapper;
import com.formation.issa.metier.Loup;
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
		MainAnimal main = new MainAnimal();
		main.init();

	}

	private void init() {
		Animal a = new Saumon();
		a.boire();
		a.crier();
		a.deplacement();
		a.manger();
		
		System.out.println();
		
		Animal b = new Lion();
		b.boire();
		b.crier();
		b.deplacement();
		b.manger();
		
		System.out.println();
		
		Animal c = new Corneille();
		c.boire();
		c.crier();
		c.deplacement();
		c.manger();
		
		System.out.println();
		
		Animal d = new Panda();
		d.boire();
		d.crier();
		d.deplacement();
		d.manger();
		
		System.out.println();
		
		Animal e = new Aigle();
		e.boire();
		e.crier();
		e.deplacement();
		e.manger();
		
		System.out.println();
		
		Animal f = new Tigre();
		f.boire();
		f.crier();
		f.deplacement();
		f.manger();
		
		System.out.println();
		
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
		lstLapper.add(new Pangolin(30,"Blanc"));
		lstLapper.add(new Lion());
		lstLapper.add(new Panda());
		System.out.println();
		for (int i = 0; i < lstLapper.size(); i++) {
			lstLapper.get(i).lapper();
		}
		
	}
}
