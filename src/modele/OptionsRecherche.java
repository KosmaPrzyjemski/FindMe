package modele;

import java.util.ArrayList;
import java.util.List;


public class OptionsRecherche {
	private int tauxSimilarite;
	private int nbApparition;
	private Couleur couleur;
	private List<Couleur> couleursDispo = new ArrayList<>();
	private boolean menuOptionsRecherche = false;

	
	//Contructeur
	private OptionsRecherche() {
		tauxSimilarite = 20;
		nbApparition = 3;
		couleur = new Couleur();
	}
	
	//Hoder
	private static class OptionsRechercheHolder {
		//instance unique non initialise
		private static OptionsRecherche instance = new OptionsRecherche();
	}
	
	//Point d'acces a l'instance
	public static OptionsRecherche getInstance() { 
		return OptionsRechercheHolder.instance;
	}
	
	
	//METHODES
	public void setBooleanMenuOptionsRecherche(boolean etat) {
		menuOptionsRecherche = etat;
	}
	
	public boolean getBooleanMenuOptionsRecherche() {
		return menuOptionsRecherche;
	}
	
	public void addCouleur(Couleur couleur) {
		couleursDispo.add(couleur);
	}
	
	public int getTauxSimilarite() {
		return tauxSimilarite;
	}

	public void setTauxSimilarite(int tauxSimilarite) {
		this.tauxSimilarite = tauxSimilarite;
	}

	public int getNbApparition() {
		return nbApparition;
	}

	public void setNbApparition(int nbApparition) {
		this.nbApparition = nbApparition;
	}

	public Couleur getCouleur() {
		return couleur;
	}
	
	public String getCouleurString() {
		return couleur.getNomCouleur();
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}
	

	public void setCouleur(String couleur) {
		this.couleur = new Couleur(couleur);
	}

	
	public String getListCouleursToString(){
		String couleurs = "";
		for (int i=0; i<couleursDispo.size(); i++) {
			
			couleurs += i+1 + ". " + couleursDispo.get(i).getNomCouleur() + "\n";
			
		}
		return couleurs;
	}
	
	public List<Couleur> getListCouleurs(){
		return couleursDispo;
	}
	
	
}
