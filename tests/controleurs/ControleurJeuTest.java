/**
 * 
 */
package controleurs;

import static org.junit.Assert.*;

import java.awt.event.MouseEvent;

import modeles.Constantes;
import modeles.Constantes.Direction;
import modeles.Modele;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import vues.VueEnJeu;

/**
 * @author mathiasrobert
 *
 */
public class ControleurJeuTest {

	Modele modele;
	VueEnJeu vueEnJeu;
	ControleurJeu controleur;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		modele = new Modele();
		vueEnJeu = new VueEnJeu(modele);
		controleur = new ControleurJeu(modele,vueEnJeu);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testDeplacementPossible() {
		assertEquals(controleur.deplacementPossible(Direction.GAUCHE),true);
		assertEquals(controleur.deplacementPossible(Direction.HAUT),true);
		assertEquals(controleur.deplacementPossible(Direction.BAS),false);
		assertEquals(controleur.deplacementPossible(Direction.DROITE),false);
	}
	
	@Test
	public void testDeplacement() {
		int nbCoups = modele.getNbDeCoups();
		controleur.deplacement(Direction.GAUCHE);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),2);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),3);
		assertEquals(modele.getNbDeCoups()==nbCoups+1,true);
		
		controleur.deplacement(Direction.HAUT);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),2);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),2);
		assertEquals(modele.getNbDeCoups()==nbCoups+2,true);
		
		controleur.deplacement(Direction.DROITE);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),3);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),2);
		assertEquals(modele.getNbDeCoups()==nbCoups+3,true);
		
		controleur.deplacement(Direction.DROITE);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),3);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),2);
		assertEquals(modele.getNbDeCoups()==nbCoups+4,false);
		
		controleur.deplacement(Direction.BAS);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),3);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),3);
		assertEquals(modele.getNbDeCoups()==nbCoups+4,true);
	}
	
	@Test
	public void testDeplacementSouris() {
		MouseEvent e = new MouseEvent(vueEnJeu, 0, 0, 0, 0, 0, 0, false);
		e.translatePoint(2*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_X_VUEGRILLE, 3*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_Y_VUEGRILLE);
		int nbCoups = modele.getNbDeCoups();
		controleur.deplacement(e);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),2);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),3);
		assertEquals(modele.getNbDeCoups()==nbCoups+1,true);
		
		e = new MouseEvent(vueEnJeu, 0, 0, 0, 0, 0, 0, false);
		e.translatePoint(2*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_X_VUEGRILLE, 2*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_Y_VUEGRILLE);
		controleur.deplacement(e);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),2);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),2);
		assertEquals(modele.getNbDeCoups()==nbCoups+2,true);
		
		e = new MouseEvent(vueEnJeu, 0, 0, 0, 0, 0, 0, false);
		e.translatePoint(3*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_X_VUEGRILLE, 2*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_Y_VUEGRILLE);
		controleur.deplacement(e);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),3);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),2);
		assertEquals(modele.getNbDeCoups()==nbCoups+3,true);
		
		e = new MouseEvent(vueEnJeu, 0, 0, 0, 0, 0, 0, false);
		e.translatePoint(4*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_X_VUEGRILLE, 2*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_Y_VUEGRILLE);
		controleur.deplacement(e);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),3);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),2);
		assertEquals(modele.getNbDeCoups()==nbCoups+4,false);
		
		e = new MouseEvent(vueEnJeu, 0, 0, 0, 0, 0, 0, false);
		e.translatePoint(3*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_X_VUEGRILLE, 3*Constantes.CASE_EN_PIXELS+1+Constantes.POSITION_Y_VUEGRILLE);
		controleur.deplacement(e);
		assertEquals(modele.getGrille().getCaseVide().getIndiceX(),3);
		assertEquals(modele.getGrille().getCaseVide().getIndiceY(),3);
		assertEquals(modele.getNbDeCoups()==nbCoups+4,true);
	}

}
