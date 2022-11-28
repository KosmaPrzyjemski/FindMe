package vueconsole;

import java.util.ArrayList;

import controleur.ControlEffectuerRecherche;
import modele.Clavier;

public class BoundaryEffectuerRecherche {
	private ControlEffectuerRecherche controlEffectuerRecherche;
	private BoundaryAfficherResultats boundaryAfficherResultats;
	
	public BoundaryEffectuerRecherche(ControlEffectuerRecherche controlEffectuerRecherche,BoundaryAfficherResultats boundaryAfficherResultats) {
		this.controlEffectuerRecherche = controlEffectuerRecherche;
		this.boundaryAfficherResultats = boundaryAfficherResultats;
	}
	
	public void effectuerRecherche() {
		System.out.print("Entrez votre recherche : ");
		String requette = Clavier.entrerClavierString();
		int type = 0;
		while(type<1 || type>3) {
			System.out.print("veuillez maintenant selectionner le type de rehcerche :\n"
					+ "1 - Texte\n"
					+ "2 - Image\n"
					+ "3 - Audio\n"
					+ "Votre selection :");
			type = Clavier.entrerClavierInt();
			if(type<1 || type>3) {
				System.out.println("erreur de saisie");
			}
		}
		ArrayList<String> resultats = new ArrayList<String>();
		switch(type) {
			case 1:
				System.out.println("Recherche Texte en cour :");
				resultats = controlEffectuerRecherche.rechercheTexte(requette);
				break;
			case 2:
				System.out.println("Recherche Image en cour :");
				resultats = controlEffectuerRecherche.rechercheImage(requette);
				break;
			case 3:
				System.out.println("Recherche Audio en cour :");
				resultats = controlEffectuerRecherche.rechercheAudio(requette);
				break;
			default:
				System.out.println("Il y a eu une erreur");
				break;
		}
		String nomCouleur = controlEffectuerRecherche.getCouleurString();
		if(nomCouleur.equals("toutes les couleurs")) {
			boundaryAfficherResultats.AfficherResultats(requette, resultats);
		}else {
			boundaryAfficherResultats.AfficherResultats("[Couleur "+nomCouleur+"]", resultats);
		}
		
	}
}
