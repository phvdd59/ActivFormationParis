package com.formation.joca.main;

import java.util.Date;

import com.formation.joca.metier.ExoJoca;

public class MainTest {

	public static void main(String[] args) {
		ExoJoca exo = new ExoJoca();
		Date datetest = new Date();
		exo.setDate(datetest);
		System.out.println(exo.getDateEmbauche());

		exo.setTel("+33698783875");
		System.out.println(exo.getTel());
		
		exo.setNom("De_Crapal");
		System.out.println(exo.getNom());
		
		exo.setAdresseMail("johanncassagne@gmail.com");
		System.out.println(exo.getAdresseMail());
		
		exo.setMdp("Mp8");
		System.out.println(exo.getMdp());

	}

}
