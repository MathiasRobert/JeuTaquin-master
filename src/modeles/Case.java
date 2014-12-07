package modeles;

public class Case {
	protected int indiceX;
	protected int indiceY;

	public Case(int indiceX, int indiceY) {
		this.indiceX = indiceX;
		this.indiceY = indiceY;
	}

	public int getIndiceX() {
		return indiceX;
	}

	public void setIndiceX(int indiceX) {
		this.indiceX = indiceX;
	}

	public int getIndiceY() {
		return indiceY;
	}

	public void setIndiceY(int indiceY) {
		this.indiceY = indiceY;
	}

	public int getX() {
		return indiceX * Constantes.CASE_EN_PIXELS;
	}

	public int getY() {
		return indiceY * Constantes.CASE_EN_PIXELS;
	}

	public int getLargeur() {
		return Constantes.CASE_EN_PIXELS;
	}

	public int getHauteur() {
		return Constantes.CASE_EN_PIXELS;
	}

}
