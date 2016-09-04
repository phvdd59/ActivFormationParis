package com.formation.ajee.veriffom;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import com.formation.ajee.metier.ListeDoc;
import com.formation.ajee.metier.SEXE;
import com.formation.ajee.metier.SITUATION;

public class VerifForm {

	public String nomVerif(String nom) {
		String retour = "";
		try {
		if (nom.matches("[A-Za-zабвдзийклмнопстуфцщъыь\\-\\']*") &&nom.length()<=100) {
				retour = nom;
			}
		} catch (Exception e) {
			
		}

		return retour;
	}

	public String prenomVerif(String prenom) {
		String retour = "";
		try {
			if (prenom.matches("[A-Za-zабвдзийклмнопстуфцщъыь]*")&&prenom.length()<=100) {
				retour = prenom;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}

		return retour;
	}

	public SEXE sexeVerif(String sexe) {
		SEXE retour =null;
		try {
			sexe = sexe.toUpperCase();
			if (sexe.equals("MASCULIN")) {
				retour = SEXE.MASCULIN;
			} else if (sexe.equals("FEMININ")) {
				retour = SEXE.FEMINIM;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String identifiantVerif(String identifiant) {
		String retour = "";
		try {
			if (identifiant.matches("[A-Za-zабвдзийклмнопстуфцщъыь]*")&&identifiant.length()<=100 ) {
				retour = identifiant;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String mdpVerif(String mdp) {
		String retour = "";
		try {
			if (mdp.matches("[0-9A-Za-z]*")&&mdp.length()<=100) {
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
		
			if (adresse.matches("[0-9A-Za-zабвдзийклмнопстуфцщъыь\\s\\-\\,]*")&&adresse.length()<=100) {
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
			if (ville.matches("[a-zабвдзийклмнопстуфцщъыь\\-\\'\\s]*")&&ville.length()<100) {
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
			if (telPort.matches("[0-9]{10}") && (telPort.substring(0, 1).equals("06") || telPort.substring(0, 1).equals("07"))) {
				retour = telPort;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String faxVerif(String fax) {
		String retour =null;
		try {
			char premierchiffre = fax.charAt(0);
			char deuxiemechiffre = fax.charAt(1);
			if (fax.matches("[0-9]{10}") && (premierchiffre != '0' && deuxiemechiffre != '6' && deuxiemechiffre != '7' && deuxiemechiffre != '0')) {

				retour = fax;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public Date dateNaissanceVerif(String dateNaissance) {
		Date retour =null;
		try {
			String s = dateNaissance;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			retour = sdf.parse(s);
		} catch (Exception e) {

		}

		return retour;
	}

	public String lieuNaissanceVerif(String lieuNaissance) {
		String retour = "";
		try {
			if (lieuNaissance.matches("[^A-Za-zь-я]*") == false) {
				retour = lieuNaissance;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String numSecuVerif(String numSecu) {
		String retour = "";
		try {
			if (numSecu.matches("^[12][0-9]{2}[0-1][0-9](2[AB]|[0-9]{2})[0-9]{3}[0-9]{3}[0-9]{2}") == false) {
				retour = numSecu;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String nationaliteVerif(String nationalite) {
		String retour = "";
		try {
			nationalite = nationalite.toLowerCase();
			if (nationalite.matches("[^a-zь-я]*") == false) {
				retour = nationalite;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public SITUATION situationVerif(String situation) {
		SITUATION retour = null;
		try {
			situation = situation.toLowerCase();

			switch (situation) {
			case "salarie":
				retour = SITUATION.SALARIE;
				break;
			case "auto entrepreneur":
				retour = SITUATION.AUTO_ENTREPRENEUR;
				break;
			case "freelance":
				retour = SITUATION.FREELANCE;
				break;
			case "demandeur d'emplois":
				retour = SITUATION.DEMANDEUR;
				break;
			case "retraite":
				retour = SITUATION.RETRAITE;
				break;
			case "autre":
				retour = SITUATION.AUTRE;
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
			if (fonction.matches("[^A-Za-zь-я]*") == false) {
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
			if (coeff.matches("[^0-9]*") == false) {
				retour = coeff;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String salaireVerif(String salaire) {
		String retour = "";
		try {
			if (salaire.matches("[^0-9]*") == false) {
				retour = salaire;
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public Date visiteMedicaleVerif(String visiteMedicale) {
		Date retour =null;
		try {
			String s = visiteMedicale;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
			retour = sdf.parse(s);
		} catch (Exception e) {

		}

		return retour;
	}

	public String montantTransportVerif(String montantTransport) {
		String retour = "";
		try {
			if (montantTransport.matches("[^0-9]*") == false) {
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
			if (nbCV.matches("[^0-9]*") == false) {
				retour = Integer.valueOf(nbCV);
			}
		} catch (Exception e) {

		}

		return retour;
	}

	public String nbKm(String nbKm) {
		String retour = "";
		try {
			if (nbKm.matches("[^0-9]*") == false) {
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
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
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
		if (raisonBlocage.matches("[a-zA-Z]*")) {

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
