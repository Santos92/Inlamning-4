package ClientSide.GUI;

import javax.swing.JPanel;

import ClientSide.Client;

public class ClientGUI extends JPanel{
	
	private ClientGuiPanels GuiPanels;
	private Client client;
	
	public ClientGUI(Client client){
		this.client = client;
		GuiPanels = new ClientGuiPanels();
		add(GuiPanels.Login());
		
		
		new ClientWindow(this);
	}
	

}
