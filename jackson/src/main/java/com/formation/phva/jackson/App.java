package com.formation.phva.jackson;

import java.io.File;
import java.util.ArrayList;

import com.formation.phva.jackson.metier.Elmt;
import com.formation.phva.jackson.metier.ListeMeuble;
import com.formation.phva.jackson.metier.Materiaux;
import com.formation.phva.jackson.metier.Meuble;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		App app = new App();
		//app.init();
		//app.initMeuble();
		app.initUnMeuble();
		//app.initMeubleVrai();
	}

	public void initMeubleVrai() {
		ListeMeuble liste = new ListeMeuble();
		File file = new File("ikae");
		if (file.exists()) {
			liste.chargeListeMeuble(file);
			
			final GsonBuilder builder = new GsonBuilder();
			final Gson gson = builder.create();
			String json = gson.toJson(liste);
			json = json.replace("\"", "\\\"");
			System.out.println(json);
		}
	}

	public void initMeuble() {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		final Coordonnees coordonnees = new Coordonnees(120, 450);

		final Meuble meuble1 = new Meuble(Elmt.TRI_REF, "Cube", "123456789", 100, 100, 100);
		Elmt elmt1 = new Elmt(1, "facade", 2, 100, 100, 10);
		Elmt elmt2 = new Elmt(2, "cote", 2, 100, 100, 10);
		Elmt elmt3 = new Elmt(1, "plan", 2, 100, 100, 10);
		elmt1.getListeMateriaux().add(Materiaux.BOIS.getMateriaux(100));
		elmt2.getListeMateriaux().add(Materiaux.BOIS.getMateriaux(100));
		elmt3.getListeMateriaux().add(Materiaux.BOIS.getMateriaux(100));
		meuble1.getLstElmt().add(elmt1);
		meuble1.getLstElmt().add(elmt2);
		meuble1.getLstElmt().add(elmt3);

		final Meuble meuble2 = new Meuble(Elmt.TRI_REF, "Table", "123456780", 160, 70, 80);
		Elmt elmt4 = new Elmt(1, "Plan", 1, 160, 80, 10);
		Elmt elmt5 = new Elmt(1, "Pied", 4, 70, 10, 10);
		elmt4.getListeMateriaux().add(Materiaux.BOIS.getMateriaux(100));
		elmt5.getListeMateriaux().add(Materiaux.FER.getMateriaux(100));
		meuble2.getLstElmt().add(elmt1);
		meuble2.getLstElmt().add(elmt2);
		meuble2.getLstElmt().add(elmt3);

		ListeMeuble lst = new ListeMeuble();
		lst.add(meuble1);
		lst.add(meuble2);

		String json = gson.toJson(lst);
		json = json.replace("\"", "\\\"");
		System.out.println(json);
	}

	public void initUnMeuble() {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();

		final Meuble meuble2 = new Meuble(Elmt.TRI_REF, "Table", "123456780", 160, 70, 80);
		Elmt elmt4 = new Elmt(1, "Plan", 1, 160, 80, 10);
		Elmt elmt5 = new Elmt(1, "Pied", 4, 70, 10, 10);
		elmt4.getListeMateriaux().add(Materiaux.BOIS.getMateriaux(100));
		elmt5.getListeMateriaux().add(Materiaux.FER.getMateriaux(100));
		meuble2.getLstElmt().add(elmt4);
		meuble2.getLstElmt().add(elmt5);

		String json = gson.toJson(meuble2);
		json = json.replace("\"", "\\\"");
		System.out.println(json);
	}

	public void init() {
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		final Coordonnees coordonnees = new Coordonnees(120, 450);
		final PersonData p = new PersonData();
		p.setFirstName("ph");
		p.setLastName("vdd");
		ArrayList<String> lst = new ArrayList<String>();
		lst.add("Bonjour1");
		lst.add("Bonjour2");
		String json = gson.toJson(coordonnees);
		System.out.println("Resultat = " + json);
		json = gson.toJson(p);
		System.out.println("Resultat = " + json);
		json = gson.toJson(lst);
		System.out.println("Resultat = " + json);
	}
}
