/**
 * 
 */
package controleurs;

import static org.junit.Assert.*;
import modeles.Modele;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vues.Vue;

/**
 * @author mathiasrobert
 *
 */
public class ControleurMenuTest {

	private Modele modele;
	private Vue vue;
	private ControleurMenu controleur;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		modele = new Modele();
		vue = new Vue(modele);
		controleur = new ControleurMenu(modele,vue);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testChangementVue() {
		controleur.changementVue();
		assertEquals(vue.getContentPane()==vue.getVueEnJeu(),true);
		assertEquals(vue.getBarreMenu().isVisible(),true);
		assertEquals(vue.getVueMenu().isFocusable(),false);
		assertEquals(vue.isFocusable(),false);
		assertEquals(vue.getVueEnJeu().isFocusable(),true);
		assertEquals(vue.getVueEnJeu().isValid(),true);
	}

}
