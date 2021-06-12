import java.io.File;

public class TauxCompression {

	private String fileName;

	public TauxCompression(String fileName) {
		this.fileName = fileName;
	}

	public float calculTaux(String txt, String bin) {

		float volInitial = (new File(txt)).length();
		
		float volFinal = (new File(bin)).length();

		float taux = 1 - (volFinal / volInitial);

		return taux;

	}

}
