package Communication.Questions;
import java.io.Serializable;
import java.util.LinkedList;

public class QuestionsDatabase implements Serializable{

	private static final long serialVersionUID = -5423637154305702606L;
	private LinkedList<Questions> Mat = new LinkedList<>();
	private LinkedList<Questions> Film = new LinkedList<>();
	private LinkedList<Questions> Teknik = new LinkedList<>();
	private LinkedList<Questions> Geografi = new LinkedList<>();
	private LinkedList<Questions> Historia = new LinkedList<>();
	
	public QuestionsDatabase(){
		fillMat();
		fillTeknik();
		fillFilm();
	}
    public void fillMat()
    {
    	Questions MatQ;
    	String Kategori = "Mat";
    	MatQ = new Questions(Kategori, "What is an apple?", "A fruit", "A car", "An animal", "A toy");
    	Mat.add(MatQ);
    	MatQ = new Questions(Kategori, "What is an apple?", "A fruit", "A car", "An animal", "A toy");
    	Mat.add(MatQ);
    	MatQ = new Questions(Kategori, "What is an apple?", "A fruit", "A car", "An animal", "A toy");
    	Mat.add(MatQ);
    }
    public void fillFilm()
    {
    	Questions FilmQ;
    	String Kategori = "Film";
    	FilmQ = new Questions(Kategori, "Vem spelade huvudrollen i 'I am Legend' ?", "Will Smith", "Denzel Washington", "Jamie Fox", "Samuel Jackson");
    	Film.add(FilmQ);
    }
    public void fillTeknik()
    {
    	Questions TeknikQ;
    	String Kategori = "Teknik";
    	TeknikQ = new Questions(Kategori, "Vad förknippas med märket Airfix?", "Flygplansmodeller","Bilmodeller", "Båtar", "Lastbilar" );
    	Teknik.add(TeknikQ);
    }
	public LinkedList<Questions> getMat() {
		return Mat;
	}
	public LinkedList<Questions> getFilm() {
		return Film;
	}
	public LinkedList<Questions> getTeknik() {
		return Teknik;
	}
	public LinkedList<Questions> getGeografi() {
		return Geografi;
	}
	public LinkedList<Questions> getHistoria() {
		return Historia;
	}
}
