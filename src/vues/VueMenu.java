/**
 * 
 */
package vues;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controleurs.ControleurMenu;

/**
 * @author matrobert
 *
 */
public class VueMenu extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2734690958736171821L;
	private JButton jouer;
	private JButton quitter;
	private JLabel titre;
	private ControleurMenu controleurMenu;
	
	public VueMenu() {
		setLayout(null);
		
		titre = new JLabel("Jeu du taquin");
		titre.setFont(new Font("Verdana", Font.BOLD, 100));
		titre.setBounds(100, 100, 900, 300);
		add(titre);
		
		initBoutons();
	}
	
	/**
	 * @return the jouer
	 */
	public JButton getJouer() {
		return jouer;
	}

	/**
	 * @return the quitter
	 */
	public JButton getQuitter() {
		return quitter;
	}

	/**
	 * @param controleurMenu the controleurMenu to set
	 */
	public void setControleurMenu(ControleurMenu controleurMenu) {
		this.controleurMenu = controleurMenu;
	}

	private void initBoutons() {
		jouer = new JButton("Jouer");
		jouer.setBounds(350, 450, 100, 50);
		jouer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controleurMenu.changementVue();
			}
		});
		add(jouer);

		quitter = new JButton("Quitter");
		quitter.setBounds(500, 450, 100, 50);
		quitter.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controleurMenu.quitter();
			}
		});
		add(quitter);	
	}
}
