package com.formation.ajee.metier;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

import com.formation.ajee.dao.DaoPersonne;

public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int FEMINIM = 0;
	public static final int MASCULIN = 1;

	public static final String SALARIE = "salarie";
	public static final String AUTO_ENTREPRENEUR = "auto entrepreneur";
	public static final String FREELANCE = "freelance";
	public static final String DEMANDEUR = "demandeur d'emplois";
	public static final String RETRAITE = "retraite";
	public static final String AUTRE = "autre";

	private int idPersonne;
	private String nom;
	private String prenom;
	private int sexe;
	private String identifiant;
	private String mdp;
	private String email;

	private String adresse;
	private String cp;
	private String ville;
	private String telFixe;
	private String telPort;
	private String fax;

	private Date dateNaissance;
	private String lieuNaissance;
	private String numSecu;
	private String nationalite;

	private String situation;
	private String fonction;
	private String positionEntreprise;
	private boolean cadre;
	private String coeff;
	private String salaire;

	private Date visiteMedicale;
	private String montantTransport;

	private boolean voiture;
	private int nbCV;
	private String nbKm;

	private boolean mutuelle;
	private boolean ticketResto;
	private Date dateCreation;
	private Date dateModification;
	private boolean bloque;
	private String raisonBlocage;
	private ListeDoc listeDoc;

	public Personne() {
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
		this.situation = null;
		this.visiteMedicale = new Date();
		this.dateNaissance = new Date();
	}

	public Personne(int idPersonne, String nom, String prenom, String identifiant, String mdp, int sexe, String email, String adresse, String cp, String ville, String telFixe, String telPort, String fax, Date dateNaissance, String lieuNaissance, String numSecu, String nationalite, String situation, String fonction,
			String positionEntreprise, boolean cadre, String coeff, String salaire, Date visiteMedicale, String montantTransport, boolean voiture, int nbCV, String nbKm, boolean mutuelle, boolean ticketResto, Date dateCreation, Date dateModification, boolean bloque, String raisonBlocage) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.sexe=sexe;
		this.email = email;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telFixe = telFixe;
		this.telPort = telPort;
		this.fax = fax;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.numSecu = numSecu;
		this.nationalite = nationalite;
		this.situation=situation;
		this.fonction = fonction;
		this.positionEntreprise = positionEntreprise;
		this.cadre = cadre;
		this.coeff = coeff;
		this.salaire = salaire;
		this.visiteMedicale = visiteMedicale;
		this.montantTransport = montantTransport;
		this.voiture = voiture;
		this.nbCV = nbCV;
		this.nbKm = nbKm;
		this.mutuelle = mutuelle;
		this.ticketResto = ticketResto;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.bloque = bloque;
		this.raisonBlocage = raisonBlocage;
	}

	public Personne(int idPersonne, String nom, String prenom, int sexe, String identifiant, String mdp, String email, String adresse, String cp, String ville, String telFixe, String telPort, String fax, Date dateNaissance, String lieuNaissance, String numSecu, String nationalite, String situation,
			String fonction, String positionEntreprise, boolean cadre, String coeff, String salaire, Date visiteMedicale, String montantTransport, boolean voiture, int nbCV, String nbKm, boolean mutuelle, boolean ticketResto, Date dateCreation, Date dateModification, boolean bloque,
			String raisonBlocage, ListeDoc listeDoc) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.sexe = sexe;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.email = email;
		this.adresse = adresse;
		this.cp = cp;
		this.ville = ville;
		this.telFixe = telFixe;
		this.telPort = telPort;
		this.fax = fax;
		this.dateNaissance = dateNaissance;
		this.lieuNaissance = lieuNaissance;
		this.numSecu = numSecu;
		this.nationalite = nationalite;
		this.situation = situation;
		this.fonction = fonction;
		this.positionEntreprise = positionEntreprise;
		this.cadre = cadre;
		this.coeff = coeff;
		this.salaire = salaire;
		this.visiteMedicale = visiteMedicale;
		this.montantTransport = montantTransport;
		this.voiture = voiture;
		this.nbCV = nbCV;
		this.nbKm = nbKm;
		this.mutuelle = mutuelle;
		this.ticketResto = ticketResto;
		this.dateCreation = dateCreation;
		this.dateModification = dateModification;
		this.bloque = bloque;
		this.raisonBlocage = raisonBlocage;
		this.listeDoc = listeDoc;
	}

	public void ajoutPersonne(int idPersonne) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		this.dateCreation = new Date();
		this.dateModification = new Date();
		DaoPersonne daoP = new DaoPersonne();
		daoP.insertPersonne(this);

	}

	public void modifPersonne(int idPersonne) {
		this.dateModification = new Date();
		DaoPersonne daoP = new DaoPersonne();
		daoP.updatePersonne(this);
	}

	public String epuration(String texte) {
		texte = texte.toLowerCase();
		texte = texte.replaceAll("[àâã]", "a");
		texte = texte.replaceAll("[éèêë]", "e");
		texte = texte.replaceAll("ù", "u");
		texte = texte.replaceAll("ç", "c");
		texte = texte.replaceAll("ôõ", "o");
		texte = texte.replaceAll("[îï]", "i");
		texte = texte.replaceAll("\\s+", "");
		return texte;
	}

	public String creationId(String nom, String prenom) {

		String nomE = epuration(nom);
		String prenomE = epuration(prenom);
		String identifiant = prenomE.substring(0, 1) + "." + nomE;

		return identifiant;
	}

	public String creationMdp() {
		String mdp = "";
		while (mdp.length() != 8) {
			int a = (int) (Math.random() * 123);
			char lettre = (char) a;
			if (a > 47 && a < 58) {
				mdp = mdp + lettre;
			} else if (a > 96 && a < 123) {
				mdp = mdp + lettre;
			} else if (a > 64 && a < 91) {
				mdp = mdp + lettre;
			}
		}
		return mdp;
	}

	public int getIdPersonne() {
		return idPersonne;
	}

	public String getIdPersonneString() {
		return Integer.toString(idPersonne);
	}

	public String getNom() {
		if (nom == null || nom.equals("null")) {
			nom = "";
		}
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		if (prenom == null || prenom.equals("null")) {
			prenom = "";
		}
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getSexe() {
		return sexe;
	}

	public void setSexe(int sexe) {
		this.sexe = sexe;
	}

	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		if (email == null || email.equals("null")) {
			email = "";
		}
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		if (adresse == null || adresse.equals("null")) {
			adresse = "";
		}
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		if (cp == null || cp.equals("null")) {
			cp = "";
		}
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		if (ville == null || ville.equals("null")) {
			ville = "";
		}
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelFixe() {
		if (telFixe == null || telFixe.equals("null")) {
			telFixe = "";
		}
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getTelPort() {
		if (telPort == null || telPort.equals("null")) {
			telPort = "";
		}
		return telPort;
	}

	public void setTelPort(String telPort) {
		this.telPort = telPort;
	}

	public String getFax() {
		if (fax == null || fax.equals("null")) {
			fax = "";
		}
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public String getDateNaissanceString() {
		String datenaissance = "";
		if (dateNaissance != null) {
			SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy");
			datenaissance = formatDateJour.format(dateNaissance);
		}
		return datenaissance;
	}
	
	public String getDateNaissanceStringDAO() {
		String datenaissance = "";
		if (dateNaissance != null) {
			SimpleDateFormat formatDateJour = new SimpleDateFormat("yyyy-MM-dd");
			datenaissance = formatDateJour.format(dateNaissance);
		}
		return datenaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		if (lieuNaissance == null || lieuNaissance.equals("null")) {
			lieuNaissance = "";
		}
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getNumSecu() {
		if (numSecu == null || numSecu.equals("null")) {
			numSecu = "";
		}
		return numSecu;
	}

	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	public String getNationalite() {
		if (nationalite == null || nationalite.equals("null")) {
			nationalite = "";
		}
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getSituation() {
		if (situation == null || situation.equals("null")) {
			situation = "";
		}
		return situation;
	}

	public String getSituationString() {

		String retour = "";
		if (situation != null || situation.equals(AUTO_ENTREPRENEUR) || situation.equals(RETRAITE) || situation.equals(AUTRE) || situation.equals(FREELANCE) || situation.equals(SALARIE) || situation.equals(DEMANDEUR)) {
			
			retour = situation;
		}

		return retour;
	}

	public void setSituation(String situation) {
		this.situation = situation;
	}

	public String getFonction() {
		if (fonction == null || fonction.equals("null")) {
			fonction = "";
		}
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getPositionEntreprise() {
		if (positionEntreprise == null || positionEntreprise.equals("null")) {
			positionEntreprise = "";
		}
		return positionEntreprise;
	}

	public void setPositionEntreprise(String positionEntreprise) {
		this.positionEntreprise = positionEntreprise;
	}

	public boolean isCadre() {
		return cadre;
	}

	public void setCadre(boolean cadre) {
		this.cadre = cadre;
	}

	public String getCoeff() {
		if (coeff == null || coeff.equals("null")) {
			coeff = "";
		}
		return coeff;
	}

	public void setCoeff(String coeff) {
		this.coeff = coeff;
	}

	public String getSalaire() {
		if (salaire == null || salaire.equals("null")) {
			salaire = "";
		}
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	public Date getVisiteMedicale() {
		return visiteMedicale;
	}

	public String getVisiteMedicaleString() {
		String visitemedicale = "";
		if (visiteMedicale != null) {
			SimpleDateFormat formatDateJour = new SimpleDateFormat("dd/MM/yyyy");
			visitemedicale = formatDateJour.format(visiteMedicale);
		}
		return visitemedicale;
	}

	public String getVisiteMedicaleStringDAO() {
		String visitemedicale = "";
		if (visiteMedicale != null) {
			SimpleDateFormat formatDateJour = new SimpleDateFormat("yyyy-MM-dd");
			visitemedicale = formatDateJour.format(visiteMedicale);
		}
		return visitemedicale;
	}
	
	public void setVisiteMedicale(Date visiteMedicale) {
		this.visiteMedicale = visiteMedicale;
	}

	public String getMontantTransport() {
		if (montantTransport == null || montantTransport.equals("null")) {
			montantTransport = "";
		}
		return montantTransport;
	}

	public void setMontantTransport(String montantTransport) {
		this.montantTransport = montantTransport;
	}

	public boolean isVoiture() {
		return voiture;
	}

	public String getVoiture() {
		String voiture = "";
		if (isMutuelle() == false) {
			voiture = "non";
		} else {
			voiture = "oui";
		}
		return voiture;
	}

	public void setVoiture(boolean voiture) {
		this.voiture = voiture;
	}

	public int getNbCV() {
		return nbCV;
	}

	public String getNbCVString() {
		return Integer.toString(nbCV);
	}

	public void setNbCV(int nbCV) {
		this.nbCV = nbCV;
	}

	public String getNbKm() {
		if (nbKm == null || nbKm.equals("null")) {
			nbKm = "";
		}
		return nbKm;
	}

	public void setNbKm(String nbKm) {
		this.nbKm = nbKm;
	}

	public boolean isMutuelle() {
		return mutuelle;
	}

	public String getMutuelle() {
		String mutuelle = "";
		if (isMutuelle() == false) {
			mutuelle = "non";
		} else {
			mutuelle = "oui";
		}
		return mutuelle;
	}

	public void setMutuelle(boolean mutuelle) {
		this.mutuelle = mutuelle;
	}

	public boolean isTicketResto() {
		return ticketResto;
	}

	public String getTicketResto() {
		String ticketResto = "";
		if (isMutuelle() == false) {
			ticketResto = "non";
		} else {
			ticketResto = "oui";
		}
		return ticketResto;
	}

	public void setTicketResto(boolean ticketResto) {
		this.ticketResto = ticketResto;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public String getDateCreationString() {
		String sDateCreation = "";
		if (dateCreation != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			sDateCreation = df.format(dateCreation);
		}
		return sDateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Date getDateModification() {
		return dateModification;
	}

	public String getDateModificationString() {
		String sDateModification = "";
		if (dateModification != null) {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			sDateModification = df.format(dateModification);
		}
		return sDateModification;
	}

	public void setDateModification(Date dateModification) {
		this.dateModification = dateModification;
	}

	public boolean isBloque() {
		return bloque;
	}

	public void setBloque(boolean bloque) {
		this.bloque = bloque;
	}

	public String getRaisonBlocage() {
		return raisonBlocage;
	}

	public void setRaisonBlocage(String raisonBlocage) {
		this.raisonBlocage = raisonBlocage;
	}

	public ListeDoc getListeDoc() {
		return listeDoc;
	}

	public void setListeDoc(ListeDoc listeDoc) {
		this.listeDoc = listeDoc;
	}

}