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
//		alert("Le champ doit comporter entre " + min + " et " + max
//				+ " caracteres");
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
		document.getElementById("IDError").innerHTML = "test";
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

function verifMdp2(champ) {
	if (mdp1.value == mdp2.value) {
		surligne(mdp1, false);
		surligne(mdp2, false);
		return true;
	} else {
		surligne(mdp1, true);
		surligne(mdp2, true);
		return false;
	}
}

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

function verifTel(champ) {
	if ((verifTaille(champ, 8, 12)) && (!verifLettres(champ))) {
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

function verifEmail(champ) {
	if ((verifTaille(champ, 4, 30)) && (champ.value.contains("@"))) {
		// aaaaaapproximatif, ah !
		surligne(champ, false);
		return true;
	} else {
		surligne(champ, true);
		return false;
	}
}

// ____ Dernière verif au submit ____
function verifInscription1(f) {
	var alerttotal ="";
	if (verifIdentifiant(f.Identifiant)==false) {
		alerttotal = alerttotal+"Probleme identidiant \n";
	}
	if (verifMdp1(f.mdp1)==false) {
		alerttotal = alerttotal+"Probleme mdp \n";
	}
//	if (verifMdp2(f.mdp2)==false) {
//		alert("3");
//	}
	if (verifIdentifiant(f.Identifiant)==false||verifMdp1(f.mdp1)==false){
		alert(alerttotal);
		return false;
	}else{
		return true;
	}
}