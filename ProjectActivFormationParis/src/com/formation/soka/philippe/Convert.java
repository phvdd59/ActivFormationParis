package com.formation.soka.philippe;

public class Convert {

	public float inchToMeter(float inch) {
		return inch * 2.54f / 100f;
	}

	public float meterToInch(float meter) {
		return meter / 2.54f * 100f;
	}

	public Personne nomPersonne(int id) {
		ListPersonne listPersonne = new ListPersonne();
		Personne personne = null;
		for (int i = 0; i < 10; i++) {
			personne = new Personne();
			personne.setIdPersonne(i);
			personne.setNom("toto " + i);
			listPersonne.add(personne);
		}

		String nom = "";
		Personne p = null;
		for (int i = 0; i < 10; i++) {
			if (id == listPersonne.get(i).getIdPersonne()) {
				p = listPersonne.get(i);
				DocPerso[] d = new DocPerso[1];
				d[0] = new DocPerso();
				d[0].setIdDoc(1);
				d[0].setNomDocFile("Souad");
				p.setListeDoc(d);
			}
		}
		return p;
	}
}