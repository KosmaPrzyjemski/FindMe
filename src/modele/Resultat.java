package modele;

public class Resultat {
	private String nom;
	private int pourcentage;
	TypeFichier type;
	
	public Resultat(TypeFichier type) {
		nom = "test";
		pourcentage = 42;
		this.type = type;
	}
	public Resultat(String nom,int pourentage,TypeFichier type) {
		this.nom = nom;
		this.pourcentage = pourentage;
		this.type = type; 
	}

	public String getNom() {
		return nom;
	}

	public int getPourcentage() {
		return pourcentage;
	}
	
	public String toString() {
		return "fichier "+type+ " : "+nom+" "+pourcentage+"%";
	}
	
}
