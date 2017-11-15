package ClientSide.SessionHandling;

import ClientSide.Client;
import ClientSide.GUI.ClientGUI;
import Communication.Session;
import Communication.Session.gameStates;
import ServerSide.ClientThread;

public class ClientSessionHandling {

	private Client client;
	private ClientGUI GUI;
	private Session Packet;
	private gameStates state;
	private String Message;
	
	public ClientSessionHandling(Client client, ClientGUI GUI, Object obj) {
		this.client = client;
		this.GUI = GUI;
		Packet = (Session) obj;
		state = Packet.getState();
		Message = Packet.getMessage();
		handle();
	}

	public void handle()
	{
		if(state == gameStates.FailAuth)
		{
			System.out.println(Message);
		}
	}
}
