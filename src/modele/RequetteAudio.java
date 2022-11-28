package modele;

public class RequetteAudio extends Requette{
	private int tauxSimilarite;
	
	public RequetteAudio(String nom,int taux) {
		super(nom,TypeFichier.AUDIO);
		tauxSimilarite = taux;
	}
	

	public int getTauxSimilarite() {
		return tauxSimilarite;
	}
	
	public String toString() {
		return "["+super.toString()+" : fichier avec un taux de "+tauxSimilarite+"%]";
	}
}
