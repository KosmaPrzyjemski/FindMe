package vueprocessing;

import java.awt.Frame;
import java.io.File;
import java.util.ArrayList;

import javax.swing.JFileChooser;

import controleur.ControlConnexion;
import controleur.ControlParametres;
import processing.core.PApplet;
import processing.core.PImage;

public class MenuParamettre extends Menu {

	private PApplet sketch;
	private String requette = "";
	private PImage onglet;
	private int posx;
	private ArrayList<Bouton> boutons;
	private ControlConnexion controlConnexion;
	private ControlParametres controlParametres;
	//
	private PImage combox;
	private PImage FindME;
	private PImage metaMoteur;
	private PImage MR1;
	private PImage MR2;
	private PImage nvx_fichier;
	private PImage fleche;
	private PImage switchActualisation;
	
	private PImage ongletOptionOver;
	private PImage ongletHistoriqueOver;
	private PImage ongletAdminOver;
	//
	private boolean comboBoxOuvert = false;
	
	private PImage moteurSelectionne;
	private boolean bouttonActive = false;
	private int oldMenu;
	private PImage cache;
	
	
	public MenuParamettre(PApplet sketch, ControlConnexion controlConnexion, ControlParametres controlParametres){
		oldMenu = 0;
		posx = 1109;
		this.sketch = sketch;
		onglet = sketch.loadImage("./src/data/image/parrametrev2.png");
		//
		combox = sketch.loadImage("./src/data/Parametre/comboBox.png");
		FindME = sketch.loadImage("./src/data/Parametre/FindMe.png");
		metaMoteur = sketch.loadImage("./src/data/Parametre/Metamoteur.png");
		MR1 = sketch.loadImage("./src/data/Parametre/MR1.png");
		MR2 = sketch.loadImage("./src/data/Parametre/MR2.png");
		nvx_fichier = sketch.loadImage("./src/data/Parametre/nvx_fichier.PNG");
		switchActualisation = sketch.loadImage("./src/data/Parametre/boutonActive.png");
		fleche = sketch.loadImage("./src/data/Parametre/flecheHaut.png");
		
		ongletOptionOver = sketch.loadImage("./src/data/image/optionP.png");
		ongletHistoriqueOver = sketch.loadImage("./src/data/image/historiqueP.png");
		ongletAdminOver = sketch.loadImage("./src/data/image/adminP.png");
		cache = sketch.loadImage("./src/data/image/cache.png");
		//
		this.boutons = new ArrayList<>();
		this.initialisation();
		this.controlConnexion = controlConnexion;
		this.controlParametres = controlParametres;
		moteurSelectionne = FindME;
	}
	
	private void initialisation() {
		boutons.add(new Bouton("Attente",0,0,sketch.width,sketch.height));
		boutons.add(new Bouton("Retour",0,0,855,sketch.height));
		boutons.add(new Bouton("Option",855,0,70,167));
		boutons.add(new Bouton("Historique",855,166,70,167));
		boutons.add(new Bouton("Admin",855,500,70,167));
		boutons.add(new Bouton("Connexion Admin",2,2,80,80));
		//
		boutons.add(new Bouton("SelectionMoteur",1113,71,40,40));
		
		boutons.add(new Bouton("FindMe",956,110,196,33));
		boutons.add(new Bouton("MR1",956,143,196,33));
		boutons.add(new Bouton("MR2",956,176,196,33));
		boutons.add(new Bouton("MetaMoteur",955,210,196,33));
		boutons.add(new Bouton("switch Actualisation",1082,211,47,30)); 
		boutons.add(new Bouton("Ajouter Fichier",974,278,171,92)); 

		
	}
	
	public void update() {
		if(posx > 858) {
			posx -=8;
		}
		
	}


	public void render(){
		sketch.image(onglet,posx,0);
		
		if(bouttonActive) {
			sketch.image(nvx_fichier,posx+115,275);
			sketch.image(switchActualisation, posx+230, 214);
		}
		if(comboBoxOuvert) {
			sketch.image(fleche, posx+261, 74);
			sketch.image(combox, 955,109);	
		}
		sketch.image(moteurSelectionne, posx+103,78);
		
		int posY = sketch.mouseY;
		if(sketch.mouseX > 856 && sketch.mouseX < 921 && posx<858) {
			if(posY<168) {
				sketch.image(ongletOptionOver, 853, 0);
			}else if(posY<335) {
				sketch.image(ongletHistoriqueOver, 853, 168);
			}else if(posY<500) {
				//sketch.image(ongletParametreOver, 853, 335);
			}else if(posY<sketch.height) {
				sketch.image(ongletAdminOver, 853,500);
			}
		}
		if(!controlConnexion.isConnected()) {
			sketch.image(cache, posx-32,501);
	
		}
	}
	
	public Menu moussePressed(int x,int y) {
		String button = "";
		String action = "";
		int supperpo = 0;
		System.out.println(x+" "+y);
		for(Bouton b : boutons) {
			button = b.mouseOver(sketch.mouseX, sketch.mouseY);
			if(button != "null") {
				action = button; 
			}
			if(button == "MetaMoteur" || button == "switch Actualisation") {
				supperpo++;
			}
		}
		System.out.println("action = "+action);
		switch (action) {
			case "Connexion Admin":
				if(oldMenu==0)
					FindMe.changeMenu("Principal", requette,oldMenu,true);
				else
					FindMe.changeMenu("Recherche", requette,oldMenu,true);
				break;
			case "Attente":
				comboBoxOuvert = false;
				break;
			case "Retour":
				comboBoxOuvert=false;
				if(oldMenu == 0) 
					FindMe.changeMenu("Principal", requette,oldMenu,false);
				else
					FindMe.changeMenu("Recherche", requette,oldMenu,false);
				break;
			case "Option":
				comboBoxOuvert = false;
				FindMe.changeMenu("Option", requette,oldMenu,false);
				break;
			case "Historique":
				comboBoxOuvert = false;
				FindMe.changeMenu("Historique", requette,oldMenu,false);
				break;
			case "Admin":
				comboBoxOuvert = false;
				if(controlConnexion.isConnected()) {
					FindMe.changeMenu("Admin", requette,oldMenu,false);
				}/*else {
					if(oldMenu==0)
						FindMe.changeMenu("Principal", requette,oldMenu,true);
					else
						FindMe.changeMenu("Recherche", requette,oldMenu,true);
				}*/
				break;
			case "SelectionMoteur":
				comboBoxOuvert = !comboBoxOuvert;
				break;
			case "FindMe":
				if(comboBoxOuvert) 
					moteurSelectionne = FindME;
					controlParametres.desactiverTout();
					controlParametres.activerMoteur(controlParametres.getMoteurViaIndex(0));
				break;
			case "MR1" :
				if(comboBoxOuvert) 
					moteurSelectionne = MR1;
					controlParametres.desactiverTout();
					controlParametres.activerMoteur(controlParametres.getMoteurViaIndex(1));
				break;
			case "MR2" :
				if(comboBoxOuvert) 
					moteurSelectionne = MR2;
					controlParametres.desactiverTout();
					controlParametres.activerMoteur(controlParametres.getMoteurViaIndex(2));
				break;
			case "MetaMoteur":
				if(comboBoxOuvert) 
					moteurSelectionne = metaMoteur;
					controlParametres.desactiverTout();
					controlParametres.activerMoteur(controlParametres.getMoteurViaIndex(3));
				break;
			case "switch Actualisation":
				if(supperpo==1) {
					comboBoxOuvert = false;
					bouttonActive = !bouttonActive;
					if(bouttonActive) {
						controlParametres.activerActualisationDonnees();
					}else {
						controlParametres.desactiverActualisationDonnees();
					}
				}
				break;
			case "Ajouter Fichier":
				comboBoxOuvert = false;
				if(bouttonActive) {
					
					JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File("./src/data/image"));
					int result = fileChooser.showOpenDialog(new Frame());
					if (result == JFileChooser.APPROVE_OPTION) {
					    @SuppressWarnings("unused")
						File selectedFile = fileChooser.getSelectedFile();
					    /*partie � completer quand on saura ou mettre les fichier pour que la rehcerche fonctionne avec le code en C */
					}
					break;
				}
				break;
			default:
				break;
		}
		if(supperpo==2) {
			if(comboBoxOuvert) {
				moteurSelectionne = metaMoteur;
			}else {
				bouttonActive = !bouttonActive;
			}
		}
		return null;
	}
	
	public void setRecherche(String requette) {
		this.requette = requette;
	}
	
	public void setAnimation() {
		posx = 853;
	}
	
	public void resetAnimation() {
		posx = 1109;
	}
	
	public void setOldMenu(int i) {
		oldMenu = i;
	}
}
