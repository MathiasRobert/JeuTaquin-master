package controleurs;

import java.awt.event.MouseEvent;

import vues.VueEnJeu;

import modeles.Constantes;
import modeles.Grille;
import modeles.Jeton;
import modeles.Modele;

public class ControleurJeu {
	Modele modele;
	VueEnJeu vueEnJeu;
	
	public ControleurJeu(Modele modele, VueEnJeu vueEnJeu){
		this.modele = modele;
		this.vueEnJeu = vueEnJeu;
	}
	
	public void deplacement(Constantes.Direction direction) {
		int tmpX, tmpY;
		boolean mouvFait = false;
		Grille grille = modele.getGrille();
		tmpX = grille.getCaseVide().getIndiceX();
		tmpY = grille.getCaseVide().getIndiceY();
		if (deplacementPossible(direction)) {
			for (Jeton box : grille.getListeGrille()) {
				switch (direction) {
				case GAUCHE:
					if (box.getIndiceX() == tmpX - 1
							&& box.getIndiceY() == tmpY) {
						grille.getCaseVide().setIndiceX(box.getIndiceX());
						box.setIndiceX(tmpX);
						mouvFait = true;
					}
					break;
				case DROITE:
					if (box.getIndiceX() == tmpX + 1
							&& box.getIndiceY() == tmpY) {
						grille.getCaseVide().setIndiceX(box.getIndiceX());
						box.setIndiceX(tmpX);
						mouvFait = true;
					}
					break;
				case HAUT:
					if (box.getIndiceY() == tmpY - 1
							&& box.getIndiceX() == tmpX) {
						grille.getCaseVide().setIndiceY(box.getIndiceY());
						box.setIndiceY(tmpY);
						mouvFait = true;
					}
					break;
				case BAS:
					if (box.getIndiceY() == tmpY + 1
							&& box.getIndiceX() == tmpX) {
						grille.getCaseVide().setIndiceY(box.getIndiceY());
						box.setIndiceY(tmpY);
						mouvFait = true;
					}
					break;
				}
				if (mouvFait) {
					box.verifPlacement();
					box.majCouleur();
					modele.setNbDeCoups(modele.getNbDeCoups()+1);
					modele.notifierVue();
					break;
				}
			}
		}
	}
	
	public boolean deplacementPossible(Constantes.Direction direction) {
		if (modele.getGrille().getCaseVide().getIndiceX() == Constantes.NBRE_DE_COLONNES - 1
				&& direction == Constantes.Direction.DROITE)
			return false;
		else if (modele.getGrille().getCaseVide().getIndiceX() == 0 && direction == Constantes.Direction.GAUCHE)
			return false;
		else if (modele.getGrille().getCaseVide().getIndiceY() == Constantes.NBRE_DE_LIGNES - 1
				&& direction == Constantes.Direction.BAS)
			return false;
		else if (modele.getGrille().getCaseVide().getIndiceY() == 0 && direction == Constantes.Direction.HAUT)
			return false;
		return true;
	}
	
	public void deplacement(MouseEvent e){
		int caseVideX, caseVideY;
		Constantes.Direction direction = Constantes.Direction.GAUCHE;
		boolean depPossible = false;
		caseVideX = modele.getGrille().getCaseVide().getIndiceX();
		caseVideY = modele.getGrille().getCaseVide().getIndiceY();

		for (Jeton box : modele.getGrille().getListeGrille()) {
			if (box.getRectJeton().contains(
					e.getX() - Constantes.POSITION_X_VUEGRILLE,
					e.getY() - Constantes.POSITION_Y_VUEGRILLE)) {
				if (box.getIndiceX() == caseVideX - 1
						&& box.getIndiceY() == caseVideY) {
					direction = Constantes.Direction.GAUCHE;
					depPossible = true;
				}
				else if (box.getIndiceX() == caseVideX + 1
						&& box.getIndiceY() == caseVideY) {
					direction = Constantes.Direction.DROITE;
					depPossible = true;
				}
				else if (box.getIndiceX() == caseVideX
						&& box.getIndiceY() == caseVideY - 1) {
					direction = Constantes.Direction.HAUT;
					depPossible = true;
				}
				else if (box.getIndiceX() == caseVideX
						&& box.getIndiceY() == caseVideY + 1) {
					direction = Constantes.Direction.BAS;
					depPossible = true;
				}
				if (depPossible) {
					deplacement(direction);
				}
				break;
			}
		}
	}
	
	public void ajoutLigne() {
		if (Constantes.NBRE_DE_LIGNES < Constantes.NBRE_DE_LIGNES_MAX) {
			Constantes.NBRE_DE_LIGNES++;
			modele.reinitialiser();
			vueEnJeu.reinitialiserBoutons();
		}
	}
	
	public void suppLigne() {
		if (Constantes.NBRE_DE_LIGNES > Constantes.NBRE_DE_LIGNES_MIN) {
			Constantes.NBRE_DE_LIGNES--;
			modele.reinitialiser();
			vueEnJeu.reinitialiserBoutons();
		}
	}
	
	public void ajoutColonne() {
		if (Constantes.NBRE_DE_COLONNES < Constantes.NBRE_DE_COLONNES_MAX) {
			Constantes.NBRE_DE_COLONNES++;
			modele.reinitialiser();
			vueEnJeu.reinitialiserBoutons();
		}
	}

	public void suppColonne() {
		if (Constantes.NBRE_DE_COLONNES > Constantes.NBRE_DE_COLONNES_MIN) {
			Constantes.NBRE_DE_COLONNES--;
			modele.reinitialiser();
			vueEnJeu.reinitialiserBoutons();
		}
	}
	
}
