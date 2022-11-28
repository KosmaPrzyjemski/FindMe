package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ParrametreIndexationTest {
	static ParrametreIndexation indexation = ParrametreIndexation.getInstance();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(indexation!=null);
	}

	@BeforeEach
	void setUp() throws Exception {
		indexation.miseAJour();
	}

	@Test
	void testTexteAJour() {
		Assertions.assertTrue(indexation.TexteAJour());
	}
	
	@Test
	void testImageAJour() {
		Assertions.assertTrue(indexation.ImageAJour());
	}
	
	@Test
	void testAudioAJour() {
		Assertions.assertTrue(indexation.AudioAJour());
	}
	
	@Test
	void testGetParrametreIndexationImage() {
		Assertions.assertEquals(4, indexation.getParrametreIndexationImage());
	}
	
	@Test
	void testGetParrametreIndexationTexte() {
		Assertions.assertEquals(50, indexation.getParrametreIndexationTexte());
	}
	
	@Test
	void testGetParrametreIndexationAudio() {
		Assertions.assertEquals(15, indexation.getParrametreIndexationAudio());
	}
	
	@Test
	void testSetParrametreIndexationImage() {
		indexation.setParrametreIndexationImage(7);
		Assertions.assertEquals(7, indexation.getParrametreIndexationImage());
	}
	
	@Test
	void testSetParrametreIndexationTexte() {
		indexation.setParrametreIndexationTexte(200);
		Assertions.assertEquals(200, indexation.getParrametreIndexationTexte());
	}
	
	@Test
	void testSetParrametreIndexationAudio() {
		indexation.setParrametreIndexationAudio(50);
		Assertions.assertEquals(50, indexation.getParrametreIndexationAudio());
	}
	
	@Test
	void testMiseAJour() {
		indexation.setParrametreIndexationImage(2);
		indexation.setParrametreIndexationTexte(20);
		indexation.setParrametreIndexationAudio(17);
		Assertions.assertFalse(indexation.ImageAJour());
		Assertions.assertFalse(indexation.TexteAJour());
		Assertions.assertFalse(indexation.AudioAJour());
		indexation.miseAJour();
		Assertions.assertTrue(indexation.ImageAJour());
		Assertions.assertTrue(indexation.TexteAJour());
		Assertions.assertTrue(indexation.AudioAJour());
	}

}
