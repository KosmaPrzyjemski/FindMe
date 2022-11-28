package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RequetteCouleurTest {
	static Couleur violet = new Couleur(200,10,190, "Violet");
	static Couleur rouge = new Couleur(255,0,0, "Rouge");
	static RequetteCouleur requetteViolet = new RequetteCouleur("requette violet", violet);
	static RequetteCouleur requetteRouge = new RequetteCouleur("requette rouge", rouge);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}
	
	@Test
	void testGetNom() {
		Assertions.assertEquals("requette violet", requetteViolet.getNom());
		Assertions.assertEquals("requette rouge", requetteRouge.getNom());
	}
	
	@Test
	void testGetType() {
		Assertions.assertEquals(TypeFichier.IMAGE, requetteViolet.getType());
		Assertions.assertEquals(TypeFichier.IMAGE, requetteRouge.getType());
	}
	
	@Test
	void testGetCouleur() {
		Assertions.assertEquals(violet, requetteViolet.getCouleur());
		Assertions.assertEquals(rouge, requetteRouge.getCouleur());
	}
	
	@Test
	void testToString() {
		Assertions.assertEquals("Requette de type IMAGE (requette violet) : Recherche de Violet", requetteViolet.toString());
		Assertions.assertEquals("Requette de type IMAGE (requette rouge) : Recherche de Rouge", requetteRouge.toString());
	}

}
