package controleurs;

import vues.Vue;
import modeles.Modele;

public class ControleurMenu {
	
	private Modele modele;
	private Vue vue;
	
	public ControleurMenu(Modele modele, Vue vue) {
		this.modele = modele;
		this.vue = vue;
	}
	
	public void changementVue() {
		vue.setContentPane(vue.getVueEnJeu());
		vue.getBarreMenu().setVisible(true);
		vue.getVueMenu().setFocusable(false);
		vue.setFocusable(false);
		vue.getVueEnJeu().setFocusable(true);
		vue.getVueEnJeu().revalidate();
	}
	
	public void quitter() {
		vue.dispose();
	}
	
	public void recommencer() {
		modele.reinitialiser();
	}

}
