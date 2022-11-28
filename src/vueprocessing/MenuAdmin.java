package vueprocessing;

import java.util.ArrayList;

import controleur.ControlChangerParrametreIndexation;
import processing.core.PApplet;
import processing.core.PImage;

public class MenuAdmin extends Menu {

	private PApplet sketch;
	private String requette;
	private PImage onglet;
	private int posx;
	private ArrayList<Bouton> boutons;
	private ControlChangerParrametreIndexation controlChangerParrametreIndexation;

	private int positionXBar;
	private int positionXBar2;
	private int positionXBar3;
	private boolean suivreSouris = false;
	private boolean suivreSouris2 = false;
	private boolean suivreSouris3 = false;
	private int pourcentage = 20;
	private int pourcentage2 = 2;
	private int pourcentage3 = 2;
	private PImage tauxSimilarite;
	private PImage tauxSimilaritePressed;

	private int oldMenu;
	private boolean aJour = false;

	private PImage ongletOptionOver;
	private PImage ongletHistoriqueOver;
	private PImage ongletParametreOver;

	public MenuAdmin(PApplet sketch, ControlChangerParrametreIndexation controlChangerParrametreIndexation) {
		oldMenu = 0;
		posx = 1109;
		this.sketch = sketch;
		this.controlChangerParrametreIndexation = controlChangerParrametreIndexation;
		onglet = sketch.loadImage("./src/data/image/adminv2.PNG");
		ongletOptionOver = sketch.loadImage("./src/data/image/optionP.png");
		ongletHistoriqueOver = sketch.loadImage("./src/data/image/historiqueP.png");
		ongletParametreOver = sketch.loadImage("./src/data/image/parametreP.png");
		tauxSimilarite = sketch.loadImage("./src/data/image/slider.png");
		tauxSimilaritePressed = sketch.loadImage("./src/data/image/sliderP.png");

		this.boutons = new ArrayList<>();
		this.initialisation();

		pourcentage = controlChangerParrametreIndexation.getParrametreTexte();
		pourcentage2 = controlChangerParrametreIndexation.getParrametreImage();
		pourcentage3 = controlChangerParrametreIndexation.getParrametreAudio();
		positionXBar = 1014;
		positionXBar2 = 985;
		positionXBar3 = 985;
	}

	private void initialisation() {
		boutons.add(new Bouton("Retour", 0, 0, 855, sketch.height));
		boutons.add(new Bouton("Option", 855, 0, 70, 167));
		boutons.add(new Bouton("Historique", 855, 166, 70, 167));
		boutons.add(new Bouton("Paramettre", 855, 335, 70, 167));
		boutons.add(new Bouton("parram Indexation texte", 961, 145, 195, 35));
		boutons.add(new Bouton("parram Indexation image", 961, 226, 195, 35));
		boutons.add(new Bouton("parram Indexation audio", 961, 306, 195, 35));
		boutons.add(new Bouton("Mise a jour", 970, 385, 175, 100));
		boutons.add(new Bouton("Connexion Admin", 2, 2, 80, 80));

	}

	public void update() {
		if (posx > 858) {
			posx -= 8;
		}

		int min = 967;
		int max = 1132;
		if (suivreSouris) {
			positionXBar = sketch.mouseX - 5;
			if (positionXBar < min) {
				positionXBar = min;
			}
			if (positionXBar > max) {
				positionXBar = max;
			}
			pourcentage = 100 * (positionXBar - min) / (max - min);
		}

		if (suivreSouris2) {
			positionXBar2 = sketch.mouseX - 5;
			if (positionXBar2 < min) {
				positionXBar2 = min;
			}
			if (positionXBar2 > max) {
				positionXBar2 = max;
			}
			pourcentage2 = 5 * (positionXBar2 - min) / (max - min) + 2;
		}

		if (suivreSouris3) {
			positionXBar3 = sketch.mouseX - 5;
			if (positionXBar3 < min) {
				positionXBar3 = min;
			}
			if (positionXBar3 > max) {
				positionXBar3 = max;
			}
			pourcentage3 = 240 * (positionXBar3 - min) / (max - min) + 10;
		}

	}

	public void render() {
		sketch.image(onglet, posx, 0);

		if (posx < 858) {
			// slider 1
			if (suivreSouris) {
				sketch.image(tauxSimilaritePressed, positionXBar, 152);
			} else {
				sketch.image(tauxSimilarite, positionXBar, 152);
			}

			sketch.text(pourcentage, positionXBar - 4, 152 + 36);

			// slider 2
			if (suivreSouris2) {
				sketch.image(tauxSimilaritePressed, positionXBar2, 234);
			} else {
				sketch.image(tauxSimilarite, positionXBar2, 234);
			}

			sketch.text(pourcentage2, positionXBar2 - 4, 234 + 36);

			// slider 3
			if (suivreSouris3) {
				sketch.image(tauxSimilaritePressed, positionXBar3, 315);
			} else {
				sketch.image(tauxSimilarite, positionXBar3, 315);
			}

			sketch.text(pourcentage3, positionXBar3 - 4, 315 + 36);
		}

		if (aJour == true) {
			sketch.fill(0, 200, 150);
			sketch.textSize(24);
			sketch.text("Mise a�Jour !", 986, 527);
			sketch.fill(0);
		}

		int posY = sketch.mouseY;
		if (sketch.mouseX > 856 && sketch.mouseX < 921 && posx < 858) {
			if (posY < 168) {
				sketch.image(ongletOptionOver, 853, 0);
			} else if (posY < 335) {
				sketch.image(ongletHistoriqueOver, 853, 168);
			} else if (posY < 500) {
				sketch.image(ongletParametreOver, 853, 335);
			} else if (posY < sketch.height) {
				// sketch.image(ongletAdminOver, 853,500);
			}

		}

	}

	public void mouseReleased() {

		if (suivreSouris) {
			controlChangerParrametreIndexation.changerParrametreTexte(pourcentage);
			suivreSouris = false;
		}

		if (suivreSouris2) {
			controlChangerParrametreIndexation.changerParrametreImage(pourcentage2);
			suivreSouris2 = false;
		}

		if (suivreSouris3) {
			controlChangerParrametreIndexation.changerParrametreAudio(pourcentage3);
			suivreSouris3 = false;
		}
	}

	public Menu moussePressed(int x, int y) {
		aJour = false;
		String button = "";
		String action = "";
		System.out.println(x + " " + y);
		for (Bouton b : boutons) {
			button = b.mouseOver(sketch.mouseX, sketch.mouseY);
			if (button != "null") {
				action = button;
			}
		}

		System.out.println("action = " + action);
		switch (action) {
		case "Connexion Admin":
			if (oldMenu == 0)
				FindMe.changeMenu("Principal", requette, oldMenu, true);
			else
				FindMe.changeMenu("Recherche", requette, oldMenu, true);
			break;
		case "Retour":
			if (oldMenu == 0)
				FindMe.changeMenu("Principal", requette, oldMenu, false);
			else
				FindMe.changeMenu("Recherche", requette, oldMenu, false);
			break;
		case "Option":
			FindMe.changeMenu("Option", requette, oldMenu, false);
			break;
		case "Paramettre":
			FindMe.changeMenu("Paramettre", requette, oldMenu, false);
			break;
		case "Historique":
			FindMe.changeMenu("Historique", requette, oldMenu, false);
			break;
		case "parram Indexation texte":
			suivreSouris = true;
			break;
		case "parram Indexation image":
			suivreSouris2 = true;
			break;
		case "parram Indexation audio":
			suivreSouris3 = true;
			break;
		case "Mise a jour":
			controlChangerParrametreIndexation.lancerIndexation();
			controlChangerParrametreIndexation.miseAJour();
			aJour = true;
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
