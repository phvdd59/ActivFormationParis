package controleur;

import com.formation.thcr.metier.Personne;

public class CtrlPersonne {

	Personne personne;

	public CtrlPersonne(Personne personne) {
		super();
		this.personne = personne;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public boolean CtrlNom() {
		return true;
	}

	public boolean CtrlPrenom() {
		return true;
	}

	public boolean CtrlLogin() {
		return true;
	}

	public boolean CtrlMotDePasse() {
		return true;
	}

	public boolean CtrlMail() {
		return true;
	}

	public boolean CtrlNationalite() {
		return true;
	}

	public boolean CtrlAdresse() {
		return true;
	}

	public boolean CtrlTelFix() {
		return true;
	}

	public boolean CtrlTelPort() {
		return true;
	}

	public boolean CtrlFax() {
		return true;
	}

	public boolean CtrlVille() {
		return true;
	}

	public boolean CtrlCodePostal() {
		return true;
	}

	public boolean CtrlDateNaissance() {
		return true;
	}

	public boolean CtrlLieuNaissance() {
		return true;
	}

	public boolean CtrlNumSecu() {
		return true;
	}

	public boolean CtrlPosition() {
		return true;
	}

	public boolean CtrlCoeff() {
		return true;
	}

	public boolean CtrlSalaire() {
		return true;
	}

	public boolean CtrlVisiteMedicale() {
		return true;
	}

	public boolean CtrlMontantTransport() {
		return true;
	}

	public boolean CtrlNbCV() {
		return true;
	}

	public boolean CtrlNbKm() {
		return true;
	}

	public boolean CtrlSituation() {
		return true;
	}

	public boolean CtrlVoiture() {
		return true;
	}

	public boolean CtrlCadre() {
		return true;
	}

	public boolean CtrlMutuelle() {
		return true;
	}

	public boolean CtrlTicketResto() {
		return true;
	}

	public boolean CtrlAdmin() {
		return true;
	}

	public boolean CtrlTotal() {
		return CtrlNom() & CtrlPrenom() & CtrlLogin() & CtrlMotDePasse() & CtrlMail() & CtrlNationalite()
				& CtrlAdresse() & CtrlTelFix() & CtrlTelPort() & CtrlFax() & CtrlVille() & CtrlCodePostal()
				& CtrlDateNaissance() & CtrlLieuNaissance() & CtrlNumSecu() & CtrlPosition() & CtrlCoeff()
				& CtrlSalaire() & CtrlVisiteMedicale() & CtrlMontantTransport() & CtrlNbCV() & CtrlNbKm()
				& CtrlSituation() & CtrlVoiture() & CtrlVoiture() & CtrlCadre() & CtrlMutuelle() & CtrlTicketResto()
				& CtrlAdmin() & CtrlAdmin();
	}
}
