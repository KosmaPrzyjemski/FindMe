package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParametresTest {
	static Parametres parametres = new Parametres();
	static Moteur findMe = new Moteur("FindMe");

	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(findMe != null, "Assume : Moteur de recherche FindMe non-null");
		Assumptions.assumeTrue(parametres != null, "Assume : Parametres parametres non-null");
		parametres.addMoteur(findMe);
	}

	@BeforeEach
	void setUp() throws Exception {
		parametres.desactiverActialisationDonnees();
		parametres.desactiverMoteur(findMe);
	}

	@Test
	void testAddMoteur() {
		Assertions.assertNotNull(parametres.listeMoteurs.get(0));
	}
	
	@Test
	void testActiverActialisationDonnees() {
		parametres.activerActialisationDonnees();
		Assertions.assertTrue(parametres.actialisationDonnees, "Expected : True , Actual : "+parametres.actialisationDonnees);
	}
	
	@Test
	void testDesactiverActialisationDonnees() {
		parametres.activerActialisationDonnees();
		Assertions.assertTrue(parametres.actialisationDonnees, "testActiverActialisationDonnees : OK");
		parametres.desactiverActialisationDonnees();
		Assertions.assertFalse(parametres.actialisationDonnees, "testDesactiverActialisationDonnees : OK");
	}
	
	@Test
	void testActialisationDonneesIsActive() {
		Assertions.assertFalse(parametres.actialisationDonneesIsActive(), "Expected : False , Actual : "+parametres.actialisationDonneesIsActive());
		parametres.activerActialisationDonnees();
		Assertions.assertTrue(parametres.actialisationDonneesIsActive(), "Expected : True , Actual : "+parametres.actialisationDonneesIsActive());
	}
	
	@Test
	void testActiverMoteur() {
		parametres.activerMoteur(findMe);
		Assertions.assertTrue(findMe.moteurIsActive(), "Expected : True , Actual : "+findMe.moteurIsActive());
	}
	
	@Test
	void testDesactiverMoteur() {
		parametres.activerMoteur(findMe);
		Assertions.assertTrue(findMe.moteurIsActive(), "Expected : True , Actual : "+findMe.moteurIsActive());
		parametres.desactiverMoteur(findMe);
		Assertions.assertFalse(findMe.moteurIsActive(), "Expected : False , Actual : "+findMe.moteurIsActive());
	}
	
	@Test
	void testGetListeMoteurs() {
		Assertions.assertEquals(findMe, parametres.getListeMoteurs().get(0));
	}
	
	@Test
	void testAjouterFichier(){
		Assertions.assertEquals("BDFichiers [listeFichiers=[Halo]]", parametres.bdFichiersToString(), "Expected : \"BDFichiers [listeFichiers= Halo ]\" , Actual : "+parametres.bdFichiersToString());
	}
	
	@Test
	void testBdFichiersToString(){
		parametres.ajouterFichier("Halo");
		Assertions.assertEquals("BDFichiers [listeFichiers=[Halo]]", parametres.bdFichiersToString(), "Expected : \"BDFichiers [listeFichiers= Halo ]\" , Actual : "+parametres.bdFichiersToString());
	}
	
	
	@Test
	void testGetNombreMoteurs(){
		Assertions.assertEquals(1, parametres.getNombreMoteurs(), "Expected : 1 , Actual : "+parametres.getNombreMoteurs());
	}
	
	
	@Test
	void testGetMoteurViaIndex(){
		Assertions.assertNotNull(parametres.getMoteurViaIndex(1), "Expected : NotNull (on a deja ajoute un moteur) , Actual : Null");
	}
	
	@Test 
	void testDesactiverMoteurs() {
		for (Moteur m : parametres.getListeMoteurs()) {
			Assertions.assertFalse(m.moteurIsActive());
		}
	}
	
	
}
