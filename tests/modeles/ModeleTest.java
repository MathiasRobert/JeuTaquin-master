/**
 * 
 */
package modeles;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mathiasrobert
 *
 */
public class ModeleTest {
	private Modele modele;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		modele = new Modele();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testReinitialiser() {
		modele.setNbDeCoups(5);
		modele.reinitialiser();
		assertEquals(modele.getNbDeCoups(),0);
	}

}
