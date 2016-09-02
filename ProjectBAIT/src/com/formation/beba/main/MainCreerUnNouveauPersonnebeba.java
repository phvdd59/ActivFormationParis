package com.formation.beba.main;

import java.util.ArrayList;
import java.util.Date;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;

public class MainCreerUnNouveauPersonnebeba {

	public static void main(String[] args) {
		MainCreerUnNouveauPersonnebeba m = new MainCreerUnNouveauPersonnebeba();
		m.init();

	}

	private void init() {
		AccesBDDPersonne bdd = new AccesBDDPersonne();
		Personne jojo = new Personne("beba","badmin");
		Personne toto = new Personne();
//		jojo.setNom("BASDEVANT");
//		jojo.setPrenom("Benoit");
//		jojo.setEmail("beba@activConsulting.fr");
//		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
		ArrayList<String> lstPersonnes = new ArrayList<String>();
		String[] st = bdd.findPersonne(jojo.getIdentifiant());
		toto = bdd.getPersonne(st[0]);
		toto.setAdresse("");
		toto.setcP("");
		toto.setVille("");
		toto.setTelFixe("");
		toto.setTelPort("");
		toto.setFax("");
		toto.setDateNaissance("");
		toto.setLieuNaissance("");
		toto.setNumSecu("");
		toto.setSituation("");
		toto.setFonction("");
		toto.setPosition("");
//		toto.setCadre(true);
		toto.setCoeff("");
		toto.setSalaire("");
		toto.setVisiteMedicale("");
		toto.setMontantTransport("");
//		toto.setVoiture(false);
		toto.setNbCV("");
		toto.setNdKm("");
//		toto.setMutuelle(true);
//		toto.setTicket(true);
//		toto.setAdmin(true);
		toto.setDateCreation(new Date().toString());
		toto.setDateModification(new Date().toString());
//		toto.setBloque(false);
//		toto.setRaisonBlocage("");
		bdd.savePersonne(toto);
		
	}

}
