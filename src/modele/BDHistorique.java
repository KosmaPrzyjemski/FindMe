package modele;

import java.util.ArrayList;

public class BDHistorique {
	private ArrayList<Requette> requettes;
	private ArrayList<ArrayList<Resultat>> resultats;
	
	private int nbRecherche = 0;
	
	
	private BDHistorique() {
		requettes = new ArrayList<>();
		resultats = new ArrayList<>();
	}
	
	private static class BDHistoriqueHolder{
		private static BDHistorique instance = new BDHistorique();
	}
	
	
	public static BDHistorique getInstance() {
		return BDHistoriqueHolder.instance;
	}
	
	
	public void archiver(Requette requette, ArrayList<Resultat> resultats) {
		requettes.add(requette);
		this.resultats.add(resultats);
		nbRecherche++;
	}
	
	
	public int getNbRecherche() {
		return this.nbRecherche;
	}
	
	public ArrayList<Requette> getRequettes(){
		return this.requettes;
	}
	
	public ArrayList<ArrayList<Resultat>> getResultats() {
		return this.resultats;
	}
	
	public Requette getRequette(int indice){
		return this.requettes.get(indice);
	}
	
	public ArrayList<Resultat> getResultat(int indice) {
		return this.resultats.get(indice);
	}	
}
