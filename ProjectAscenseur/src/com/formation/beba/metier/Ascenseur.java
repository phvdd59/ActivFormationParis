package com.formation.beba.metier;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur {
	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_Etage = 30;
	public InterListPersonne lst;
	public static boolean lstPersFin;
	private InterAffichage affichage;

	private int etage;
	private int progression = 0;
	private boolean fin;
	private InterPersonne personne;

	public Ascenseur(String nom, InterListPersonne lst, InterAffichage affichage) {
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

	public InterPersonne getPersonne() {
		return personne;
	}

	public void setPersonne(InterPersonne personne) {
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
				e1.printStackTrace();
			}
			if (personne == null) {
				synchronized (lst) {
					if (lst.isSortie() && lst.size() == 0) {
						fin = true;
					} else {
						if (lst.size() > 0) {
							this.setPersonne(lst.remove(lst.size() - 1));
							personne.setEtat(ETAT.ETAT_DEPART);
							// System.out.println("l'ascenseur " +
							// this.getName() + " va vers " +
							// personne.getNom());
						}
					}
				}

			} else if (personne.getEtat() == ETAT.ETAT_DEPART) {

				this.leMove(personne.getDepart());

				if (etage == personne.getDepart()) {
					// System.out.println("l'ascenseur " + this.getName() + "
					// embarque " + personne.getNom());
					personne.setEtat(ETAT.ETAT_MOVE);

				}

			} else if (personne.getEtat() == ETAT.ETAT_MOVE) {

				this.leMove(personne.getArrivee());

				if (etage == personne.getArrivee()) {
					personne.setEtat(ETAT.ETAT_ARRIVE);

					// System.err.println(personne.getNom() + " est arrivé à
					// l'étage " + personne.getArrive() + " de l'etage " +
					// personne.getDepart());
					personne = null;
				}
			} else if (lst.isSortie()) {
				if (lst.size() == 0) {
					fin = true;
				}
			}
			affichage.repaint();
		}
	}

	private void leMove(int etageFin) {
		if (etage < etageFin) {
			progression++;
			if (progression % 30 == 0) {
				// System.out.println(progression + " " + etage);
				this.setEtage(++etage);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} else {
			progression--;
			if (progression % 30 == 0) {
				// System.out.println(progression + " " + etage);
				this.setEtage(--etage);
			}
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		// this.deplacement(etageFin);
	}

	public static boolean isLstPersFin() {
		return lstPersFin;
	}

	public static void setLstPersFin(boolean lstPersFin) {
		Ascenseur.lstPersFin = lstPersFin;
	}

}
