package modele;

import java.util.ArrayList;

public class RequetteMot extends Requette {
	private ArrayList<Triplet> mots;
	
	
	public RequetteMot(String nom,ArrayList<Triplet> mots) {
		super(nom,TypeFichier.TEXTE);
		this.mots = mots;
	}
	
	public ArrayList<Triplet> getMots(){
		return this.mots;
	}
	
	public String toString() {
		String s = "["+super.toString()+" : [";
		for(Triplet t : mots) {
			s+="("+t.toString()+")";
		}
		return s+"] ]";
	}
	
}
