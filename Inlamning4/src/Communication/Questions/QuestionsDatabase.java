package Communication.Questions;

import java.awt.List;
import java.util.ArrayList;

public class QuestionsDatabase {

	private ArrayList<Questions> Mat = new ArrayList<>();
	private ArrayList<Questions> Film = new ArrayList<>();
	private ArrayList<Questions> Teknik = new ArrayList<>();
	private ArrayList<Questions> Geografi = new ArrayList<>();
	private ArrayList<Questions> Historia = new ArrayList<>();
	
	
	Questions Mat1 = new Questions("Mat", "What is an apple?", "A fruit", "A car", "An animal", "A toy");
	Questions Teknik1 = new Questions("Teknik", "Vad förknippas med märket Airfix?", "Flygplansmodeller","Bilmodeller", "Båtar", "Lastbilar" );
	Questions Film1 = new Questions("Film", "Vem spelade huvudrollen i 'I am Legend' ?", "Will Smith", "Denzel Washington", "Jamie Fox", "Samuel Jackson");

	QuestionsDatabase(){
		Mat.add(Mat1);
		Teknik.add(Teknik1);
		Film.add(Film1);
	}
    


}
