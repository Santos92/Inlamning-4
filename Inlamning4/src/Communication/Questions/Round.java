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
		setQ1(ChosenCategory.get(0));
		setQ2(ChosenCategory.get(1));
	}

	public Questions getQ2() {
		return Q2;
	}

	public void setQ2(Questions q2) {
		Q2 = q2;
	}

	public Questions getQ1() {
		return Q1;
	}

	public void setQ1(Questions q1) {
		Q1 = q1;
	}
}
