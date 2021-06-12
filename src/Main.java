import java.util.ArrayList;
import java.util.PriorityQueue;

public class Main {
	

	public static void main(String[] args){
		
		String nomFichier = "extraitalice";
		
		
		Texte tex = new Texte();
		Fichier fich = new Fichier(nomFichier+".txt");
		tex.setTexteBase(fich.LectureFichier());
		tex.formation_liste();
		ArrayList<Lettre> ListeLettres = tex.statistiques();
		char[] charArray = new char[ListeLettres.size()];
        int[] charFreq = new int[ListeLettres.size()];
		for (int i = 0; i < ListeLettres.size(); i++) {
			charArray[i]=(ListeLettres.get(i).getCaractere());
			charFreq[i]=(ListeLettres.get(i).getNbOccurences());
		}
		PriorityQueue<HuffmanNode> q = Huffman.Codage(charArray, charFreq);
		Reecriture reecr = new Reecriture(nomFichier+".txt",Huffman.getHashTable());
		String test = reecr.makeString();
		reecr.write(test);
		EcritureInfos ecrInf = new EcritureInfos(nomFichier+".txt");
		ecrInf.ecritureFreq(q);
		TauxCompression taux = new TauxCompression(nomFichier+".txt");
		System.out.println("Taux de compression "+ taux.calculTaux(nomFichier+".txt",nomFichier+"_comp.bin"));
		
	}
}
