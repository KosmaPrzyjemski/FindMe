package modele;

public class Connexion {
	private String mdp = "Admin";
	private boolean isConnected = false;
	
	public Connexion() {
	}
	
	public boolean isConnected() {
		return isConnected;
	}
	
	public void connexion(String mdp) {
		if (this.mdp.equals(mdp)) {
			isConnected = true;
		} 
	}
	
	public void deconnexion() {
		isConnected = false;
	}
	
}
