package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RequetteImageTest {
	static RequetteImage requetteFleur = new RequetteImage("fleur", 70);
	static RequetteImage requetteSunglasses = new RequetteImage("sunglasses", 50);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(requetteFleur!=null);
		Assumptions.assumeTrue(requetteSunglasses!=null);
	}
	
	@Test
	void testGetNom() {
		Assertions.assertEquals("fleur", requetteFleur.getNom());
		Assertions.assertEquals("sunglasses", requetteSunglasses.getNom());
	}
	
	@Test
	void testGetType() {
		Assertions.assertEquals(TypeFichier.IMAGE, requetteFleur.getType());
		Assertions.assertEquals(TypeFichier.IMAGE, requetteSunglasses.getType());
	}
	
	@Test
	void testGetTauxSimilarite() {
		Assertions.assertEquals(70, requetteFleur.getTauxSimilarite());
		Assertions.assertEquals(50, requetteSunglasses.getTauxSimilarite());
	}
	
	@Test
	void testToString() {
		Assertions.assertEquals("[Requette de type IMAGE (fleur) : fichier avec un taux de 70%]", requetteFleur.toString());
		Assertions.assertEquals("[Requette de type IMAGE (sunglasses) : fichier avec un taux de 50%]", requetteSunglasses.toString());
	}

}
