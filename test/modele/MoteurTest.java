package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MoteurTest {
	static Moteur findMe = new Moteur("FindMe");
	static Moteur safari = new Moteur("Safari");
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(findMe != null, "Assume : Moteur de recherche FindMe non-null");
		Assumptions.assumeTrue(safari != null, "Assume : Moteur de recherche Safari non-null");
	}

	@BeforeEach
	void setUp() throws Exception {
		findMe.desactiverMoteur();
		safari.desactiverMoteur();
	}

	@Test
	void testActiverMoteur() {
		findMe.activerMoteur();
		Assertions.assertTrue(findMe.moteurIsActive(), "Expected : True , Actual : "+findMe.moteurIsActive());
		safari.activerMoteur();
		Assertions.assertTrue(safari.moteurIsActive(), "Expected : True , Actual : "+safari.moteurIsActive());
	}
	
	@Test
	void testDesactiverMoteur() {
		findMe.activerMoteur();
		Assertions.assertTrue(findMe.moteurIsActive());
		safari.activerMoteur();
		Assertions.assertTrue(safari.moteurIsActive());
		findMe.desactiverMoteur();
		Assertions.assertFalse(findMe.moteurIsActive(), "Expected : False , Actual : "+findMe.moteurIsActive());
		safari.desactiverMoteur();
		Assertions.assertFalse(safari.moteurIsActive(), "Expected : False , Actual : "+safari.moteurIsActive());
	}
	
	@Test
	void testMoteurIsActive() {
		Assertions.assertFalse(findMe.moteurActive, "Expected : False, Actual : "+findMe.moteurIsActive());
	}
	
	@Test
	void testToSring() {
		Assertions.assertEquals("FindMe : active = false", findMe.toSring(), "Expected : FindMe : active = false , Actual : "+findMe.toSring());
		Assertions.assertEquals("Safari : active = false", safari.toSring(), "Expected : Safari : active = false , Actual : "+findMe.toSring());
	}
	
	@Test
	void testGetNom() {
		Assertions.assertEquals("FindMe", findMe.getNom(), "Expected : FindMe , Actual : "+findMe.getNom());
		Assertions.assertEquals("Safari", safari.getNom(), "Expected : Safari , Actual : "+safari.getNom());
	}

}
