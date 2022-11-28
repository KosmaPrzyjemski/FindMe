package controleur;

import java.util.ArrayList;

import modele.Moteur;
import modele.Parametres;

public class ControlParametres {
	private Parametres parametres;
	private boolean menuParametres = false;

	public ControlParametres(Parametres parametres) {
		this.parametres = parametres;
	}
	
	public boolean getBooleanMenuParametres(){
		return menuParametres;
	}
	
	public void setBooleanMenuParametres(boolean choice) {
		menuParametres = choice;
	}

	public void activerActualisationDonnees() {
		parametres.activerActialisationDonnees();
	}

	public void desactiverActualisationDonnees() {
		parametres.desactiverActialisationDonnees();
	}

	public void activerMoteur(Moteur moteur) {
		parametres.activerMoteur(moteur);
	}

	public void desactiverMoteur(Moteur moteur) {
		parametres.desactiverMoteur(moteur);
	}
	
	public ArrayList<Moteur> getListeMoteurs() {
		return parametres.getListeMoteurs();
	}
	/*
	public String getStringListeMoteurs() {
		return parametres.listeMoteursToString();
	}
	*/
	
	public void ajouterFichier(String fichier) {
		parametres.ajouterFichier(fichier);
	}
	
	public void addMoteur(Moteur moteur) {
		parametres.addMoteur(moteur);
	}

	public boolean actialisationDonneesIsActive() {
		return parametres.actialisationDonneesIsActive();
	}

	public int getNombreMoteurs() {
		return parametres.getNombreMoteurs();
	}

	public Moteur getMoteurViaIndex(int choix) {
		return parametres.getMoteurViaIndex(choix);
	}

	public void desactiverTout() {
		parametres.desactiverMoteurs();
		
	}

}
