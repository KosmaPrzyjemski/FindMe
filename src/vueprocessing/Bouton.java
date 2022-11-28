package vueprocessing;

public class Bouton {
	int x;
	int y;
	int width;
	int height;
	String action;
	
	public Bouton(String nom, int x,int y, int width,int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		action = nom;
	}
	
	public String mouseOver(int mx,int my) {
		if (mx>x && mx<x+width && my>y && my<y+height) {
			return action;
		}
		return "null";
	}
	
}
