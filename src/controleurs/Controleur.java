package controleurs;

import vues.Vue;
import modeles.Modele;

public class Controleur {
	
	private ControleurMenu controleurMenu;
	private ControleurJeu controleurJeu;
	
	public Controleur(Modele modele, Vue vue) {
		controleurMenu = new ControleurMenu(modele, vue);
		controleurJeu = new ControleurJeu(modele, vue.getVueEnJeu());
	}
	
	/**
	 * @return the controleurMenu
	 */
	public ControleurMenu getControleurMenu() {
		return controleurMenu;
	}
	/**
	 * @return the controleurJeu
	 */
	public ControleurJeu getControleurJeu() {
		return controleurJeu;
	}

}
