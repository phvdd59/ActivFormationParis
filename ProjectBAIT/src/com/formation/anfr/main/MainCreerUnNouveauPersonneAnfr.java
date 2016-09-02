package com.formation.anfr.main;

import java.util.ArrayList;
import java.util.Date;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;

public class MainCreerUnNouveauPersonneAnfr {

	public static void main(String[] args) {
		MainCreerUnNouveauPersonneAnfr m = new MainCreerUnNouveauPersonneAnfr();
		m.init();

	}

	private void init() {
		AccesBDDPersonne bdd = new AccesBDDPersonne();
		Personne jojo = new Personne("anfr","admin");
		Personne toto = new Personne();
		jojo.setNom("FRERE");
		jojo.setPrenom("Antoine");
		jojo.setEmail("anfr@activConsulting.fr");
//		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
		ArrayList<String> lstPersonnes = new ArrayList<String>();
		String[] st = bdd.findPersonne(jojo.getIdentifiant());
		toto = bdd.getPersonne(st[0]);
		toto.setAdresse("15 rue du de chez moi");
		toto.setcP("49000");
		toto.setVille("Angers");
		toto.setTelFixe("0287070737");
		toto.setTelPort("0687070737");
		toto.setFax("LOLWUT");
		toto.setDateNaissance("15/09/1988");
		toto.setLieuNaissance("Nantes");
		toto.setNumSecu("1 88 09 44 158 236 12");
		toto.setSituation("En Formation");
		toto.setFonction("Apprenti Dévellopeur");
		toto.setPosition("En Formation");
		toto.setCadre(true);
		toto.setCoeff("2");
		toto.setSalaire("15000000000000");
		toto.setVisiteMedicale("15/02/2015");
		toto.setMontantTransport("73");
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
