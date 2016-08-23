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
		// alert("Le champ doit comporter entre " + min + " et " + max
		// + " caracteres");
		return false;
	}
}

function verifExisteDeja(champ) {
	// pour l'instant, même chose que Vide. A changer.
	if (champ.value == '') {
		return false;
	} else {
		return true;
	}
}

function verifLettres(champ) {
	if ((champ.value.match("[\\w]+")) && (!champ.value.match(".*\\d+.*"))) {
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
	if (verifTaille(champ, 6, 20)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

// function verifMdp2(champ) {
// if (mdp1.value == champ.value) {
// surligne(champ, false);
// return true;
// } else {
// surligne(champ, true);
// return false;
// }
// }

function verifNom(champ) {
	if ((verifTaille(champ, 1, 20)) && (verifLettres(champ))) {
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

function verifVille(champ) {
	if (verifVide(champ)) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifTel(champ) {
	if ((verifTaille(champ, 10, 10)) && (!verifLettres(champ))) {
		surligne(champ, false);
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

// ____ Dernière verifs au submit ____
function verifInscription1(f) {
	var alerttotal = "";
	if (verifIdentifiant(f.identifiant) == false) {
		alerttotal = alerttotal + "Probleme identidiant \n";
	}
	if (verifMdp1(f.mdp1) == false) {
		alerttotal = alerttotal + "Probleme mdp \n";
	}
	// if (verifMdp2(f.mdp2)==false) {
	// alerttotal = alerttotal+"Probleme mdp2 \n";
	// }
	if (verifIdentifiant(f.identifiant) == false || verifMdp1(f.mdp1) == false) {
		alert(alerttotal);
		return false;
	} else {
		return true;
	}
}

function verifCoordonnees(f) {
	var alerttotal = "";
	if (verifAdresse(f.adresse) == false) {
		alerttotal = alerttotal + "Probleme adresse \n";
	}
	if (verifCodePostal(f.cp) == false) {
		alerttotal = alerttotal + "Probleme code postal \n";
	}
	if (verifVille(f.ville) == false) {
		alerttotal = alerttotal + "Probleme ville \n";
	}
	if (verifTel(f.tel) == false) {
		alerttotal = alerttotal + "Probleme tel \n";
	}
	if (verifEmail(f.mail) == false) {
		alerttotal = alerttotal + "Probleme email \n";
	}
	if (verifAdresse(f.adresse) == false || verifCodePostal(f.cp) == false
			|| verifVille(f.ville) == false || verifTel(f.tel) == false
			|| verifEmail(f.email) == false) {
		alert(alerttotal);
		return false;
	} else {
		return true;
	}
}
