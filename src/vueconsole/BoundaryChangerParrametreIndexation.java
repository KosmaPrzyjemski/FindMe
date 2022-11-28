package vueconsole;

import controleur.ControlChangerParrametreIndexation;
import modele.Clavier;

public class BoundaryChangerParrametreIndexation {
	private ControlChangerParrametreIndexation controlChangerParrametreIndexation;
	
	public BoundaryChangerParrametreIndexation(ControlChangerParrametreIndexation controlChangerParrametreIndexation) {
		this.controlChangerParrametreIndexation=controlChangerParrametreIndexation;
	}
	
	
	public void ChangerParrametreIndexation() {
		
		int choix;
		do {
			System.out.println(" Quel parrametre voulez vous changer ");
			System.out.println(" 0 - quitter le menu");
			System.out.println(" 1 - Parrametres d'indexation texte courant : "+controlChangerParrametreIndexation.getParrametreTexte()+"  ");
			System.out.println(" 2 - Parrametres d'indexation image courant :"+controlChangerParrametreIndexation.getParrametreImage()+" ");
			System.out.println(" 3 - Parrametres d'indexation audio courant :"+controlChangerParrametreIndexation.getParrametreAudio()+" ");
			System.out.println(" 4 - Lancer Indexation ");
			choix = Clavier.entrerClavierInt();
			switch(choix) {
				case 1:
					System.out.println("vous avez avez choisis texte entrez le nouveau parrametre :");
					int nouveauParram = Clavier.entrerClavierInt();
					controlChangerParrametreIndexation.changerParrametreTexte(nouveauParram);
					break;
					
				case 2:
				
					System.out.println("vous avez avez choisis Image entrez le nouveau parrametre :");
					int nouveauParram1 = Clavier.entrerClavierInt();
					controlChangerParrametreIndexation.changerParrametreImage(nouveauParram1);
				break;	
				
				case 3:
					
					System.out.println("vous avez avez choisis Audio entrez le nouveau parrametre :");
					int nouveauParram2 = Clavier.entrerClavierInt();
					controlChangerParrametreIndexation.changerParrametreAudio(nouveauParram2);
				break;	
				
				case 4:
					controlChangerParrametreIndexation.lancerIndexation();
			}
		}while(choix!=0);
		
	}
}
