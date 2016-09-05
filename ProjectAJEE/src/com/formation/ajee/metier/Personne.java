package com.formation.ajee.metier;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;

import com.formation.ajee.dao.DaoPersonne;

public class Personne implements Serializable {
	private static final long serialVersionUID = 1L;
	public static final int FEMINIM = 0;
	public static final int MASCULIN = 1;

	private int idPersonne;
	private String nom;
	private String prenom;
	private SEXE sexe;
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

	private SITUATION situation;
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
	private Timestamp dateModification;
	private boolean bloque;
	private String raisonBlocage;
	private ListeDoc listeDoc;

	public Personne() {
	}

	public Personne(int idPersonne, String nom, String prenom, String identifiant, String mdp) {
		this.idPersonne = idPersonne;
		this.identifiant = identifiant;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Personne(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
//		this.visiteMedicale = new Date(2016 - 9 - 02); 		//mettre une valeur par default
//		this.dateNaissance = new Date(2016 - 9 - 02);
//		this.dateCreation = new Date(2016 - 9 - 02);
//		this.situation=SITUATION.AUTRE;
	}
	
	public Personne(int idPersonne, String nom, String prenom, String identifiant, String mdp, String email, String adresse, String cp, String ville, String telFixe, String telPort, String fax, Date dateNaissance, String lieuNaissance, String numSecu, String nationalite,
			String fonction, String positionEntreprise, boolean cadre, String coeff, String salaire, Date visiteMedicale, String montantTransport, boolean voiture, int nbCV, String nbKm, boolean mutuelle, boolean ticketResto, Date dateCreation, Timestamp dateModification,
			boolean bloque, String raisonBlocage) {
		super();
		this.idPersonne = idPersonne;
		this.nom = nom;
		this.prenom = prenom;
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
		this.dateCreation = Date.from(Instant.now());
		this.dateModification = dateModification;
		this.bloque = bloque;
		this.raisonBlocage = raisonBlocage;
	}

	public Personne(int idPersonne, String nom, String prenom, SEXE sexe, String identifiant, String mdp, String email, String adresse, String cp, String ville, String telFixe, String telPort, String fax, Date dateNaissance, String lieuNaissance, String numSecu, String nationalite,
			SITUATION situation, String fonction, String positionEntreprise, boolean cadre, String coeff, String salaire, Date visiteMedicale, String montantTransport, boolean voiture, int nbCV, String nbKm, boolean mutuelle, boolean ticketResto, Date dateCreation, Timestamp dateModification,
			boolean bloque, String raisonBlocage, ListeDoc listeDoc) {
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
		this.dateCreation = Date.from(Instant.now());
		this.dateModification = dateModification;
		this.bloque = bloque;
		this.raisonBlocage = raisonBlocage;
		this.listeDoc = listeDoc;
	}
	
	public void ajoutPersonne(int idPersonne){
	DaoPersonne daoP = new DaoPersonne();
		daoP.insertPersonne(this);
	}
	
	public void modifPersonne(int idPersonne){
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
		texte = texte.replaceAll("\\s+", " ");
		return texte;
	}

	public String creationId(String nom, String prenom) {

		String nomE = epuration(nom);
		String prenomE = epuration(prenom);
		String identifiant = prenomE.substring(0, 1) + "." + nomE;

		return identifiant;
	}
	
	public String creationMdp() {
		String mdp = " ";
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

	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public SEXE getSexe() {
		return sexe;
	}

	public void setSexe(SEXE sexe) {
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
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCp() {
		return cp;
	}

	public void setCp(String cp) {
		this.cp = cp;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelFixe() {
		return telFixe;
	}

	public void setTelFixe(String telFixe) {
		this.telFixe = telFixe;
	}

	public String getTelPort() {
		return telPort;
	}

	public void setTelPort(String telPort) {
		this.telPort = telPort;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getLieuNaissance() {
		return lieuNaissance;
	}

	public void setLieuNaissance(String lieuNaissance) {
		this.lieuNaissance = lieuNaissance;
	}

	public String getNumSecu() {
		return numSecu;
	}

	public void setNumSecu(String numSecu) {
		this.numSecu = numSecu;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getSituation() {
		return situation.getNom();
	}

	public void setSituation(SITUATION situation) {
		this.situation = situation;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public String getPositionEntreprise() {
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
		return coeff;
	}

	public void setCoeff(String coeff) {
		this.coeff = coeff;
	}

	public String getSalaire() {
		return salaire;
	}

	public void setSalaire(String salaire) {
		this.salaire = salaire;
	}

	public Date getVisiteMedicale() {
		return visiteMedicale;
	}

	public void setVisiteMedicale(Date visiteMedicale) {
		this.visiteMedicale = visiteMedicale;
	}

	public String getMontantTransport() {
		return montantTransport;
	}

	public void setMontantTransport(String montantTransport) {
		this.montantTransport = montantTransport;
	}

	public boolean isVoiture() {
		return voiture;
	}

	public void setVoiture(boolean voiture) {
		this.voiture = voiture;
	}

	public int getNbCV() {
		return nbCV;
	}

	public void setNbCV(int nbCV) {
		this.nbCV = nbCV;
	}

	public String getNbKm() {
		return nbKm;
	}

	public void setNbKm(String nbKm) {
		this.nbKm = nbKm;
	}

	public boolean isMutuelle() {
		return mutuelle;
	}

	public void setMutuelle(boolean mutuelle) {
		this.mutuelle = mutuelle;
	}

	public boolean isTicketResto() {
		return ticketResto;
	}

	public void setTicketResto(boolean ticketResto) {
		this.ticketResto = ticketResto;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	public Timestamp getDateModification() {
		return dateModification;
	}

	public void setDateModification(Timestamp dateModification) {
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