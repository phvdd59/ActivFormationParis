package com.formation.beba.metier;

public class Ascenseur extends Thread {
	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_Etage = 30;
	public ListePersonne lst;
	public static boolean lstPersFin;

	private int etage;
	private int progression;
	private boolean fin;
	private Personne personne;

	public Ascenseur(String nom, ListePersonne lst) {
		super(nom);
		lstPersFin = false;
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

	@Override
	public void run() {
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			if (personne == null) {
				synchronized (lst) {
					if (lst.isSortie() && lst.size() == 0) {
						fin = true;
					} else {
						if (lst.size() > 0) {

							lst.get(0).setEtat(ETAT.ETAT_DEPART.ordinal());
							this.setPersonne(lst.get(0));
							lst.remove(0);
						}
					}
				}
			} else if (personne.getEtat() == ETAT.ETAT_DEPART.ordinal()) {

				this.leMove(personne.getDepart());

				personne.setEtat(ETAT.ETAT_MOVE.ordinal());
				this.leMove(personne.getArrive());

			} else if (personne.getEtat() == ETAT.ETAT_MOVE.ordinal()) {

				personne.setEtat(ETAT.ETAT_ARRIVE.ordinal());
				System.err.println(personne.getNom() + " est arrivé à l'étage " + etage + " de l'etage " + personne.getDepart());
				personne = null;
			} else if (lst.isSortie()) {
				if (lst.size() == 0) {
					fin = true;
				}
			}
		}
	}

	private void deplacement(int etageFin) {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if (etage < etageFin) {
			this.setEtage(++etage);
			// System.out.println("l'ascenser " + this.getName() + " va de " + "
			// de " + etagePre + " vers " + etage);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			this.setEtage(--etage);
			// System.out.println("l'ascenser " + this.getName() + " va de " + "
			// de " + etagePre + " vers " + etage);
			try {
				Thread.sleep(10);
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

	public static boolean isLstPersFin() {
		return lstPersFin;
	}

	public static void setLstPersFin(boolean lstPersFin) {
		Ascenseur.lstPersFin = lstPersFin;
	}

}
