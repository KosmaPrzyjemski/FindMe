package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RequetteTexteTest {
	static RequetteTexte requetteBiologyArticle = new RequetteTexte("biology article", 75);
	static RequetteTexte requetteHikingPaper = new RequetteTexte("hiking paper", 60);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(requetteBiologyArticle!=null);
		Assumptions.assumeTrue(requetteHikingPaper!=null);
	}

	@Test
	void testGetNom() {
		Assertions.assertEquals("biology article", requetteBiologyArticle.getNom());
		Assertions.assertEquals("hiking paper", requetteHikingPaper.getNom());
	}
	
	@Test
	void testGetType() {
		Assertions.assertEquals(TypeFichier.TEXTE, requetteBiologyArticle.getType());
		Assertions.assertEquals(TypeFichier.TEXTE, requetteHikingPaper.getType());
	}
	
	@Test
	void testGetTauxSimilarite() {
		Assertions.assertEquals(75, requetteBiologyArticle.getTauxSimilarite());
		Assertions.assertEquals(60, requetteHikingPaper.getTauxSimilarite());
	}
	
	@Test
	void testToString() {
		Assertions.assertEquals("[Requette de type TEXTE (biology article) : fichier avec un taux de 75%]", requetteBiologyArticle.toString());
		Assertions.assertEquals("[Requette de type TEXTE (hiking paper) : fichier avec un taux de 60%]", requetteHikingPaper.toString());
	}
}
