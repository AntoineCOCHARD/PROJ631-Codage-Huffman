import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;



public class EcritureInfos {
	
	private String fileName;
	
	public EcritureInfos(String fileName) {
		this.fileName = fileName;
	}
	
	public void ecritureFreq(PriorityQueue<HuffmanNode> q) {

		// Get the file name without the extension
		String fName = this.fileName.substring(0, this.fileName.length() - 4);

		int size = q.size();

		try {
			// Create a new file with an added name
			FileWriter file = new FileWriter(fName + "_freq.txt");

			file.write(size + "\n");
			while (q.size() > 0) {
				// Take the Node with the lowest frequency and lowest Ascii value if there are
				// multiple nodes with the same frequency
				HuffmanNode n = q.poll();
				// Write its infos in the file
				file.write("" + n.getChar() + " " + n.getFrequence() + "\n");
			}
			


			file.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	
}
