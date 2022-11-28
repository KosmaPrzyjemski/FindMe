package modele;

public abstract class Requette {
	private String nom; // nom sans modifications
	private TypeFichier type;
	
	public Requette(String nom,TypeFichier type) {
		this.nom = nom;
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public TypeFichier getType() {
		return type;
	}
	
	public String toString() {
		return "Requette de type "+type+" ("+nom+")";
	}
	
}
