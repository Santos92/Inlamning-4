package Communication.Questions;

import java.io.Serializable;
import java.util.Collections;
import java.util.LinkedList;

public class Round implements Serializable{

	private static final long serialVersionUID = 2059232265937406891L;
	
	private Questions[] Q;
	private int currentQuestion;
	private int Score = 0;
	
	private boolean hidden = true;
	
	private String category;
	private QuestionsDatabase QDB = new QuestionsDatabase();
	private LinkedList<Questions> ChosenCategory;
	
	public Round(String category, int AmountOfQuestions)
	{
		Q = new Questions[AmountOfQuestions];
		setCurrentQuestion(0);
		this.setCategory(category);
		if(category.equals("Mat"))
			ChosenCategory = QDB.getMat();
		if(category.equals("Film"))
			ChosenCategory = QDB.getFilm();
		if(category.equals("Teknik"))
			ChosenCategory = QDB.getTeknik();
		if(category.equals("Historia"))
			ChosenCategory = QDB.getHistoria();
		if(category.equals("Geografi"))
			ChosenCategory = QDB.getGeografi();
		
		Collections.shuffle(ChosenCategory);
		for(int i = 0; i<AmountOfQuestions; i++)
			setQ(ChosenCategory.get(i), i);
	}

	public Questions getQ(int i)
	{
		return Q[i];
	}
	public void setQ(Questions q,int i)
	{
		Q[i] = q;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getCurrentQuestion() {
		return currentQuestion;
	}

	public void setCurrentQuestion(int currentQuestion) {
		this.currentQuestion = currentQuestion;
	}

	public boolean isHidden() {
		return hidden;
	}

	public void setHidden(boolean hidden) {
		this.hidden = hidden;
	}
	public int getScore() {
		return Score;
	}

	public void setScore(int score) {
		Score = score;
	}
}
