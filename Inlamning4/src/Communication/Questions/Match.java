package Communication.Questions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.Scanner;

public class Match implements Serializable{

	private static final long serialVersionUID = -7411990445543465752L;
	private boolean active;
	private boolean turn;
	
	private int points;
	private int pointsOpp;
	
	private int AmountOfRounds;
	private int AmountOfQuestions;
	
	private static int id = 0;
	private int ID = 0;
	private Round[] round;
	private Round[] roundOpp;
	
	private int CurrentRound;
	
	private String Opponent;
	private int OpponentID;
	
	public Match(String opp)
	{
		Scanner scan;
		try {
			scan = new Scanner(new File("Inlamning4\\res\\Properties.conf"));
			while (scan.hasNextLine())
			{
				String firstLine = scan.nextLine();
				String secondLine = scan.nextLine();
				String[] temp;
				temp = firstLine.split(":");
				temp[1] = temp[1].trim();
				AmountOfQuestions = Integer.parseInt(temp[1]);
				temp = secondLine.split(":");
				temp[1] = temp[1].trim();
				AmountOfRounds = Integer.parseInt(temp[1]);
				System.out.println(AmountOfQuestions);
				System.out.println(AmountOfRounds);
			}
			} catch (FileNotFoundException e) {
				System.out.println("kunde inte läsa fil");
				AmountOfQuestions = 2;
				AmountOfRounds = 2;
			}
			round = new Round[AmountOfRounds];
			roundOpp = new Round[AmountOfRounds];	
			
		ID = id++;
		setCurrentRound(0);
		setOpponent(opp);
	}
	public int getAmountOfRounds() {
		return AmountOfRounds;
	}
	public void setAmountOfRounds(int amountOfRounds) {
		AmountOfRounds = amountOfRounds;
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
	public int getAmountOfQuestions() {
		return AmountOfQuestions;
	}
	public void setAmountOfQuestions(int amountOfQuestions) {
		AmountOfQuestions = amountOfQuestions;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}
	public int getPointsOpp() {
		return pointsOpp;
	}
	public void setPointsOpp(int pointsOpp) {
		this.pointsOpp = pointsOpp;
	}
	
}
