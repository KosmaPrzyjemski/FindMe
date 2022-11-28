package vueconsole;

import modele.Clavier;

public class BundaryMenuPrincipal {
	private BoundaryParametres boundaryParametres;
	private BoundaryEffectuerRecherche boundaryEffectuerRecherche;
	private BoundaryHistorique boundaryHistorique;
	private BoundaryConnexion boundaryConnexion;
	private BoundaryOptionsRecherche boundaryOptionsRechercher;
	private BoundaryChangerParrametreIndexation boundaryChangerParrametreIndexation;
	private boolean menuPrincipal = true;

	public BundaryMenuPrincipal(BoundaryParametres boundaryParametres, BoundaryEffectuerRecherche boundaryEffectuerRecherche, BoundaryHistorique boundaryHistorique, BoundaryConnexion boundaryConnexion,BoundaryOptionsRecherche boundaryOptionsRechercher,BoundaryChangerParrametreIndexation boundaryChangerParrametreIndexation) {
		this.boundaryParametres = boundaryParametres;
		this.boundaryEffectuerRecherche = boundaryEffectuerRecherche;
		this.boundaryHistorique = boundaryHistorique;
		this.boundaryConnexion = boundaryConnexion;
		this.boundaryOptionsRechercher = boundaryOptionsRechercher;
		this.boundaryChangerParrametreIndexation = boundaryChangerParrametreIndexation;
	}
	
	public void menuPrincipal() {
		if (!boundaryConnexion.isConnected()) {
			System.out.println("1. Recherche\n" + "2. Options de recherche\n" + "3. Historique\n"
					+ "4. Parametres\n" + "9. Connexion\n" + "0. Exit\nVotre selection :");

			int choix1 = Clavier.entrerClavierInt();
			switch (choix1) {
			case 1:
				boundaryEffectuerRecherche.effectuerRecherche();
				break;
			case 2:
				boundaryOptionsRechercher.setBooleanMenuOptionsRecherche(true);
				while(boundaryOptionsRechercher.getBooleanMenuOptionsRecherche()) {
					boundaryOptionsRechercher.menuOptionsRecherche();
				}
				break;
			case 3:
				boundaryHistorique.setBooleanHistorique(true);
				while(boundaryHistorique.getBooleanMenuHistorique()) {
					boundaryHistorique.afficherHistorique();
				}
				break;
			case 4:
				boundaryParametres.setBooleanMenuParametres(true);
				while(boundaryParametres.getBooleanMenuParametres()) {
					boundaryParametres.menuParametres();
				}
				break;
			case 9:
				boundaryConnexion.setBooleanMenuConnexion(true);
				while(boundaryConnexion.getBooleanMenuConnexion()) {
					boundaryConnexion.menuConnexion();
				}
				break;
			case 0:
				System.out.println("See you soon!");
				this.setBooleanMenuPrincipal(false);
				break;
			default:
				System.out.println("Option inconnu");
			}
		} else {
			System.out.println("1. Recherche\n" + "2. Options de recherche\n" + "3. Historique\n"
					+ "4. Parametres\n" + "5. Options d'administrateur\n" + "9. Deconnexion\n" + "0. Exit\nVotre selection :");

			int choix2 = Clavier.entrerClavierInt();
			switch (choix2) {
			case 1:
				boundaryEffectuerRecherche.effectuerRecherche();
				break;
			case 2:
				boundaryOptionsRechercher.setBooleanMenuOptionsRecherche(true);
				while(boundaryOptionsRechercher.getBooleanMenuOptionsRecherche()) {
					boundaryOptionsRechercher.menuOptionsRecherche();
				}
				break;
			case 3:
				boundaryHistorique.setBooleanHistorique(true);
				while(boundaryHistorique.getBooleanMenuHistorique()) {
					boundaryHistorique.afficherHistorique();
				}
				break;
			case 4:
				boundaryParametres.setBooleanMenuParametres(true);
				while(boundaryParametres.getBooleanMenuParametres()) {
					boundaryParametres.menuParametres();
				}
				break;
			case 5:
				boundaryChangerParrametreIndexation.ChangerParrametreIndexation();
				break;
			case 9:
				boundaryConnexion.setBooleanMenuConnexion(true);
				while(boundaryConnexion.getBooleanMenuConnexion()) {
					boundaryConnexion.menuConnexion();
				}
				break;
			case 0:
				System.out.println("See you soon!");
				this.setBooleanMenuPrincipal(false);
				break;
			default:
				System.out.println("Option inconnu.");
			}
		}
	}
	
	public boolean getBooleanMenuPrincipal() {
		return menuPrincipal;
	}
	
	public void setBooleanMenuPrincipal(boolean choice) {
		menuPrincipal = choice;
	}
}
