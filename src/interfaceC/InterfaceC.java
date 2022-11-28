package interfaceC;

import java.util.ArrayList;

import modele.OptionsRecherche;
import modele.RequetteAudio;
import modele.RequetteCouleur;
import modele.RequetteImage;
import modele.RequetteMot;
import modele.RequetteTexte;
import modele.Resultat;
import modele.Triplet;

public class InterfaceC {
	// Attributes
	private static int parametreIndexationTexte = 50;
	private static int parametreIndexationImage = 4;
	private static int parametreIndexationAudio = 15;
	private static int numero = 20;

	public static boolean fichierExiste(String requette) {
		if(requette.contains("oeuvre") || requette.contains("rock")) {
			return false;
		}
		return true;
	}

	public static ArrayList<Resultat> rechercheTexte(RequetteTexte requetteTexte) {
		ArrayList<Resultat> resultats = new ArrayList<>();
		numero = requetteTexte.getTauxSimilarite();
		if(numero<90)
			resultats.add(new Resultat("12-Jean-Marie_Sevestre,_libraire_et_PDG.xml", 90, requetteTexte.getType()));
		if(numero<87)
			resultats.add(new Resultat("26-Tom_Boonen_sacré_champion_du.xml",87, requetteTexte.getType()));
		if(numero<70)
			resultats.add(new Resultat("05-L_apnéiste_français_Guillaume_Néry_plonge.xml", 70, requetteTexte.getType()));
		if(numero<68)
			resultats.add(new Resultat("05-Le_théâtre_de_texte_confronté.xml", 68, requetteTexte.getType()));
		return resultats;
	}

	public static ArrayList<Resultat> rechercheMot(RequetteMot requetteMot) {
		ArrayList<Resultat> resultats = new ArrayList<>();
		ArrayList<Triplet> a = requetteMot.getMots();
		OptionsRecherche options = OptionsRecherche.getInstance();
		numero = options.getTauxSimilarite();
		if(a.size() == 1) {
			if(a.get(0).getMot().contains("rock")){
				if(numero<83)
					resultats.add(new Resultat("05-Rock___l_Illinois_magique_de.xml", 83, requetteMot.getType()));
				if(numero<62)
					resultats.add(new Resultat("05-Musique_électronique___l_élan_collectif.xml", 62, requetteMot.getType()));
			}else if(a.get(0).getMot().contains("oeuvre")){
				if(numero<74)
					resultats.add(new Resultat("05-Le_théâtre_de_texte_confronté.xml", 74, requetteMot.getType()));
				if(numero<62)
					resultats.add(new Resultat("05-Musique_électronique___l_élan_collectif.xml", 62, requetteMot.getType()));
				if(numero<30)
					resultats.add(new Resultat("03-Mimer_un_signal_nerveux_pour.xml", 30, requetteMot.getType()));
			}else {
				if(numero<72)
					resultats.add(new Resultat("03-Des_chercheurs_parviennent_Ã _régénérer.xml", 72, requetteMot.getType()));
				if(numero<45)
					resultats.add(new Resultat("12-Jean-Marie_Sevestre,_libraire_et_PDG.xml", 45, requetteMot.getType()));
				if(numero<35)
					resultats.add(new Resultat("05-La_circoncision_pourrait_réduire_le.xml", 35, requetteMot.getType()));
			}
		}else {
			if(a.get(0).getMot().contains("rock") || a.get(0).getMot().contains("oeuvre")) {
				if(a.get(1).isPlus() && numero<83) {
					resultats.add(new Resultat("05-Rock___l_Illinois_magique_de.xml", 83, requetteMot.getType()));
					
				}
				if(numero<74)
					resultats.add(new Resultat("05-Le_théâtre_de_texte_confronté.xml", 74, requetteMot.getType()));
				if(a.get(1).isPlus() && numero<62) {
					resultats.add(new Resultat("05-Musique_électronique___l_élan_collectif.xml", 62, requetteMot.getType()));
				}
				if(numero<30)
					resultats.add(new Resultat("03-Mimer_un_signal_nerveux_pour.xml", 30, requetteMot.getType()));
			}
		}
		
		
		return resultats;
	}

	public static ArrayList<Resultat> rechercheImage(RequetteImage requetteImage) {
		ArrayList<Resultat> resultats = new ArrayList<>();
		numero = requetteImage.getTauxSimilarite();
		if(requetteImage.getNom().contains("bmp")) {
			if(numero<97)
				resultats.add(new Resultat("52.bmp", 97, requetteImage.getType()));
			if(numero<91)
				resultats.add(new Resultat("53.bmp", 91, requetteImage.getType()));
			if(numero<70)
				resultats.add(new Resultat("54.bmp", 70, requetteImage.getType()));
			if(numero<68)
				resultats.add(new Resultat("55.bmp", 68, requetteImage.getType()));
			if(numero<65)
				resultats.add(new Resultat("56.bmp", 65, requetteImage.getType()));
		}else { // (requetteImage.equals("01.jpg")
			if(numero<73)
				resultats.add(new Resultat("09.jpg", 73, requetteImage.getType()));
			if(numero<65)
				resultats.add(new Resultat("08.jpg", 65, requetteImage.getType()));
			if(numero<63)
				resultats.add(new Resultat("25.jpg", 63, requetteImage.getType()));
			if(numero<61)
				resultats.add(new Resultat("10.jpg", 61, requetteImage.getType()));
			if(numero<61)
				resultats.add(new Resultat("02.jpg", 61, requetteImage.getType()));
		}
		return resultats;
	}

	public static ArrayList<Resultat> rechercheAudio(RequetteAudio requetteAudio) {
		ArrayList<Resultat> resultats = new ArrayList<>();
		resultats.add(new Resultat("corpus_fi.wav", 98, requetteAudio.getType()));
		return resultats;
	}

	public static ArrayList<Resultat> rechercheCouleur(RequetteCouleur requetteCouleur) {
		ArrayList<Resultat> resultats = new ArrayList<>();
		OptionsRecherche options = OptionsRecherche.getInstance();
		numero = options.getTauxSimilarite();
		String n = requetteCouleur.getCouleur().getNomCouleur();
		if(n.equals("Rouge") || n.equals("Orange")) {
			if(numero<83)
				resultats.add(new Resultat("36.jpg", 83, requetteCouleur.getType()));
			if(numero<78)
				resultats.add(new Resultat("16.jpg", 78, requetteCouleur.getType()));
			if(numero<67)
				resultats.add(new Resultat("38.jpg", 67, requetteCouleur.getType()));
		}else {
			if(numero>75)
				resultats.add(new Resultat("Image contenant du "+n, 75, requetteCouleur.getType()));
			if(numero>70)
				resultats.add(new Resultat("Image contenant du "+n, 70, requetteCouleur.getType()));
			if(numero>60)
				resultats.add(new Resultat("Image contenant du "+n, 60, requetteCouleur.getType()));
		}
		return resultats;
	}

	public static void changerParrametreTexte(int nouveauParram) {
		/*paramIndex.setParrametreIndexationTexte(nouveauParram);*/
		if(0 < nouveauParram && nouveauParram < 100) {
			parametreIndexationTexte = nouveauParram;
		}
	}

	public static void changerParrametreImage(int nouveauParram) {
		/*paramIndex.setParrametreIndexationImage(nouveauParram);*/
		if(0 < nouveauParram && nouveauParram < 100) {
			parametreIndexationImage = nouveauParram;
		}
	}

	public static void changerParrametreAudio(int nouveauParram) {
		/*paramIndex.setParrametreIndexationAudio(nouveauParram);*/
		if(0 < nouveauParram && nouveauParram < 100) {
			parametreIndexationAudio = nouveauParram;
		}
	}

	public static void indexationTexte(int parrametreIndexationTexte) {
		// Faire une nouvelle indexation avec le parametre donne

	}

	public static void indexationImage(int parrametreIndexationTexte) {
		// Faire une nouvelle indexation avec le parametre donne

	}

	public static void indexationAudio(int parrametreIndexationTexte) {
		// Faire une nouvelle indexation avec le parametre donne

	}

	public static int chargerParametreTexte() {
		return parametreIndexationTexte;
	}

	public static int chargerParametreImage() {
		return parametreIndexationImage;
	}

	public static int chargerParametreAudio() {
		return parametreIndexationAudio;
	}
}