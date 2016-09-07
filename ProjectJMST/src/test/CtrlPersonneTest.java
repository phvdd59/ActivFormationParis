package test;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.joca.controleur.CtrlPersonne;
import com.formation.joca.controleur.InterCtrlPersonne;

public class CtrlPersonneTest {
	CtrlPersonne ctrlPersonne;
	InterCtrlPersonne iCtrlPersonne;

	@Before
	public void init() {
		ctrlPersonne = new CtrlPersonne();
		iCtrlPersonne =  ctrlPersonne;
	}

	// ---------------------------------------------------NOM---------------------------------------------------------
	@Test
	public void testCtrlNomCapitalOk() {
		String nom = "DENIS";
		Assert.assertTrue("nom ok", iCtrlPersonne.ctrlNom(nom));
	}

	@Test
	public void testCtrlNomMinusculeOK() {
		String nom = "denis";
		Assert.assertTrue("nom ok", iCtrlPersonne.ctrlNom(nom));
	}

	@Test
	public void testCtrlNomCaracSpeciauxOk() {
		String nom = "l'a-bas ";
		Assert.assertTrue("nom ok", iCtrlPersonne.ctrlNom(nom));
	}

	@Test
	public void testCtrlNomCaracSpeciauxKo() {
		String nom = "l'a-bas%) ";
		Assert.assertFalse("nom pas ok", iCtrlPersonne.ctrlNom(nom));
	}

	@Test
	public void testCtrlNomVide() {
		String nom = "";
		Assert.assertFalse("nom pas ok", iCtrlPersonne.ctrlNom(nom));
	}

	@Test
	public void testCtrlNomNull() {
		String nom = null;
		Assert.assertFalse("nom pas ok", iCtrlPersonne.ctrlNom(nom));
	}

	@Test
	public void testCtrlNomCourt() {
		String nom = "e";
		Assert.assertTrue("nom pas ok", iCtrlPersonne.ctrlNom(nom));
	}

	@Test
	public void testCtrlNomLong() {
		String nom = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		Assert.assertTrue("nom pas ok", iCtrlPersonne.ctrlNom(nom));
	}

	@Test
	public void testCtrlNomChiffre() {
		String nom = "denis6";
		Assert.assertFalse("nom pas ok", iCtrlPersonne.ctrlNom(nom));
	}

	// -----------------------------------------------PRENOM------------------------------------------------------------//
	@Test
	public void testCtrlPrenomCapitalOk() {
		String prenom = "DENIS";
		Assert.assertTrue("prenom ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	@Test
	public void testCtrlPrenomMinusculeOK() {
		String prenom = "denis";
		Assert.assertTrue("prenom ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	@Test
	public void testCtrlPrenomCaracSpeciauxOk() {
		String prenom = "l'a-bas ";
		Assert.assertTrue("prenom ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	@Test
	public void testCtrlPrenomCaracSpeciauxKo() {
		String prenom = "l'a-bas%) ";
		Assert.assertFalse("prenom pas ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	@Test
	public void testCtrlPrenomVide() {
		String prenom = "";
		Assert.assertFalse("prenom pas ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	@Test
	public void testCtrlPrenomNull() {
		String prenom = null;
		Assert.assertFalse("prenom pas ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	@Test
	public void testCtrlPrenomCourt() {
		String prenom = "e";
		Assert.assertTrue("prenom pas ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	@Test
	public void testCtrlPrenomLong() {
		String prenom = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		Assert.assertTrue("prenom pas ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	@Test
	public void testCtrlPrenomChiffre() {
		String prenom = "denis6";
		Assert.assertFalse("prenom pas ok", iCtrlPersonne.ctrlPrenom(prenom));
	}

	// ---------------------------------------------IDENTIFIANT------------------------------------------------------------
	@Test
	public void testCtrlIdentifiantOk() {
		String identifiant = "denis_10";
		Assert.assertTrue(iCtrlPersonne.ctrlIdentifiant(identifiant));
	}

	@Test
	public void testCtrlIdentifiantOk2() {
		String identifiant = "Denis-10.";
		Assert.assertTrue(iCtrlPersonne.ctrlIdentifiant(identifiant));
	}

	@Test
	public void testCtrlIdentifiantsimple() {
		String identifiant = "toto";
		Assert.assertTrue(iCtrlPersonne.ctrlIdentifiant(identifiant));
	}

	@Test
	public void testCtrlIdentifiantCourt() {
		String identifiant = "d";
		Assert.assertFalse(iCtrlPersonne.ctrlIdentifiant(identifiant));
	}

	@Test
	public void testCtrlIdentifiantLong() {
		String identifiant = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
		Assert.assertFalse(iCtrlPersonne.ctrlIdentifiant(identifiant));
	}

	@Test
	public void testCtrlIdentifiantVide() {
		String identifiant = "";
		Assert.assertFalse(iCtrlPersonne.ctrlIdentifiant(identifiant));
	}

	@Test
	public void testCtrlIdentifiantNull() {
		String identifiant = null;
		Assert.assertFalse(iCtrlPersonne.ctrlIdentifiant(identifiant));
	}

	// --------------------------------------------------------MDP-----------------------------------------------------------------------------------------

	@Test
	public void testCtrlMdpOk() {
		String mdp = "denis_10";
		Assert.assertTrue(iCtrlPersonne.ctrlMdp(mdp));
	}

	@Test
	public void testCtrlMdpOk2() {
		String mdp = "Denis%10ç^";
		Assert.assertTrue(iCtrlPersonne.ctrlMdp(mdp));
	}

	@Test
	public void testCtrlMdpsimple() {
		String mdp = "toto";
		Assert.assertFalse(iCtrlPersonne.ctrlMdp(mdp));
	}

	@Test
	public void testCtrlMdpCourt() {
		String mdp = "d";
		Assert.assertFalse(iCtrlPersonne.ctrlMdp(mdp));
	}

	@Test
	public void testCtrlMdpLong() {
		String mdp = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
		Assert.assertTrue(iCtrlPersonne.ctrlMdp(mdp));
	}

	@Test
	public void testCtrlMdpVide() {
		String mdp = "";
		Assert.assertFalse(iCtrlPersonne.ctrlMdp(mdp));
	}

	@Test
	public void testCtrlMdpNull() {
		String mdp = null;
		Assert.assertFalse(iCtrlPersonne.ctrlMdp(mdp));
	}

	// --------------------------------------------------------EMAIL-------------------------------------------------------
	@Test
	public void testCtrlEmailOk() {
		String email = "nom@fournisseur.fr";
		Assert.assertTrue(iCtrlPersonne.ctrlEmail(email));
	}

	@Test
	public void testCtrlEmailOk2() {
		String email = "Nom-prenom.99_o@fournisseur.com.za";
		Assert.assertTrue(iCtrlPersonne.ctrlEmail(email));
	}

	@Test
	public void testCtrlEmailKo() {
		String email = "toto@hotmailcom";
		Assert.assertFalse(iCtrlPersonne.ctrlEmail(email));
	}

	@Test
	public void testCtrlEmailCourt() {
		String email = "d";
		Assert.assertFalse(iCtrlPersonne.ctrlEmail(email));
	}

	@Test
	public void testCtrlEmailLong() {
		String email = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
		Assert.assertFalse(iCtrlPersonne.ctrlEmail(email));
	}

	@Test
	public void testCtrlEmailVide() {
		String email = "";
		Assert.assertFalse(iCtrlPersonne.ctrlEmail(email));
	}

	@Test
	public void testCtrlEmailNull() {
		String email = null;
		Assert.assertFalse(iCtrlPersonne.ctrlEmail(email));
	}

	// -------------------------------------------------------ADRESSE-------------------------------------------------------
	@Test
	public void testCtrlAdresseOk() {
		String adresse = "33 rue des Robinets";
		Assert.assertTrue(iCtrlPersonne.ctrlAdresse(adresse));
	}

	@Test
	public void testCtrlAdresseOk2() {
		String adresse = "99 rue du General de-Gaulle (chez xx)";
		Assert.assertTrue(iCtrlPersonne.ctrlAdresse(adresse));
	}

	@Test
	public void testCtrlAdressesimple() {
		String adresse = "xxxxxxxxxxxxxxxxxxxxxxxxxxxxx";
		Assert.assertTrue(iCtrlPersonne.ctrlAdresse(adresse));
	}

	@Test
	public void testCtrlAdresseKO() {
		String adresse = "vtrsv 74 '(-èx";
		Assert.assertFalse(iCtrlPersonne.ctrlAdresse(adresse));
	}

	@Test
	public void testCtrlAdresseCourt() {
		String adresse = "d";
		Assert.assertTrue(iCtrlPersonne.ctrlAdresse(adresse));
	}

	@Test
	public void testCtrlAdresseLong() {
		String adresse = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
		Assert.assertTrue(iCtrlPersonne.ctrlAdresse(adresse));
	}

	@Test
	public void testCtrlAdresseVide() {
		String adresse = "";
		Assert.assertTrue(iCtrlPersonne.ctrlAdresse(adresse));
	}

	@Test
	public void testCtrlAdresseNull() {
		String adresse = null;
		Assert.assertFalse(iCtrlPersonne.ctrlAdresse(adresse));
	}

	// ---------------------------------------------------CODEPOSTAL------------------------------------------------------
	@Test
	public void testCtrlCpOk() {
		String cp = "95000";
		Assert.assertTrue(iCtrlPersonne.ctrlCp(cp));
	}

	@Test
	public void testCtrlCpOk2() {
		String cp = "63521";
		Assert.assertTrue(iCtrlPersonne.ctrlCp(cp));
	}

	@Test
	public void testCtrlCpCorse() {
		String cp = "2A500";
		Assert.assertFalse(iCtrlPersonne.ctrlCp(cp));
	}

	@Test
	public void testCtrlCpCourt() {
		String cp = "92";
		Assert.assertFalse(iCtrlPersonne.ctrlCp(cp));
	}

	@Test
	public void testCtrlCpLong() {
		String cp = "920000";
		Assert.assertFalse(iCtrlPersonne.ctrlCp(cp));
	}

	@Test
	public void testCtrlCpVide() {
		String cp = "";
		Assert.assertTrue(iCtrlPersonne.ctrlCp(cp));
	}

	@Test
	public void testCtrlCpNull() {
		String cp = null;
		Assert.assertFalse(iCtrlPersonne.ctrlCp(cp));
	}

	// --------------------------------VILLE---------------------------------------------------------------------
	@Test
	public void testCtrlVilleOk() {
		String ville = "Saint-Maur Creteil";
		Assert.assertTrue(iCtrlPersonne.ctrlVille(ville));
	}

	@Test
	public void testCtrlVilleKo3() {
		String ville = "L'Essônnë";
		Assert.assertFalse(iCtrlPersonne.ctrlVille(ville));
	}

	@Test
	public void testCtrlVillesimple() {
		String ville = "bonjour";
		Assert.assertTrue(iCtrlPersonne.ctrlVille(ville));
	}

	@Test
	public void testCtrlVilleKo() {
		String ville = "paris75";
		Assert.assertFalse(iCtrlPersonne.ctrlVille(ville));
	}

	@Test
	public void testCtrlVilleKo2() {
		String ville = "paris_%";
		Assert.assertFalse(iCtrlPersonne.ctrlVille(ville));
	}

	@Test
	public void testCtrlVilleCourt() {
		String ville = "d";
		Assert.assertTrue(iCtrlPersonne.ctrlVille(ville));
	}

	@Test
	public void testCtrlVilleLong() {
		String ville = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
		Assert.assertTrue(iCtrlPersonne.ctrlVille(ville));
	}

	@Test
	public void testCtrlVilleVide() {
		String ville = "";
		Assert.assertTrue(iCtrlPersonne.ctrlVille(ville));
	}

	@Test
	public void testCtrlVilleNull() {
		String ville = null;
		Assert.assertFalse(iCtrlPersonne.ctrlVille(ville));
	}

	// ------------------------------------------------------TELFIXE---------------------------------------------------
	@Test
	public void testCtrlTelFixeOk() {
		String telFixe = "123456789";
		Assert.assertTrue(iCtrlPersonne.ctrlTelFixe(telFixe));
	}

	@Test
	public void testCtrlTelFixeOk2() {
		String telFixe = "987654321";
		Assert.assertTrue(iCtrlPersonne.ctrlTelFixe(telFixe));
	}

	@Test
	public void testCtrlTelFixeKo() {
		String telFixe = "bonjour";
		Assert.assertFalse(iCtrlPersonne.ctrlTelFixe(telFixe));
	}

	@Test
	public void testCtrlTelFixeKo2() {
		String telFixe = "+330123456789";
		Assert.assertFalse(iCtrlPersonne.ctrlTelFixe(telFixe));
	}

	@Test
	public void testCtrlTelFixeCourt() {
		String telFixe = "123";
		Assert.assertFalse(iCtrlPersonne.ctrlTelFixe(telFixe));
	}

	@Test
	public void testCtrlTelFixeLong() {
		String telFixe = "12345678910";
		Assert.assertFalse(iCtrlPersonne.ctrlTelFixe(telFixe));
	}

	@Test
	public void testCtrlTelFixeVide() {
		String telFixe = "";
		Assert.assertTrue(iCtrlPersonne.ctrlTelFixe(telFixe));
	}

	@Test
	public void testCtrlTelFixeNull() {
		String telFixe = null;
		Assert.assertFalse(iCtrlPersonne.ctrlTelFixe(telFixe));
	}

	// ----------------------------------------------------TELPORTABLE-------------------------------------------------
	@Test
	public void testCtrlTelPortOk() {
		String telPort = "123456789";
		Assert.assertTrue(iCtrlPersonne.ctrlTelPort(telPort));
	}

	@Test
	public void testCtrlTelPortOk2() {
		String telPort = "987654321";
		Assert.assertTrue(iCtrlPersonne.ctrlTelPort(telPort));
	}

	@Test
	public void testCtrlTelPortKo() {
		String telPort = "bonjour";
		Assert.assertFalse(iCtrlPersonne.ctrlTelPort(telPort));
	}

	@Test
	public void testCtrlTelPortKo2() {
		String telPort = "+330123456789";
		Assert.assertFalse(iCtrlPersonne.ctrlTelPort(telPort));
	}

	@Test
	public void testCtrlTelPortCourt() {
		String telPort = "123";
		Assert.assertFalse(iCtrlPersonne.ctrlTelPort(telPort));
	}

	@Test
	public void testCtrlTelPortLong() {
		String telPort = "12345678910";
		Assert.assertFalse(iCtrlPersonne.ctrlTelPort(telPort));
	}

	@Test
	public void testCtrlTelPortVide() {
		String telPort = "";
		Assert.assertTrue(iCtrlPersonne.ctrlTelPort(telPort));
	}

	@Test
	public void testCtrlTelPortNull() {
		String telPort = null;
		Assert.assertFalse(iCtrlPersonne.ctrlTelPort(telPort));
	}

	// --------------------------------------------------FAX-----------------------------------------------------------
	@Test
	public void testCtrlFaxOk() {
		String fax = "123456789";
		Assert.assertTrue(iCtrlPersonne.ctrlFax(fax));
	}

	@Test
	public void testCtrlFaxOk2() {
		String fax = "987654321";
		Assert.assertTrue(iCtrlPersonne.ctrlFax(fax));
	}

	@Test
	public void testCtrlFaxKo() {
		String fax = "bonjour";
		Assert.assertFalse(iCtrlPersonne.ctrlFax(fax));
	}

	@Test
	public void testCtrlFaxKo2() {
		String fax = "+330123456789";
		Assert.assertFalse(iCtrlPersonne.ctrlFax(fax));
	}

	@Test
	public void testCtrlFaxCourt() {
		String fax = "123";
		Assert.assertFalse(iCtrlPersonne.ctrlFax(fax));
	}

	@Test
	public void testCtrlFaxLong() {
		String fax = "12345678910";
		Assert.assertFalse(iCtrlPersonne.ctrlFax(fax));
	}

	@Test
	public void testCtrlFaxVide() {
		String fax = "";
		Assert.assertTrue(iCtrlPersonne.ctrlFax(fax));
	}

	@Test
	public void testCtrlFaxNull() {
		String fax = null;
		Assert.assertFalse(iCtrlPersonne.ctrlFax(fax));
	}

	// --------------------------------------------------DATENAISSANCE-------------------------------------------------
	@Test
	public void testCtrlDateNaissanceOk() {
		String sDate = "16-06-1989";
		Assert.assertTrue(iCtrlPersonne.ctrlDateNaissance(sDate));
	}

	@Test
	public void testCtrlDateNaissanceOk2() {
		String sDate = "12-12-2012";
		Assert.assertTrue(iCtrlPersonne.ctrlDateNaissance(sDate));
	}

	@Test
	public void testCtrlDateNaissanceKo() {
		String sDate = "12-12-12";
		Assert.assertFalse(iCtrlPersonne.ctrlDateNaissance(sDate));
	}

	@Test
	public void testCtrlDateNaissanceKo2() {
		String sDate = "12/12/12";
		Assert.assertFalse(iCtrlPersonne.ctrlDateNaissance(sDate));
	}

	@Test
	public void testCtrlDateNaissanceVide() {
		String sDate = "";
		Assert.assertFalse(iCtrlPersonne.ctrlDateNaissance(sDate));
	}

	@Test
	public void testCtrlDateNaissanceNull() {
		String sDate = null;
		Assert.assertFalse(iCtrlPersonne.ctrlDateNaissance(sDate));
	}

	// -----------------------------------------------LIEUNAISSANCE------------------------------------------------------
	@Test
	public void testCtrlLieuNaissanceOk() {
		String lieuNaissance = "Paris";
		Assert.assertTrue(iCtrlPersonne.ctrlLieuNaissance(lieuNaissance));
	}

	@Test
	public void testCtrlLieuNaissanceOk2() {
		String lieuNaissance = "Saint-Maur des F'osses";
		Assert.assertTrue(iCtrlPersonne.ctrlLieuNaissance(lieuNaissance));
	}

	@Test
	public void testCtrlLieuNaissancesimple() {
		String lieuNaissance = "toto";
		Assert.assertTrue(iCtrlPersonne.ctrlLieuNaissance(lieuNaissance));
	}

	@Test
	public void testCtrlLieuNaissanceCourt() {
		String lieuNaissance = "d";
		Assert.assertTrue(iCtrlPersonne.ctrlLieuNaissance(lieuNaissance));
	}

	@Test
	public void testCtrlLieuNaissanceLong() {
		String lieuNaissance = "dddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddddd";
		Assert.assertTrue(iCtrlPersonne.ctrlLieuNaissance(lieuNaissance));
	}

	@Test
	public void testCtrlLieuNaissanceVide() {
		String lieuNaissance = "";
		Assert.assertFalse(iCtrlPersonne.ctrlLieuNaissance(lieuNaissance));
	}

	@Test
	public void testCtrlLieuNaissanceNull() {
		String lieuNaissance = null;
		Assert.assertFalse(iCtrlPersonne.ctrlLieuNaissance(lieuNaissance));
	}

	// --------------------------------------------------NUMSECU-------------------------------------------------------
	@Test
	public void testCtrlNumSecuOk() {
		String numSecu = "123456789101112";
		Assert.assertTrue(iCtrlPersonne.ctrlNumSecu(numSecu));
	}

	@Test
	public void testCtrlNumSecuOk2() {
		String numSecu = "212345678910123";
		Assert.assertTrue(iCtrlPersonne.ctrlNumSecu(numSecu));
	}

	@Test
	public void testCtrlNumSecuKo() {
		String numSecu = "bonjour";
		Assert.assertFalse(iCtrlPersonne.ctrlNumSecu(numSecu));
	}

	@Test
	public void testCtrlNumSecuKo2() {
		String numSecu = "012345678910112";
		Assert.assertFalse(iCtrlPersonne.ctrlNumSecu(numSecu));
	}

	@Test
	public void testCtrlNumSecuCourt() {
		String numSecu = "123";
		Assert.assertFalse(iCtrlPersonne.ctrlNumSecu(numSecu));
	}

	@Test
	public void testCtrlNumSecuLong() {
		String numSecu = "1234567891011121314";
		Assert.assertFalse(iCtrlPersonne.ctrlNumSecu(numSecu));
	}

	@Test
	public void testCtrlNumSecuVide() {
		String numSecu = "";
		Assert.assertFalse(iCtrlPersonne.ctrlNumSecu(numSecu));
	}

	@Test
	public void testCtrlNumSecuNull() {
		String numSecu = null;
		Assert.assertFalse(iCtrlPersonne.ctrlNumSecu(numSecu));
	}

	// --------------------------------------------------NATIONALITE--------------------------------------------------------
	@Test
	public void testCtrlNationaliteCapitalOk() {
		String nationalite = "FRANCAISE";
		Assert.assertTrue("nationalite ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	@Test
	public void testCtrlNationaliteMinusculeOK() {
		String nationalite = "belge";
		Assert.assertTrue("nationalite ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	@Test
	public void testCtrlNationaliteCaracSpeciauxOk() {
		String nationalite = "trinidad-et-tobago ";
		Assert.assertTrue("nationalite ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	@Test
	public void testCtrlNationaliteCaracSpeciauxKo() {
		String nationalite = "l'a-b%) ";
		Assert.assertFalse("nationalite pas ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	@Test
	public void testCtrlNationaliteVide() {
		String nationalite = "";
		Assert.assertFalse("nationalite pas ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	@Test
	public void testCtrlNationaliteNull() {
		String nationalite = null;
		Assert.assertFalse("nationalite pas ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	@Test
	public void testCtrlNationaliteCourt() {
		String nationalite = "e";
		Assert.assertTrue("nationalite pas ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	@Test
	public void testCtrlNationaliteLong() {
		String nationalite = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		Assert.assertTrue("nationalite pas ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	@Test
	public void testCtrlNationaliteChiffre() {
		String nationalite = "denis6";
		Assert.assertFalse("nationalite pas ok", iCtrlPersonne.ctrlNationalite(nationalite));
	}

	// -----------------------------------------------------SITUATION-----------------------------------------------
	@Test
	public void testCtrlSituationCapitalOk() {
		String situation = "INGENIEUR";
		Assert.assertTrue("situation ok", iCtrlPersonne.ctrlSituation(situation));
	}

	@Test
	public void testCtrlSituationMinusculeOK() {
		String situation = "ingenieur";
		Assert.assertTrue("situation ok", iCtrlPersonne.ctrlSituation(situation));
	}

	@Test
	public void testCtrlSituationCaracSpeciauxOk() {
		String situation = "ingenieurs ' arts-et-metiers ";
		Assert.assertTrue("situation ok", iCtrlPersonne.ctrlSituation(situation));
	}

	@Test
	public void testCtrlSituationCaracSpeciauxKo() {
		String situation = "l'a-bas%) ";
		Assert.assertFalse("situation pas ok", iCtrlPersonne.ctrlSituation(situation));
	}

	@Test
	public void testCtrlSituationVide() {
		String situation = "";
		Assert.assertTrue("situation pas ok", iCtrlPersonne.ctrlSituation(situation));
	}

	@Test
	public void testCtrlSituationNull() {
		String situation = null;
		Assert.assertFalse("situation pas ok", iCtrlPersonne.ctrlSituation(situation));
	}

	@Test
	public void testCtrlSituationCourt() {
		String situation = "e";
		Assert.assertTrue("situation pas ok", iCtrlPersonne.ctrlSituation(situation));
	}

	@Test
	public void testCtrlSituationLong() {
		String situation = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		Assert.assertTrue("situation pas ok", iCtrlPersonne.ctrlSituation(situation));
	}

	@Test
	public void testCtrlSituationChiffre() {
		String situation = "13ingenieur6";
		Assert.assertFalse("situation pas ok", iCtrlPersonne.ctrlSituation(situation));
	}

	// -------------------------------------------------------FONCTION-------------------------------------------------
	@Test
	public void testCtrlFonctionCapitalOk() {
		String fonction = "INGENIEUR";
		Assert.assertTrue("fonction ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	@Test
	public void testCtrlFonctionMinusculeOK() {
		String fonction = "ingenieur";
		Assert.assertTrue("fonction ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	@Test
	public void testCtrlFonctionCaracSpeciauxOk() {
		String fonction = "ingenieur s ' arts-et-metiers ";
		Assert.assertTrue("fonction ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	@Test
	public void testCtrlFonctionCaracSpeciauxKo() {
		String fonction = "l'a-bas%) ";
		Assert.assertFalse("fonction pas ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	@Test
	public void testCtrlFonctionVide() {
		String fonction = "";
		Assert.assertTrue("fonction pas ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	@Test
	public void testCtrlFonctionNull() {
		String fonction = null;
		Assert.assertFalse("fonction pas ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	@Test
	public void testCtrlFonctionCourt() {
		String fonction = "e";
		Assert.assertTrue("fonction pas ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	@Test
	public void testCtrlFonctionLong() {
		String fonction = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
		Assert.assertTrue("fonction pas ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	@Test
	public void testCtrlFonctionChiffre() {
		String fonction = "13ingenieur6";
		Assert.assertFalse("fonction pas ok", iCtrlPersonne.ctrlFonction(fonction));
	}

	// ----------------------------------------------------------POSITION-------------------------------------------------
	@Test
	public void testCtrlPositionOk() {
		String position = "123";
		Assert.assertTrue("position ok", iCtrlPersonne.ctrlPosition(position));
	}

	@Test
	public void testCtrlPositionok2() {
		String position = "14";
		Assert.assertTrue("position ok", iCtrlPersonne.ctrlPosition(position));
	}

	@Test
	public void testCtrlPositionCaracSpeciaux() {
		String position = "dirécteur ès -'";
		Assert.assertFalse("position ok", iCtrlPersonne.ctrlPosition(position));
	}

	@Test
	public void testCtrlPositionCaracSpeciauxKo() {
		String position = "directeur)} ";
		Assert.assertFalse("position pas ok", iCtrlPersonne.ctrlPosition(position));
	}

	@Test
	public void testCtrlPositionVide() {
		String position = "";
		Assert.assertTrue("position pas ok", iCtrlPersonne.ctrlPosition(position));
	}

	@Test
	public void testCtrlPositionNull() {
		String position = null;
		Assert.assertFalse("position pas ok", iCtrlPersonne.ctrlPosition(position));
	}

	@Test
	public void testCtrlPositionCourt() {
		String position = "1";
		Assert.assertTrue("position pas ok", iCtrlPersonne.ctrlPosition(position));
	}

	@Test
	public void testCtrlPositionLong() {
		String position = "14141414141414";
		Assert.assertTrue("position pas ok", iCtrlPersonne.ctrlPosition(position));
	}

	@Test
	public void testCtrlPositionChiffre() {
		String position = "45direc6";
		Assert.assertFalse("position pas ok", iCtrlPersonne.ctrlPosition(position));
	}

	// ------------------------------------------------------CADRE------------------------------------------------------------
	@Test
	public void testCtrlCadreOk() {
		String cadre = "oui";
		Assert.assertTrue("cadre ok", iCtrlPersonne.ctrlCadre(cadre));
	}

	@Test
	public void testCtrlNonCadreOk() {
		String cadre = "non";
		Assert.assertTrue("cadre ok", iCtrlPersonne.ctrlCadre(cadre));
	}

	@Test
	public void testCtrlCadreTrueKo() {
		String cadre = "true";
		Assert.assertFalse("cadre ok", iCtrlPersonne.ctrlCadre(cadre));
	}

	@Test
	public void testCtrlCadreAutreKo() {
		String cadre = "bonjour";
		Assert.assertFalse("cadre ok", iCtrlPersonne.ctrlCadre(cadre));
	}

	@Test
	public void testCtrlCadreVide() {
		String cadre = "";
		Assert.assertFalse("cadre pas ok", iCtrlPersonne.ctrlCadre(cadre));
	}

	@Test
	public void testCtrlCadreNull() {
		String cadre = null;
		Assert.assertFalse("cadre pas ok", iCtrlPersonne.ctrlCadre(cadre));
	}

	// -----------------------------------------------------COEFF------------------------------------------------------------
	@Test
	public void testCtrlCoeffOk() {
		String coeff = "150";
		Assert.assertTrue(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffOk2() {
		String coeff = "125";
		Assert.assertTrue(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffKo() {
		String coeff = "999";
		Assert.assertTrue(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffKo2() {
		String coeff = "23.3";
		Assert.assertFalse(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffKo3() {
		String coeff = "125p";
		Assert.assertFalse(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffKo4() {
		String coeff = "15$";
		Assert.assertFalse(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffCourt() {
		String coeff = "1";
		Assert.assertFalse(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffLong() {
		String coeff = "12345";
		Assert.assertFalse(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffVide() {
		String coeff = "";
		Assert.assertTrue(iCtrlPersonne.ctrlCoeff(coeff));
	}

	@Test
	public void testCtrlCoeffNull() {
		String coeff = null;
		Assert.assertFalse(iCtrlPersonne.ctrlCoeff(coeff));
	}

	// ----------------------------------------------------SALAIRE------------------------------------------------------
	@Test
	public void testCtrlSalaireOk() {
		String salaire = "1500";
		Assert.assertTrue(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireOk2() {
		String salaire = "26000";
		Assert.assertTrue(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireok3() {
		String salaire = "9";
		Assert.assertTrue(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireKo2() {
		String salaire = "2300.3";
		Assert.assertFalse(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireKo3() {
		String salaire = "125k/an";
		Assert.assertFalse(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireKo4() {
		String salaire = "15$";
		Assert.assertFalse(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireCourt() {
		String salaire = "1";
		Assert.assertTrue(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireLong() {
		String salaire = "12345454455455545445454545545";
		Assert.assertTrue(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireVide() {
		String salaire = "";
		Assert.assertFalse(iCtrlPersonne.ctrlSalaire(salaire));
	}

	@Test
	public void testCtrlSalaireNull() {
		String salaire = null;
		Assert.assertFalse(iCtrlPersonne.ctrlSalaire(salaire));
	}

	// -----------------------------------------------------VISITEMEDICALE---------------------------------------------
	@Test
	public void testCtrlVisiteMedicaleOk() {
		String sDate = "16-06-1989";
		Assert.assertTrue(iCtrlPersonne.ctrlVisiteMedicale(sDate));
	}

	@Test
	public void testCtrlVisiteMedicaleOk2() {
		String sDate = "12-12-2012";
		Assert.assertTrue(iCtrlPersonne.ctrlVisiteMedicale(sDate));
	}

	@Test
	public void testCtrlVisiteMedicaleKo() {
		String sDate = "12-12-12";
		Assert.assertFalse(iCtrlPersonne.ctrlVisiteMedicale(sDate));
	}

	@Test
	public void testCtrlVisiteMedicaleKo2() {
		String sDate = "12/12/12";
		Assert.assertFalse(iCtrlPersonne.ctrlVisiteMedicale(sDate));
	}

	@Test
	public void testCtrlVisiteMedicaleVide() {
		String sDate = "";
		Assert.assertFalse(iCtrlPersonne.ctrlVisiteMedicale(sDate));
	}

	@Test
	public void testCtrlVisiteMedicaleNull() {
		String sDate = null;
		Assert.assertFalse(iCtrlPersonne.ctrlVisiteMedicale(sDate));
	}

	// ------------------------------------------------------MONTANTTRANSPORT------------------------------------------
	@Test
	public void testCtrlMontantTransportOk() {
		String montantTransport = "15";
		Assert.assertTrue(iCtrlPersonne.ctrlMontantTransport(montantTransport));
	}

	@Test
	public void testCtrlMontantTransportko2() {
		String montantTransport = "0.00";
		Assert.assertFalse(iCtrlPersonne.ctrlMontantTransport(montantTransport));
	}

	@Test
	public void testCtrlMontantTransportko3() {
		String montantTransport = "9.35";
		Assert.assertFalse(iCtrlPersonne.ctrlMontantTransport(montantTransport));
	}

	@Test
	public void testCtrlMontantTransportKo() {
		String montantTransport = "125/mois";
		Assert.assertFalse(iCtrlPersonne.ctrlMontantTransport(montantTransport));
	}

	@Test
	public void testCtrlMontantTransportKo4() {
		String montantTransport = "15$";
		Assert.assertFalse(iCtrlPersonne.ctrlMontantTransport(montantTransport));
	}

	@Test
	public void testCtrlMontantTransportLong() {
		String montantTransport = "12345454455455545445454545545";
		Assert.assertTrue(iCtrlPersonne.ctrlMontantTransport(montantTransport));
	}

	@Test
	public void testCtrlMontantTransportVide() {
		String montantTransport = "";
		Assert.assertTrue(iCtrlPersonne.ctrlMontantTransport(montantTransport));
	}

	@Test
	public void testCtrlMontantTransportNull() {
		String montantTransport = null;
		Assert.assertFalse(iCtrlPersonne.ctrlMontantTransport(montantTransport));
	}

	// ------------------------------------------------------VOITURE---------------------------------------------------
	@Test
	public void testCtrlVoitureOk() {
		String voiture = "oui";
		Assert.assertTrue("voiture ok", iCtrlPersonne.ctrlVoiture(voiture));
	}

	@Test
	public void testCtrlNonVoitureOk() {
		String voiture = "non";
		Assert.assertTrue("voiture ok", iCtrlPersonne.ctrlVoiture(voiture));
	}

	@Test
	public void testCtrlVoitureTrueKo() {
		String voiture = "true";
		Assert.assertFalse("voiture ok", iCtrlPersonne.ctrlVoiture(voiture));
	}

	@Test
	public void testCtrlVoitureAutreKo() {
		String voiture = "peut-être ";
		Assert.assertFalse("voiture ok", iCtrlPersonne.ctrlVoiture(voiture));
	}

	@Test
	public void testCtrlVoitureVide() {
		String voiture = "";
		Assert.assertFalse("voiture pas ok", iCtrlPersonne.ctrlVoiture(voiture));
	}

	@Test
	public void testCtrlVoitureNull() {
		String voiture = null;
		Assert.assertFalse("voiture pas ok", iCtrlPersonne.ctrlVoiture(voiture));
	}

	// --------------------------------------------------------NBCV----------------------------------------------------
	@Test
	public void testCtrlNbCVOk() {
		String nbCV = "5";
		Assert.assertTrue(iCtrlPersonne.ctrlNbCV(nbCV));
	}

	@Test
	public void testCtrlNbCVOk2() {
		String nbCV = "37";
		Assert.assertTrue(iCtrlPersonne.ctrlNbCV(nbCV));
	}

	@Test
	public void testCtrlNbCVKo2() {
		String nbCV = "5.1";
		Assert.assertFalse(iCtrlPersonne.ctrlNbCV(nbCV));
	}

	@Test
	public void testCtrlNbCVKo3() {
		String nbCV = "2cv";
		Assert.assertFalse(iCtrlPersonne.ctrlNbCV(nbCV));
	}

	@Test
	public void testCtrlNbCVKo4() {
		String nbCV = "99";
		Assert.assertTrue(iCtrlPersonne.ctrlNbCV(nbCV));
	}

	@Test
	public void testCtrlNbCVLong() {
		String nbCV = "12345454455455545445454545545";
		Assert.assertTrue(iCtrlPersonne.ctrlNbCV(nbCV));
	}

	@Test
	public void testCtrlNbCVVide() {
		String nbCV = "";
		Assert.assertFalse(iCtrlPersonne.ctrlNbCV(nbCV));
	}

	@Test
	public void testCtrlNbCVNull() {
		String nbCV = null;
		Assert.assertFalse(iCtrlPersonne.ctrlNbCV(nbCV));
	}

	// --------------------------------------------------------NBKM------------------------------------------------------
	@Test
	public void testCtrlNbKmOk() {
		String nbKm = "10";
		Assert.assertTrue(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	@Test
	public void testCtrlNbKmOk2() {
		String nbKm = "26000";
		Assert.assertTrue(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	@Test
	public void testCtrlNbKmKo() {
		String nbKm = "mille cent";
		Assert.assertFalse(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	@Test
	public void testCtrlNbKmKo2() {
		String nbKm = "2300.3";
		Assert.assertFalse(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	@Test
	public void testCtrlNbKmKo3() {
		String nbKm = "125km/an";
		Assert.assertFalse(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	@Test
	public void testCtrlNbKmKo4() {
		String nbKm = "15~";
		Assert.assertFalse(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	@Test
	public void testCtrlNbKmLong() {
		String nbKm = "12345454455455545445454545545";
		Assert.assertTrue(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	@Test
	public void testCtrlNbKmVide() {
		String nbKm = "";
		Assert.assertTrue(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	@Test
	public void testCtrlNbKmNull() {
		String nbKm = null;
		Assert.assertFalse(iCtrlPersonne.ctrlNbKm(nbKm));
	}

	// --------------------------------------------------------MUTUELLE--------------------------------------------------
	@Test
	public void testCtrlMutuelleOk() {
		String mutuelle = "oui";
		Assert.assertTrue("mutuelle ok", iCtrlPersonne.ctrlMutuelle(mutuelle));
	}

	@Test
	public void testCtrlNonMutuelleOk() {
		String mutuelle = "non";
		Assert.assertTrue("mutuelle ok", iCtrlPersonne.ctrlMutuelle(mutuelle));
	}

	@Test
	public void testCtrlMutuelleTrueKo() {
		String mutuelle = "true";
		Assert.assertFalse("mutuelle ok", iCtrlPersonne.ctrlMutuelle(mutuelle));
	}

	@Test
	public void testCtrlMutuelleAutreKo() {
		String mutuelle = "peut-être ";
		Assert.assertFalse("mutuelle ok", iCtrlPersonne.ctrlMutuelle(mutuelle));
	}

	@Test
	public void testCtrlMutuelleVide() {
		String mutuelle = "";
		Assert.assertFalse("mutuelle pas ok", iCtrlPersonne.ctrlMutuelle(mutuelle));
	}

	@Test
	public void testCtrlMutuelleNull() {
		String mutuelle = null;
		Assert.assertFalse("mutuelle pas ok", iCtrlPersonne.ctrlMutuelle(mutuelle));
	}

	// ----------------------------------------------------TICKETRESTO---------------------------------------------------
	@Test
	public void testCtrlTicketRestoOk() {
		String ticketResto = "oui";
		Assert.assertTrue("ticketResto ok", iCtrlPersonne.ctrlTicketResto(ticketResto));
	}

	@Test
	public void testCtrlNonTicketRestoOk() {
		String ticketResto = "non";
		Assert.assertTrue("ticketResto ok", iCtrlPersonne.ctrlTicketResto(ticketResto));
	}

	@Test
	public void testCtrlTicketRestoTrueKo() {
		String ticketResto = "true";
		Assert.assertFalse("ticketResto ok", iCtrlPersonne.ctrlTicketResto(ticketResto));
	}

	@Test
	public void testCtrlTicketRestoAutreKo() {
		String ticketResto = "peut-être ";
		Assert.assertFalse("ticketResto ok", iCtrlPersonne.ctrlTicketResto(ticketResto));
	}

	@Test
	public void testCtrlTicketRestoVide() {
		String ticketResto = "";
		Assert.assertFalse("ticketResto pas ok", iCtrlPersonne.ctrlTicketResto(ticketResto));
	}

	@Test
	public void testCtrlTicketRestoNull() {
		String ticketResto = null;
		Assert.assertFalse("ticketResto pas ok", iCtrlPersonne.ctrlTicketResto(ticketResto));
	}

}
