package com.formation.issa.main;

import java.util.ArrayList;
import java.util.Date;

import com.formation.bait.dao.AccesBDDPersonne;
import com.formation.bait.metier.Personne;

public class MainCreerUnNouveauPersonneFrk {

	public static void main(String[] args) {
		MainCreerUnNouveauPersonneFrk m = new MainCreerUnNouveauPersonneFrk();
		m.init();
		
	}



	private void init() {
		AccesBDDPersonne bdd = new AccesBDDPersonne();
		Personne jojo = new Personne("dpt","DPT046");
		Personne toto = new Personne();
		jojo.setNom("Dupont");
		jojo.setPrenom("Henri");
		jojo.setEmail("dupont@activConsulting.fr");
		bdd.createNewPersonne(jojo.getIdentifiant(), jojo.getMdp(), jojo.getEmail(), jojo.getNom(), jojo.getPrenom());
		ArrayList<String> lstPersonnes = new ArrayList<String>();
		String[] st = bdd.findPersonne(jojo.getIdentifiant());
		toto = bdd.getPersonne(st[0]);
		toto.setAdresse("20 rue du Chêne");
		toto.setcP("25000");
		toto.setVille("Besançon");
		toto.setTelFixe("0163450289");
		toto.setTelPort("0614030596");
		toto.setFax("0215457863");
		toto.setDateNaissance("14/02/1965");
		toto.setLieuNaissance("Brest");
		toto.setNumSecu("1 65 02 55 208 118 15");
		toto.setSituation("Salarié");
		toto.setFonction("Consultant senior Big Data");
		toto.setPosition("2.51");
		toto.setCadre(true);
		toto.setCoeff("2");
		toto.setSalaire("35000000000");
		toto.setVisiteMedicale("16/03/2016");
		toto.setMontantTransport("73");
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
