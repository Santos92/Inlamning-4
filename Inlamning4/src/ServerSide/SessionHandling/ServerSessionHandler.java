package ServerSide.SessionHandling;

import java.util.LinkedList;

import Communication.Session;
import Communication.Session.gameStates;
import Communication.Questions.Match;
import Communication.Questions.Round;
import ServerSide.ClientThread;
import ServerSide.Server;
import ServerSide.Users.User;
import ServerSide.Users.UserDatabase;

public class ServerSessionHandler {

	private Server MainServer;
	private ClientThread server;
	private Session Packet;
	private UserDatabase userDB;
	private gameStates state;
	private String Message;
	private String UserName;
	private String UserPass;
	private Match match;
	private User user;
	private static LinkedList<User> MatchKö = new LinkedList<>();
	
	public ServerSessionHandler(Server MainServer, ClientThread server, Object obj) {
		this.server = server;
		this.MainServer = MainServer;
		this.userDB = MainServer.getUserDB();
		Packet = (Session) obj;
		state = Packet.getState();
		Message = Packet.getMessage();
		UserName = Packet.getUserName();
		UserPass = Packet.getUserPass();
		match = Packet.getPickedMatch();
		user = userDB.getUser(UserName);
		handle();
	}

	public void handle()
	{
		if(state == gameStates.TryRegister)
		{
			userDB.register(UserName, UserPass, server);
		}
		else if(state == gameStates.TryLogin)
		{
			userDB.login(UserName, UserPass, server);
		}
		else if(state == gameStates.getMatches)
		{
			Session sess = new Session();
			sess.setState(gameStates.getMatches);
			sess.setMatcher(userDB.getUser(UserName).getMatcher());
			server.send(sess);
		}
		else if(state == gameStates.startRound)
		{
			User opponent = userDB.getUser(match.getOpponent());
			Match oppMatch = null;
			Match userMatch = null;
			for(Match x : opponent.getMatcher())
				if(x.getID() == match.getOpponentID())
					oppMatch = x;
			for(Match x : user.getMatcher())
				if(x.getID() == match.getID())
					userMatch = x;
			
			Round R = new Round(Message, userMatch.getAmountOfQuestions());
			userMatch.setRound(R, userMatch.getCurrentRound());
			R.setHidden(false);
			oppMatch.setRound(R, userMatch.getCurrentRound());
			
			Session sess = new Session();
			sess.setState(gameStates.startRound);
			sess.setPickedMatch(userMatch);
			server.send(sess);
		}
		else if(state == gameStates.RandomMatch)
		{
			MatchKö.add(user);
			if(MatchKö.size() >= 2)
			{
				User user0 = MatchKö.get(0);
				User user1 = MatchKö.get(1);
				Match match0 = new Match(user1.getNamn());
				Match match1 = new Match(user0.getNamn());
				match0.setActive(true);
				match0.setTurn(false);
				match1.setActive(true);
				match1.setTurn(true);
				match1.setOpponentID(match0.getID());
				match0.setOpponentID(match1.getID());
				user0.addMatch(match0);
				user1.addMatch(match1);
				MatchKö.removeFirst();
				MatchKö.removeFirst();
			}
		}
		else if(state == gameStates.FinishedRound)
		{
			User opponent = userDB.getUser(match.getOpponent());	
			Match oppMatch = null;
			Match userMatch = null;
			int index = 0;
			for(Match x : opponent.getMatcher())
				if(x.getID() == match.getOpponentID())
					oppMatch = x;
			for(Match x : user.getMatcher())
				if(x.getID() == match.getID())
				{
					userMatch = x;
					index = user.getMatcher().indexOf(x);
				}
			
			user.setMatch(match, index);
			oppMatch.setRoundOpp(userMatch.getRound(userMatch.getCurrentRound()), userMatch.getCurrentRound());
			oppMatch.setCurrentRound(match.getCurrentRound());
			oppMatch.setActive(match.isActive());
			oppMatch.setTurn(!match.isTurn());
			
			Session sess = new Session();
			sess.setMatcher(user.getMatcher());
			sess.setState(gameStates.FinishedRound);
			server.send(sess);
			
		}
	}
}
