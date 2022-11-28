package modele;

public class Triplet {
	private String mot;
	private boolean plus;
	private int apparition;
	
	public Triplet(String nom,boolean plus,int apparition) {
		this.apparition = apparition;
		this.mot = nom;
		this.plus = plus;
	}

	public String getMot() {
		return mot;
	}

	public boolean isPlus() {
		return plus;
	}

	public int getApparition() {
		return apparition;
	}
	
	public String toString() {
		if(plus) {
			return "presence de "+mot+" "+apparition+"x";
		}else {
			return "abscence de "+mot;
		}
	}
	
}
