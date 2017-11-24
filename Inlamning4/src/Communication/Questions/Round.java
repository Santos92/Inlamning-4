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
	
	
	public Round(String category) // här kommer actionPerformed knappen in när användaren trycker på Mat
	{
		if(category.equals("Mat")) {
			ChosenCategory = QDB.getMat(); // ger en lista av alla Mat frågor
		
		Collections.shuffle(ChosenCategory);
		Q1 = ChosenCategory.get(0); // Ger första set med frågan och svaren i Matkategorin
		// Få ut frågan från ChosenCategory
		category = Q1.getCategory();
		question = Q1.getQuestion();  // Kanske behöver dessa delar flyttas till Match
		for(int i =2; i<ChosenCategory.size()-1; i++) // Shufflar alla answers som ska läggas ut på knappar
		   Collections.shuffle(ChosenCategory);
		rightAns = Q1.getCorAnswer();
		Q2 = ChosenCategory.get(1); // Ger andra set med frågan och svaren i Matkategorin
		question = Q2.getQuestion();
		for(int i =2; i<ChosenCategory.size()-1; i++) // Shufflar alla answers som ska läggas ut på knappar
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
	
	// Skapa en metod som ger frågan från kategorin
	// skapa en metod som ger alla svaren från kategorin
	// skapa en metod som ger grön färg på knapp om rätt svar valts eller röd färg om fel svar valts
	
}
