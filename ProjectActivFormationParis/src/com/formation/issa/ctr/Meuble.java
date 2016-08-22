package com.formation.issa.ctr;

public class Meuble implements Comparable<Meuble>{
	private TRI tri;
	private String nomCommercial;
	private String refAbrege;
	private float longueur;
	private float largeur;
	private float hauteur;
	private ListeElmt lstElmt;
	private String unite;
	
	public Meuble(TRI tri, String nomCommercial, String unite, float longueur, float largeur, float hauteur){
		this.tri=tri;
		this.nomCommercial=nomCommercial;
		this.unite=unite;
		this.longueur=longueur;
		this.largeur=largeur;
		this.hauteur=hauteur;
		
	}
	public TRI getTri() {
		return tri;
	}
	public void setTri(TRI tri) {
		this.tri = tri;
	}
	public String getNomCommercial() {
		return nomCommercial;
	}
	public void setNomCommercial(String nomCommercial) {
		this.nomCommercial = nomCommercial;
	}
	public String getRefAbrege() {
		return refAbrege;
	}
	public void setRefAbrege(String refAbrege) {
		this.refAbrege = refAbrege;
	}
	public float getLongueur() {
		return longueur;
	}
	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}
	public float getLargeur() {
		return largeur;
	}
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}
	public float getHauteur() {
		return hauteur;
	}
	public void setHauteur(float hauteur) {
		this.hauteur = hauteur;
	}
	public ListeElmt getLstElmt() {
		return lstElmt;
	}
	public void setLstElmt(ListeElmt lstElmt) {
		this.lstElmt = lstElmt;
	}
	public String getUnite() {
		return unite;
	}
	public void setUnite(String unite) {
		this.unite = unite;
	}
	public Meuble(TRI tri, String nomCommercial, float longueur, float largeur, float hauteur){
		this.tri=tri;
		this.nomCommercial=nomCommercial;
		this.longueur=longueur;
		this.largeur=largeur;
		this.hauteur=hauteur;
		
	}
	public float AfficherVolume(){
		float volume=longueur*largeur*hauteur;
		return volume;
		
	}
	 public void prix(float taux, float promoPourecent, int isSolidite, float lstPrix){
		 //ArrayList<float> lstPrix=new ArrayLsit<float>();
		 Elmt element=new Elmt(tri, isSolidite, nomCommercial, isSolidite, lstPrix, lstPrix, lstPrix);
		 
		 
	 }
	@Override
	public int compareTo(Meuble obj) {
		int retour=0;
		if(this.getNomCommercial().compareTo(obj.nomCommercial)>0){
			retour=1;
		}else if(this.getNomCommercial().compareTo(obj.nomCommercial)<0){
			retour=-1;
		}else{
			if(this.getRefAbrege().compareTo(obj.getRefAbrege())>0){
				retour=1;
			}else if(this.getRefAbrege().compareTo(obj.getRefAbrege())<0){
				retour=-1;
			}else{
				if((int)this.getHauteur()*getLargeur()*getHauteur()<obj.getHauteur()*getLongueur()*getLargeur()){
					retour=-1;
				}else if((int)this.getHauteur()*getLargeur()*getHauteur()>obj.getHauteur()*getLongueur()*getLargeur()){
					retour=1;
				}else{
					retour=0;
				}
			}
		}
		return retour;
	}
	@Override
	public String toString() {
		return "Meuble [tri=" + tri + ", nomCommercial=" + nomCommercial + ", refAbrege=" + refAbrege + ", longueur=" + longueur + ", largeur=" + largeur + ", hauteur=" + hauteur + ", lstElmt=" + lstElmt + ", unite=" + unite + ", toString()=" + super.toString() + "]";
	}

}
