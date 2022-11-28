package controleur;

import java.util.List;

import modele.Couleur;
import modele.OptionsRecherche;

public class ControlChangerOptionsRecherche {
	// ATTRIBUTS
	OptionsRecherche optionsRecherche = OptionsRecherche.getInstance();
	
	//CONSTRUCTEUR
	public ControlChangerOptionsRecherche() {
	}
	
	
	//METHODES
	public void ajouterCouleur(Couleur couleur) {
		optionsRecherche.addCouleur(couleur);
	}
	
	public void changerTauxSimilarite(int newSimilarite) {
		optionsRecherche.setTauxSimilarite(newSimilarite);
	}
	
	
	public void changerCouleur(String newCouleur) {
		optionsRecherche.setCouleur(newCouleur);
	}
	
	public void changerNoApparitions(int newNoApparitions) {
		optionsRecherche.setNbApparition(newNoApparitions);
	}
	
	public String getListCouleursToString() {
		return optionsRecherche.getListCouleursToString();
	}
	
	public List<Couleur> getListCouleurs(){
		return optionsRecherche.getListCouleurs();
	}
	
	
	public Couleur getCouleurRecherche() {
		return optionsRecherche.getCouleur();
	}
	
	public String getCouleurRechercheString() {
		return optionsRecherche.getCouleurString();
	}
	
	public int getTauxSimilarite() {
		return optionsRecherche.getTauxSimilarite();
	}
	
	public int getNbApparitions() {
		return optionsRecherche.getNbApparition();
	}


	public void setBooleanMenuOptionsRecherche(boolean etat) {
		optionsRecherche.setBooleanMenuOptionsRecherche(etat);
	}


	public boolean getBooleanMenuOptionsRecherche() {
		return optionsRecherche.getBooleanMenuOptionsRecherche();
	}
	
}