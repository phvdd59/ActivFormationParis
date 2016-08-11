package com.formation.anfr.metier;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenceur extends Thread implements InterAscenseur{
	public static int CPT = 0;
	public static int TEMPS = 10;
	public static int HAUTEUR_ETAGE = 30;
	public InterListPersonne lst = null;
	private int etage;
	private int destination;
	private int progression;
	private boolean fin = false;
	private InterPersonne personne;
	private InterAffichage affichage;

	public Ascenceur(InterListPersonne lst, InterAffichage affichage) {
		super(Integer.toString(CPT));
		setLst(lst);
		setDestination(0);
		setEtage(0);
		setProgression(0);
		setPersonne(null);
		setFin(false);
		CPT++;
		this.affichage = affichage;
//		try {
//			Thread.sleep(500l + (long) Math.random() * 1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
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

	public InterListPersonne getLst() {
		return lst;
	}

	public void setLst(InterListPersonne lst) {
		this.lst = lst;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	private void mouvement(int etageFin) {
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (etage < etageFin) {
			progression++;
			if (progression % HAUTEUR_ETAGE == 0) {
				//System.out.println(Thread.currentThread().getName() + " : Je suis a l'étage " + etage);
				etage++;
				progression = 0;
			}
		}

		else if (etage > etageFin) {
			progression--;
			if (progression % HAUTEUR_ETAGE == 0) {
				//System.out.println(Thread.currentThread().getName() + " : Je suis a l'étage " + etage);
				etage--;
				progression = 0;
			}
		} else {
			if (personne.getEtat() == ETAT.ETAT_DEPART) {
				personne.setEtat(ETAT.ETAT_MOVE);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println(Thread.currentThread().getName() + " : Je charge  " + personne.toString());
			} else {
				//System.out.println(Thread.currentThread().getName() + " : " + personne.toString() + " est arrivé!");
				personne.setEtat(ETAT.ETAT_ARRIVE);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		// System.out.println("Ascenceur :
		// "+Thread.currentThread().getName()+" etage : "+etage);
	}

	private InterPersonne recherchePersonneEnAttente() {
		InterPersonne personneDispo = null;
		if (lst.size() > 0) {
			personneDispo = lst.remove(lst.size() - 1);
			personneDispo.setEtat(ETAT.ETAT_DEPART);

		}
		return personneDispo;
	}

	@Override
	public void run() {
		while (!fin) {
			if (personne == null) {
				synchronized (lst) {
					if (lst.size() == 0 && lst.isSortie()) {
						fin = true;
					} else {
						personne = recherchePersonneEnAttente();
					}

				}
			} else {
				if (personne.getEtat() == ETAT.ETAT_DEPART) {
					// System.out.println(Thread.currentThread().getName() + " :
					// Je me déplace de l'étage " + etage
					// + " vers l'étage " + personne.getDepart());
					mouvement(personne.getDepart());
				} else if (personne.getEtat() == ETAT.ETAT_MOVE) {
					// System.out.println(Thread.currentThread().getName() + " :
					// Je me déplace de l'étage " + etage
					// + " vers l'étage " + personne.getArrive());
					mouvement(personne.getArrivee());
				} else if (personne.getEtat() == ETAT.ETAT_ARRIVE) {
					personne = null;
				}
			}
			affichage.repaint();
		}
	}

}
