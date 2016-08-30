package controleur;

import java.util.Date;

public class CtrlPersonne implements InterCtrlPersonne {

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
	public boolean ctrlSexe(String sexe) {
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
	public boolean ctrlCadre(String cadre) {
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
	public boolean ctrlVoiture(String voiture) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNbCV(String nbCV) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlNbKm(String nbKm) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlMutuelle(String mutuelle) {
		try {
			if (mutuelle.equals("oui") || mutuelle.equals("non")) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean ctrlTicketResto(String ticketResto) {
		// TODO Auto-generated method stub
		return false;
	}

}
