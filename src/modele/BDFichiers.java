package modele;

import java.util.ArrayList;

public class BDFichiers {
	private ArrayList<String> listeFichiers;
	
	public BDFichiers() {
		listeFichiers = new ArrayList<>();
	}
	
	public void ajouterFichier(String fichier) {
		listeFichiers.add(fichier);
	}
	
	public boolean contains(String fichier) {
		return listeFichiers.contains(fichier);
	}

	@Override
	public String toString() {
		return "BDFichiers [listeFichiers=" + listeFichiers + "]";
	}
	
}
