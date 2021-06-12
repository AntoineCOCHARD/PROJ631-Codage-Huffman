import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Hashtable;

public class Reecriture {

	private String fileName;
	private Hashtable<String, String> table;

	public Reecriture(String fileName, Hashtable<String, String> table) {
		this.fileName = fileName;
		this.table = table;
	}
	
	
	public void write(String strToWrite) {

		String fName = this.fileName.substring(0, this.fileName.length() - 4);
		// Get the bits that will be written
		BitSet bitsToWrite = this.makeBitSet(strToWrite);

		try {
			// Create a new file with a custom name
			FileOutputStream fos = new FileOutputStream(new File(fName + "_comp.bin"));
			// Write the bits in it
			fos.write(bitsToWrite.toByteArray());
			fos.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
	
	
	public String makeString() {

		String res = "";

		Fichier fReader = new Fichier(this.fileName);
		// Get the text that will be encrypted
		ArrayList<String> data = fReader.LectureFichier();

		for (String s : data) {

			for (char ch : s.toCharArray()) {
				// For every char of the text, get the corresponding binary value and add it to
				// the string
				res += this.table.get(String.valueOf(ch));
			}
		}
		return res;
	}
	
	public BitSet makeBitSet(String str) {
		BitSet bitSet = new BitSet(str.length());
		int bitcounter = 0;
		for (Character c : str.toCharArray()) {
			if (c.equals('1')) {
				bitSet.set(bitcounter);
			}
			bitcounter++;
		}

		return bitSet;
	}
}
