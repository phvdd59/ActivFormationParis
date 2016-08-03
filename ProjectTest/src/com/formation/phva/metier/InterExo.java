package com.formation.phva.metier;

import java.util.Date;

public interface InterExo {
	
	public void constructeurExoFra();
	public void constructeurExoFra(String nom);
	
	public void setDate(Date date);
	public void setCoordonnee(String adressMail, String tel);
	public void setMdpCache(String mdpCache);
	public String getNom();
	public void setNom(String nom);
	public String getAdresseMail();
	public void setAdresseMail(String adresseMail);
	public String getDateEmbauche();
	public void setDateEmbauche(String dateEmbauche);
	public String getTel();
	public void setTel(String tel);
	public String getMdp();
	public void setMdp(String mdp);
}
