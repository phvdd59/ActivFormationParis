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
		Personne jojo = new Personne("anfrtest1","admin");
		Personne toto = new Personne();
		jojo.setNom("Aubert");
		jojo.setPrenom("JeanLouis");
		jojo.setEmail("aubert@musique.fr");
		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
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
		toto.setCadre(false);
		toto.setCoeff("");
		toto.setSalaire("");
		toto.setVisiteMedicale("");
		toto.setMontantTransport("");
		toto.setVoiture(false);
		toto.setNbCV("");
		toto.setNdKm("");
		toto.setMutuelle(true);
		toto.setTicket(true);
		toto.setAdmin(false);
		toto.setDateCreation(new Date().toString());
		toto.setDateModification(new Date().toString());
		toto.setBloque(false);
		toto.setRaisonBlocage("");
		bdd.savePersonne(toto);
		
	}

}
