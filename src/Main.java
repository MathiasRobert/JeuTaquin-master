import controleurs.*;
import vues.*;
import modeles.*;

/**
 * 
 */

/**
 * @author mathiasrobert
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Modele modele = new Modele();
		Vue vue = new Vue(modele);
		Controleur controleur =  new Controleur(modele, vue);
		vue.addControleur(controleur);
	}
}
