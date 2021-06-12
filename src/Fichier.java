import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Fichier {
	private String fPath;

	public Fichier(String fName) {
		this.fPath = fName;
	}

	public ArrayList<String> LectureFichier() {
		ArrayList<String> texts = new ArrayList<String>();
		File myFile = new File(this.fPath);

		try {
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				texts.add(data);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return texts;
	}

}
