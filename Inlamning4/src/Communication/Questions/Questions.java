package Communication.Questions;

public class Questions {

	private	String category;
	private String question;
	private	String corAnswer;
	private String wroAns1;
	private String wroAns2;
	private String wroAns3;
	
	public Questions(String category,String question,String corAnswer, String wroAns1,
				String wroAns2,String wroAns3 ){
		this.category = category;
		this.question = question;
		this.corAnswer = corAnswer;
		this.wroAns1 = wroAns1;
		this.wroAns2 = wroAns2;
		this.wroAns3 = wroAns3;
	}

	public String getCategory() {
		return category;
	}
	public String getQuestion() {
		return question;
	}
	public String getCorAnswer() {
		return corAnswer;
	}
	public String getWroAns1() {
		return wroAns1;
	}
	public String getWroAns2() {
		return wroAns2;
	}
	public String getWroAns3() {
		return wroAns3;
	}
}
