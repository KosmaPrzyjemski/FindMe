package vueprocessing;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import controleur.ControlConnexion;
import controleur.ControlEffectuerRecherche;
import modele.Resultat;
import processing.core.PApplet;
import processing.core.PImage;

public class MenuRecherche extends Menu {

	private PApplet sketch;
	private PImage background;
	private String requette = "";
	private PImage iconType;
	private ControlEffectuerRecherche controlEffectuerRecherche;
	private ArrayList<Bouton> boutons;
	ArrayList<Resultat> resultats;
	private PImage flecheRetour;
	private PImage onglet;
	private ControlConnexion controlConnexion;
	private boolean connexionDepuisOnglet;
	
	private PImage ongletOptionOver;
	private PImage ongletHistoriqueOver;
	private PImage ongletParametreOver;
	private PImage ongletAdminOver;
	private PImage flecheRetourP;
	private PImage cache;
	
	public MenuRecherche(PApplet sketch, ControlEffectuerRecherche controlEffectuerRecherche,ControlConnexion controlConnexion){
		this.controlConnexion = controlConnexion;
		this.sketch = sketch;
		connexionDepuisOnglet = false;
		resultats = new ArrayList<>();
		flecheRetour = sketch.loadImage("./src/data/image/flecheMenu.PNG");
		flecheRetourP = sketch.loadImage("./src/data/image/flecheMenuP.PNG");
		background = sketch.loadImage("./src/data/image/recherche.PNG");
		onglet = sketch.loadImage("./src/data/image/ONGLET8VIDE.png"); 
		cache = sketch.loadImage("./src/data/image/cache.png");
		
		this.boutons = new ArrayList<>();
		this.controlEffectuerRecherche = controlEffectuerRecherche;
		this.initialisation();
	}
	
	private void initialisation() {
		boutons.add(new Bouton("Attente",0,0,sketch.width,sketch.height));
		boutons.add(new Bouton("Resultat1",125,150,694,36));
		boutons.add(new Bouton("Resultat2",125,186,694,36));
		boutons.add(new Bouton("Resultat3",125,222,694,36));
		boutons.add(new Bouton("Resultat4",125,258,694,38));
		boutons.add(new Bouton("Resultat5",125,295,694,38));
		boutons.add(new Bouton("Resultat6",125,333,694,38));
		boutons.add(new Bouton("Resultat7",125,370,694,38));
		boutons.add(new Bouton("RetourMenu", 280, 426,flecheRetour.width,flecheRetour.height));
		
		boutons.add(new Bouton("Onglet Option",1112,0,70,167));
		boutons.add(new Bouton("Onglet Historique",1112,167,70,167));
		boutons.add(new Bouton("Onglet Paramettre",1112,334,70,167));
		boutons.add(new Bouton("Onglet Admin",1112,500,70,167));
		boutons.add(new Bouton("Connexion Admin",2,2,80,80));
		
		ongletOptionOver = sketch.loadImage("./src/data/image/optionP.png");
		ongletHistoriqueOver = sketch.loadImage("./src/data/image/historiqueP.png");
		ongletParametreOver = sketch.loadImage("./src/data/image/parametreP.png");
		ongletAdminOver = sketch.loadImage("./src/data/image/adminP.png");
		
	}
	
	public void update() {
		
	}


	public void render(){
		sketch.image(background,0,0);
		sketch.image(onglet,1109,0);
		sketch.image(iconType, 285, 23);
		sketch.textSize(18);
		
		sketch.text(requette,320,42);
		
		sketch.image(flecheRetour, 280, 426);
		sketch.textSize(24);
		int max = 7;
		if(resultats.size()<7) {
			max = resultats.size();
		}
		for(int i = 0;i<max; i++) {
			String affichage = resultats.get(i).getNom();
			if(affichage.length()>40) {
				affichage = affichage.substring(0,40);
				affichage+="...";
			}
			sketch.text(affichage,126, 180+i*38);
			sketch.text(resultats.get(i).getPourcentage(),730, 180+i*38);
		}
		
		if(connexionDepuisOnglet) {
			connexionDepuisOnglet = false;
			FindMe.changeMenu("ConnexionAdmin", requette,1,false);
		}
		
		int posY = sketch.mouseY;
		int posX = sketch.mouseX;
		
		//280, 426,flecheRetour.width,flecheRetour.height)
		if(posX>280 && posX<280+flecheRetourP.width && posY>426 && posY<426+flecheRetour.height) {
			sketch.image(flecheRetourP, 280, 426);
		}
		
		if(posX> 1113) {
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
			sketch.text("Admin",27,91);
		}else {
			sketch.image(cache, 1100,501);
		}
		
	}
	
	public void keyPressed() {
		
	}

	
	
	/* Pour ouvrir un fichier
	 * 
	 */
	
	public Menu moussePressed(int x,int y) {
		String button = "";
		String action = "";
		System.out.println(x+" "+y);
		Desktop desktop = null;
		for(Bouton b : boutons) {
			button = b.mouseOver(sketch.mouseX, sketch.mouseY);
			if(button != "null") {
				action = button; 
			}
		}
		System.out.println("action = "+action);
		switch (action) {
			case "Connexion Admin":
				FindMe.changeMenu("ConnexionAdmin", requette,1,false);
				break;
			case "Attente":
				break;
			case "RetourMenu":
				FindMe.changeMenu("Principal", requette,1,false);
				break;
			case "Resultat1":
				if(resultats.size()>0) {
					System.out.println("Ouverture fichier 1");
				    File file = new File("./src/interfaceC/BaseDonnee/"+resultats.get(0).getNom());
				    try {
				    	if (Desktop.isDesktopSupported()) {
				         desktop = Desktop.getDesktop();
				         desktop.open(file);
				      }
				      else {
				         System.out.println("desktop is not supported");
				      }
				    }catch (IOException e){  }
				}
				break;
			case "Resultat2":
				if(resultats.size()>1) {
					System.out.println("Ouverture fichier 2");
					System.out.println("Ouverture fichier 1");
				    File file = new File("./src/interfaceC/BaseDonnee/"+resultats.get(1).getNom());
				    try {
				    	if (Desktop.isDesktopSupported()) {
				         desktop = Desktop.getDesktop();
				         desktop.open(file);
				      }
				      else {
				         System.out.println("desktop is not supported");
				      }
				    }catch (IOException e){  }
				}
				break;
			case "Resultat3":
				if(resultats.size()>2) {
					System.out.println("Ouverture fichier 3");
					System.out.println("Ouverture fichier 1");
				    File file = new File("./src/interfaceC/BaseDonnee/"+resultats.get(2).getNom());
				    try {
				    	if (Desktop.isDesktopSupported()) {
				         desktop = Desktop.getDesktop();
				         desktop.open(file);
				      }
				      else {
				         System.out.println("desktop is not supported");
				      }
				    }catch (IOException e){  }
				}
				break;
			case "Resultat4":
				if(resultats.size()>3) {
					System.out.println("Ouverture fichier 4");
					System.out.println("Ouverture fichier 1");
				    File file = new File("./src/interfaceC/BaseDonnee/"+resultats.get(3).getNom());
				    try {
				    	if (Desktop.isDesktopSupported()) {
				         desktop = Desktop.getDesktop();
				         desktop.open(file);
				      }
				      else {
				         System.out.println("desktop is not supported");
				      }
				    }catch (IOException e){  }
				}
				break;
			case "Resultat5":
				if(resultats.size()>4) {
					System.out.println("Ouverture fichier 5");
					System.out.println("Ouverture fichier 1");
				    File file = new File("./src/interfaceC/BaseDonnee/"+resultats.get(4).getNom());
				    try {
				    	if (Desktop.isDesktopSupported()) {
				         desktop = Desktop.getDesktop();
				         desktop.open(file);
				      }
				      else {
				         System.out.println("desktop is not supported");
				      }
				    }catch (IOException e){  }
				}
				break;
			case "Resultat6":
				if(resultats.size()>5) {
					System.out.println("Ouverture fichier 6");
					System.out.println("Ouverture fichier 1");
				    File file = new File("./src/interfaceC/BaseDonnee/"+resultats.get(5).getNom());
				    try {
				    	if (Desktop.isDesktopSupported()) {
				         desktop = Desktop.getDesktop();
				         desktop.open(file);
				      }
				      else {
				         System.out.println("desktop is not supported");
				      }
				    }catch (IOException e){  }
				}
				break;
			case "Resultat7":
				if(resultats.size()>6) {
					System.out.println("Ouverture fichier 7");
					System.out.println("Ouverture fichier 1");
				    File file = new File("./src/interfaceC/BaseDonnee/"+resultats.get(6).getNom());
				    try {
				    	if (Desktop.isDesktopSupported()) {
				         desktop = Desktop.getDesktop();
				         desktop.open(file);
				      }
				      else {
				         System.out.println("desktop is not supported");
				      }
				    }catch (IOException e){  }
				}
				break;
			case "Onglet Option":
				FindMe.changeMenu("Option",requette,1,false);
				break;
			case "Onglet Historique":
				FindMe.changeMenu("Historique",requette,1,false);
				break;
			case "Onglet Paramettre":
				FindMe.changeMenu("Paramettre",requette,1,false);
				break;
			case "Onglet Admin":
				if(controlConnexion.isConnected()) {
					FindMe.changeMenu("Admin", requette,1,false);
				}/*else {
					FindMe.changeMenu("ConnexionAdmin", requette,1,false);
				}*/
				break;
			default:
				break;
		}
		return null;
	}
	
	public void setRecherche(String requette) {
		this.requette = requette;
		
	}
	
	public void setTexte() {
		iconType = sketch.loadImage("./src/data/image/petitIconTexte.png");
		resultats = controlEffectuerRecherche.rechercheResultatTexte(requette);
	}

	public void setImage() {
		iconType = sketch.loadImage("./src/data/image/petitIconImage.png");
		resultats = controlEffectuerRecherche.rechercheResultatImage(requette);
	}

	public void setAudio() {
		iconType = sketch.loadImage("./src/data/image/petitIconAudio.png");
		resultats = controlEffectuerRecherche.rechercheResultatAudio(requette);
	}
	
	
	public void reload(ArrayList<Resultat> resultats,int type) {
		this.resultats = resultats;
		switch(type) {
			case 0:
				iconType = sketch.loadImage("./src/data/image/petitIconTexte.png");
				break;
			case 1:
				iconType = sketch.loadImage("./src/data/image/petitIconImage.png");
				break;
			case 2:
				iconType = sketch.loadImage("./src/data/image/petitIconAudio.png");
				break;
			default:
				break;
				
		}
	}
	
	public void setTransitionConnexion() {
		this.connexionDepuisOnglet = true;	
	}
}
