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
public class CaseTest {
	private Case c;
	private Case p;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		c = new Case(0,0);
		p = new Case(5,3);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetX() {
		assertEquals(c.getX(),0);
		assertEquals(p.getX(),500);
	}
	
	@Test
	public void testGetY() {
		assertEquals(c.getY(),0);
		assertEquals(p.getY(),300);
	}
}
