package com.formation.beba.metier;

public class Ascenseur extends Thread {
	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_Etage = 30;

	private int etage;
	private int progression;
	private boolean fin;
	private Personne personne;
	public ListePersonne lst;

	public Ascenseur(String nom, ListePersonne lst) {
		super(nom);
		this.lst = lst;
		this.personne = null;
		this.etage = 0;
		this.fin = false;

	}

	public static int getCPT() {
		return CPT;
	}

	public static void setCPT(int cPT) {
		CPT = cPT;
	}

	public static int getTEMPS() {
		return TEMPS;
	}

	public static void setTEMPS(int tEMPS) {
		TEMPS = tEMPS;
	}

	public static int getHAUTEUR_Etage() {
		return HAUTEUR_Etage;
	}

	public static void setHAUTEUR_Etage(int hAUTEUR_Etage) {
		HAUTEUR_Etage = hAUTEUR_Etage;
	}

	public int getEtage() {
		return etage;
	}

	public void setEtage(int etage) {
		this.etage = etage;
	}

	public int getProgression() {
		return progression;
	}

	public void setProgression(int progression) {
		this.progression = progression;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	@Override
	public String toString() {
		return "THE Ascenseur [etage au départ= " + etage + ", progression= " + progression + ", fin= " + fin + ", personne= " + personne + "]";
	}

	boolean passage;

	@Override
	public void run() {

		while (!fin) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int enCours = -1;
			synchronized (lst) {
				if (lst.size() > 5) {
					passage = false;
					for (int i = 0; i < lst.size(); i++) {
						if (lst.get(i).getEtat() == ETAT.ETAT_ATTENTE.ordinal()) {
							enCours = i;

							lst.get(i).setEtat(ETAT.ETAT_DEPART.ordinal());
							this.setPersonne(lst.get(i));
							lst.remove(i);

							break;
						}
					}
				}
			}
			if (enCours != -1) {

				this.leMove(lst.get(enCours).getDepart());
				passage = true;
				personne.setEtat(ETAT.ETAT_MOVE.ordinal());
				this.leMove(lst.get(enCours).getArrive());

				personne.setEtat(ETAT.ETAT_ARRIVE.ordinal());
				System.err.println(personne.getNom() + " est arrivé à l'étage " + etage + " de l'etage " + personne.getDepart());
				personne = null;
			}

		}
	}

	private void deplacement(int etageFin) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		int etagePre = etage;
		if (etage < etageFin) {
			this.setEtage(++etage);

			// System.out.println("l'ascenser " + this.getName() + " va de " + "
			// de " + etagePre + " vers " + etage);
			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			this.setEtage(--etage);

			// System.out.println("l'ascenser " + this.getName() + " va de " + "
			// de " + etagePre + " vers " + etage);
			try {
				this.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private void leMove(int etageFin) {
		while (etage != etageFin) {
			this.deplacement(etageFin);
		}

	}
}
