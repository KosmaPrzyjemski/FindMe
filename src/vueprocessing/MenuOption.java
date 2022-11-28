package vueprocessing;

import java.util.ArrayList;

import controleur.ControlChangerOptionsRecherche;
import controleur.ControlConnexion;
import processing.core.PApplet;
import processing.core.PImage;

public class MenuOption extends Menu {

	private PApplet sketch;
	private String requette = "";
	private PImage onglet;
	private int posx;
	private ArrayList<Bouton> boutons;
	private ControlConnexion controlConnexion;
	private ControlChangerOptionsRecherche controlChangerOptionsRecherche;
	
	
	private int positionContourX = 955;
	private int positionContourY = 518;
	private PImage couleur;
	private PImage contourCouleur;
	
	private PImage tauxSimilarite;
	private PImage tauxSimilaritePressed;
	private int positionXBar;
	private int positionXBar2;
	private boolean suivreSouris = false;
	private boolean suivreSouris2 = false;
	private int pourcentage = 20;
	private int pourcentage2 = 2;
	private int oldMenu;
	
	private PImage ongletHistoriqueOver;
	private PImage ongletParametreOver;
	private PImage ongletAdminOver;
	private PImage cache;
	
	public MenuOption(PApplet sketch, ControlConnexion controlConnexion, ControlChangerOptionsRecherche controlChangerOptionsRecherche){
		oldMenu = 0;
		posx = 1109;
		this.sketch = sketch;
		onglet = sketch.loadImage("./src/data/image/option.png");
		this.boutons = new ArrayList<>();
		this.initialisation();
		this.controlConnexion = controlConnexion;
		this.controlChangerOptionsRecherche = controlChangerOptionsRecherche;
		couleur = sketch.loadImage("./src/data/Option/pasDeCouleur.png");
		contourCouleur = sketch.loadImage("./src/data/Option/couleurSelected.png");
		tauxSimilarite = sketch.loadImage("./src/data/image/slider.png");
		tauxSimilaritePressed = sketch.loadImage("./src/data/image/sliderP.png");
		ongletHistoriqueOver = sketch.loadImage("./src/data/image/historiqueP.png");
		ongletParametreOver = sketch.loadImage("./src/data/image/parametreP.png");
		ongletAdminOver = sketch.loadImage("./src/data/image/adminP.png");
		cache = sketch.loadImage("./src/data/image/cache.png");
		
		positionXBar = 1014;
		positionXBar2 = 985;
	}
	
	private void initialisation() {
		boutons.add(new Bouton("Retour",0,0,855,sketch.height));
		boutons.add(new Bouton("Historique",855,166,70,167));
		boutons.add(new Bouton("Paramettre",855,335,70,167));
		boutons.add(new Bouton("Admin",855,500,70,167));
		boutons.add(new Bouton("Connexion Admin",2,2,80,80));
		
		boutons.add(new Bouton("Rouge", 953, 416, 40, 40 )); //40+
		boutons.add(new Bouton("Orange", 1005, 416, 40, 40));
		boutons.add(new Bouton("Jaune", 1057, 416, 40, 40));
		boutons.add(new Bouton("Vert", 1107, 416, 40, 40));
		boutons.add(new Bouton("BleuClaire", 953, 468, 40, 40));
		boutons.add(new Bouton("BleuFonce", 1005, 468, 40, 40));
		boutons.add(new Bouton("Violet", 1057, 468, 40, 40));
		boutons.add(new Bouton("Rose", 1107, 468, 40, 40));
		boutons.add(new Bouton("PasDeCouleur", 953, 518, 40, 40));
		boutons.add(new Bouton("Gris", 1005, 518, 40, 40));
		boutons.add(new Bouton("Noir", 1057, 518, 40, 40));
		boutons.add(new Bouton("Marron", 1107, 518, 40, 40));
		boutons.add(new Bouton("NbApparition", 954,143,1146-954,34));
		boutons.add(new Bouton("tauxSimilarite", 955, 249, 1141-955, 278-249));
		//Espace en x +- = init 971 - fin 1157 = 186 / 2 = 93
		
	}
	
	public void update() {
		if(posx > 858) {
			posx -=8;
		}
		int max = 1125;
		int min = 958;
		if(suivreSouris) {
			positionXBar = sketch.mouseX-5;
			if(positionXBar<min) {
				positionXBar = min;
			}
			if(positionXBar>max) {
				positionXBar = max;
			}
			pourcentage = 100 * (positionXBar-min)/(max-min); 
		}
		
		if(suivreSouris2) {
			positionXBar2 = sketch.mouseX-5;
			if(positionXBar2<min) {
				positionXBar2 = min;
			}
			if(positionXBar2>max) {
				positionXBar2 = max;
			}
			pourcentage2 = 20 * (positionXBar2-min)/(max-min); 
		}
		
		
	}


	public void render(){
		sketch.image(onglet,posx,0);
		sketch.image(couleur,posx + 220, 355);
		if(posx < 858) {
			sketch.image(contourCouleur, positionContourX, positionContourY);
			sketch.textSize(18);
			
			
			
			
			
			//slider 1
			if(suivreSouris2) {
				sketch.image(tauxSimilaritePressed, positionXBar2, 154);
			}else {
				sketch.image(tauxSimilarite, positionXBar2, 154);
			}
			sketch.text(pourcentage2, positionXBar2, 191);
			
			
			
			//slider 2
			if(suivreSouris) {
				sketch.image(tauxSimilaritePressed, positionXBar, 260);
			}else {
				sketch.image(tauxSimilarite, positionXBar, 260);
			}
			sketch.text(pourcentage, positionXBar, 323);
			
			
		}
		
		int posY = sketch.mouseY;
		if(sketch.mouseX > 856 && sketch.mouseX < 921 && posx<858) {
			if(posY<168) {
				//sketch.image(ongletOptionOver, 853, 0);
			}else if(posY<335) {
				sketch.image(ongletHistoriqueOver, 853, 168);
			}else if(posY<500) {
				sketch.image(ongletParametreOver, 853, 335);
			}else if(posY<sketch.height) {
				sketch.image(ongletAdminOver, 853,500);
			}
			
		}
		
		if(!controlConnexion.isConnected()) {
			sketch.image(cache, posx-32,501);
	
		}
	}
		
	
	public void keyPressed() {
	}
	
	public void mouseReleased() {
		
		if(suivreSouris2) {
			controlChangerOptionsRecherche.changerNoApparitions(pourcentage2);
			System.out.println("Recherche avec un nombre d'apparition de : " + controlChangerOptionsRecherche.getNbApparitions());
			suivreSouris2=false;
		}
		
		if(suivreSouris) {
			controlChangerOptionsRecherche.changerTauxSimilarite(pourcentage);
			System.out.println("Recherche avec un taux de similarité de : " + controlChangerOptionsRecherche.getTauxSimilarite());
			suivreSouris=false;
		}
	}

	
	public Menu moussePressed(int x,int y) {
		String button = "";
		String action = "";
		System.out.println(x+" "+y);
		for(Bouton b : boutons) {
			button = b.mouseOver(sketch.mouseX, sketch.mouseY);
			if(button != "null") {
				action = button; 
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
			case "Retour":
				if(oldMenu == 0) 
					FindMe.changeMenu("Principal", requette,oldMenu,false);
				else
					FindMe.changeMenu("Recherche", requette,oldMenu,false);
				break;
			case "Historique":
				FindMe.changeMenu("Historique", requette,oldMenu,false);
				break;
			case "Paramettre":
				FindMe.changeMenu("Paramettre", requette,oldMenu,false);
				break;
			case "Admin":
				if(controlConnexion.isConnected()) {
					FindMe.changeMenu("Admin", requette,oldMenu,false);
				}/*else {
					if(oldMenu==0)
						FindMe.changeMenu("Principal", requette,oldMenu,true);
					else
						FindMe.changeMenu("Recherche", requette,oldMenu,true);
				}*/
				break;
			case "Rouge":
				couleur = sketch.loadImage("./src/data/Option/rouge.png");
				positionContourX = 954;
				positionContourY = 416;
				controlChangerOptionsRecherche.changerCouleur("Rouge");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "Orange":
				couleur = sketch.loadImage("./src/data/Option/orange.png");
				positionContourX = 1005;
				positionContourY = 416;
				controlChangerOptionsRecherche.changerCouleur("Orange");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "Jaune":
				couleur = sketch.loadImage("./src/data/Option/jaune.png");
				positionContourX = 1056;
				positionContourY = 416;
				controlChangerOptionsRecherche.changerCouleur("Jaune");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "Vert":
				couleur = sketch.loadImage("./src/data/Option/vert.png");
				positionContourX = 1107;
				positionContourY = 416;
				controlChangerOptionsRecherche.changerCouleur("Vert");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;	
			case "BleuClaire":
				couleur = sketch.loadImage("./src/data/Option/cyan.png");
				positionContourX = 954;
				positionContourY = 467;
				controlChangerOptionsRecherche.changerCouleur("BleuClaire");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "BleuFonce":
				couleur = sketch.loadImage("./src/data/Option/bleu.png");
				positionContourX = 1005;
				positionContourY = 467;
				controlChangerOptionsRecherche.changerCouleur("BleuFonce");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "Violet":
				couleur = sketch.loadImage("./src/data/Option/violet.png");
				positionContourX = 1056;
				positionContourY = 467;
				controlChangerOptionsRecherche.changerCouleur("Violet");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "Rose":
				couleur = sketch.loadImage("./src/data/Option/rose.png");
				positionContourX = 1107;
				positionContourY = 467;
				controlChangerOptionsRecherche.changerCouleur("Rose");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "PasDeCouleur":
				couleur = sketch.loadImage("./src/data/Option/pasDeCouleur.png");
				positionContourX = 955;
				positionContourY = 518;
				controlChangerOptionsRecherche.changerCouleur("PasDeCouleur");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "Gris":
				couleur = sketch.loadImage("./src/data/Option/gris.png");
				positionContourX = 1006;
				positionContourY = 518;
				controlChangerOptionsRecherche.changerCouleur("Gris");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "Noir":
				couleur = sketch.loadImage("./src/data/Option/noir.png");
				positionContourX = 1056;
				positionContourY = 518;
				controlChangerOptionsRecherche.changerCouleur("Noir");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "Marron":
				couleur = sketch.loadImage("./src/data/Option/marron.png");
				positionContourX = 1107;
				positionContourY = 518;
				controlChangerOptionsRecherche.changerCouleur("Marron");
				System.out.println("Recher ï¿½ partir du coueleur = " + controlChangerOptionsRecherche.getCouleurRechercheString());
				break;
			case "tauxSimilarite":
				suivreSouris = true;
				break;
			case "NbApparition":
				suivreSouris2 = true;
				break;
			default:
				break;
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