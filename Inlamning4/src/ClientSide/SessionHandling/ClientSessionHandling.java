package ClientSide.SessionHandling;

import ClientSide.Client;
import ClientSide.GUI.ClientGUI;
import Communication.Session;

public class ClientSessionHandling {

	private Client client;
	private ClientGUI GUI;
	private Session session;
	
	public ClientSessionHandling(Client client, ClientGUI GUI, Object session) {
		this.client = client;
		this.GUI = GUI;
		this.session = (Session) session;
	}

}
