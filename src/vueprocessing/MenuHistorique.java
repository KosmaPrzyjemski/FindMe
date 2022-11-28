package vueprocessing;

import java.util.ArrayList;
import java.util.List;

import controleur.ControlConnexion;
import controleur.ControlHistorique;
import processing.core.PApplet;
import processing.core.PImage;

public class MenuHistorique extends Menu {

	private PApplet sketch;
	private String requette = "";
	private PImage onglet;
	private int posx;
	private List<Bouton> boutons;
	private ControlConnexion controlConnexion;
	private ControlHistorique controlHistorique;
	private PImage caseHisto;
	private PImage texte;
	private PImage image;
	private PImage audio;
	private int nombreRecherches = 0;
	private String[] listeRecherches;
	private String[] types;
	private int oldMenu;
	
	private PImage ongletOptionOver;
	private PImage ongletParametreOver;
	private PImage ongletAdminOver;
	private PImage cache;
	
	public MenuHistorique(PApplet sketch, ControlConnexion controlConnexion, ControlHistorique controlHistorique){
		oldMenu = 0;
		posx = 1109;
		this.sketch = sketch;
		onglet = sketch.loadImage("./src/data/image/historiquev2.PNG");
		this.boutons = new ArrayList<>();
		this.initialisation();
		this.controlConnexion = controlConnexion;
		this.controlHistorique = controlHistorique;
		caseHisto = sketch.loadImage("./src/data/image/histoCase.png");
		texte = sketch.loadImage("./src/data/image/petitIconTexte.png");
		image = sketch.loadImage("./src/data/image/petitIconImage.png");
		audio = sketch.loadImage("./src/data/image/petitIconAudio.png");
		
		ongletOptionOver = sketch.loadImage("./src/data/image/optionP.png");
		ongletParametreOver = sketch.loadImage("./src/data/image/parametreP.png");
		ongletAdminOver = sketch.loadImage("./src/data/image/adminP.png");
		cache = sketch.loadImage("./src/data/image/cache.png");
		
		types = new String[14];
		listeRecherches = new String[14];
	}
	
	private void initialisation() {
		boutons.add(new Bouton("Retour",0,0,855,sketch.height));
		boutons.add(new Bouton("Option",855,0,70,167));
		boutons.add(new Bouton("Paramettre",855,335,70,167));
		boutons.add(new Bouton("Admin",855,500,70,167));
		boutons.add(new Bouton("AncienneRecherche",927,10,1171-927,655-10));
		boutons.add(new Bouton("Connexion Admin",2,2,80,80));
		
	}
	
	@Override
	public void update() {
		if(posx > 858) {
			posx -=8;
		}
		
	}

	@Override
	public void render(){
		sketch.image(onglet,posx,0);
		sketch.textSize(14);
		for(int i = 0;i<nombreRecherches;i++) {
			sketch.image(caseHisto,posx+74,10+i*50);
			String nomRecherche = listeRecherches[i];
			if(nomRecherche.length()>24) {
				nomRecherche = nomRecherche.substring(0,24)+"...";
			}
			sketch.text(nomRecherche,posx+112,35+i*50);
			
			switch(types[i]) {
				case "TEXTE":
					sketch.image(texte,posx+81,16+i*50);
					break;
				case "IMAGE":
					sketch.image(image,posx+81,16+i*50);
					break;
				case "AUDIO":
					sketch.image(audio,posx+81,16+i*50);
					break;
				default:
					break;
			}
		}
		
		int posY = sketch.mouseY;
		if(sketch.mouseX > 856 && sketch.mouseX < 921 && posx<858) {
			if(posY<168) {
				sketch.image(ongletOptionOver, 853, 0);
			}else if(posY<335) {
				//sketch.image(ongletHistoriqueOver, 853, 168);
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

	
	
	public Menu moussePressed(int x,int y) {
		String button = "";
		String action = "";
		//System.out.println(x+" "+y);
		for(Bouton b : boutons) {
			button = b.mouseOver(x, y);
			if(button != "null") {
				action = button; 
			}
		}
		//System.out.println("action = "+action);
		
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
			case "Option":
				FindMe.changeMenu("Option", requette,oldMenu,false);
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
			case "AncienneRecherche":
				int numero = (y-10)/50;
				if(numero<nombreRecherches) {
					int type = 0;
					if(controlHistorique.getTypeRequetteHistorique(controlHistorique.getNbRecherche()-numero-1) == "IMAGE") {
						type = 1;
					}
					if(controlHistorique.getTypeRequetteHistorique(controlHistorique.getNbRecherche()-numero-1) == "AUDIO") {
						type = 2;
					}
					
					
					FindMe.reload(controlHistorique.getRequetteHistorique(controlHistorique.getNbRecherche()-numero-1),controlHistorique.getResultats(controlHistorique.getNbRecherche()-numero-1),type);
				}
				break;
			default:
				break;
		}
		return null;
	}
	
	public void setRecherche(String requette) {
		nombreRecherches = this.controlHistorique.getNbRecherche();
		int maxi = 13;
		if(nombreRecherches<maxi)
			maxi = nombreRecherches;
		for(int i = 0;i<maxi;i++) {
			listeRecherches[i] = this.controlHistorique.getRequetteHistorique(nombreRecherches-i-1);
			types[i] = this.controlHistorique.getTypeRequetteHistorique(nombreRecherches-i-1);
		}
		nombreRecherches = maxi;
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
