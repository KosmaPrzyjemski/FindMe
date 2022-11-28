package vueprocessing;

import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import controleur.ControlConnexion;
import controleur.ControlEffectuerRecherche;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;


public class MenuPrincipal extends Menu{
	
	private PApplet sketch;
	private PImage background;
	private PImage onglet;
	private String requette = "";
	private ArrayList<Bouton> boutons;
	private boolean saisieRequette = false;
	private PImage selected;
	private boolean connexionDepuisOnglet; // pour patcher un bug (quand va dans le menu connexion depuis les onglets il y avait un pb graphique)
	
	
	private PImage ongletOptionOver;
	private PImage ongletHistoriqueOver;
	private PImage ongletParametreOver;
	private PImage ongletAdminOver;
	private PImage rechercheOver;
	private PImage logoRecherche;
	private PImage cache;
	
	//Controls
	ControlConnexion controlConnexion;
	ControlEffectuerRecherche controlEffectuerRecherche;
	
	public MenuPrincipal(PApplet sketch, ControlConnexion controlConnexion, ControlEffectuerRecherche controlEffectuerRecherche){
		this.controlConnexion = controlConnexion;
		this.controlEffectuerRecherche = controlEffectuerRecherche;
		this.sketch = sketch;
		connexionDepuisOnglet = false;
		selected = sketch.loadImage("./src/data/image/barreSelected.png");
		onglet = sketch.loadImage("./src/data/image/ONGLET8VIDE.png"); 
		background = sketch.loadImage("./src/data/image/fond.PNG");
		
		ongletOptionOver = sketch.loadImage("./src/data/image/optionP.png");
		ongletHistoriqueOver = sketch.loadImage("./src/data/image/historiqueP.png");
		ongletParametreOver = sketch.loadImage("./src/data/image/parametreP.png");
		ongletAdminOver = sketch.loadImage("./src/data/image/adminP.png");
		rechercheOver = sketch.loadImage("./src/data/image/rechercheP.png");
		logoRecherche = sketch.loadImage("./src/data/image/logoSeul.png");
		cache = sketch.loadImage("./src/data/image/cache.png");
		
		this.boutons = new ArrayList<>();
		this.initialisation();
	}
	
	private void initialisation() {
		boutons.add(new Bouton("Attente",0,0,sketch.width,sketch.height));
		boutons.add(new Bouton("Recherche Texte",391,395,461-391,472-395));
		boutons.add(new Bouton("Recherche Image",522,396,622-522,469-396));
		boutons.add(new Bouton("Recherche Audio",680,398,748-680,468-398));
		boutons.add(new Bouton("Saisie Requette",250,281,962-326+75,364-281));
		
		boutons.add(new Bouton("Connexion Admin",2,2,80,80));
		boutons.add(new Bouton("Onglet Option",1112,0,70,167));
		boutons.add(new Bouton("Onglet Historique",1112,167,70,167));
		boutons.add(new Bouton("Onglet Paramettre",1112,334,70,167));
		boutons.add(new Bouton("Onglet Admin",1112,500,70,167));
		boutons.add(new Bouton("Help",18,597,73-18,649-597));
		boutons.add(new Bouton("Fichier",896,282,60,84));
	}
	
	public void update() {
	
	}


	public void render(){
		sketch.image(background,0,0);
		sketch.image(onglet,1109,0);
		sketch.textSize(24);
		sketch.fill(0);
		if(requette.length()>42) {
			sketch.text(requette.substring(0,42)+"...",328,332);
		}else {
			sketch.text(requette,328,332);
		}
		if(saisieRequette) {
			sketch.image(selected, 250, 278);
		}
		if(connexionDepuisOnglet) {
			connexionDepuisOnglet = false;
			FindMe.changeMenu("ConnexionAdmin", requette,0,false);
		}
		
		int posY = sketch.mouseY;
		int posX = sketch.mouseX;
		
		if(posX > 250 && posX < 326+962-326 && posY > 281 && posY < 281+364-281 && !saisieRequette) {
			sketch.image(rechercheOver, 250, 278);
		}
		if(posY > 390 && posY < 469) {
			if(posX > 391 && posX < 462 ) {
				sketch.image(logoRecherche, posX-logoRecherche.width/2, posY-logoRecherche.height/2);
				sketch.fill(113,231,235);
				sketch.text("Recherche Texte", 340, 510);
			}else if(posX > 522 && posX< 623) {
				sketch.image(logoRecherche, posX-logoRecherche.width/2, posY-logoRecherche.height/2);
				sketch.fill(116,212,91);
				sketch.text("Recherche Image", 480, 510);
			}else if(posX > 678 && posX< 742) {
				sketch.image(logoRecherche, posX-logoRecherche.width/2, posY-logoRecherche.height/2);
				sketch.fill(110,91,212);
				sketch.text("Recherche Audio", 625, 510);
			}
			sketch.fill(0);
		}
		if(posX > 1113) {
			if(posY<168) {
				sketch.image(ongletOptionOver, 1109, 0);
			}else if(posY<335) {
				sketch.image(ongletHistoriqueOver, 1109, 168);
			}else if(posY<500) {
				sketch.image(ongletParametreOver, 1109, 335);
			}else if(posY<sketch.height) {
				sketch.image(ongletAdminOver, 1109,500);
			}
			
		}
		
		if(controlConnexion.isConnected()) {
			sketch.textSize(18);
			sketch.text("Admin",26,91);
			sketch.textSize(24);
		}else {
			sketch.image(cache, 1100,501);
		}
		
	}
	
	public void keyPressed() {
		if(sketch.key == PConstants.ENTER) {
			if(requette.contains(".jpg") || requette.contains(".bmp")) {
				FindMe.menuRecherche(requette,"Image");
			}
			if(requette.contains(".xml") || requette.contains("+") || requette.contains("-") ) {
				FindMe.menuRecherche(requette,"Texte");
			}
			if(requette.contains(".wav") || requette.contains(".bin")) {
				FindMe.menuRecherche(requette,"Audio");
			}
		}
		if( saisieRequette) {
			if( (sketch.key>='0' && sketch.key <='9') || (sketch.key>='A' && sketch.key <='Z') || (sketch.key>='a' && sketch.key <='z') || sketch.key == '_' || sketch.key == '.' || sketch.key == '-' || sketch.key == '+' || sketch.key == ' ') {
				requette+=sketch.key;
				System.out.println("en attente de requette");
			}
			if(sketch.key == PConstants.DELETE || sketch.key == PConstants.BACKSPACE || sketch.key == PConstants.RETURN ) {
				if(requette.length()>0) {
					requette = requette.substring(0, requette.length()-1);
				}
			}
		}else {
			// raccourci pour le deboggage
			if(sketch.key == 'a')
				this.controlConnexion.connexion("Admin");
		}
		
	}

	
	
	public Menu moussePressed(int x,int y) {
		String button = "";
		String action = "";
		for(Bouton b : boutons) {
			button = b.mouseOver(sketch.mouseX, sketch.mouseY);
			if(button != "null") {
				action = button; 
			}
		}
		System.out.println("action = "+action);
		saisieRequette = false;
		switch (action) {
			case "Connexion Admin":
				FindMe.changeMenu("ConnexionAdmin", requette,0,false);
				break;
			case "Attente":
				break;
			case "Recherche Texte":
				FindMe.menuRecherche(requette,"Texte");
				break;
			case "Recherche Audio":
				FindMe.menuRecherche(requette,"Audio");
				break;
			case "Recherche Image":
				FindMe.menuRecherche(requette,"Image");
				break;
			case "Saisie Requette":
				saisieRequette = true;
				break;
			case "Onglet Option":
				FindMe.changeMenu("Option",requette,0,false);
				break;
			case "Onglet Historique":
				FindMe.changeMenu("Historique",requette,0,false);
				break;
			case "Onglet Paramettre":
				FindMe.changeMenu("Paramettre",requette,0,false);
				break;
			case "Onglet Admin":
				if(controlConnexion.isConnected()) {
					FindMe.changeMenu("Admin", requette,0,false);
				}
				break;
			case "Fichier":
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setCurrentDirectory(new File("./src/interfaceC/fichierRecherche"));
				int result = fileChooser.showOpenDialog(new Frame());
				if (result == JFileChooser.APPROVE_OPTION) {
				    File selectedFile = fileChooser.getSelectedFile();
				    requette = selectedFile.getName();
				    //selectedFile.renameTo(new File("./src/interfaceC/fichierRecherche/"+selectedFile.getName()));
				    /*partie � completer quand on saura ou mettre les fichier pour que la rehcerche fonctionne avec le code en C */
				}
				break;
			case "Help":
				FindMe.changeMenu("Help", requette,0,false);
				break;
			default:
				break;
		}
		return null;
	}
	
	public void setTransitionConnexion() {
		this.connexionDepuisOnglet = true;	
	}

}
