package vueconsole;

import java.util.ArrayList;


public class BoundaryAfficherResultats {
	
	public BoundaryAfficherResultats() {
	}
	
	void AfficherResultats(String requette, ArrayList<String> resultats) {
		System.out.println("Pour la recherche :"+requette);
		if(resultats.size() == 0) {
			System.out.println("Aucun r�sultat trouv� pour cette recherche\n");
		}else {
			System.out.println("Nous avons trouv� "+resultats.size()+" r�sultats :");
			for(String resultat : resultats) {
				System.out.println(resultat);
			}
			System.out.println("Fin affichage des resultats\n");
		}
	}
	
}
