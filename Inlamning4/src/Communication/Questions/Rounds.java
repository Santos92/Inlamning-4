package Communication.Questions;

import java.util.ArrayList;
import java.util.Random;

public class Rounds {

	
	public static QuestionsDatabase category;
	Questions någonting;
		
		
// slumpar 3 nummer från 1 till 5 som referar till categories 
 public static String getRandomNumber() {
	Random generator = new Random();
	int n1;
	String s = "";
	          
	for(int i=0; i<3 ; i++) {
		n1 = generator.nextInt(5)+1;
		s= s+n1;
	}
	 
     return s;
  }
 
 // metod som tillsätter kategorier till heltalet i String s
	public static QuestionsDatabase getCategory() {
		String string = getRandomNumber();
	 switch(string) {
	 case("1"):
		 category.getMat();
	
	 break;
	 case("2"):
		 category.getFilm();
	 break;
	 case("3"):
		 category.getTeknik();
	 break;
	 case("4"):
		 category.getGeografi();
	 break;
	 case("5"):
		 category.getHistoria();
	 break;
		 
	 }
	
	return category;
}
	// metod som visar de två frågorna från kategorin
	public String getQuestions() {
		String s = getRandomNumber();
		//ArrayList<Questions> questionSet = Questions.getCategory(s);
		
		return s;
	}
	
	//public String getQuestion() {
	//	ArrayList<Questions> randomCategory = getMat();	
	//	for(int i=0; i<randomCategory.size(); i++)
	//	return question;
	//	}
 
 
	
	
		
	



}
