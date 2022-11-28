package modele;

import java.util.ArrayList;

public class Parametres {
	public boolean actialisationDonnees = false;
	public ArrayList<Moteur> listeMoteurs;
	private BDFichiers bdFichiers;
	
	public Parametres() {
		listeMoteurs = new ArrayList<>();
		bdFichiers = new BDFichiers();
	}
	
	public void activerActialisationDonnees() {
		actialisationDonnees = true;
	}
	
	public void desactiverActialisationDonnees() {
		actialisationDonnees = false;
	}
	
	public boolean actialisationDonneesIsActive() {
		return actialisationDonnees;
	}
	
	public void activerMoteur(Moteur moteur) {
		for (Moteur m : listeMoteurs) {
			if (m.equals(moteur)) {
				m.activerMoteur();
			}
		}
	}
	
	public void desactiverMoteur(Moteur moteur) {
		for (Moteur m : listeMoteurs) {
			if (m.equals(moteur)) {
				m.desactiverMoteur();
			}
		}
	}
	
	public ArrayList<Moteur> getListeMoteurs(){
		return listeMoteurs;
	}
	/*
	public String listeMoteursToString() {
		String stringListeMoteurs = "";
		int i = 1;
		for (Moteur m : listeMoteurs) {
				stringListeMoteurs += i+". " + m.toString() + "\n";
				i++;
		}
		return stringListeMoteurs;
	}
	*/
	public void ajouterFichier(String fichier) {
		if (!bdFichiers.contains(fichier)) {
			bdFichiers.ajouterFichier(fichier);
		}
		else {
			System.out.println("Le fichier " + fichier + " existe deja dans la base de donnees.");
		}
	}
	
	/* De plus : */
	public void addMoteur(Moteur moteur) {
		listeMoteurs.add(moteur);
	}
	
	public String bdFichiersToString() {
		return bdFichiers.toString();
	}
	
	public int getNombreMoteurs() {
		return listeMoteurs.size();
	}
	
	public Moteur getMoteurViaIndex(int choix) {
		if (choix>=1) {
			return listeMoteurs.get(choix-1);
		}
		System.out.println("Attention : moteur NULL");
		return null;
	}

	public void desactiverMoteurs() {
		for(Moteur moteur : listeMoteurs) {
			moteur.desactiverMoteur();
		}
	}
	
	/* pour le BoundaryParametres
	 * System.out.println("Veuillez saisir votre fichier :");
		String fichier = Clavier.entrerClavierString();
		*/
}
