package vueconsole;

import java.util.ArrayList;

import controleur.ControlParametres;
import modele.Clavier;
import modele.Moteur;

public class BoundaryParametres {
	private ControlParametres controlParametres;
	
	public BoundaryParametres(ControlParametres controlParametres) {
		this.controlParametres = controlParametres;
	}
	
	public void menuParametres() {
		System.out.println("Voici les moteurs de recherche disponibles :");
		System.out.println("\n"+getListeMoteurs() +"\n");
		System.out.println("Veuillez choisir une action parmis :");
		if (!controlParametres.actialisationDonneesIsActive()) {
			System.out.println("1. Activer l'actualisation des donnees.\n"
					+ "2. Activer un moteur de recherche.\n"
					+ "3. Desactiver un moteur de recherche.\n"
					+ "0. Retour au menu principal.");
			
			int choix1 = Clavier.entrerClavierInt();
			switch1(choix1);
		} else {
			System.out.println("1. Desactiver l'actualisation des donnees.\n"
					+ "2. Activer un moteur de recherche.\n"
					+ "3. Desactiver un moteur de recherche.\n"
					+ "4. Ajouter un fichier.\n"
					+ "0. Retour au menu principal.");
			int choix2 = Clavier.entrerClavierInt();
			switch2(choix2);
		}
	}

	private void switch1(int choix1) {
		switch (choix1) {
		case 1 :
			System.out.println("Activation d'actualisation des donnees.");
			controlParametres.activerActualisationDonnees();
			break;
		case 2 : 
			activerMoteur();
			break;
		case 3 :
			desactiverMoteur();
			break;
		case 0 :
			System.out.println("Exit --> Menu Principal\n");
			controlParametres.setBooleanMenuParametres(false);
			break;
		default :
			System.out.println("Option inconnu");
		}
	}
	
	private void switch2(int choix2) {
		switch (choix2) {
		case 1 :
			System.out.println("Desactivation d'actualisation des donnees.");
			controlParametres.desactiverActualisationDonnees();
			break;
		case 2 : 
			activerMoteur();
			break;
		case 3 :
			desactiverMoteur();
			break;
		case 4 :
			System.out.println("Veuillez saisir votre fichier :");
			String fichier = Clavier.entrerClavierString();
			controlParametres.ajouterFichier(fichier);
			break;
		case 0 :
			System.out.println("Exit --> Menu Principal");
			controlParametres.setBooleanMenuParametres(false);
			break;
		default :
			System.out.println("Option inconnu. Veuillez essayer encore une fois.");
			break;
		}
	}
	
	public boolean getBooleanMenuParametres(){
		return controlParametres.getBooleanMenuParametres();
	}
	
	public void setBooleanMenuParametres(boolean choice) {
		controlParametres.setBooleanMenuParametres(choice);
	}
	
	public void activerMoteur() {
		int choix;
		int nombreMoteurs = controlParametres.getNombreMoteurs();
		String stringListeMoteurs = getListeMoteurs();
		do {
			System.out.println("Veuillez choisir lequel moteur vous voulez activer parmis :");
			System.out.println(stringListeMoteurs);
			choix = Clavier.entrerClavierInt();
		} while (!((choix>0) && (choix<=nombreMoteurs)));
		Moteur moteur = controlParametres.getMoteurViaIndex(choix);
		System.out.println("Activation du moteur de recherche : " + moteur.getNom());
		controlParametres.activerMoteur(moteur);
	}
	
	public void desactiverMoteur() {
		int choix;
		int nombreMoteurs = controlParametres.getNombreMoteurs();
		String stringListeMoteurs = getListeMoteurs();
		do {
			System.out.println("Veuillez choisir lequel moteur vous voulez desactiver parmis :");
			System.out.println(stringListeMoteurs);
			choix = Clavier.entrerClavierInt();
		} while (!((choix>0) && (choix<=nombreMoteurs)));
		Moteur moteur = controlParametres.getMoteurViaIndex(choix);
		System.out.println("Desactivation du moteur de recherche : " + moteur.getNom());
		controlParametres.desactiverMoteur(moteur);
	}
	
	public String getListeMoteurs() {
		ArrayList<Moteur> listeMoteurs = controlParametres.getListeMoteurs();
		int i = 1;
		String stringListeMoteurs = "";
		for (Moteur moteur : listeMoteurs) {
			stringListeMoteurs += i + ". "+moteur.getNom() + " : active = " + moteur.moteurIsActive() + "\n";
			i++;
		}
		return stringListeMoteurs;
	}
	
}
