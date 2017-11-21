package Communication.Questions;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

public class Round implements Serializable{

	private static final long serialVersionUID = 2059232265937406891L;
	private Questions Q1;
	private Questions Q2;
	
	private QuestionsDatabase QDB = new QuestionsDatabase();
	private LinkedList<Questions> ChosenCategory;
	
	public Round(String category)
	{
		if(category.equals("Mat"))
			ChosenCategory = QDB.getMat();
		
		Collections.shuffle(ChosenCategory);
		Q1 = ChosenCategory.get(0);
		Q2 = ChosenCategory.get(1);
	}
}
