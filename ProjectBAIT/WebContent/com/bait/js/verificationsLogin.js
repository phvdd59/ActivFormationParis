function surligne(champ, erreur) {
	if (erreur)
		champ.style.backgroundColor = "#fba";
	else
		champ.style.backgroundColor = "";
}


//private void validationEmail( String email ) throws Exception {
//
//    if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
//
//        throw new Exception( "Merci de saisir une adresse mail valide." );
//
//    }
//
//}


function verifIdentifiant(champ) {
	if (champ.value != "Admin") {
		surligne(champ, true);
		return false;
	} else {
		surligne(champ, false);
		return true;
	}
}

function verifMdp(champ) {
	if (champ.value != "Admin") {
		surligne(champ, true);
		return false;
	} else {
		surligne(champ, false);
		return true;
	}
}

function verifForm(f) {
	var idOk = verifIdentifiant(f.identifiant);
	var mdpOk = verifMdp(f.mdp);
	if (idOk && mdpOk)
		return true;
	else {
		alert("Erreur");
		return false;
	}
}