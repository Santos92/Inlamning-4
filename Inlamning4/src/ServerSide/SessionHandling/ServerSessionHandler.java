package ServerSide.SessionHandling;

import Communication.Session;
import Communication.Session.gameStates;
import ServerSide.ClientThread;

public class ServerSessionHandler {

	private Session Packet;
	private gameStates state;
	private String Message;
	private ClientThread server;
	
	public ServerSessionHandler(ClientThread server, Object obj) {
		this.server = server;
		Packet = (Session) obj;
		state = Packet.getState();
		Message = Packet.getMessage();
		handle();
	}

	public void handle()
	{
		if(state == gameStates.TryLogin)
		{

		}
	}
	
}
