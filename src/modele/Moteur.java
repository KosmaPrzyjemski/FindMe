package modele;

public class Moteur {
	public String nomMoteur;
	public boolean moteurActive = false;
	
	public Moteur(String name) {
		nomMoteur = name;
	}
	
	public void activerMoteur() {
		moteurActive = true;
	}
	
	public void desactiverMoteur() {
		moteurActive = false;
	}
	
	public boolean moteurIsActive() {
		return moteurActive;
	}
	
	public String toSring() {
		return nomMoteur + " : active = " + moteurActive;
	}

	public String getNom() {
		return nomMoteur;
	}
}
