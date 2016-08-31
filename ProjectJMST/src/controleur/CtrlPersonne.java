package controleur;

import java.util.regex.Pattern;

public class CtrlPersonne implements InterCtrlPersonne {

	@Override
	public boolean ctrlNom(String nom) {
		if (nom == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z\\-\\'\\s]+", nom)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlPrenom(String prenom) {
		if (prenom == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z\\-\\'\\s]+", prenom)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlIdentifiant(String identifiant) {
		if (identifiant == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z0-9\\-\\.\\_]{4,25}", identifiant)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlMdp(String mdp) {
		if (mdp != null) {
			if (mdp.length() >= 6 && !mdp.contains(" ")) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlEmail(String email) {
		if (email == null) {
			return false;
		} else if (Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", email)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlAdresse(String adresse) {
		if (adresse == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z0-9\\-\\'\\s\\(\\)]+", adresse)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlCp(String cp) {
		if (cp == null) {
			return false;
		} else if (Pattern.matches("[0-9]{5}", cp)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlVille(String ville) {
		if (ville == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z\\-\\'\\s]+", ville)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlTelFixe(String telFixe) {
		if (telFixe == null) {
			return false;
		} else if (Pattern.matches("[0-9]{9}", telFixe)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlTelPort(String telPort) {
		if (telPort == null) {
			return false;
		} else if (Pattern.matches("[0-9]{9}", telPort)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlFax(String fax) {
		if (fax == null) {
			return false;
		} else if (Pattern.matches("[0-9]{9}", fax)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlDateNaissance(String dateNaissance) {
		if (dateNaissance == null) {
			return false;
		} else if (Pattern.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$", dateNaissance)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlLieuNaissance(String lieuNaissance) {
		if (lieuNaissance == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z\\-\\'\\s]+", lieuNaissance)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlNumSecu(String numSecu) {
		if (numSecu == null) {
			return false;
		} else if (Pattern.matches("(1|2)[0-9]{14}", numSecu)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlNationalite(String nationalite) {
		if (nationalite == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z\\-\\s]+", nationalite)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlSituation(String situation) {
		if (situation == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z\\-\\'\\s]+", situation)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlFonction(String fonction) {
		if (fonction == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z\\-\\'\\s]+", fonction)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlPosition(String position) {
		if (position == null) {
			return false;
		} else if (Pattern.matches("[a-zA-Z\\-\\'\\s]+", position)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlCadre(String cadre) {
		if (cadre == null) {
			return false;
		} else if (cadre.equals("Cadre") || cadre.equals("Non cadre")) {
			return true;
		} else {
			return false;
		}
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
	public boolean ctrlVisiteMedicale(String visiteMedicale) {
		if (visiteMedicale == null) {
			return false;
		} else if (Pattern.matches("^(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)$", visiteMedicale)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlMontantTransport(String montantTransport) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean ctrlVoiture(String voiture) {
		if (voiture == null) {
			return false;
		} else if (voiture.equals("oui") || voiture.equals("non")) {
			return true;
		} else {
			return false;
		}
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

		if (mutuelle == null) {
			return false;
		} else if (mutuelle.equals("oui") || mutuelle.equals("non")) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean ctrlTicketResto(String ticketResto) {
		if (ticketResto == null) {
			return false;
		} else if (ticketResto.equals("oui") || ticketResto.equals("non")) {
			return true;
		} else {
			return false;
		}
	}

}
