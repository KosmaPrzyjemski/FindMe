package vueconsole;

import controleur.ControlHistorique;
import modele.Clavier;

public class BoundaryHistorique {
	ControlHistorique controlHistorique = new ControlHistorique();
	BoundaryAfficherResultats boundaryAfficherResultats;

	public BoundaryHistorique(ControlHistorique controlHistorique,
			BoundaryAfficherResultats boundaryAfficherResultats) {
		this.controlHistorique = controlHistorique;
		this.boundaryAfficherResultats = boundaryAfficherResultats;
	}

	public void afficherHistorique() {
		int nombre = controlHistorique.getNbRecherche();
		System.out.println("Vous avez effectué " + nombre + " recherches");

		for (int i = 0; i < nombre; i++) {
			System.out.println("" + (i + 1) + " " + controlHistorique.getTypeRequetteHistorique(i) + " : "
					+ controlHistorique.getRequetteHistorique(i));
		}

		System.out.println("1-Effectuer une ancienne recherche\n2-Retour au menu Principal");
		int choix = Clavier.entrerClavierInt();

		switch (choix) {
		case 1:
			if(controlHistorique.getNbRecherche()==0) {
				System.out.println("Vous n'avez pas effectue de recherche.\n");
			}else {
				System.out.println("Choissisez la recherche :");
				choix = Clavier.entrerClavierInt();
				boundaryAfficherResultats.AfficherResultats(controlHistorique.getRequetteHistorique(choix-1),
						controlHistorique.getResultatHistorique(choix-1));
			}
			break;

		case 2:
			controlHistorique.setBooleanHistorique(false);
			break;

		default:
			System.out.println("Choix inconnu\n");
			this.afficherHistorique();
			break;

		}
	}

	public boolean getBooleanMenuHistorique() {
		return controlHistorique.getBooleanMenuHistorique();
	}

	public void setBooleanHistorique(boolean choix) {
		controlHistorique.setBooleanHistorique(choix);
	}
}
