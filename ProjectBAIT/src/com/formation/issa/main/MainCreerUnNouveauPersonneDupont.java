package com.formation.issa.main;

import java.util.ArrayList;
import java.util.Date;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;

public class MainCreerUnNouveauPersonneDupont {

	public static void main(String[] args) {
		MainCreerUnNouveauPersonneDupont m = new MainCreerUnNouveauPersonneDupont();
		m.init();
		
	}



	private void init() {
		AccesBDDPersonne bdd = new AccesBDDPersonne();
		Personne jojo = new Personne("frk","FRK75");
		Personne toto = new Personne();
		jojo.setNom("Franklin");
		jojo.setPrenom("Aretha");
		jojo.setEmail("franklin@activConsulting.fr");
		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
		ArrayList<String> lstPersonnes = new ArrayList<String>();
		String[] st = bdd.findPersonne(jojo.getIdentifiant());
		toto = bdd.getPersonne(st[0]);
		toto.setAdresse("15 rue du Bac");
		toto.setcP("91000");
		toto.setVille("Boulogne-Billancourt");
		toto.setTelFixe("0145125023");
		toto.setTelPort("0678450166");
		toto.setFax("0245120164");
		toto.setDateNaissance("23/05/1978");
		toto.setLieuNaissance("Limoges");
		toto.setNumSecu("2 78 01 26 213 109 07");
		toto.setSituation("Salariée");
		toto.setFonction("Chef de Produits OTC");
		toto.setPosition("1.25");
		toto.setCadre(true);
		toto.setCoeff("3");
		toto.setSalaire("4500000000000000000");
		toto.setVisiteMedicale("26/01/2016");
		toto.setMontantTransport("73");
		toto.setVoiture(true);
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
