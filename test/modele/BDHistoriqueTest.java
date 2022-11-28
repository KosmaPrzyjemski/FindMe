package modele;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class BDHistoriqueTest {
	static BDHistorique bdHistorique = BDHistorique.getInstance();
	static Requette requetteTest = new RequetteTexte("TestRequetteTexte", 80);
	static ArrayList<Resultat> resultatsTest = new ArrayList<>();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(bdHistorique!=null, "Expected : True , Actual : "+(bdHistorique!=null));
		bdHistorique.archiver(requetteTest, resultatsTest);
	}

	@Test
	void testArchiver() {
		Assertions.assertEquals(requetteTest, bdHistorique.getRequette(0));
		Assertions.assertEquals(resultatsTest, bdHistorique.getResultat(0));
	}
	
	@Test
	void testGetNbRecherche() {
		Assertions.assertEquals(1, bdHistorique.getNbRecherche(), "Expected : 1 , Actual : "+bdHistorique.getNbRecherche());
	}
	
	@Test
	void testGetRequettes() {
		Assertions.assertEquals(requetteTest, bdHistorique.getRequettes().get(0));
	}
	
	@Test
	void testGetResultats() {
		Assertions.assertEquals(resultatsTest, bdHistorique.getResultats().get(0));
	}
	
	@Test
	void testgetRequette() {
		Assertions.assertEquals(requetteTest, bdHistorique.getRequette(0));
	}
	
	@Test
	void testGetResultat() {
		Assertions.assertEquals(resultatsTest, bdHistorique.getResultat(0));
	}

}
