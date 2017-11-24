package ServerSide.SessionHandling;

import java.util.LinkedList;

import Communication.Session;
import Communication.Session.gameStates;
import Communication.Questions.Match;
import ServerSide.ClientThread;
import ServerSide.Server;
import ServerSide.Users.User;
import ServerSide.Users.UserDatabase;

public class ServerSessionHandler {

	private Session Packet;
	private gameStates state;
	private String Message;
	private ClientThread server;
	private String UserName;
	private String UserPass;
	private UserDatabase userDB;
	private Server MainServer;
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
		else if(state == gameStates.RandomMatch)
		{
			User user = userDB.getUser(UserName);
			MatchKö.add(user);
			if(MatchKö.size() >= 2)
			{
				User user0 = MatchKö.get(0);
				User user1 = MatchKö.get(1);
				Match match0 = new Match(user1.getNamn());
				Match match1 = new Match(user0.getNamn());
				user0.addMatch(match0);
				user1.addMatch(match1);
				MatchKö.removeFirst();
				MatchKö.removeFirst();
			}
		}
		
	}
}
