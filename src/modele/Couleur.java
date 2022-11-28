package modele;

import java.util.ArrayList;
import java.util.List;

public class Couleur {
	private int rouge = 0;
	private int vert = 0;
	private int bleu = 0;
	private String nom="toutes les couleurs";
	private List<Integer> RGB = new ArrayList<>();
	private boolean vide = true;

	// Constructeur vide
	public Couleur () {
	}
	
//	Constructeur avec niveau de r,v,b	
	public Couleur(int r,int v, int b, String nom) {
		rouge = r;
		vert = v;
		bleu = b;
		this.nom = nom; 
		vide = false;
	}
	
	public Couleur (String nom) {
		this.nom = nom;
	}
	
	public List<Integer> getRGB(){
		RGB.add(rouge);
		RGB.add(vert);
		RGB.add(bleu);
		return RGB;
	}
	
	public boolean isVide() {
		return vide;
	}

	public String getNomCouleur() {
		return nom;
	}
	
	public String toString() {
		return nom;
		
	}
	
	public void setCouleur(String nom) {
		this.nom = nom;
	}

	
}
