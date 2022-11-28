package modele;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ConnexionTest {
	static Connexion classeConnexion = new Connexion();

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Assumptions.assumeTrue(classeConnexion!=null, "Expected : True , Actual : "+(classeConnexion!=null));
	}

	@BeforeEach
	void setUp() throws Exception {
		classeConnexion.deconnexion();
	}

	@Test
	void testIsConnected() {
		Assertions.assertFalse(classeConnexion.isConnected(), "Expected : False , Actual : "+classeConnexion.isConnected());
	}
	
	@Test
	void testConnexion() {
		classeConnexion.connexion("Admin");
		Assertions.assertTrue(classeConnexion.isConnected(), "Expected : True , Actual : "+classeConnexion.isConnected());
	}
	
	@Test
	void testDeconnexion() {
		classeConnexion.connexion("Admin");
		Assertions.assertTrue(classeConnexion.isConnected(), "Expected : True , Actual : "+classeConnexion.isConnected());
		classeConnexion.deconnexion();
		Assertions.assertFalse(classeConnexion.isConnected(), "Expected : False , Actual : "+classeConnexion.isConnected());
	}

}
