package ClientSide.SessionHandling;

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
	private Match match;
	
	public ClientSessionHandling(Client client, ClientGUI GUI, Object obj) {
		this.client = client;
		this.GUI = GUI;
		Packet = (Session) obj;
		state = Packet.getState();
		Message = Packet.getMessage();
		UserName = Packet.getUserName();
		match = Packet.getPickedMatch();
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
			GUI.swapWindow(GUI.getPanels().sidaLogedin());
			JOptionPane.showMessageDialog(null, Message);
		}
		else if(state == gameStates.FailAuth)
		{
			JOptionPane.showMessageDialog(null, Message);
		}
		else if(state == gameStates.AuthAccept) {
			client.setUserName(UserName);
			client.setMatcher(Packet.getMatcher());
			GUI.swapWindow(GUI.getPanels().sidaLogedin());
			JOptionPane.showMessageDialog(null, Message);
		}
		else if(state == gameStates.getMatches)
		{
			client.setMatcher(Packet.getMatcher());
			GUI.swapWindow(GUI.getPanels().sidaLogedin());
		}
		else if(state == gameStates.startRound)
		{
			System.out.println(match.getRound1().getQ1().getQuestion());
		}
	} 
	
	
	
	
}
