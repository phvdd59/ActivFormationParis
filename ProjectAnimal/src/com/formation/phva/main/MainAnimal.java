package com.formation.phva.main;

import com.formation.anfr.metier.Poney;
import com.formation.issa.metier.Loup;
import com.formation.jeci.interfacea.Recueille;
import com.formation.jeci.metier.Aigle;
import com.formation.jeci.metier.Oiseaux;
import com.formation.soka.metier.Lion;
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
		
		
	}
}
