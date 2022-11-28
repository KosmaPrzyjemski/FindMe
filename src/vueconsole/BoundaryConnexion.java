package vueconsole;

import controleur.ControlConnexion;
import modele.Clavier;

public class BoundaryConnexion {
	private ControlConnexion controlConnexion = new ControlConnexion();

	public BoundaryConnexion(ControlConnexion controlConnexion) {
		this.controlConnexion = controlConnexion;
	}

	public void menuConnexion() {
		if (!controlConnexion.isConnected()) {
			System.out.println("1. Connexion\n" + "0. Retour menu principal");
			int choixDeconnected = Clavier.entrerClavierInt();
			switch (choixDeconnected) {
			case 1 :
				System.out.println("Mot de passe : ");
				String mdp = Clavier.entrerClavierString();
				controlConnexion.connexion(mdp);
				if (controlConnexion.isConnected()) {
					System.out.println("Vous etes bien connecte!");
				} else {
					System.out.println("Mot de passe incorrecte, essayez encore une fois.");
				}
				break;
			case 0 : 
				setBooleanMenuConnexion(false);
				break;
			}
		} else {
			System.out.println("1. Deconnexion\n" + "0. Retour menu principal");
			int choixConnected = Clavier.entrerClavierInt();
			switch (choixConnected) {
			case 1 :
				controlConnexion.deconnexion();
				System.out.println("Vous etes deconnecte.");
				break;
			case 0 : 
				setBooleanMenuConnexion(false);
				break;
			}
		}
	}
	
	public boolean isConnected() {
		return controlConnexion.isConnected();
	}
	
	public boolean getBooleanMenuConnexion(){
		return controlConnexion.getBooleanMenuConnexion();
	}
	
	public void setBooleanMenuConnexion(boolean choice){
		controlConnexion.setBooleanMenuConnexion(choice);
	}
	
}
