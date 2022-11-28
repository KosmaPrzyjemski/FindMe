package controleur;

import java.util.ArrayList;

import modele.BDHistorique;
import modele.Requette;
import modele.Resultat;

public class ControlHistorique {
	private BDHistorique bdHistorique = BDHistorique.getInstance();
	private boolean menuHistorique = false;
	
	public void archiver(Requette requette, ArrayList<Resultat> resultats) {
		bdHistorique.archiver(requette, resultats);
	}


	public ArrayList<String> getResultatHistorique(int indice) {
		ArrayList<String> resultats = new ArrayList<>();
		ArrayList<Resultat> resultatsHisto = bdHistorique.getResultat(indice);
		for(Resultat resultat : resultatsHisto) {
			resultats.add(resultat.toString());
		}
		return resultats;
	}
	
	public String getRequetteHistorique(int indice) {
		return bdHistorique.getRequette(indice).getNom();
	}


	public int getNbRecherche() {
		return bdHistorique.getNbRecherche();
	}


	public String getTypeRequetteHistorique(int i) {
		return bdHistorique.getRequette(i).getType().name();
	}
	

	public boolean getBooleanMenuHistorique() {
		return menuHistorique;
	}
	
	public void setBooleanHistorique(boolean choix) {
		menuHistorique=choix;	
	}


	public ArrayList<Resultat> getResultats(int indice) {
		return bdHistorique.getResultat(indice);
	}

}
