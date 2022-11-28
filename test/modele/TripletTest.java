package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TripletTest {
	static Triplet tripletOeuvre = new Triplet("oeuvre", true, 3);
	static Triplet tripletRock = new Triplet("rock", false, 1);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(tripletOeuvre!=null);
		Assumptions.assumeTrue(tripletRock!=null);
	}
	
	@Test
	void testGetMot() {
		Assertions.assertEquals("oeuvre", tripletOeuvre.getMot());
		Assertions.assertEquals("rock", tripletRock.getMot());
	}
	
	@Test
	void testIsPlus() {
		Assertions.assertTrue(tripletOeuvre.isPlus());
		Assertions.assertFalse(tripletRock.isPlus());
	}
	
	@Test
	void testGetApparition() {
		Assertions.assertEquals(3, tripletOeuvre.getApparition());
		Assertions.assertEquals(1, tripletRock.getApparition());
	}
	
	@Test
	void testToString() {
		System.out.println(tripletOeuvre.toString());
		Assertions.assertEquals("présence de oeuvre 3x", tripletOeuvre.toString());
		Assertions.assertEquals("abscence de rock", tripletRock.toString());
	}

}
