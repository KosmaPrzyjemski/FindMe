package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class RequetteAudioTest {
	static RequetteAudio requetteJingle = new RequetteAudio("jingle_fi.wav", 30);
	static RequetteAudio requetteCorpus = new RequetteAudio("corpus_fi.wav", 50);

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(requetteJingle!=null);
		Assumptions.assumeTrue(requetteCorpus!=null);
	}

	@Test
	void testGetNom() {
		Assertions.assertEquals("jingle_fi.wav", requetteJingle.getNom());
		Assertions.assertEquals("corpus_fi.wav", requetteCorpus.getNom());
	}
	
	@Test
	void testGetType() {
		Assertions.assertEquals(TypeFichier.AUDIO, requetteJingle.getType());
		Assertions.assertEquals(TypeFichier.AUDIO, requetteCorpus.getType());
	}
	
	@Test
	void testGetTauxSimilarite() {
		Assertions.assertEquals(30, requetteJingle.getTauxSimilarite());
		Assertions.assertEquals(50, requetteCorpus.getTauxSimilarite());
	}
	
	@Test
	void testToString() {
		Assertions.assertEquals("[Requette de type AUDIO (jingle_fi.wav) : fichier avec un taux de 30%]", requetteJingle.toString());
		Assertions.assertEquals("[Requette de type AUDIO (corpus_fi.wav) : fichier avec un taux de 50%]", requetteCorpus.toString());
	}
	
}
