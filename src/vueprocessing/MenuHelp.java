package vueprocessing;

import processing.core.PApplet;
import processing.core.PImage;

public class MenuHelp extends Menu {
	private PApplet sketch;
	private String requette = "";
	private PImage background;
	
	public MenuHelp(PApplet sketch) {
		this.sketch = sketch;
		background = sketch.loadImage("./src/data/image/help.PNG");
	}
	
	public void render() {
		sketch.image(background,0,0);
		sketch.textSize(24);
		sketch.fill(0);
		sketch.text(requette,328,332);
	}
	
	public Menu moussePressed(int x,int y) {
		FindMe.changeMenu("Principal", requette,0,false);
		return null;
	}
	
	public void setRecherche(String requette) {
		this.requette = requette;
	}
}
