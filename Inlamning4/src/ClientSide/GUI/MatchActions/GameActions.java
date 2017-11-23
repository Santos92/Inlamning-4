package ClientSide.GUI.MatchActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ClientSide.Client;
import ClientSide.GUI.ClientGUI;
import Communication.Session;
import Communication.Questions.Match;
import Communication.Session.gameStates;

public class GameActions implements ActionListener {

	private Client client;
	private ClientGUI GUI;

	public GameActions(Client client, ClientGUI GUI)
	{
		this.client = client;
		this.GUI = GUI;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Match m = (Match) ((JButton)e.getSource()).getClientProperty("match");
		Session sess = new Session();
		sess.setState(gameStates.startRound);
		sess.setMessage(e.getActionCommand());
		sess.setPickedMatch(m);
		sess.setUserName(client.getUserName());
		client.send(sess);
		System.out.println(e.getActionCommand());
		
	}

}
