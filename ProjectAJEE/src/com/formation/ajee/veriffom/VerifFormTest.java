package com.formation.ajee.veriffom;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.formation.ajee.metier.SEXE;
import com.formation.ajee.metier.SITUATION;

public class VerifFormTest {
	VerifForm test;

	@Before
	public void init() {

		test = new VerifForm();
	}

	@Test
	public void testnomnok() {
		String nom = test.nomVerif("054 pazeo");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testnomok() {
		String nom = test.nomVerif("'-Paul");

		Assert.assertEquals("'-Paul", nom);
	}

	@Test
	public void testnomokaccent() {
		String nom = test.nomVerif("Jérémy");

		Assert.assertEquals("Jérémy", nom);
	}

	@Test
	public void testnomnoklong() {
		String nom = test.nomVerif("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testprenomnok() {
		String nom = test.nomVerif("054 pazeo");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testprenomok() {
		String nom = test.nomVerif("Paul");

		Assert.assertEquals("Paul", nom);
	}

	@Test
	public void testprenomokaccent() {
		String nom = test.nomVerif("Jérémy");

		Assert.assertEquals("Jérémy", nom);
	}

	@Test
	public void testprenomnoklong() {
		String nom = test.nomVerif("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testsexenok() {
		SEXE sexe = test.sexeVerif("etga");

		Assert.assertEquals(null, sexe);
	}

	@Test
	public void testsexemasculin() {
		SEXE sexe = test.sexeVerif("masculin");

		Assert.assertEquals(SEXE.MASCULIN, sexe);
	}

	@Test
	public void testsexefeminin() {
		SEXE sexe = test.sexeVerif("feminin");

		Assert.assertEquals(SEXE.FEMINIM, sexe);
	}

	@Test
	public void testsexeMASCULIN() {
		SEXE sexe = test.sexeVerif("MASCULIN");

		Assert.assertEquals(SEXE.MASCULIN, sexe);
	}

	@Test
	public void testsexeFEMININ() {
		SEXE sexe = test.sexeVerif("FEMININ");

		Assert.assertEquals(SEXE.FEMINIM, sexe);
	}

	@Test
	public void testidentifiantokaccent() {
		String identifiant = test.identifiantVerif("Jérémy");

		Assert.assertEquals("Jérémy", identifiant);
	}

	@Test
	public void testidentifiantnull() {
		String identifiant = test.identifiantVerif(null);

		Assert.assertEquals("", identifiant);
	}

	@Test
	public void testidentifiantnok() {
		String identifiant = test.identifiantVerif("&zerg>");

		Assert.assertEquals("", identifiant);
	}

	@Test
	public void testidentifiantnoklong() {
		String identifiant = test.identifiantVerif("Jérémyaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		Assert.assertEquals("", identifiant);
	}

	@Test
	public void testmdpnoaccent() {
		String mdp = test.mdpVerif("Jérémy");

		Assert.assertEquals("", mdp);
	}

	@Test
	public void testmdpnull() {
		String mdp = test.mdpVerif(null);

		Assert.assertEquals("", mdp);
	}

	@Test
	public void testmdpok() {
		String mdp = test.mdpVerif("123489AZEvgsdfie");

		Assert.assertEquals("123489AZEvgsdfie", mdp);
	}

	@Test
	public void testmdpnoklong() {
		String mdp = test.mdpVerif("J8979845myaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		Assert.assertEquals("", mdp);
	}

	@Test
	public void testmailnull() {
		String mail = test.emailVerif(null);

		Assert.assertEquals("", mail);
	}

	@Test
	public void testmailNarobase() {
		String mail = test.emailVerif("jarzer.gmail.com");

		Assert.assertEquals("", mail);
	}

	@Test
	public void testmailnoendpoint() {
		String mail = test.emailVerif("zaedgre@gmailcom");

		Assert.assertEquals("", mail);
	}

	@Test
	public void testmaildoubleendpointok() {
		String mail = test.emailVerif("azrazkop@gmail.dt.com");

		Assert.assertEquals("azrazkop@gmail.dt.com", mail);
	}

	@Test
	public void testmailchiffre() {
		String mail = test.emailVerif("aze16456@gmail.com");

		Assert.assertEquals("aze16456@gmail.com", mail);
	}

	@Test
	public void testmailaccent() {
		String mail = test.emailVerif("azeééé16456@gmail.com");

		Assert.assertEquals("", mail);
	}

	@Test
	public void testmaildoublearo() {
		String mail = test.emailVerif("aze16@456@gmail.com");

		Assert.assertEquals("", mail);
	}

	@Test
	public void testmailmajetdoubleendpointnok() {
		String mail = test.emailVerif("aze.RZETER16456@gmail..com");

		Assert.assertEquals("", mail);
	}

	@Test
	public void testmailcaracspe() {
		String mail = test.emailVerif("aze&'(ZETER16456@gmail.com");

		Assert.assertEquals("", mail);
	}

	@Test
	public void testadresseok() {
		String adresse = test.adresseVerif("2 rue de la Sainte-Croix");

		Assert.assertEquals("2 rue de la Sainte-Croix", adresse);
	}

	@Test
	public void testadressenok() {
		String adresse = test.adresseVerif("la rue etga#@&&");

		Assert.assertEquals("", adresse);
	}

	@Test
	public void testcpok() {
		String cp = test.cpVerif("75012");

		Assert.assertEquals("75012", cp);
	}

	@Test
	public void testcpnokmoins() {
		String cp = test.cpVerif("7501");

		Assert.assertEquals("", cp);
	}

	@Test
	public void testcpnokplus() {
		String cp = test.cpVerif("7501123");

		Assert.assertEquals("", cp);
	}

	@Test
	public void testcpnoklettre() {
		String cp = test.cpVerif("750sq");

		Assert.assertEquals("", cp);
	}

	@Test
	public void testvillenok() {
		String nom = test.villeVerif("054 pazeo");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testvilleok() {
		String nom = test.villeVerif("'-Paul");

		Assert.assertEquals("'-paul", nom);
	}

	@Test
	public void testvilleokaccent() {
		String nom = test.villeVerif("Jérémy");

		Assert.assertEquals("jérémy", nom);
	}

	@Test
	public void testvillenoklong() {
		String nom = test.villeVerif("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");

		Assert.assertEquals("", nom);
	}

	@Test
	public void testtelfixokaccent() {
		String num = test.telFixVerif("Jérémy");

		Assert.assertEquals("", num);
	}

	@Test
	public void testtelfixneufchiffre() {
		String num = test.telFixVerif("047385258");

		Assert.assertEquals("", num); 
	}

	@Test
	public void testtelfixok() {
		String num = test.telFixVerif("0473852589");

		Assert.assertEquals("0473852589", num);
	}

	@Test
	public void testtelfixonzechiffre() {
		String num = test.telFixVerif("047385258484");

		Assert.assertEquals("", num);
	}

	@Test
	public void testtelfixpremierchhiffrefaux() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				String a = Integer.toString(i) + Integer.toString(j) + "856274";
				String num = test.telFixVerif(a);
if (a.equals("01")||a.equals("02")||a.equals("03")||a.equals("04")||a.equals("05")||a.equals("08")||a.equals("09")) {
	Assert.assertEquals(a + "856274", num);
}else {
	Assert.assertEquals("", num);
}
			
			}
		}

	}
	
	@Test
	public void testtelportokaccent() {
		String num = test.telPortVerif("Jérémy");

		Assert.assertEquals("", num);
	}

	@Test
	public void testtelPortneufchiffre() {
		String num = test.telPortVerif("067385258");

		Assert.assertEquals("", num); 
	}

	@Test
	public void testPortfixok() {
		String num = test.telPortVerif("0673852589");

		Assert.assertEquals("0673852589", num);
	}
	@Test
	public void testPortfixok2() {
		String num = test.telPortVerif("0773852589");

		Assert.assertEquals("0773852589", num);
	}

	@Test
	public void testtelPortonzechiffre() {
		String num = test.telPortVerif("067385258484");

		Assert.assertEquals("", num);
	}
	@Test
	public void testdateNaissance() {
		Date num = test.dateNaissanceVerif("29/06/1990");

		Assert.assertEquals("1990/06/29", num);
	}
	
	@Test
	public void testnumSecu() {
		String num = test.numSecuVerif("190062A11335323");

		Assert.assertEquals("190062A11335323", num);
	}
	@Test
	public void testnumSecu2() {
		String num = test.numSecuVerif("390062A11335323");

		Assert.assertEquals("", num);
	}
	@Test
	public void testnumSecu3() {
		String num = test.numSecuVerif("190062A11A35323");

		Assert.assertEquals("", num);
	}
	
	@Test
	public void testNationaliteokaccent() {
		String nom = test.nationaliteVerif("Saint-Marinoise");

		Assert.assertEquals("Saint-Marinoise", nom);
	}
	@Test
	public void testsituation() {
		SITUATION situation = test.situationVerif("salarié");

		Assert.assertEquals(SITUATION.SALARIE, situation);
	}
	@Test
	public void testsituation1() {
		SITUATION situation = test.situationVerif("auto entrepreneur");

		Assert.assertEquals(SITUATION.AUTO_ENTREPRENEUR, situation);
	}
	@Test
	public void testsituation2() {
		SITUATION situation = test.situationVerif("freelance");

		Assert.assertEquals(SITUATION.FREELANCE, situation);
	}
	@Test
	public void testsituation3() {
		SITUATION situation = test.situationVerif("demandeur d'emplois");

		Assert.assertEquals(SITUATION.DEMANDEUR, situation);
	}
	@Test
	public void testsituation4() {
		SITUATION situation = test.situationVerif("autre");

		Assert.assertEquals(SITUATION.AUTRE, situation);
	}
	@Test
	public void testsituation5() {
		SITUATION situation = test.situationVerif("retraité");

		Assert.assertEquals(SITUATION.RETRAITE, situation);
	}
	
	
}
