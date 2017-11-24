package Communication.Questions;

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;


public class QuestionsDatabase {

	 
	    private LinkedList<Questions> Mat = new LinkedList<>();
		private LinkedList<Questions> Film = new LinkedList<>();
		private LinkedList<Questions> Teknik = new LinkedList<>();
		private LinkedList<Questions> Geografi = new LinkedList<>();
		private LinkedList<Questions> Historia = new LinkedList<>();
		private LinkedList<Questions> QDBase = new LinkedList<>(); // Kanske on�digt
		
	
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
	    	MatQ = new Questions(Kategori, "Vad �r en durian?", "En frukt", "En sm�rg�s", "En s�s", "En dryck");
	    	Mat.add(MatQ);
	    	MatQ = new Questions(Kategori, "Vad �r inte en ingrediens i den �stafrikanska s�sen 'Kachumbari'?", "baobabpulver", "tomater", "cilantro", "chilli");
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
	    	TeknikQ = new Questions(Kategori, "Vad f�rknippas med m�rket Airfix?", "Flygplansmodeller","Bilmodeller", "B�tar", "Lastbilar" );
	    	Teknik.add(TeknikQ);
	    	TeknikQ = new Questions(Kategori, "Vem uppfann den popul�ra leksaken Fidget Spinner?", "Catherine Hettinger","Joseph Fry", "Cai Lun", "Ray Tomlinson" );
	    	Teknik.add(TeknikQ);
	    }
	    public void fillGeografi()
	    {
	    	Questions GeoQ;
	    	String Kategori = "Geografi";
	    	GeoQ = new Questions(Kategori, "Var ligger landet Djibouti?", "�stAfrika","Mellan�stern", "Sydost asien", "Brevid Salomon�arna" );
	    	Geografi.add(GeoQ);
	    	GeoQ = new Questions(Kategori, "Vad �r omkretsen runt jorden l�ngs ekvatorn?", "40075 km","400000km", "35000km", "25900km" );
	    	Geografi.add(GeoQ);
	    }
	    public void fillHistoria()
	    {
	    	Questions HistoriaQ;
	    	String Kategori = "Historia";
	    	HistoriaQ = new Questions(Kategori, "N�r formades det Osmanska riket?", "1300 talet","1400 talet", "1500 talet", "1200 talet" );
	    	Historia.add(HistoriaQ);
	    	HistoriaQ = new Questions(Kategori, "Vad anses vara den Gustavianska tiden?", "1772�1809","1603-1771", "1890-1902", "1656-1772" );
	    	Historia.add(HistoriaQ);
	    }
	    
	  	    
	    public void fillQuestionDatabase() { //Kanske on�digt d� Roundklassen har liknande 
	    	QDBase.addAll(Film);
	    	QDBase.addAll(Teknik);
	    	QDBase.addAll(Geografi);
	    	QDBase.addAll(Historia);
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
