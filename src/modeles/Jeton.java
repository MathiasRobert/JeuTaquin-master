package modeles;

import java.awt.Color;
import java.awt.Rectangle;

public class Jeton extends Case {

	private int numero;
	private Color color;
	private boolean bienPlace;

	public Jeton(int indiceX, int indiceY, int numero) {
		super(indiceX, indiceY);
		this.numero = numero;
		this.color = new Color(255, 102, 102);
	}

	public int getNumero() {
		return numero;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public boolean isBienPlace() {
		return bienPlace;
	}

	public void verifPlacement() {
		int col = 0, ligne = 0;
		int tmp = this.numero % Constantes.NBRE_DE_COLONNES;
		if (tmp > 0)
			col = tmp - 1;
		else if (tmp == 0)
			col = Constantes.NBRE_DE_COLONNES - 1;

		double tmp2 = (double) this.numero
				/ (double) Constantes.NBRE_DE_COLONNES;
		ligne = (int) Math.ceil(tmp2) - 1;

		if (ligne == this.indiceY && col == this.indiceX)
			bienPlace = true;
		else
			bienPlace = false;
	}

	public void majCouleur() {
		if (bienPlace)
			this.color = new Color(102, 204, 0);
		else
			this.color = new Color(255, 102, 102);
	}
	
	public Rectangle getRectJeton() {
		return new Rectangle(getX(), getY(),getLargeur(),getHauteur());
	}

}
