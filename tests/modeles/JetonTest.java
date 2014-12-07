package modeles;

import static org.junit.Assert.*;

import java.awt.Color;
import java.awt.Rectangle;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mathiasrobert
 *
 */
public class JetonTest {
	private Jeton j;
	private Jeton p;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		j = new Jeton(0, 0, 1);
		p = new Jeton(2, 2, 1);
		j.verifPlacement();
		p.verifPlacement();
		j.majCouleur();
		p.majCouleur();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testVerifPlacement() {
		assertEquals(j.isBienPlace(),true);
		assertEquals(p.isBienPlace(),false);
	}
	
	@Test
	public void testMajCouleur() {
		assertEquals(j.getColor(),new Color(102, 204, 0));
		assertEquals(p.getColor(),new Color(255, 102, 102));
	}

	@Test
	public void testGetRectJeton() {
		assertEquals(j.getRectJeton(), new Rectangle(0,0,100,100));
		assertEquals(p.getRectJeton(), new Rectangle(200,200,100,100));
	}
}
