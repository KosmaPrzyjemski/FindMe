package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ResultatTest {
	static Resultat resultat = new Resultat(TypeFichier.AUDIO);
	static Resultat resultatMusique = new Resultat("musique", 75, TypeFichier.TEXTE);
	static Resultat resultatRouge = new Resultat("01", 60, TypeFichier.IMAGE);
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(resultat!=null);
		Assumptions.assumeTrue(resultatMusique!=null);
		Assumptions.assumeTrue(resultatRouge!=null);
	}
	
	@Test
	void testGetNom() {
		Assertions.assertEquals("test", resultat.getNom());
		Assertions.assertEquals("musique", resultatMusique.getNom());
		Assertions.assertEquals("01", resultatRouge.getNom());
	}
	
	@Test
	void testGetPourcentage() {
		Assertions.assertEquals(42, resultat.getPourcentage());
		Assertions.assertEquals(75, resultatMusique.getPourcentage());
		Assertions.assertEquals(60, resultatRouge.getPourcentage());
	}
	
	@Test
	void testToString() {
		Assertions.assertEquals("fichier AUDIO : test 42%", resultat.toString());
		Assertions.assertEquals("fichier TEXTE : musique 75%", resultatMusique.toString());
		Assertions.assertEquals("fichier IMAGE : 01 60%", resultatRouge.toString());
	}
	
}
