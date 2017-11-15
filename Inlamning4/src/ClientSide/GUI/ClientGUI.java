package ClientSide.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

import ClientSide.Client;

public class ClientGUI extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 6652272365889996841L;
	private ClientGuiPanels GuiPanels;
	private Client client;
	
	private JPanel mainPanel;
	
	public ClientGUI(Client client){
		this.client = client;
		GuiPanels = new ClientGuiPanels(this);
		mainPanel = GuiPanels.startSide();
		add(mainPanel);
		new ClientWindow(this);
	}
	
	public void swapWindow(JPanel panel)
	{
		remove(mainPanel);
		mainPanel = panel;
		add(mainPanel);
		validate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(GuiPanels.getLoginBtn()))
			swapWindow(GuiPanels.loginSide());
		else if(e.getSource().equals(GuiPanels.getBack()))
			swapWindow(GuiPanels.startSide());
		else if(e.getSource().equals(GuiPanels.getRegBtn()))
			swapWindow(GuiPanels.createUserSide());
	}
}
