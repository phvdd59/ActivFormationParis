package com.formation.joca.controleur;

public interface InterCtrlPersonne {

	public boolean ctrlNom(String nom);

	public boolean ctrlPrenom(String prenom);

	public boolean ctrlIdentifiant(String identifiant);

	public boolean ctrlMdp(String mdp);

	public boolean ctrlEmail(String email);

	public boolean ctrlAdresse(String adresse);

	public boolean ctrlCp(String cp);

	public boolean ctrlVille(String ville);

	public boolean ctrlTelFixe(String telFixe);

	public boolean ctrlTelPort(String telPort);

	public boolean ctrlFax(String fax);

	public boolean ctrlDateNaissance(String dateNaissance);

	public boolean ctrlLieuNaissance(String lieuNaissance);

	public boolean ctrlNumSecu(String numSecu);

	public boolean ctrlNationalite(String nationalite);

	public boolean ctrlSituation(String situation);

	public boolean ctrlFonction(String fonction);

	public boolean ctrlPosition(String position);

	public boolean ctrlCadre(String cadre);

	public boolean ctrlCoeff(String coeff);

	public boolean ctrlSalaire(String salaire);

	public boolean ctrlVisiteMedicale(String visiteMedicale);

	public boolean ctrlMontantTransport(String montantTransport);

	public boolean ctrlVoiture(String voiture);

	public boolean ctrlNbCV(String nbCV);

	public boolean ctrlNbKm(String nbKm);

	public boolean ctrlMutuelle(String mutuelle);

	public boolean ctrlTicketResto(String ticketResto);

}
