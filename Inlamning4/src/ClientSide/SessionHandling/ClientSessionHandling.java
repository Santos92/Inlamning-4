package ClientSide.SessionHandling;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import ClientSide.Client;
import ClientSide.GUI.ClientGUI;
import Communication.Session;
import Communication.Session.gameStates;
import Communication.Questions.Match;

public class ClientSessionHandling {

	private Client client;
	private ClientGUI GUI;
	private Session Packet;
	private gameStates state;
	private String Message;
	private String UserName;
	private LinkedList<Match> matches;
	
	public ClientSessionHandling(Client client, ClientGUI GUI, Object obj) {
		this.client = client;
		this.GUI = GUI;
		Packet = (Session) obj;
		state = Packet.getState();
		Message = Packet.getMessage();
		UserName = Packet.getUserName();
		matches = Packet.getMatches();
		handle();
	}

	public synchronized void handle()
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
			client.setMatches(matches);
			for(Match x : client.getMatches())
				System.out.println(x.getOpponent());
			GUI.swapWindow(GUI.getPanels().sidaLogedin(), GUI.getTopPanels().Top());
			JOptionPane.showMessageDialog(null, Message);
		}
		else if(state == gameStates.getMatches) {
			client.setMatches(matches);
			for(Match x : client.getMatches())
				System.out.println(x.getOpponent());
			GUI.swapWindow(GUI.getPanels().sidaLogedin(), GUI.getTopPanels().Top());
		}
	}
	
	
	
	
}
