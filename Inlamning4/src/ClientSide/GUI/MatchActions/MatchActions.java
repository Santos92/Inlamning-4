package ClientSide.GUI.MatchActions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ClientSide.Client;
import ClientSide.GUI.ClientGUI;
import Communication.Session;
import Communication.Questions.Match;
import Communication.Session.gameStates;

public class MatchActions implements ActionListener {

	private Client client;
	private ClientGUI GUI;

	public MatchActions(Client client, ClientGUI GUI)
	{
		this.client = client;
		this.GUI = GUI;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() instanceof JButton)
		{
			int index = (int) ((JButton)e.getSource()).getClientProperty("index");
			Match match = client.getMatcher().get(index);
			System.out.println(match.getID());
			System.out.println(match.getOpponentID());
			System.out.println(index);
			Session sess = new Session();
			sess.setState(gameStates.startRound);
			sess.setPickedMatch(match);
			sess.setUserName(client.getUserName());
			client.send(sess);
		}
	}

}
