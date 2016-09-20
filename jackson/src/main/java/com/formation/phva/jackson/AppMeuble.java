package com.formation.phva.jackson;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Hello world!
 *
 */
public class AppMeuble {
	public static void main(String[] args) {
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
