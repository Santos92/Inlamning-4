package ServerSide.SessionHandling;

import Communication.Session;
import Communication.Session.gameStates;
import ServerSide.ClientThread;
import ServerSide.Server;
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
			server.status(UserName);
			server.status(UserPass);
			userDB.register(UserName, UserPass, server);
		}
		else if(state == gameStates.TryLogin)
		{
			userDB.login(UserName, UserPass, server);
		}
	}
	
}
