package vues;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controleurs.Controleur;
import modeles.Modele;

/**
 * 
 */

/**
 * @author mathiasrobert
 * 
 */
public class Vue extends JFrame implements Observer {
	/**
	 * 
	 */
	private static final long serialVersionUID = -598600068637201269L;
	Modele modele;
	Controleur controleur;

	VueEnJeu vueEnJeu;
	VueMenu vueMenu;

	private JMenuBar barreMenu;
	private JMenu jeuMenu;
	private JMenuItem nouveauJeuMenu;
	private JMenuItem quitterJeuMenu;

	public Vue(Modele modele) {
		setTitle("Jeu du taquin");
		setSize(1000, 1000);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		this.modele = modele;
		modele.addObserver(this);

		initBarreMenu();

		vueMenu = new VueMenu();
		setContentPane(vueMenu);
		setFocusable(false);
		vueMenu.setFocusable(true);

		vueEnJeu = new VueEnJeu(modele);

		setVisible(true);
	}

	/**
	 * @return the vueEnJeu
	 */
	public VueEnJeu getVueEnJeu() {
		return vueEnJeu;
	}

	/**
	 * @return the vueMenu
	 */
	public VueMenu getVueMenu() {
		return vueMenu;
	}

	/**
	 * @return the barreMenu
	 */
	public JMenuBar getBarreMenu() {
		return barreMenu;
	}

	@Override
	public void update(Observable o, Object arg) {
		vueEnJeu.repaint();
		vueEnJeu.majLabelNbDeCoups();
	}

	public void addControleur(Controleur controleur) {
		this.controleur = controleur;
		vueMenu.setControleurMenu(controleur.getControleurMenu());
		vueEnJeu.setControleurJeu(controleur.getControleurJeu());
		vueEnJeu.addMouseListener(new Click(controleur.getControleurJeu()));
	}

	private void initBarreMenu() {
		barreMenu = new JMenuBar();
		jeuMenu = new JMenu("Jeu");
		nouveauJeuMenu = new JMenuItem("Nouveau");
		quitterJeuMenu = new JMenuItem("Quitter");
		jeuMenu.add(nouveauJeuMenu);
		jeuMenu.add(quitterJeuMenu);
		barreMenu.add(jeuMenu);
		setJMenuBar(barreMenu);
		barreMenu.setVisible(false);
		
		nouveauJeuMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.getControleurMenu().recommencer();
			}
		});
		quitterJeuMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controleur.getControleurMenu().quitter();
			}
		});
	}
}
