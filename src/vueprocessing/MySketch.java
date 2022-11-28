package vueprocessing;

import java.util.ArrayList;
import java.util.List;

import controleur.*;
import modele.Moteur;
import modele.Parametres;
import modele.Resultat;
import processing.core.PApplet;

public class MySketch extends PApplet{
	
	private static Menu menu;
	private static List<Menu> liste;
	
	/*Creation de la fenetre*/
	public void settings(){
		size(1175, 660);
		this.initialisation();
	}
	
	/*Initialisation des variables*/
	private void initialisation() {
		liste = new ArrayList<>();
		
		/*Initialisation de la partie controleur*/
		ControlConnexion controlConnexion = new ControlConnexion();
		ControlHistorique controlHistorique = new ControlHistorique();
		ControlEffectuerRecherche controlEffectuerRecherche = new ControlEffectuerRecherche(controlHistorique);
		ControlChangerOptionsRecherche controlChangerOptionsRecherche = new ControlChangerOptionsRecherche();
		ControlChangerParrametreIndexation controlChangerParrametreIndexation = new ControlChangerParrametreIndexation();
		Parametres parametres = new Parametres();
		ControlParametres controlParametres = new ControlParametres(parametres);
		controlParametres.addMoteur(new Moteur("FindMe"));
		controlParametres.addMoteur(new Moteur("MR1"));
		controlParametres.addMoteur(new Moteur("MR2"));
		controlParametres.addMoteur(new Moteur("Metamoteur"));
		
		/*Ajout des differents menusutilisables*/
		liste.add(new MenuPrincipal(this,controlConnexion,controlEffectuerRecherche));
		liste.add(new MenuOption(this,controlConnexion,controlChangerOptionsRecherche));
		liste.add(new MenuHistorique(this,controlConnexion,controlHistorique));
		liste.add(new MenuParamettre(this,controlConnexion,controlParametres));
		liste.add(new MenuAdmin(this,controlChangerParrametreIndexation));
		liste.add(new MenuRecherche(this,controlEffectuerRecherche,controlConnexion));
		liste.add(new MenuConnexionAdmin(this,controlConnexion));
		liste.add(new MenuHelp(this));
		menu = liste.get(0);
	}
	
	/*Affichage du menu courant apres sa mise a jour*/
	public void draw(){
		menu.update();
		
		menu.render();
	}
	
	/*Detection d'un clic souris*/
	public void mousePressed() {
		System.out.println("x="+mouseX+" y="+mouseY);
		menu.moussePressed(mouseX,mouseY);
	}
	
	/*Detection appuie sur une touche*/
	public void keyPressed() {
		menu.keyPressed();
	}
	
	/*Detection d'un arret d'appuie sur la souris (utilile pour le slider du menu option)*/
	public void mouseReleased() {
		menu.mouseReleased();
	}
	
	/*Methode utilisee pour changer le menu courant à partir d'autres menus*/
	public static void changeMenu(String nomMenu,String requette,int oldMenu,boolean connexionDepuisOnglet) {
		boolean reset = false;
		//boolean oldPrincipal = false;
		if (menu.equals(liste.get(0))){
			reset = true;
			//oldPrincipal = true;	
		}
		
		
		if (menu.equals(liste.get(5))){
			reset = true;
		}
		switch (nomMenu) {
			case "Principal":
				menu = liste.get(0);
				menu.setRecherche(requette);
				break;
			case "Option":
				menu = liste.get(1);
				menu.setRecherche(requette);
				break;
			case "Historique":
				menu = liste.get(2);
				menu.setRecherche(requette);
				break;
			case "Paramettre":
				menu = liste.get(3);
				menu.setRecherche(requette);
				break;
			
			case "Admin":
				menu = liste.get(4);
				menu.setRecherche(requette);
				break;
			case "Recherche":
				menu = liste.get(5);
				menu.setRecherche(requette);
				break;
			case "ConnexionAdmin":
				menu = liste.get(6);
				menu.setRecherche(requette);
				break;
			case "Help":
				menu = liste.get(7);
				menu.setRecherche(requette);
				break;
			default:
				break;
		}
		menu.setOldMenu(oldMenu);

		if(connexionDepuisOnglet) {
			menu.setTransitionConnexion();
		}
		if(reset) {
			menu.resetAnimation();
		}else {
			menu.setAnimation();
		}
	}
	
	/*Methode pour lancer le menu des recherches*/
	public static void menuRecherche(String requette, String type) {
		menu =liste.get(5);
		menu.setRecherche(requette);
		switch (type) {
			case "Texte":
				menu.setTexte();
				break;
			case "Image":
				menu.setImage();
				break;
			case "Audio":
				menu.setAudio();
				break;
			default:
				break;
		}
		
	}
	
	/*Methode pour relancer l'affichage d'une ancienne recherche*/
	public static void reload(String requetteHistorique, ArrayList<Resultat> resultats,int type) {
		menu =liste.get(5);
		menu.setRecherche(requetteHistorique);
		menu.reload(resultats,type);
		System.out.println("type = "+type);
	}
	
	
	
	
	
}