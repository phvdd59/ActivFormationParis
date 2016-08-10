package com.formation.frva.metier;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur {

	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_ETAGE = 30;

	private String nom;
	private int etage;
	private int progression;
	private boolean fin;
	private InterPersonne personne;
	public InterListPersonne lPers = null;

	private int maProgression = 0;
	private InterAffichage affichage;


	public Ascenseur(InterListPersonne listePersonne, InterAffichage affichage) {
		super(Integer.toString(CPT));
		this.nom = Integer.toString(CPT);
		CPT++;
		this.etage = 0;
		this.progression = 0;
		this.fin = false;
		this.lPers = listePersonne;
		this.affichage = affichage;
	}

	@Override
	public void run() {
		while (!fin) {
			try {
				Thread.sleep(TEMPS);
			} catch (InterruptedException e) {
			}
			if (personne == null) {
				synchronized (lPers) {
					if (lPers.size() == 0 && Personne.CPT >= ListePersonne.NBMAXPERS) {
						fin = true;
					}
					if (lPers.size() > 0) {
						personne = lPers.remove(0);
						personne.setEtat(ETAT.DEPART);
						System.out.println(nom +"    J'ai pris l'appel de " + personne.toString());
					}
				}
				maProgression = 0;
			} else {
				if (personne.getEtat() == ETAT.DEPART) {
					deplaceAscenseurVersDepart();
				} else {
					if (personne.getEtat() == ETAT.MOVE) {
						deplaceAscenseurVersArrrivee();
						
					} else {
						if (personne.getEtat() == ETAT.ARRIVE) {
							personne = null;
						}
					}
				}
			}
			affichage.repaint();
		}
		System.out.println(nom +"    Voilà c'est fini"); 
	}

	public void deplaceAscenseurVersDepart() {
		if (maProgression < 30) {
			maProgression++;
		} else {
			maProgression = 0;
			System.out.println(nom +"    Je suis au "+etage + " et je vais au " + personne.getDepart());
			if (etage < personne.getDepart()) {
				etage++;
			} else {
				if (etage > personne.getDepart()) {
					etage--;
				} else {
					personne.setEtat(ETAT.MOVE);
					System.out.println(nom +"    La personne monte dans mon ascenceur au "+etage);
				}
			}
		}
	}

	public void deplaceAscenseurVersArrrivee() {
		if (maProgression < 30) {
			maProgression++;
		} else {
			System.out.println(nom +"    Je suis au "+etage + " et je vais au " + personne.getArrivee());
			maProgression = 0;
			if (etage < personne.getArrivee()) {
				etage++;
			} else {
				if (etage > personne.getArrivee()) {
					etage--;
				} else {
					personne.setEtat(ETAT.ARRIVE);
					System.out.println(nom +"    Je suis me déleste à l'étage "+etage + " de mon client " + personne.toString());
					
				}
			}
		}
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
}
