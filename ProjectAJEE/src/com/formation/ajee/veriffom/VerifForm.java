package com.formation.ajee.veriffom;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.regex.Pattern;

import com.formation.ajee.metier.ListeDoc;
import com.formation.ajee.metier.Personne;
import com.formation.ajee.metier.SEXE;
import com.formation.ajee.metier.SITUATION;

public class VerifForm {

	public String nomVerif(String nom) {
		String retour = "";
		try {
			if (nom.matches("[A-Za-zאבגהחטיךכלםמןסעףפצשתûü\\-\\'\\s]*") && nom.length() <= 100) {
				retour = nom;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String prenomVerif(String prenom) {
		String retour = "";
		try {
			if (prenom.matches("[A-Za-zאבגהחטיךכלםמןסעףפצשתûü\\-\\']*") && prenom.length() <= 100) {
				retour = prenom;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return retour;
	}

	public int sexeVerif(String sexe) {
		int retour = 0;
		try {
			sexe = sexe.toUpperCase();
			if (sexe.equals("MASCULIN")) {
				retour = Personne.MASCULIN;
			} else if (sexe.equals("FEMININ")) {
				retour = Personne.FEMINIM;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String identifiantVerif(String identifiant) {
		String retour = "";
		try {
			if (identifiant.matches("[A-Za-zאבגהחטיךכלםמןסעףפצשתûü]*") && identifiant.length() <= 100) {
				retour = identifiant;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String mdpVerif(String mdp) {
		String retour = "";
		try {
			if (mdp.matches("[0-9A-Za-z]*") && mdp.length() <= 100) {
				retour = mdp;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String emailVerif(String email) {
		String retour = "";
		try {
			if (email != null) {
				if (Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE).matcher(email).find()) {
					retour = email;
				}
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String adresseVerif(String adresse) {
		String retour = "";
		try {

			if (adresse.matches("[0-9A-Za-zאבגהחטיךכלםמןסעףפצשתûü\\s\\-\\'\\,]*") && adresse.length() <= 100) {
				retour = adresse;
			}

		} catch (Exception e) {

		}

		return retour;
	}

	public String cpVerif(String cp) {
		String retour = "";
		try {
			if (cp.matches("[0-9]{5}")) {
				retour = cp;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String villeVerif(String ville) {
		String retour = "";
		try {
			ville = ville.toLowerCase();
			if (ville.matches("[A-Za-zאבגהחטיךכלםמןסעףפצשתûü\\-\\'\\s]*") && ville.length() < 100) {
				retour = ville;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String telFixVerif(String telFix) {
		String retour = "";
		try {
			char premierchiffre = telFix.charAt(0);
			char deuxiemechiffre = telFix.charAt(1);
			if (telFix.matches("[0-9]{10}") && (premierchiffre == '0' && (deuxiemechiffre != '6' && deuxiemechiffre != '7' && deuxiemechiffre != '0'))) {

				retour = telFix;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String telPortVerif(String telPort) {
		String retour = "";
		try {
			if (telPort.matches("[0-9]{10}") && (telPort.substring(0, 2).equals("06") || telPort.substring(0, 2).equals("07"))) {

				retour = telPort;

			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String faxVerif(String fax) {
		String retour = null;
		try {
			char premierchiffre = fax.charAt(0);
			char deuxiemechiffre = fax.charAt(1);
			if (fax.matches("[0-9]{10}") && (premierchiffre == '0' && deuxiemechiffre != '6' && deuxiemechiffre != '7' && deuxiemechiffre != '0')) {

				retour = fax;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public Date dateNaissanceVerif(String dateNaissance) {
		Date retour = new Date();
		try {
			String s = dateNaissance;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			retour = sdf.parse(s);
		} catch (Exception e) {

		}

		return retour;
	}

	public String lieuNaissanceVerif(String lieuNaissance) {
		String retour = "";
		try {
			if (lieuNaissance.matches("[A-Za-zאבגהחטיךכלםמןסעףפצשתûü\\-\\'\\s]*")) {
				retour = lieuNaissance;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String numSecuVerif(String numSecu) {
		String retour = "";
		try {
			if (numSecu.matches("[12][0-9]{2}[0-1][0-9](2[AB]|[0-9]{2})[0-9]{3}[0-9]{3}[0-9]{2}")) {
				retour = numSecu;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String nationaliteVerif(String nationalite) {
		String retour = "";
		try {
			
			if (nationalite.matches("[A-Za-zאבגהחטיךכלםמןסעףפצשתûü\\-\\'\\s]*")) {
				retour = nationalite;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String situationVerif(String situation, String champsAutre) {
		String retour = "";
		champsAutre = this.lieuNaissanceVerif(champsAutre);
		try {

			switch (situation) {
			case "salarie":
				retour = Personne.SALARIE;
				break;
			case "autoEntrepreneur":
				retour = Personne.AUTO_ENTREPRENEUR;
				break;
			case "freelance":
				retour = Personne.FREELANCE;
				break;
			case "demandeurDEmploi":
				retour = Personne.DEMANDEUR;
				break;
			case "retraite":
				retour = Personne.RETRAITE;
				break;
			case "autre":
				retour = Personne.AUTRE + ":" + champsAutre;
				break;
			default:
				break;
			}

		} catch (Exception e) {

		}

		return retour;
	}

	public String fonctionVerif(String fonction) {
		String retour = "";
		try {
			if (fonction.matches("[a-zאבגהחטיךכלםמןסעףפצשתûü\\-\\'\\s]*")) {
				retour = fonction;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public boolean cadreVerif(String cadre) {
		boolean retour = false;
		try {
			cadre = cadre.toLowerCase();
			if (cadre.equals("cadre")) {
				retour = true;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String coeffVerif(String coeff) {
		String retour = "";
		try {
			if (coeff.matches("[0-9]+")) {
				retour = coeff;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String salaireVerif(String salaire) {
		String retour = "";
		try {
			if (salaire.matches("[0-9]*")) {
				retour = salaire;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public Date visiteMedicaleVerif(String visiteMedicale) {
		Date retour = new Date();
		try {
			String s = visiteMedicale;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			retour = sdf.parse(s);
		} catch (Exception e) {

		}

		return retour;
	}

	public String montantTransportVerif(String montantTransport) {
		String retour = "";
		try {
			if (montantTransport.matches("[0-9]*")) {
				retour = montantTransport;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public boolean voitureVerif(String voiture) {
		boolean retour = false;
		try {
			voiture = voiture.toLowerCase();
			if (voiture.equals("oui")) {
				retour = true;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public int nbCVVerif(String nbCV) {
		int retour = 0;
		try {
			if (nbCV.matches("[0-9]+")) {
				retour = Integer.valueOf(nbCV);
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String nbKm(String nbKm) {
		String retour = "";
		try {
			if (nbKm.matches("[0-9]+")) {
				retour = nbKm;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public boolean mutuelleVerif(String mutuelle) {
		boolean retour = false;
		try {
			mutuelle = mutuelle.toLowerCase();
			if (mutuelle.equals("oui")) {
				retour = true;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public boolean ticketRestoVerif(String ticketResto) {
		boolean retour = false;
		try {
			ticketResto = ticketResto.toLowerCase();
			if (ticketResto.equals("oui")) {
				retour = true;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public Date dateCreationVerif(String dateCreation) {
		Date retour = null;
		try {
			String s = dateCreation;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			retour = sdf.parse(s);
		} catch (Exception e) {

		}

		return retour;
	}

	public Timestamp dateModificationVerif(String dateModification) {
		Timestamp retour = null;
		try {
			String s = dateModification;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			retour = (Timestamp) sdf.parse(s);
		} catch (Exception e) {

		}

		return retour;
	}

	public boolean bloqueVerif(String bloque) {
		boolean retour = false;
		try {
			bloque = bloque.toLowerCase();
			if (bloque.equals("oui")) {
				retour = true;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String raisonBlocageVerif(String raisonBlocage) {
		String retour = "";
		if (raisonBlocage.matches("[a-zאבגהחטיךכלםמןסעףפצשתûü\\-\\'\\s]*")) {
			retour = raisonBlocage;
		}

		return retour;
	}

	ListeDoc listDocVerif(String listDoc) {
		ListeDoc retour = null;
		if (listDoc.matches("[a-zA-Z]*")) {

		}

		return retour;
	}

}
