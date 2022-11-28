package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OptionsRechercheTest {
	static OptionsRecherche optionsRecherche = OptionsRecherche.getInstance();
	static Couleur violet = new Couleur(200,10,190, "Violet");

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(optionsRecherche!=null);
	}

	@BeforeEach
	void setUp() throws Exception {
		optionsRecherche.setBooleanMenuOptionsRecherche(true);
	}

	@Test
	void testSetBooleanMenuOptionsRecherche() {
		Assertions.assertTrue(optionsRecherche.getBooleanMenuOptionsRecherche());
		optionsRecherche.setBooleanMenuOptionsRecherche(false);
		Assertions.assertFalse(optionsRecherche.getBooleanMenuOptionsRecherche());
	}
	
	@Test
	void testGetBooleanMenuOptionsRecherche() {
		Assertions.assertTrue(optionsRecherche.getBooleanMenuOptionsRecherche());
		optionsRecherche.setBooleanMenuOptionsRecherche(false);
		Assertions.assertFalse(optionsRecherche.getBooleanMenuOptionsRecherche());
	}
	
	@Test
	void testAddCouleur() {
		optionsRecherche.addCouleur(violet);
		Assertions.assertTrue(optionsRecherche.getListCouleurs().get(0).equals(violet));
	}
	
	@Test
	void testGetTauxSimilarite() {
		optionsRecherche.setTauxSimilarite(80);
		Assertions.assertEquals(80, optionsRecherche.getTauxSimilarite());
	}
	
	@Test
	void testSetTauxSimilarite() {
		optionsRecherche.setTauxSimilarite(50);
		Assertions.assertEquals(50, optionsRecherche.getTauxSimilarite());
	}
	
	@Test
	void testGetNbApparition() {
		Assertions.assertEquals(3, optionsRecherche.getNbApparition());
		optionsRecherche.setNbApparition(5);;
		Assertions.assertEquals(5, optionsRecherche.getNbApparition());
	}
	
	@Test
	void testSetNbApparition() {
		optionsRecherche.setNbApparition(4);;
		Assertions.assertEquals(4, optionsRecherche.getNbApparition());
	}
	
	@Test
	void testGetCouleur() {
		optionsRecherche.setCouleur(violet);
		Assertions.assertEquals(violet, optionsRecherche.getCouleur());	
	}
	
	@Test
	void testSetCouleur() {
		optionsRecherche.setCouleur(violet);
		Assertions.assertEquals(violet, optionsRecherche.getCouleur());	
	}
	
	@Test
	void testGetListCouleursToString() {
		Assertions.assertEquals("1. Violet\n", optionsRecherche.getListCouleursToString());
	}
	
	@Test
	void testGetListCouleurs() {
		Assertions.assertEquals(violet, optionsRecherche.getListCouleurs().get(0));
	}
	
}
