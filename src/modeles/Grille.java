package modeles;

import java.util.ArrayList;
import java.util.Collections;

public class Grille{
	private ArrayList<Jeton> listeGrille;
	private Case caseVide;
	private ArrayList<Integer> tabMelange;

	public Grille() {
		this.listeGrille = new ArrayList<Jeton>();
		this.tabMelange = new ArrayList<Integer>();
		initNombreAlea();
		int cpt = 0;
		for (int i = 0; i < Constantes.NBRE_DE_LIGNES; i++) {
			for (int y = 0; y < Constantes.NBRE_DE_COLONNES; y++) {
				if (i == Constantes.NBRE_DE_LIGNES - 1
						&& y == Constantes.NBRE_DE_COLONNES - 1)
					caseVide = new Case(y, i);
				else {
					this.listeGrille.add(new Jeton(y, i, tabMelange.get(cpt)));
					this.listeGrille.get(cpt).verifPlacement();
					this.listeGrille.get(cpt).majCouleur();
				}
				cpt++;
			}
		}
	}
	
	public void reinitialiser() {
		listeGrille.clear();
		tabMelange.clear();
		initNombreAlea();
		int cpt = 0;
		for (int i = 0; i < Constantes.NBRE_DE_LIGNES; i++) {
			for (int y = 0; y < Constantes.NBRE_DE_COLONNES; y++) {
				if (i == Constantes.NBRE_DE_LIGNES - 1
						&& y == Constantes.NBRE_DE_COLONNES - 1)
					caseVide = new Case(y, i);
				else {
					this.listeGrille.add(new Jeton(y, i, tabMelange.get(cpt)));
					this.listeGrille.get(cpt).verifPlacement();
					this.listeGrille.get(cpt).majCouleur();
				}
				cpt++;
			}
		}
	}

	private void initNombreAlea() {
		int Max = Constantes.NBRE_DE_LIGNES * Constantes.NBRE_DE_COLONNES - 1;
		for (int i = 1; i <= Max; i++) {
			tabMelange.add(i);
		}
		Collections.shuffle(tabMelange);
	}

	public Case getCaseVide() {
		return caseVide;
	}

	public ArrayList<Jeton> getListeGrille() {
		return listeGrille;
	}
}
