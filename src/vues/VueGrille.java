package vues;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import modeles.Constantes;
import modeles.Grille;
import modeles.Jeton;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class VueGrille extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 399659093994244734L;
	Grille grille;

	public VueGrille(Grille grille) {
		this.grille = grille;
	}

	public void paint(Graphics g) {
		super.paint(g);
		for (Jeton box : grille.getListeGrille()) {
			g.setColor(box.getColor());
			g.fillRect(box.getX() + 1, box.getY() + 1, box.getLargeur() - 2,
					box.getHauteur() - 2);
			g.setColor(Color.black);
			g.drawLine(box.getX(), box.getY(), box.getX()
					+ Constantes.CASE_EN_PIXELS, box.getY());
			g.drawLine(box.getX(), box.getY(), box.getX(), box.getY()
					+ Constantes.CASE_EN_PIXELS);
			g.drawLine(box.getX() + Constantes.CASE_EN_PIXELS, box.getY()
					+ Constantes.CASE_EN_PIXELS, box.getX()
					+ Constantes.CASE_EN_PIXELS, box.getY());
			g.drawLine(box.getX() + Constantes.CASE_EN_PIXELS, box.getY()
					+ Constantes.CASE_EN_PIXELS, box.getX(), box.getY()
					+ Constantes.CASE_EN_PIXELS);
			g.drawString(Integer.toString(box.getNumero()), box.getX()
					+ Constantes.CASE_EN_PIXELS / 2, box.getY()
					+ Constantes.CASE_EN_PIXELS / 2);
		}
		g.drawLine(grille.getCaseVide().getX(), grille.getCaseVide().getY(),
				grille.getCaseVide().getX() + Constantes.CASE_EN_PIXELS, grille
						.getCaseVide().getY());
		g.drawLine(grille.getCaseVide().getX(), grille.getCaseVide().getY(),
				grille.getCaseVide().getX(), grille.getCaseVide().getY()
						+ Constantes.CASE_EN_PIXELS);
		g.drawLine(grille.getCaseVide().getX() + Constantes.CASE_EN_PIXELS,
				grille.getCaseVide().getY() + Constantes.CASE_EN_PIXELS, grille
						.getCaseVide().getX() + Constantes.CASE_EN_PIXELS,
				grille.getCaseVide().getY());
		g.drawLine(grille.getCaseVide().getX() + Constantes.CASE_EN_PIXELS,
				grille.getCaseVide().getY() + Constantes.CASE_EN_PIXELS, grille
						.getCaseVide().getX(), grille.getCaseVide().getY()
						+ Constantes.CASE_EN_PIXELS);
	}
}
