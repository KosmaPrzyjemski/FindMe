package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CouleurTest {
	static Couleur couleurEmpty = new Couleur();
	static Couleur violet = new Couleur(200,10,190, "Violet");
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(couleurEmpty!=null);
		Assumptions.assumeTrue(violet!=null);
	}

	@BeforeEach
	void setUp() throws Exception {
		couleurEmpty.setCouleur("toutes les couleurs");
		violet.setCouleur("Violet");
	}	
	
	@Test
	void testGetRGB() {
		Assertions.assertEquals(200, violet.getRGB().get(0), "Expected : 200, Actual : "+violet.getRGB().get(0));
		Assertions.assertEquals(10, violet.getRGB().get(1), "Expected : 10, Actual : "+violet.getRGB().get(1));
		Assertions.assertEquals(190, violet.getRGB().get(2), "Expected : 190, Actual : "+violet.getRGB().get(2));
	}
	
	@Test
	void testIsVide() {
		Assertions.assertTrue(couleurEmpty.isVide(), "Expected : True , Actual : "+couleurEmpty.isVide());
		Assertions.assertFalse(violet.isVide(), "Expected : True , Actual : "+violet.isVide());
	}

	@Test
	void testGetNomCouleur() {
		Assertions.assertEquals("toutes les couleurs", couleurEmpty.getNomCouleur(), "Expected : toutes les couleurs , Actual : "+couleurEmpty.getNomCouleur());
		Assertions.assertEquals("Violet", violet.getNomCouleur(), "Expected : Violet , Actual : "+violet.getNomCouleur());
	}
	
	@Test
	void testToString() {
		Assertions.assertEquals("toutes les couleurs", couleurEmpty.getNomCouleur(), "Expected : toutes les couleurs , Actual : "+couleurEmpty.getNomCouleur());
		Assertions.assertEquals("Violet", violet.getNomCouleur(), "Expected : Violet , Actual : "+violet.getNomCouleur());
	}
	
	@Test
	void testSetCouleur() {
		couleurEmpty.setCouleur("-");
		violet.setCouleur("Dark Violet");
		Assertions.assertEquals("-", couleurEmpty.getNomCouleur(), "Expected : - , Actual : "+couleurEmpty.getNomCouleur());
		Assertions.assertEquals("Dark Violet", violet.getNomCouleur(), "Expected : Dark Violet , Actual : "+violet.getNomCouleur());
	}

}
