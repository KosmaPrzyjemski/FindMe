package controleur;

import modele.Connexion;

public class ControlConnexion {
	Connexion classeConnexion = new Connexion();
	private boolean menuConnexion = false;
	
	public ControlConnexion() {
	}
	
	public boolean isConnected() {
		return classeConnexion.isConnected();
	}
	
	public void connexion(String mdp) {
		classeConnexion.connexion(mdp);
	}
	
	public void deconnexion() {
		classeConnexion.deconnexion();
	}
	
	public boolean getBooleanMenuConnexion(){
		return menuConnexion;
	}
	
	public void setBooleanMenuConnexion(boolean choice){
		menuConnexion = choice;
	}
}
