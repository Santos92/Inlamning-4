package Communication.Questions;
import java.util.ArrayList;

public class QuestionsDatabase {

	private ArrayList<Questions> Mat = new ArrayList<>();
	private ArrayList<Questions> Film = new ArrayList<>();
	private ArrayList<Questions> Teknik = new ArrayList<>();
	private ArrayList<Questions> Geografi = new ArrayList<>();
	private ArrayList<Questions> Historia = new ArrayList<>();
	
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
	public ArrayList<Questions> getMat() {
		return Mat;
	}
	public ArrayList<Questions> getFilm() {
		return Film;
	}
	public ArrayList<Questions> getTeknik() {
		return Teknik;
	}
	public ArrayList<Questions> getGeografi() {
		return Geografi;
	}
	public ArrayList<Questions> getHistoria() {
		return Historia;
	}
}
