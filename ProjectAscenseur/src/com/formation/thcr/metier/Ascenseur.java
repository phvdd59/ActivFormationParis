package com.formation.thcr.metier;

import com.formation.phva.inter.InterAffichage;
import com.formation.phva.inter.InterAscenseur;
import com.formation.phva.inter.InterListPersonne;
import com.formation.phva.inter.InterPersonne;

public class Ascenseur extends Thread implements InterAscenseur, InterAffichage {

	public static int			CPT				= 0;
	public static int			TEMPS			= 20;	//Temps pour passer un pixel
	public static int			HAUTEUR_ETAGE	= 30;	//hauteur d'un étage (en pixels)

	private InterListPersonne	listPersonne;

	private int					etage;
	private int					progression;			//animation ascenseur
	private boolean				fin;					//Fin du thread
	private InterPersonne		personne;
	private InterAffichage		affichage;

	public Ascenseur(ListPersonne listPersonne, InterAffichage affichage) {
		super.setName(Integer.toString(CPT));
		this.listPersonne = listPersonne;
		this.etage = 0;
		this.fin = false;
		this.personne = null;
		this.progression = 0;
		this.affichage = affichage;
		CPT++;
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

	public void setPersonne(InterPersonne interPersonne) {
		this.personne = interPersonne;
	}

	public InterListPersonne getListPersonne() {
		return listPersonne;
	}

	public void setListPersonne(ListPersonne listPersonne) {
		this.listPersonne = listPersonne;
	}

	@Override
	public void run() {
		while (!this.fin) {
			try {
				Thread.sleep(TEMPS);
			}catch (InterruptedException e){
				e.printStackTrace();
			}
				if (personne == null) {
					synchronized (listPersonne) {
						if (listPersonne.size() == 0 && listPersonne.isSortie()) {
							this.setFin(true);
						} else {
							this.setPersonne(rechercheDePersonneEnAttente());
							if (this.personne == null) {
							} else {
								this.personne.setEtat(ETAT.DEPART);
							}
						}
					}
				} else {
					if (personne.getEtat() == ETAT.DEPART) {
						deplaceAscenseur(this.getPersonne().getDepart());
					} else if (personne.getEtat() == ETAT.MOVE) {
						deplaceAscenseur(this.getPersonne().getArrivee());
					} else if (personne.getEtat() == ETAT.ARRIVE) {
						this.personne = null;
					}
				}
				affichage.repaint();
		}
		System.out.println("FIN " + Thread.currentThread().getName());
	}

	private void deplaceAscenseur(int direction) {
		if (this.getEtage() > direction) {
			progression--;
			if (progression % HAUTEUR_ETAGE == 0) {
				this.etage--;
				progression = 0;
			}
		} else if (this.getEtage() < direction) {
			progression++;
			if (progression % HAUTEUR_ETAGE == 0) {
				this.etage++;
				progression = 0;
			}
		} else {
			if (this.personne.getEtat() == ETAT.DEPART) {
				this.personne.setEtat(ETAT.MOVE);
			} else {
				this.personne.setEtat(ETAT.ARRIVE);
			}
		}
	}
	//	private void deplaceAscenseurVersArrive() {
	//		if (this.getEtage() > this.personne.getArrive()) {
	//			this.etage--;
	//		} else if (this.getEtage() < this.personne.getArrive()) {
	//			this.etage++;
	//		} else {
	//			this.personne.setEtat(ETAT.ETAT_ARRIVE.ordinal());
	//		}
	//	}
	//
	//	private void deplaceAscenseurVersDepart() {
	//		if (this.getEtage() > this.personne.getDepart()) {
	//			this.etage--;
	//		} else if (this.getEtage() < this.personne.getDepart()) {
	//			this.etage++;
	//		} else {
	//			this.personne.setEtat(ETAT.ETAT_MOVE.ordinal());
	//		}
	//	}

	private InterPersonne rechercheDePersonneEnAttente() {
		InterPersonne pers = null;
		if (listPersonne.size() > 0) {
			pers = listPersonne.remove(listPersonne.size() - 1);
		}
		//		for (int i = 0; i < this.listPersonne.size(); i++) {
		//			if (listPersonne.get(i).getEtat() == ETAT.ETAT_ATTENTE.ordinal()) {
		//				pers = (this.listPersonne.remove(i));
		//				break;
		//			}
		//		}
		return pers;
	}

	@Override
	public String toString() {
		return Thread.currentThread().getName() + ", etage=" + etage + ", personne=" + personne + " ";
	}

	@Override
	public void repaint() {

	}

}
