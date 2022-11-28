package modele;

public class RequetteImage extends Requette{
	private int tauxSimilarite;
	
	public RequetteImage(String nom,int taux) {
		super(nom,TypeFichier.IMAGE);
		tauxSimilarite = taux;
	}
	

	public int getTauxSimilarite() {
		return tauxSimilarite;
	}
	
	public String toString() {
		return "["+super.toString()+" : fichier avec un taux de "+tauxSimilarite+"%]";
	}
	
}
