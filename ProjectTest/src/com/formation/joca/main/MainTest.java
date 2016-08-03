package com.formation.joca.main;

import java.util.Date;

import com.formation.joca.metier.ExoJoca;

public class MainTest {

	public static void main(String[] args) {
		ExoJoca exo = new ExoJoca();
		Date datetest = new Date();
		exo.setDate(datetest);
		System.out.println(exo.getDateEmbauche());

		exo.setTel("+336987p3475");
		System.out.println(exo.getTel());

	}

}
