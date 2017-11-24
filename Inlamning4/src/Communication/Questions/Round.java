package Communication.Questions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Round implements Serializable{

	private static final long serialVersionUID = 2059232265937406891L;
	private Questions Q1;
	private Questions Q2;
	private String question;
	private String rightAns;
	private String wrongAns1;
	private String wrongAns2;
	private String wrongAns3;
	private String wrongAns4;
	
	
	private QuestionsDatabase QDB = new QuestionsDatabase();
	private LinkedList<Questions> ChosenCategory;
	
	
	public Round(String category) // h�r kommer actionPerformed knappen in n�r anv�ndaren trycker p� Mat
	{
		if(category.equals("Mat")) {
			ChosenCategory = QDB.getMat(); // ger en lista av alla Mat fr�gor
		
		Collections.shuffle(ChosenCategory);
		Q1 = ChosenCategory.get(0); // Ger f�rsta set med fr�gan och svaren i Matkategorin
		// F� ut fr�gan fr�n ChosenCategory
		category = Q1.getCategory();
		question = Q1.getQuestion();  // Kanske beh�ver dessa delar flyttas till Match
		for(int i =2; i<ChosenCategory.size()-1; i++) // Shufflar alla answers som ska l�ggas ut p� knappar
		   Collections.shuffle(ChosenCategory);
		rightAns = Q1.getCorAnswer();
		Q2 = ChosenCategory.get(1); // Ger andra set med fr�gan och svaren i Matkategorin
		question = Q2.getQuestion();
		for(int i =2; i<ChosenCategory.size()-1; i++) // Shufflar alla answers som ska l�ggas ut p� knappar
			   Collections.shuffle(ChosenCategory);
		}
		
		else if(category.equals("Film")) {
			ChosenCategory = QDB.getFilm();
		Collections.shuffle(ChosenCategory);
		Q1 = ChosenCategory.get(0);
		Q2 = ChosenCategory.get(1);
		}
		
		else if(category.equals("Teknik")) {
			ChosenCategory = QDB.getTeknik();
		Collections.shuffle(ChosenCategory);
		Q1 = ChosenCategory.get(0);
		Q2 = ChosenCategory.get(1);
		}
		else if(category.equals("Geografi")) {
			ChosenCategory = QDB.getGeografi();
		Collections.shuffle(ChosenCategory);
		Q1 = ChosenCategory.get(0);
		Q2 = ChosenCategory.get(1);
		}
		else if(category.equals("Historia")) {
			ChosenCategory = QDB.getHistoria();
		Collections.shuffle(ChosenCategory);
		Q1 = ChosenCategory.get(0);
		Q2 = ChosenCategory.get(1);
		}	
	
	}
	
	// Skapa en metod som ger fr�gan fr�n kategorin
	// skapa en metod som ger alla svaren fr�n kategorin
	// skapa en metod som ger gr�n f�rg p� knapp om r�tt svar valts eller r�d f�rg om fel svar valts
	
}
