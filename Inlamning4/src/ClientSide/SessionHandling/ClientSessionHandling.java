package ClientSide.SessionHandling;

import javax.swing.JOptionPane;

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
	private String UserName;
	
	public ClientSessionHandling(Client client, ClientGUI GUI, Object obj) {
		this.client = client;
		this.GUI = GUI;
		Packet = (Session) obj;
		state = Packet.getState();
		Message = Packet.getMessage();
		UserName = Packet.getUserName();
		handle();
	}

	public void handle()
	{
		if(state == gameStates.FailReg)
		{
			JOptionPane.showMessageDialog(null, Message);
		}
		else if(state == gameStates.OkReg)
		{
			client.setUserName(UserName);
			GUI.swapWindow(GUI.getPanels().sidaLogedin(), GUI.getTopPanels().Top());
			JOptionPane.showMessageDialog(null, Message);
		}
		else if(state == gameStates.FailAuth)
		{
			JOptionPane.showMessageDialog(null, Message);
		}
		else if(state == gameStates.AuthAccept) {
			client.setUserName(UserName);
			GUI.swapWindow(GUI.getPanels().sidaLogedin(), GUI.getTopPanels().Top());
			JOptionPane.showMessageDialog(null, Message);
		}
	}
	
	
	
	
}
