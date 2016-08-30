package controleur;

import java.sql.Timestamp;
import java.util.Date;

import com.formation.thcr.metier.ListeDoc;
import com.formation.thcr.metier.Personne;
import com.formation.thcr.metier.SEXE;

public class CtrlPersonne implements InterCtrlPersonne{

	Personne personne;

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public boolean ctrlIdPersonne(int idPersonne) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNom(String nom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlPrenom(String prenom) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlSexe(SEXE sexe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlIdentifiant(String identifiant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlMdp(String mdp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlAdresse(String adresse) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlCp(String cp) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlVille(String ville) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlTelFixe(String telFixe) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlTelPort(String telPort) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlFax(String fax) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlDateNaissance(Date dateNaissance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlLieuNaissance(String lieuNaissance) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNumSecu(String numSecu) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNationalite(String nationalite) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlSituation(String situation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlFonction(String fonction) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlPosition(String position) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlCadre(boolean cadre) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlCoeff(String coeff) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlSalaire(String salaire) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlVisiteMedicale(Date visiteMedicale) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlMontantTransport(String montantTransport) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlVoiture(boolean voiture) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNbCV(int nbCV) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNbKm(String nbKm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlMutuelle(boolean mutuelle) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlTicketResto(boolean ticketResto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlAdmin(boolean admin) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlDateCreation(Date dateCreation) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlDateModification(Timestamp dateModification) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlBloque(boolean bloque) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlRaisonBlocage(String raisonBlocage) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlListeDoc(ListeDoc listeDoc) {
		// TODO Auto-generated method stub
		return false;
	}

}
