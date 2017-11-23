package Communication.Questions;

import java.io.Serializable;

public class Match implements Serializable{

	private static final long serialVersionUID = -7411990445543465752L;
	private boolean active;
	private boolean turn;
	
	private int AmountOfRounds = 2;
	
	private static int id = 0;
	private int ID = 0;
	private Round[] round = new Round[AmountOfRounds];
	private Round[] roundOpp = new Round[AmountOfRounds];
	
	private int CurrentRound;
	
	private String Opponent;
	private int OpponentID;
	
	public Match(String opp)
	{
		ID = id++;
		setCurrentRound(0);
		setOpponent(opp);
	}
	public String getOpponent() {
		return Opponent;
	}
	public void setOpponent(String opponent) {
		Opponent = opponent;
	}
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getID() {
		return ID;
	}
	public int getOpponentID() {
		return OpponentID;
	}
	public void setOpponentID(int opponentID) {
		OpponentID = opponentID;
	}
	public int getCurrentRound() {
		return CurrentRound;
	}
	public void setCurrentRound(int currentRound) {
		CurrentRound = currentRound;
	}
	public Round getRound(int i)
	{
		return round[i];
	}
	public void setRound(Round round, int i)
	{
		this.round[i] = round;
	}
	public Round getRoundOpp(int i)
	{
		return roundOpp[i];
	}
	public void setRoundOpp(Round round, int i)
	{
		this.roundOpp[i] = round;
	}
	
}
