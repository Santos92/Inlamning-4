package ClientSide.GUI;

import javax.swing.JPanel;

import ClientSide.Client;

public class ClientGUI extends JPanel{
	
	private ClientGuiPanels GuiPanels = new ClientGuiPanels();
	private Client client;
	
	public ClientGUI(Client client){
		this.client = client;
		//add(GuiPanels.Login());
		//add(GuiPanels.startSide());
		//add(GuiPanels.AndraSida());
		//add(GuiPanels.TopwithoutButtons());
		//add(GuiPanels.StartaNyttSpel());
		
		
		
		new ClientWindow(this);
	}
	

}
