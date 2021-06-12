import java.util.ArrayList;
import java.util.Arrays;

public class Texte {
	private ArrayList<String> TexteBase;
	ArrayList<Character> ListeCaracteres = new ArrayList<Character>();

	public Texte() {

	}

	public ArrayList<String> getTexteBase() {
		return TexteBase;
	}

	public void setTexteBase(ArrayList<String> texteBase) {
		TexteBase = texteBase;
	}

	public ArrayList<Character> getListeCaracteres() {
		return ListeCaracteres;
	}

	public int CompteCaractere(char caract) {
		int totalCharacteres = 0;
		char temp;
		for (int k = 0; k < TexteBase.size(); k++) {
			for (int i = 0; i < TexteBase.get(k).length(); i++) {

				temp = TexteBase.get(k).charAt(i);
				if (temp == caract)
					totalCharacteres++;
			}
		}
		return totalCharacteres;
	}

	public void formation_liste() {
		char carac;
		for (int k = 0; k < TexteBase.size(); k++) {
			for (int i = 0; i < TexteBase.get(k).length(); i++) {
				carac = TexteBase.get(k).charAt(i);
				if ((ListeCaracteres.contains(carac)) == false) {
					ListeCaracteres.add(carac);
				}
			}
		}

	}

	public ArrayList<Lettre> statistiques() {
		char carac;
		int nbOcc = 0;
		ArrayList<Lettre> ListeLettres = new ArrayList<Lettre>();
		for (int i = 0; i < ListeCaracteres.size(); i++) {
			carac = ListeCaracteres.get(i);
			Lettre qqlch = new Lettre();
			nbOcc = this.CompteCaractere(carac);
			qqlch.setCaractere(carac);
			qqlch.setNbOccurences(nbOcc);
			ListeLettres.add(qqlch);
		}
		return (ListeLettres);
	}

}
