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
	
	
	public Round(String category) 
	{
		if(category.equals("Mat")) {
			ChosenCategory = QDB.getMat(); 
		
		Collections.shuffle(ChosenCategory);
		Q1 = ChosenCategory.get(0); 
		Q2 = ChosenCategory.get(1); 
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
	
		
}
