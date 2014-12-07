package vues;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import controleurs.ControleurJeu;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class Click extends MouseInputAdapter {
	ControleurJeu controleurJeu;

	public Click(ControleurJeu controleurJeu) {
		this.controleurJeu = controleurJeu;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		controleurJeu.deplacement(e);
	}
}
