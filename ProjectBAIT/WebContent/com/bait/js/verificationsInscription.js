// //____ verifications generales ____

function surligne(champ, erreur) {
	if (erreur) {
		champ.style.backgroundColor = "#fba";
	} else {
		champ.style.backgroundColor = "";
	}
}

function verifVide(champ) {
	if (champ.value == '') {
		return false;
	} else {
		return true;
	}
}

function verifTaille(champ, min, max) {
	if (champ.value.length <= max && champ.value.length >= min) {
		return true;
	} else {
		return false;
	}
}

function verifExisteDeja(champ) {
	// pour l'instant, m\352me chose que Vide. A changer.
	if (champ.value == '') {
		return false;
	} else {
		return true;
	}
}

function verifLettres(champ) {
	if (!champ.value.match(".*\\d+.*")) {
		return true;
	} else {
		return false;
	}
}

// ____ verifications specifiques ____

function verifIdentifiant(champ) {
	if ((verifTaille(champ, 4, 30)) && (verifExisteDeja(champ))) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifMdp1(champ) {
	if (verifTaille(champ, 6, 30) && (champ.value.match(".*\\d+.*"))
			&& (champ.value.match(".*\\w+.*"))) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifMdp2(champ) {
	if (document.getElementById("MDP1").value == document
			.getElementById("MDP2").value) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifAdresse(champ) {
	if (verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifCodePostal(champ) {
	if ((verifTaille(champ, 5, 5)) && (!verifLettres(champ))) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifTel(champ) {
	var tel = champ.value.replace(/ /g, "");
	if ((tel.match(/^(\+|00)[0-9]{10}$/)) || (tel.match(/^(\+|00)[0-9]{11}$/))
			|| (tel.match(/^(\+|00)[0-9]{12}$/))
			|| (tel.match(/^(0)[0-9]{9}$/))) {
		surligne(champ, false);
		champ.value = tel;
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifEmail(champ) {
	var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	if (re.test(champ.value)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifNom(champ) {
	if (verifVide(champ) && (verifLettres(champ))) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifNomOptionnel(champ) {
	if (!verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else if (verifLettres(champ)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifDateNaissance(champ) {
	if ((champ.value.match(/^[0-3][0-9]\/[0-1][0-9]\/[1-2][0-9]{3}$/))) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifSecu(champ) {

	var secu = champ.value.replace(/ /g, "");
	champ.value = secu;
	if (!verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else if (verifTaille(champ, 15, 15) && (!verifLettres(champ))) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifPosition(champ) {
	var re = /^[0-9]+\.[0-9]+\.?[0-9]?$/;
	if (!verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else if (re.test(champ.value)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifSalaire(champ) {
	if (!verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else if (!verifLettres(champ)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifCoefficient(champ) {
	// if (verifVide(champ)) {
	// surligne(champ, false);
	return true;
	// } else {
	// surligne(champ, true);
	// return false;
	// }
}
function verifDate(champ) {
	if (!verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else if (champ.value.match(/^[0-3][0-9]\/[0-1][0-9]\/[1-2][0-9]{3}$/)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}

}
function verifMontantTransport(champ) {
	var re = /^\d+.*\d*$/;
	if (!verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else if (re.test(champ.value)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifNbCV(champ) {
	if (!verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else if (!verifLettres(champ)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifKmMensuel(champ) {
	var re = /^\d+.*\d*$/;
	if (!verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else if (re.test(champ.value)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifSitAutre(champ) {
	if (document.getElementById("autreSit").checked) {
		if (verifVide(champ)) {
			surligne(champ, false);
			return true;
		} else {
			surligne(champ, true);
			return false;
		}
	} else {
		surligne(champ, false);
		return true;
	}
}

// ____ Dernière verifs au submit ____
function verifInscription1(f) {
	var alerttotal = "";
	if (verifIdentifiant(f.identifiant) == false) {
		alerttotal = alerttotal
				+ "L'identifiant doit \352tre compos\351 de 4 \340 30 caract\350res \n";
	}
	if (verifMdp1(f.mdp1) == false) {
		alerttotal = alerttotal
				+ "Le mot de passe doit \352tre compos\351 de 6 \340 30 caract\350res dont une lettre et un chiffre \n";
	}
	if (verifMdp2(f.mdp2) == false) {
		alerttotal = alerttotal + "Les mots de passe ne sont pas identiques \n";
	}
	if (verifEmail(f.mail) == false) {
		alerttotal = alerttotal
				+ "L'email n'est pas indiqu\351 ou est invalide \n";
	}
	if (verifNom(f.nom) == false) {
		alerttotal = alerttotal
				+ "Le nom n'est pas indiqu\351 ou il contient un chiffre \n";
	}
	if (verifNom(f.prenom) == false) {
		alerttotal = alerttotal
				+ "Le pr\351nom n'est pas indiqu\351 ou il contient un chiffre \n";
	}

	if (verifIdentifiant(f.identifiant) == false || verifMdp1(f.mdp1) == false
			|| verifMdp2(f.mdp2) == false || verifNom(f.nom) == false
			|| verifNom(f.prenom) == false) {
		alert(alerttotal);
		return false;
	} else {
		return true;
	}
}

function verifCoordonnees(f) {
	var alerttotal = "";
	if (verifAdresse(f.adresse) == false) {
		alerttotal = alerttotal + "L'adresse n'est pas indiqu\351e \n";
	}
	if (verifCodePostal(f.cp) == false) {
		alerttotal = alerttotal
				+ "Le code postal doit \352tre compos\351 de 5 chiffes \n";
	}
	if (verifNom(f.ville) == false) {
		alerttotal = alerttotal
				+ "La ville n'est pas indiqu\351e ou elle contient un chiffre \n";
	}
	if ((verifTel(f.telFixe) == false) && (verifTel(f.telPort) == false)) {
		alerttotal = alerttotal
				+ "Au moins un num\351ro de t\351l\351phone valide est n\351cessaire \n";
		f.telFixe.style.backgroundColor = "#F0E68C";
		f.telPort.style.backgroundColor = "#F0E68C";
	} else {
		f.telFixe.style.backgroundColor = "";
		f.telPort.style.backgroundColor = "";
	}
	if (verifEmail(f.email) == false) {
		alerttotal = alerttotal
				+ "L'email n'est pas indiqu\351 ou est invalide \n";
	}

	if (verifAdresse(f.adresse) == false || verifCodePostal(f.cp) == false
			|| verifNom(f.ville) == false || verifTel(f.telFixe) == false
			|| verifEmail(f.email) == false) {
		alert(alerttotal);
		return false;
	} else {
		return true;
	}
}

function verifEtatCivil(f) {
	var alerttotal = "";
	if (verifNom(f.nom) == false) {
		alerttotal = alerttotal
				+ "Le nom n'est pas indiqu\351 ou il contient un chiffre \n";
	}
	if (verifNom(f.prenom) == false) {
		alerttotal = alerttotal
				+ "Le pr\351nom n'est pas indiqu\351 ou il contient un chiffre \n";
	}
	if (verifDateNaissance(f.datenaiss) == false) {
		alerttotal = alerttotal
				+ "La date de naissance n'est pas indiqu\351e ou est invalide \n";
	}
	if (verifNomOptionnel(f.lieunaiss) == false) {
		alerttotal = alerttotal + "Le lieu de naissance contient un chiffre \n";
	}
	if (verifNomOptionnel(f.nati) == false) {
		alerttotal = alerttotal + "La nationalit\351 contient un chiffre \n";
	}
	if (verifSecu(f.secu) == false) {
		alerttotal = alerttotal
				+ "Le num\351ro de s\351curit\351 sociale est invalide \n";
	}
	if (verifNom(f.nom) == false || verifNom(f.prenom) == false
			|| verifDateNaissance(f.datenaiss) == false
			|| verifNomOptionnel(f.lieunaiss) == false
			|| verifNomOptionnel(f.nati) == false || verifSecu(f.secu) == false) {
		alert(alerttotal);
		return false;
	} else {
		return true;
	}
}

function verifRemuneration(f) {

	var alerttotal = "";
	if (verifNom(f.fonction) == false) {
		alerttotal = alerttotal
				+ "La fonction n'est pas indiqu\351e ou elle contient un chiffre \n";
	}
	if (verifPosition(f.position) == false) {
		alerttotal = alerttotal
				+ "La position souhait\351e est invalide (format ?) \n";
	}
	if (verifSalaire(f.salaire) == false) {
		alerttotal = alerttotal + "Le salaire est invalide \n";
	}
	if (verifCoefficient(f.Coefficient) == false) {
		alerttotal = alerttotal + "Le coefficient est invalide \n";
	}
	if (verifDate(f.visiteMedicale) == false) {
		alerttotal = alerttotal
				+ "La date de visite m\351dicale est invalide \n";
	}
	if (verifMontantTransport(f.montantTransport) == false) {
		alerttotal = alerttotal
				+ "Le montant transports indiqu\351 est invalide \n";
	}

	if (verifNbCV(f.nbCV) == false) {
		alerttotal = alerttotal + "Le nombre de cv indiqu\351 est invalide \n";
	}
	if (verifKmMensuel(f.nbKm) == false) {
		alerttotal = alerttotal
				+ "Le nombre de km mensuel indiqu\351 est invalide \n";
	}

	if (verifNom(f.fonction) == false || verifPosition(f.position) == false
			|| verifSalaire(f.salaire) == false
			|| verifCoefficient(f.Coefficient) == false
			|| verifDate(f.visiteMedicale) == false
			|| verifMontantTransport(f.montantTransport) == false
			|| verifNbCV(f.nbCV) == false || verifKmMensuel(f.nbKm) == false) {
		alert(alerttotal);
		return false;
	} else {
		return true;
	}
}

function verifSit(f) {
	if (verifSitAutre(f.aut) == false) {
		alert("Le champ Autre est vide");
		return false;
	} else {
		return true;
	}
}