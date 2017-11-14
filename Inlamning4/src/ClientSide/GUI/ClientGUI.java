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
//		add(GuiPanels.loginSide());
//		add(GuiPanels.createUserSide());
		
		new ClientWindow(this);
	}
	
	public void swapWindow(JPanel panel)
	{
		remove(mainPanel);
		mainPanel = panel;
		add(mainPanel);
		revalidate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(GuiPanels.getLoginBtn()))
			swapWindow(GuiPanels.loginSide());
	}

}
