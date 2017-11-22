package Communication.Questions;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;


public class QuestionsDatabase {

	 //ArrayList<ArrayList<Questions>> categories = new ArrayList<ArrayList<Questions>>();
	    private ArrayList<Questions> Mat = new ArrayList<>();
		private ArrayList<Questions> Film = new ArrayList<>();
		private ArrayList<Questions> Teknik = new ArrayList<>();
		private ArrayList<Questions> Geografi = new ArrayList<>();
		private ArrayList<Questions> Historia = new ArrayList<>();
		
	
		public QuestionsDatabase(){
			fillMat();
			fillTeknik();
			fillFilm();
			fillGeografi();
			fillHistoria();
		}
	    public void fillMat()
	    {
	    	Questions MatQ;
	    	String Kategori = "Mat";
	    	MatQ = new Questions(Kategori, "Vad är en durian?", "En frukt", "En smörgås", "En sås", "En dryck");
	    	Mat.add(MatQ);
	    	MatQ = new Questions(Kategori, "Vad är inte en ingrediens i den Östafrikanska såsen 'Kachumbari'?", "baobabpulver", "tomater", "cilantro", "chilli");
	    	Mat.add(MatQ);
	    }
	    public void fillFilm()
	    {
	    	Questions FilmQ;
	    	String Kategori = "Film";
	    	FilmQ = new Questions(Kategori, "Vem spelade huvudrollen i 'I am Legend' ?", "Will Smith", "Denzel Washington", "Jamie Fox", "Samuel Jackson");
	    	Film.add(FilmQ);
	    	FilmQ = new Questions(Kategori, "Vem spelade rollen som mamma till Phiona i filmen 'Queen of Katwe' ?", "Lupita Nyong'o", "Esteri Tebandeke", "Viola Davis", "Danai Gurira");
	    	Film.add(FilmQ);
	    }
	    public void fillTeknik()
	    {
	    	Questions TeknikQ;
	    	String Kategori = "Teknik";
	    	TeknikQ = new Questions(Kategori, "Vad förknippas med märket Airfix?", "Flygplansmodeller","Bilmodeller", "Båtar", "Lastbilar" );
	    	Teknik.add(TeknikQ);
	    	TeknikQ = new Questions(Kategori, "Vem uppfann den populära leksaken Fidget Spinner?", "Catherine Hettinger","Joseph Fry", "Cai Lun", "Ray Tomlinson" );
	    	Teknik.add(TeknikQ);
	    }
	    public void fillGeografi()
	    {
	    	Questions GeoQ;
	    	String Kategori = "Geografi";
	    	GeoQ = new Questions(Kategori, "Var ligger landet Djibouti?", "ÖstAfrika","Mellanöstern", "Sydost asien", "Brevid Salomonöarna" );
	    	Teknik.add(GeoQ);
	    	GeoQ = new Questions(Kategori, "Vad är omkretsen runt jorden längs ekvatorn?", "40075 km","400000km", "35000km", "25900km" );
	    	Teknik.add(GeoQ);
	    }
	    public void fillHistoria()
	    {
	    	Questions HistoriaQ;
	    	String Kategori = "Historia";
	    	HistoriaQ = new Questions(Kategori, "När formades det Osmanska riket?", "1300 talet","1400 talet", "1500 talet", "1200 talet" );
	    	Teknik.add(HistoriaQ);
	    	HistoriaQ = new Questions(Kategori, "Vad anses vara den Gustavianska tiden?", "1772–1809","1603-1771", "1890-1902", "1656-1772" );
	    	Teknik.add(HistoriaQ);
	    }
	    
	  	    
	    public void fillQuestionDatabase() {
	    	
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
		
		

		// Testing how to get elements in the arraylists from main
		

}
