package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FabriqueRequetteTest {
	static OptionsRecherche optionsRecherche = OptionsRecherche.getInstance();
	static String requette = "Halo";
	static Couleur couleur = new Couleur(120,0,150, "Violet");
	static Requette requetteTexteOuMots = FabriqueRequette.creerRequette(TypeFichier.TEXTE, requette, null, optionsRecherche.getTauxSimilarite(), optionsRecherche.getNbApparition());
	static Requette requetteImage = FabriqueRequette.creerRequette(TypeFichier.IMAGE, "Couleur "+couleur.getNomCouleur() , couleur, optionsRecherche.getTauxSimilarite(), 0);
	static RequetteAudio requetteAudio = (RequetteAudio)FabriqueRequette.creerRequette(TypeFichier.AUDIO, requette, null, optionsRecherche.getTauxSimilarite(), optionsRecherche.getNbApparition());
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(optionsRecherche!=null);
		Assumptions.assumeTrue(couleur!=null);
	}

	@Test
	void testCreerRequette() {
		Assertions.assertNotNull(requetteTexteOuMots);
		Assertions.assertNotNull(requetteImage);
		Assertions.assertNotNull(requetteAudio);
		
	}

}
