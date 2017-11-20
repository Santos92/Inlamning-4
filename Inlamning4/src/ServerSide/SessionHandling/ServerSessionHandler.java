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
	public static LinkedList<User> RandomMatchLine = new LinkedList<>();
	
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

	public synchronized void handle()
	{
		if(state == gameStates.TryRegister)
		{
			userDB.register(UserName, UserPass, server);
		}
		else if(state == gameStates.TryLogin)
		{
			userDB.login(UserName, UserPass, server);
		}
		else if(state == gameStates.RandomMatch)
		{
			User user = userDB.getUser(UserName);
			RandomMatchLine.add(user);
			if(RandomMatchLine.size() >= 2)
			{
				User user0 = userDB.getUser(RandomMatchLine.get(0).getNamn());
				User user1 = userDB.getUser(RandomMatchLine.get(1).getNamn());
				user0.addMatch(new Match(user1.getNamn()));
				user1.addMatch(new Match(user0.getNamn()));
				RandomMatchLine.removeFirst();
				RandomMatchLine.removeFirst();
			}
		}
		else if(state == gameStates.getMatches) {
			Session sess = new Session();
			sess.setState(gameStates.getMatches);
			sess.setMatches(userDB.getUser(UserName).getMatcher());
			server.send(sess);
		}
	}
	
}
