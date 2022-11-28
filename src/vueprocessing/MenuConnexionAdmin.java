package vueprocessing;

import java.util.ArrayList;

import controleur.ControlConnexion;
import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PImage;

public class MenuConnexionAdmin extends Menu {

	private PApplet sketch;
	private String requette = "";
	private PImage admin; // si connecte 
	private PImage utilisateur; // si pas connecte
	private ArrayList<Bouton> boutons; 
	private ControlConnexion controlConnexion;
	private String mdp = "";
	private String affichageMdp = "";
	private boolean saisieMdp;
	private boolean echec = false;
	private PImage selected;
	private int oldMenu;
	private PImage cache;
	private PImage onglet;
	
	public MenuConnexionAdmin(PApplet sketch, ControlConnexion controlConnexion){
		this.sketch = sketch;
		oldMenu = 0;
		admin = sketch.loadImage("./src/data/image/connecte.png");
		utilisateur = sketch.loadImage("./src/data/image/connexion.png");
		selected = sketch.loadImage("./src/data/image/mdpSelected.png");
		cache = sketch.loadImage("./src/data/image/cache.png");
		onglet = sketch.loadImage("./src/data/image/ONGLET8VIDE.png"); 
		
		this.boutons = new ArrayList<>();
		this.initialisation();
		this.controlConnexion = controlConnexion;
	}
	
	private void initialisation() {
		boutons.add(new Bouton("Retour",0,0,sketch.width,sketch.height));
		boutons.add(new Bouton("Attente",5,80,300,167));
		boutons.add(new Bouton("SaisieMdp",169,105,132,33));
		boutons.add(new Bouton("BoutonConnexion",87,196,130,40));
		boutons.add(new Bouton("Croix",262,201,30,30));
		
	}
	
	public void update() {
		
	}


	public void render(){
		
		if(controlConnexion.isConnected()) {
			sketch.image(admin,5,80);
		}else {
			sketch.image(utilisateur,5,80);
			sketch.textSize(18);
			sketch.text(affichageMdp, 170, 132);
			
			if(echec) {
				sketch.fill(255,0,0);
				sketch.textSize(20);
				sketch.text("mot de passe incorrect !",18,182);
				sketch.fill(0);
				
			}
			sketch.textSize(24);
		}
		
		sketch.image(onglet,1109,0);
		if(!controlConnexion.isConnected()) {
			sketch.image(cache, 1100,501);
		}
		if(saisieMdp) {
			sketch.image(selected, 167, 104);
		}
		
	}
	
	public void keyPressed() {
		if( saisieMdp) {
			if(affichageMdp.length() < 14 && (sketch.key>='a' && sketch.key <='z' || sketch.key>='A' && sketch.key <='Z' || sketch.key>='0' && sketch.key <='9')) {
				mdp+=sketch.key;
				affichageMdp+='*';
			}
			if(sketch.key == PConstants.DELETE || sketch.key == PConstants.BACKSPACE || sketch.key == PConstants.RETURN ) {
				if(affichageMdp.length()>0) {
					affichageMdp = affichageMdp.substring(0, affichageMdp.length()-1);
					mdp = mdp.substring(0, mdp.length()-1);
					
				}
			}
			if(sketch.key == PConstants.ENTER) {
				/*boolean b=*/controlConnexion.connexion(mdp); // mieux si change le retour de connexion dans le contre en boolean 
				if (!controlConnexion.isConnected()) {
					echec = true;
				}
				mdp = "";
				affichageMdp = "";
				saisieMdp = false;
			}
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
		echec = false;
		saisieMdp = false;
		switch (action) {
			case "BoutonConnexion":
				if(controlConnexion.isConnected()) {
					controlConnexion.deconnexion();
				}else {
					/*boolean b=*/controlConnexion.connexion(mdp); // mieux si change le retour de connexion dans le contre en boolean 
					if (!controlConnexion.isConnected()) {
						echec = true;
					}
					mdp = "";
					affichageMdp = "";
				}
				break;
			case "Attente":
				this.saisieMdp = false;
				break;
			case "SaisieMdp":
				if(!controlConnexion.isConnected())
					this.saisieMdp = true;
				break;
			case "Croix":
			case "Retour":
				if(oldMenu == 0)
					FindMe.changeMenu("Principal", requette,0,false);
				else
					FindMe.changeMenu("Recherche", requette,0,false);
				break;
			default:
				break;
		}
		return null;
	}
	
	public void setOldMenu(int i) {
		oldMenu = i;
	}
}
