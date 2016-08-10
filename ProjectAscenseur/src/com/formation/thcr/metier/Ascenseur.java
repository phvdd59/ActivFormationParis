package com.formation.thcr.metier;

public class Ascenseur extends Thread {

	public static int		CPT				= 0;
	public static int		TEMPS			= 20;	//Temps pour passer un pixel
	public static int		HAUTEUR_ETAGE	= 30;	//hauteur d'un étage (en pixels)

	private ListPersonne	listPersonne;

	private int				etage;
	private int				progression;			//animation ascenseur
	private boolean			fin;					//Fin du thread
	private Personne		personne;

	public Ascenseur() {
		this.etage = 0;
		this.fin = false;
		this.personne = null;
		this.progression = 0;
		CPT++;
	}

	public Ascenseur(ListPersonne listPersonne) {
		this.listPersonne = listPersonne;
		this.etage = 0;
		this.fin = false;
		this.personne = null;
		this.progression = 0;
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

	public Personne getPersonne() {
		return personne;
	}

	public void setPersonne(Personne personne) {
		this.personne = personne;
	}

	public ListPersonne getListPersonne() {
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
				if (personne == null) {
					synchronized (listPersonne) {
						if (listPersonne.size() == 0 && listPersonne.isSortie()) {
							this.setFin(true);
						} else {
							this.setPersonne(rechercheDePersonneEnAttente());
							if (this.personne == null) {
							} else {
								this.personne.setEtat(ETAT.DEPART.ordinal());
							}
						}
					}
				} else {
					if (personne.getEtat() == ETAT.DEPART.ordinal()) {
						deplaceAscenseur(this.getPersonne().getDepart());
					} else if (personne.getEtat() == ETAT.MOVE.ordinal()) {
						deplaceAscenseur(this.getPersonne().getArrive());
					} else if (personne.getEtat() == ETAT.ARRIVE.ordinal()) {
						this.personne = null;
					}
				}
				// Methode Sequentielle
				//				synchronized (listPersonne) { //recherche dans liste 
				//					for (int i = 0; i < this.listPersonne.size(); i++) {
				//						if (listPersonne.get(i).getEtat() == ETAT.ETAT_ATTENTE.ordinal()) {
				//							this.setPersonne(this.listPersonne.remove(i));
				//							break;
				//						}
				//					}
				//				}
				//				System.out.println(Thread.currentThread().getName() + " " + this.getPersonne());
				//				System.out.println(Thread.currentThread().getName() + " étage : " + this.getEtage());
				//				this.getPersonne().setEtat(ETAT.ETAT_DEPART.ordinal());
				//				while (this.getEtage() != this.getPersonne().getDepart()) {
				//					Thread.sleep(200);
				//					this.setEtage(this.getPersonne().getDepart());
				//				}
				//				System.out.println(Thread.currentThread().getName() + " étage : " + this.getEtage());
				//				System.out.println(Thread.currentThread().getName() + " arrivé a départ : " + this.getEtage());
				//				this.getPersonne().setEtat(ETAT.ETAT_MOVE.ordinal());
				//				while (this.getEtage() != this.getPersonne().getArrive()) {
				//					Thread.sleep(100);
				//					this.setEtage(this.getPersonne().getArrive());
				//				}
				//				System.out.println(Thread.currentThread().getName() + " étage : " + this.getEtage());
				//				this.getPersonne().setEtat(ETAT.ETAT_ARRIVE.ordinal());
				//				this.setPersonne(null);
				//				System.out.println(Thread.currentThread().getName() + " arrivé à arrivé : " + this.getEtage());
				//				if (this.listPersonne.isEmpty()) {
				//					this.setFin(true);
				//				}
			} catch (InterruptedException | NullPointerException e) {
				e.printStackTrace();
			}
		}
		System.out.println("FIN " + Thread.currentThread().getName());
	}

	private void deplaceAscenseur(int direction) {
		if (this.getEtage() > direction) {
			progression--;
			//			System.out.println(this.progression);
			if (progression % HAUTEUR_ETAGE == 0) {
				this.etage--;
				System.out.println(this);
			}
		} else if (this.getEtage() < direction) {
			progression++;
			//			System.out.println(this.progression);
			if (progression % HAUTEUR_ETAGE == 0) {
				this.etage++;
				System.out.println(this);
			}
		} else {
			if (this.personne.getEtat() == ETAT.DEPART.ordinal()) {
				this.personne.setEtat(ETAT.MOVE.ordinal());
			} else {
				this.personne.setEtat(ETAT.ARRIVE.ordinal());
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

	private Personne rechercheDePersonneEnAttente() {
		Personne pers = new Personne();
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

}
