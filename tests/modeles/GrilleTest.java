/**
 * 
 */
package modeles;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author mathiasrobert
 *
 */
public class GrilleTest {
	private Grille grille;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		grille = new Grille();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConstructeurGrille() {
		ArrayList<Jeton> listeGrille = grille.getListeGrille();
		for (Jeton j : listeGrille) {
			for(Jeton j2 : listeGrille) {
				if(j != j2) {
					assertEquals(j.getNumero()==j2.getNumero(),false);
					if(j.getIndiceX() == j2.getIndiceX()) {
						assertEquals(j.getIndiceY()==j2.getIndiceY(),false);
					}
				}
			}
		}
		assertEquals(grille.getCaseVide().getIndiceX(),3);
		assertEquals(grille.getCaseVide().getIndiceY(),3);
	}
	
	@Test
	public void testReinitialiser() {
		grille.getCaseVide().setIndiceX(2);
		grille.getCaseVide().setIndiceY(0);
		grille.reinitialiser();
		ArrayList<Jeton> listeGrille = grille.getListeGrille();
		for (Jeton j : listeGrille) {
			for(Jeton j2 : listeGrille) {
				if(j != j2) {
					assertEquals(j.getNumero()==j2.getNumero(),false);
					if(j.getIndiceX() == j2.getIndiceX()) {
						assertEquals(j.getIndiceY()==j2.getIndiceY(),false);
					}
				}
			}
		}
		assertEquals(grille.getCaseVide().getIndiceX(),3);
		assertEquals(grille.getCaseVide().getIndiceY(),3);
	}

}
