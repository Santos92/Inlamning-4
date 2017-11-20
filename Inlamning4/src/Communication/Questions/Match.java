package Communication.Questions;

import java.io.Serializable;

public class Match implements Serializable {

	private static final long serialVersionUID = -1047562917894515640L;
	private boolean Active = false;
	private boolean yourTurn = false;
	
	private Round round1;
	private Round round2;
	
	private Round round1Opp;
	private Round round2Opp;

	private String Opponent;
	
	public Match(String Opponent)
	{
		this.setOpponent(Opponent);
	}

	public String getOpponent() {
		return Opponent;
	}

	public void setOpponent(String opponent) {
		Opponent = opponent;
	}
	
}
