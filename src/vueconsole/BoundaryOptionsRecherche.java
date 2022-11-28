package vueconsole;



import controleur.ControlChangerOptionsRecherche;
import modele.Clavier;
import modele.Couleur;

public class BoundaryOptionsRecherche {
	//ATTRIBUTS
	//Ajouter control
	private ControlChangerOptionsRecherche controlChangerOptionsRecherche = new ControlChangerOptionsRecherche();
	
	
	
	//CONSTRUCTEUR
	public BoundaryOptionsRecherche (ControlChangerOptionsRecherche controlChangerOptionsRecherche) {
		this.controlChangerOptionsRecherche = controlChangerOptionsRecherche;
	}
	
	//METHODES
	public void menuOptionsRecherche() {
		while(getBooleanMenuOptionsRecherche()) {
			System.out.println(getInformationOptionsRecherche());
			System.out.println("Quelle option voulez-vous changer?");
			System.out.println("1. Similarite");
			System.out.println("2. Couleur");
			System.out.println("3. Nombre d'apparitions");
			System.out.println("0. Retourner au menu principal");
			
			int choix = Clavier.entrerClavierInt();
			
			switch (choix) {
			case 1:
				changerSimilarite();
				break;
			case 2: 
				changerCouleur();
				break;
			case 3:
				changerNbApparitions();
				break;
			case 0: 
				System.out.println("Exit --> Menu Principal");
				setBooleanMenuOptionsRecherche(false);
				break;
			default:
				System.out.println("Choix invalide. ");
				break;
			}
			
			//System.out.println(getInformationOptionsRecherche());
		}
	}
	
	public void addCouleur() {
		System.out.println("Veuillez entrer le couleur que vous voulez ajouter a la base de donnees en RVB, puis son nom");
		System.out.println("r = ");
		int r = Clavier.entrerClavierInt();
		System.out.println("v = ");
		int v = Clavier.entrerClavierInt();
		System.out.println("b = ");
		int b = Clavier.entrerClavierInt();
		System.out.println("nom = ");
		String nom = Clavier.entrerClavierString();
		Couleur couleur = new Couleur(r, v, b, nom);
		controlChangerOptionsRecherche.ajouterCouleur(couleur);
	}
	
	public void changerSimilarite() {
		System.out.println("Veuillez entrer un taux de similarite entre 1 et 100");
		int similarite = Clavier.entrerClavierInt();
		controlChangerOptionsRecherche.changerTauxSimilarite(similarite);
	}
	
	public void changerCouleur() {
		System.out.println("Veuillez choisir un couleur pour sa recherche : ");
		System.out.println(controlChangerOptionsRecherche.getListCouleursToString());
		int i = Clavier.entrerClavierInt();
		if(i>0 && i<=controlChangerOptionsRecherche.getListCouleurs().size()) {
			//controlChangerOptionsRecherche.changerCouleur(controlChangerOptionsRecherche.getListCouleurs().get(i-1));
		} else {
			System.out.println("Choix invalide");
		}
	}
	
	public void changerNbApparitions() {
		System.out.println("Veuillez rentrer le numero d'apparitions que vous souhaitez");
		int newNoApparitions = Clavier.entrerClavierInt();
		controlChangerOptionsRecherche.changerNoApparitions(newNoApparitions);
	}
	
	public String getListCouleurToString() {
		return "Couleurs disponibles : \n" + controlChangerOptionsRecherche.getListCouleursToString();
	}
	
	
	public String getInformationOptionsRecherche() {
		return "\nPARAMETRES OPTION RECHERCHE : \n" 
				+ "Recherche image : " + controlChangerOptionsRecherche.getCouleurRecherche().getNomCouleur()
				+ "\nTaux de similarite: " + controlChangerOptionsRecherche.getTauxSimilarite()
				+ "\nNombre d'apparitions : " + controlChangerOptionsRecherche.getNbApparitions() + "\n";
	}
	
	public void setBooleanMenuOptionsRecherche(boolean etat) {
		controlChangerOptionsRecherche.setBooleanMenuOptionsRecherche(etat);
	}
	
	public boolean getBooleanMenuOptionsRecherche() {
		return controlChangerOptionsRecherche.getBooleanMenuOptionsRecherche();
	}

}