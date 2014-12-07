package modeles;

import java.util.Observable;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class Modele extends Observable{
	Grille grille;
	int nbDeCoups;
	
	public Modele() {
		grille = new Grille();
		nbDeCoups = 0;
	}
	
	public void reinitialiser() {
		grille.reinitialiser();
		nbDeCoups = 0;
		notifierVue();
	}
	
	public void notifierVue() {
		setChanged();
		notifyObservers();
	}

	public Grille getGrille() {
		return grille;
	}

	public int getNbDeCoups() {
		return nbDeCoups;
	}

	/**
	 * @param nbDeCoups the nbDeCoups to set
	 */
	public void setNbDeCoups(int nbDeCoups) {
		this.nbDeCoups = nbDeCoups;
	}

}
