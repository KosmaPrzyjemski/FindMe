package vueconsole;

import java.util.ArrayList;


public class BoundaryAfficherResultats {
	
	public BoundaryAfficherResultats() {
	}
	
	void AfficherResultats(String requette, ArrayList<String> resultats) {
		System.out.println("Pour la recherche :"+requette);
		if(resultats.size() == 0) {
			System.out.println("Aucun résultat trouvé pour cette recherche\n");
		}else {
			System.out.println("Nous avons trouvé "+resultats.size()+" résultats :");
			for(String resultat : resultats) {
				System.out.println(resultat);
			}
			System.out.println("Fin affichage des resultats\n");
		}
	}
	
}
