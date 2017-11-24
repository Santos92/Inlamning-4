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
			if(match.isTurn() && match.isActive())
			{
				if(match.getRound(match.getCurrentRound()) == null)
					GUI.swapWindow(GUI.getPanels().sidaVäljKategori(match));
				else
					GUI.swapWindow(GUI.getPanels().sidaSvaraFråga(match, true));
			}
			else if(match.isActive() && !match.isTurn())
			{
				
			}
			else if(!match.isActive())
			{
				
			}
		}
	}

}
