package Communication.Questions;

import java.io.Serializable;
import java.util.ArrayList;

public class Round implements Serializable{
	
	private static final long serialVersionUID = -7672077512953554573L;

	private Questions Q1;
	private Questions Q2;
	private boolean hidden = false;
	private QuestionsDatabase QDB = new QuestionsDatabase();
	private ArrayList<Questions> chosenCategory;
	
	public Round(String Category)
	{
		if(Category.equals("Mat"))
			chosenCategory = QDB.getMat();
		if(Category.equals("Film"))
			chosenCategory = QDB.getFilm();
		if(Category.equals("Teknik"))
			chosenCategory = QDB.getTeknik();
		if(Category.equals("Geografi"))
			chosenCategory = QDB.getGeografi();
		if(Category.equals("Historia"))
			chosenCategory = QDB.getHistoria();
	}

}
