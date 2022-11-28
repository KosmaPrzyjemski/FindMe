package modele;

public class RequetteCouleur extends Requette {
	Couleur couleur;
	
	public RequetteCouleur(String nom,Couleur coul) {
		super(nom,TypeFichier.IMAGE);
		couleur = coul;
	}
	
	public Couleur getCouleur() {
		return couleur;
	}
	
	public String toString() {
		return super.toString()+" : Recherche de "+couleur;
	}
}
