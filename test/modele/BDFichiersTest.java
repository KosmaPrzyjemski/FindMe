package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BDFichiersTest {
	static BDFichiers bdFichiers = new BDFichiers();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(bdFichiers != null, "Expected : True , Actual : "+(bdFichiers != null));
	}
	
	@Test
	void testGetListeFichiers(){
		bdFichiers.ajouterFichier("Halo");
		Assertions.assertTrue(bdFichiers.contains("Halo"), "Expected : True , Actual : False");
	}
	
	@Test
	void testAjouterFichier() {
		Assertions.assertTrue(bdFichiers.contains("Halo"), "Expected : True , Actual : False");
		bdFichiers.ajouterFichier("Halo ?");
		Assertions.assertTrue(bdFichiers.contains("Halo ?"), "Expected : True , Actual : False");
	}
	
	@Test
	void testContains() {
		Assertions.assertTrue(bdFichiers.contains("Halo"), "Expected : True , Actual : "+bdFichiers.contains("Halo"));
		Assertions.assertFalse(bdFichiers.contains("HaloHaloHalo"), "Expected : False , Actual : "+bdFichiers.contains("HaloHaloHalo"));
	}
	
	@Test
	void testToString() {
		bdFichiers.ajouterFichier("Halo");
		Assertions.assertEquals("BDFichiers [listeFichiers=[Halo]]", bdFichiers.toString(), "Expected : \"BDFichiers [listeFichiers= Halo ]\" , Actual : "+bdFichiers.toString());
	}
	

}
