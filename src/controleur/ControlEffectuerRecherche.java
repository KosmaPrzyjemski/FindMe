package controleur;

import java.util.ArrayList;

import interfaceC.InterfaceC;
import modele.*;

public class ControlEffectuerRecherche {
	private ControlHistorique controlHistorique;
	private OptionsRecherche optionsRecherche = OptionsRecherche.getInstance();
	
	
	public ControlEffectuerRecherche(ControlHistorique controlHistorique) {
		this.controlHistorique = controlHistorique;
	}
	
	public ArrayList<String> rechercheTexte(String requette) {
		if(requette == "" || requette.contains(".png") || requette.contains(".bmp") || requette.contains(".bin") || requette.contains(".wav") ) {
			return new ArrayList<>();
		}
		ArrayList<Resultat> resultats;
		Requette requetteTexteOuMots;
		if(InterfaceC.fichierExiste(requette)) {
			requetteTexteOuMots = FabriqueRequette.creerRequette(TypeFichier.TEXTE, requette, null, optionsRecherche.getTauxSimilarite(), optionsRecherche.getNbApparition());
			if(requetteTexteOuMots!=null) {
				resultats = InterfaceC.rechercheTexte((RequetteTexte)requetteTexteOuMots);
			}else {
				return new ArrayList<>();
			}
			
		}else {
			requetteTexteOuMots = FabriqueRequette.creerRequette(TypeFichier.TEXTE, requette, null, 0, optionsRecherche.getNbApparition());

			resultats = InterfaceC.rechercheMot((RequetteMot)requetteTexteOuMots);
		}
		//System.out.println("Requette=["+requetteTexteOuMots+"]");
		archiver(requetteTexteOuMots,resultats);


		ArrayList<String> resultatsString = new ArrayList<>();
		for(Resultat result : resultats) {
			resultatsString.add(result.toString());
		}
		return resultatsString;
	}
	
	public ArrayList<Resultat> rechercheResultatTexte(String requette) {
		if(requette == "" || requette.contains(".png") || requette.contains(".bmp") || requette.contains(".bin") || requette.contains(".wav") ) {
			return new ArrayList<>();
		}
		ArrayList<Resultat> resultats;
		Requette requetteTexteOuMots;
		if(InterfaceC.fichierExiste(requette)) {
			requetteTexteOuMots = FabriqueRequette.creerRequette(TypeFichier.TEXTE, requette, null, optionsRecherche.getTauxSimilarite(), optionsRecherche.getNbApparition());
			if(requetteTexteOuMots!=null) {
				resultats = InterfaceC.rechercheTexte((RequetteTexte)requetteTexteOuMots);
			}else {
				return new ArrayList<>();
			}
			
		}else {
			requetteTexteOuMots = FabriqueRequette.creerRequette(TypeFichier.TEXTE, requette, null, 0, optionsRecherche.getNbApparition());

			resultats = InterfaceC.rechercheMot((RequetteMot)requetteTexteOuMots);
		}
		//System.out.println("Requette=["+requetteTexteOuMots+"]");
		archiver(requetteTexteOuMots,resultats);

		return resultats;
	}

	public ArrayList<String> rechercheImage(String requette) {
		ArrayList<Resultat> resultats;
		Couleur couleur = optionsRecherche.getCouleur();
		Requette requetteImage;
		
		if(couleur.getNomCouleur().equals("toutes les couleurs")) { // si la couleur est vide
			
			requetteImage = FabriqueRequette.creerRequette(TypeFichier.IMAGE, requette, null, optionsRecherche.getTauxSimilarite(), 0);
			resultats = InterfaceC.rechercheImage((RequetteImage)requetteImage);
		}else {
			requetteImage = FabriqueRequette.creerRequette(TypeFichier.IMAGE, "Couleur "+couleur.getNomCouleur() , couleur, optionsRecherche.getTauxSimilarite(), 0);
			resultats = InterfaceC.rechercheCouleur((RequetteCouleur)requetteImage);
		}
		
		
		//System.out.println("Requette=["+requetteImage+"]");
		controlHistorique.archiver(requetteImage,resultats);


		
		ArrayList<String> resultatsString = new ArrayList<>();
		for(Resultat result : resultats) {
			resultatsString.add(result.toString());
		}
		return resultatsString;
		
	}
	
	public ArrayList<Resultat> rechercheResultatImage(String requette) {
		ArrayList<Resultat> resultats = new ArrayList<>();
		Couleur couleur = optionsRecherche.getCouleur();
		Requette requetteImage;
		
		if(couleur.getNomCouleur().equals("toutes les couleurs") || couleur.getNomCouleur().equals("PasDeCouleur") ) { // si la couleur est vide
			System.out.println("Test ="+optionsRecherche.getTauxSimilarite());
			if(requette == "" || requette.contains(".xml") || requette.contains(".bin") || requette.contains(".wav") ) {
				return resultats;
			}
			requetteImage = FabriqueRequette.creerRequette(TypeFichier.IMAGE, requette, null, optionsRecherche.getTauxSimilarite(), 0);
			resultats = InterfaceC.rechercheImage((RequetteImage)requetteImage);
		}else {
			requetteImage = FabriqueRequette.creerRequette(TypeFichier.IMAGE, "Couleur "+couleur.getNomCouleur() , couleur, optionsRecherche.getTauxSimilarite(), 0);
			resultats = InterfaceC.rechercheCouleur((RequetteCouleur)requetteImage);
		}
		controlHistorique.archiver(requetteImage,resultats);

		return resultats;
		
	}

	public ArrayList<String> rechercheAudio(String requette) {
		
		if(requette == "") {
			return new ArrayList<>();
		}
		ArrayList<Resultat> resultats;
		RequetteAudio requetteAudio = (RequetteAudio)FabriqueRequette.creerRequette(TypeFichier.AUDIO, requette, null, optionsRecherche.getTauxSimilarite(), optionsRecherche.getNbApparition());
		resultats = InterfaceC.rechercheAudio(requetteAudio); // attention si il est null
		//System.out.println("Requette=["+requetteAudio+"]");
		archiver(requetteAudio,resultats);
		
		ArrayList<String> resultatsString = new ArrayList<>();
		for(Resultat result : resultats) {
			resultatsString.add(result.toString());
		}
		return resultatsString;
	}
	
	public ArrayList<Resultat> rechercheResultatAudio(String requette) {
		if(requette == "") {
			return new ArrayList<>();
		}
		ArrayList<Resultat> resultats;
		RequetteAudio requetteAudio = (RequetteAudio)FabriqueRequette.creerRequette(TypeFichier.AUDIO, requette, null, optionsRecherche.getTauxSimilarite(), optionsRecherche.getNbApparition());
		resultats = InterfaceC.rechercheAudio(requetteAudio); // attention si il est null
		//System.out.println("Requette=["+requetteAudio+"]");
		archiver(requetteAudio,resultats);
		return resultats;
	}
	
	
	private void archiver(Requette requette,ArrayList<Resultat> resultats) {
		controlHistorique.archiver(requette,resultats);
	}

	public String getCouleurString() {
		return optionsRecherche.getCouleur().getNomCouleur();
	}

	
}
