package modele;

import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RequetteMotTest {
	static Triplet tripletOeuvre = new Triplet("oeuvre", true, 3);
	static Triplet tripletRockMoins = new Triplet("rockMoins", false, 3);
	static ArrayList<Triplet> motsOeuvre = new ArrayList<>();
	static Triplet tripletMusique = new Triplet("musique", true, 5);
	static Triplet tripletRockPlus = new Triplet("rockPlus", true, 3);
	static ArrayList<Triplet> motsMusique = new ArrayList<>();
	
	static RequetteMot requetteOeuvre;
	static RequetteMot requetteMusique;
	//static RequetteMot requetteOeuvre = new RequetteMot("oeuvre -rock", motsOeuvre);
	//static RequetteMot requetteMusique = new RequetteMot("musique_+rock", motsMusique);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(tripletOeuvre!=null);
		Assumptions.assumeTrue(tripletRockMoins!=null);
		Assumptions.assumeTrue(motsOeuvre!=null);
		Assumptions.assumeTrue(tripletMusique!=null);
		Assumptions.assumeTrue(tripletRockPlus!=null);
		Assumptions.assumeTrue(motsMusique!=null);
		motsOeuvre.add(tripletOeuvre);
		motsOeuvre.add(tripletRockMoins);
		requetteOeuvre = new RequetteMot("oeuvre -rock", motsOeuvre);
		Assumptions.assumeTrue(requetteOeuvre!=null);
		motsMusique.add(tripletMusique);
		motsMusique.add(tripletRockPlus);
		requetteMusique = new RequetteMot("musique +rock", motsMusique);
		Assumptions.assumeTrue(requetteMusique!=null);
	}
	
	@Test
	void testGetNom() {
		Assertions.assertEquals("oeuvre -rock", requetteOeuvre.getNom());
		Assertions.assertEquals("musique +rock", requetteMusique.getNom());
	}
	
	@Test
	void testGetType() {
		Assertions.assertEquals(TypeFichier.TEXTE, requetteOeuvre.getType());
		Assertions.assertEquals(TypeFichier.TEXTE, requetteMusique.getType());
	}
	
	@Test
	void getMots() {
		Assertions.assertEquals(tripletOeuvre, requetteOeuvre.getMots().get(0));
		Assertions.assertEquals(tripletRockMoins, requetteOeuvre.getMots().get(1));
		Assertions.assertEquals(tripletMusique, requetteMusique.getMots().get(0));
		Assertions.assertEquals(tripletRockPlus, requetteMusique.getMots().get(1));
	}
	
	@Test
	void testToString() {
		Assertions.assertEquals("[Requette de type TEXTE (oeuvre -rock) : [(presence de oeuvre 3x)(abscence de rockMoins)] ]", requetteOeuvre.toString());
		Assertions.assertEquals("[Requette de type TEXTE (musique +rock) : [(presence de musique 5x)(presence de rockPlus 3x)] ]", requetteMusique.toString());
	}
}
