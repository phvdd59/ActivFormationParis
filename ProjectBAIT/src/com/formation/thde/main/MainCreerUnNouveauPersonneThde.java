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
		Personne jojo = new Personne("thdetest4","admin");
		Personne toto = new Personne();
		jojo.setNom("Baladur");
		jojo.setPrenom("Edouard");
		jojo.setEmail("president2@activConsulting.fr");
		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
//		ArrayList<String> lstPersonnes = new ArrayList<String>();
//		String[] st = bdd.findPersonne(jojo.getIdentifiant());
//		toto = bdd.getPersonne(st[0]);
//		toto.setAdresse("20 rue de lelizee");
//		toto.setcP("75000");
//		toto.setVille("Paris");
//		toto.setTelFixe("0598765431");
//		toto.setTelPort("0698765431");
//		toto.setFax("");
//		toto.setDateNaissance("20/02/1945");
//		toto.setLieuNaissance("Paris");
//		toto.setNumSecu("1 75 09 40 158 233 08");
//		toto.setSituation("En Formation");
//		toto.setFonction("President");
//		toto.setPosition("En Formation");
//		toto.setCadre(true);
//		toto.setCoeff("10");
//		toto.setSalaire("1800000000000000");
//		toto.setVisiteMedicale("10/01/2010");
//		toto.setMontantTransport("50");
//		toto.setVoiture(true);
//		toto.setNbCV("");
//		toto.setNdKm("");
//		toto.setMutuelle(false);
//		toto.setTicket(false);
//		toto.setAdmin(false);
//		toto.setDateCreation(new Date().toString());
//		toto.setDateModification(new Date().toString());
//		toto.setBloque(false);
//		toto.setRaisonBlocage("");
//		bdd.savePersonne(toto);
//		
	}

}
