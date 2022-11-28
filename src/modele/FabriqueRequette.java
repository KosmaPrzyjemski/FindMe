package modele;

import java.util.ArrayList;

import interfaceC.InterfaceC;

public class FabriqueRequette {
	
	public static Requette creerRequette(TypeFichier type,String requette,Couleur couleur,int tauxSimilarite,int nmbApparition) {
		if(couleur != null) {
			return new RequetteCouleur("Couleur "+couleur.getNomCouleur(), couleur);
		}else {
			if(!InterfaceC.fichierExiste(requette) && type == TypeFichier.TEXTE) {
				String[] parts = requette.split(" ");
				ArrayList<Triplet> mots = new ArrayList<>();
				for(String text : parts) {
					if(text.charAt(0) == '-') {
						mots.add(new Triplet(text.substring(1), false, 0));
					}else {
						if(text.charAt(0) == '+') {
							mots.add(new Triplet(text.substring(1), true ,nmbApparition)); // chnager nmbApparition par le nombre détecté dans le string
						}else {
							mots.add(new Triplet(text, true,nmbApparition));
						}
					}
				}
				
				return new RequetteMot(requette, mots);
			}else if(InterfaceC.fichierExiste(requette)){
				switch (type) {
					case TEXTE :
						return new RequetteTexte(requette,tauxSimilarite);
					case IMAGE:
						return new RequetteImage(requette,tauxSimilarite);
					default:
						return new RequetteAudio(requette,tauxSimilarite);
				}
			}else {
				switch (type) {
					case TEXTE :
						return new RequetteTexte(requette+ "(Fichier Inexistant)",tauxSimilarite);
					case IMAGE:
						return new RequetteImage(requette+ "(Fichier Inexistant)",tauxSimilarite);
					default:
						return new RequetteAudio(requette+ "(Fichier Inexistant)",tauxSimilarite);
				}
			}
		}
	}
}
