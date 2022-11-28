package modele;

public class RequetteTexte extends Requette {
	private int tauxSimilarite;
	
	public RequetteTexte(String nom,int taux) {
		super(nom,TypeFichier.TEXTE);
		tauxSimilarite = taux;
	}
	

	public int getTauxSimilarite() {
		return tauxSimilarite;
	}
	
	
	public String toString() {
		return "["+super.toString()+" : fichier avec un taux de "+tauxSimilarite+"%]";
	}
}
