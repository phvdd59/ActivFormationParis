package com.formation.thde.main;

import java.util.ArrayList;
import java.util.Date;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;

public class MainCreerUnNouveauPersonneThde {

	public static void main(String[] args) {
		MainCreerUnNouveauPersonneThde m = new MainCreerUnNouveauPersonneThde();
		m.init();

	}

	private void init() {
		AccesBDDPersonne bdd = new AccesBDDPersonne();
		Personne jojo = new Personne("thde","admin");
		Personne toto = new Personne();
		jojo.setNom("DELANNOY");
		jojo.setPrenom("Thomas");
		jojo.setEmail("thde@activConsulting.fr");
		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
		ArrayList<String> lstPersonnes = new ArrayList<String>();
		String[] st = bdd.findPersonne(jojo.getIdentifiant());
		toto = bdd.getPersonne(st[0]);
		toto.setAdresse("16 rue du bousin");
		toto.setcP("75005");
		toto.setVille("Paris");
		toto.setTelFixe("0512345678");
		toto.setTelPort("0612345678");
		toto.setFax("");
		toto.setDateNaissance("19/09/1988");
		toto.setLieuNaissance("MAUTAUBANNNN");
		toto.setNumSecu("1 88 09 44 158 236 13");
		toto.setSituation("En Formation");
		toto.setFonction("Apprenti Développeur");
		toto.setPosition("En Formation");
		toto.setCadre(true);
		toto.setCoeff("2");
		toto.setSalaire("15000000000000");
		toto.setVisiteMedicale("15/02/2015");
		toto.setMontantTransport("75");
		toto.setVoiture(false);
		toto.setNbCV("");
		toto.setNdKm("");
		toto.setMutuelle(true);
		toto.setTicket(true);
		toto.setAdmin(true);
		toto.setDateCreation(new Date().toString());
		toto.setDateModification(new Date().toString());
		toto.setBloque(false);
		toto.setRaisonBlocage("");
		bdd.savePersonne(toto);
		
	}

}
