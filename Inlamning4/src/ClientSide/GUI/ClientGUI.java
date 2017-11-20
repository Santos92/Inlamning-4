package ClientSide.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JPanel;

import ClientSide.Client;
import Communication.Session;
import Communication.Session.gameStates;
import ServerSide.Users.User;
import ServerSide.Users.UserDatabase;

public class ClientGUI extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 6652272365889996841L;
	private ClientGuiPanels GuiPanels;
	private ClientGuiTopPanels GuiTopPanels;
	private Client client;
	
	private JPanel mainPanel;
	private JPanel topPanel;
	
	public ClientGUI(Client client){
		this.client = client;
		GuiPanels = new ClientGuiPanels(this, this.client);
		GuiTopPanels = GuiPanels.getTopPanels();
		mainPanel = GuiPanels.sidaStart();
		if(topPanel != null)
		add(topPanel);
		add(mainPanel);		
		new ClientWindow(this);
	}
	
	public void swapWindow(JPanel panel)
	{
		if(topPanel != null)
			remove(topPanel);
		
		remove(mainPanel);
		mainPanel = panel;
		add(mainPanel);
		validate();
		repaint();
	}
	public void swapWindow(JPanel panel, JPanel panelTop)
	{
		if(topPanel != null)
			remove(topPanel);
		remove(mainPanel);
		topPanel = panelTop;
		mainPanel = panel;
		if(topPanel != null)
			add(topPanel);
		add(mainPanel);
		validate();
		repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(GuiPanels.getLoginBtn()))
			swapWindow(GuiPanels.sidaLogin());
		else if(e.getSource().equals(GuiPanels.getBack()))
			swapWindow(GuiPanels.sidaStart());
		else if(e.getSource().equals(GuiPanels.getRegBtn()))
			swapWindow(GuiPanels.sidaSkapa());
		else if(e.getSource().equals(GuiPanels.getLoginUser()))
			{
				Session sess = new Session();
				sess.setState(gameStates.TryLogin);
				sess.setUserName(GuiPanels.getUsernameTxFdLog().getText());
				sess.setUserPass(GuiPanels.getPasswordTxFdLog().getText());
				client.send(sess);
			}
		else if(e.getSource().equals(GuiPanels.getSaveBtn())) {
			Session sess = new Session();
			sess.setState(gameStates.TryRegister);
			sess.setUserName(GuiPanels.getUsernameTxFdReg().getText());
			sess.setUserPass(GuiPanels.getPasswordTxFdReg().getText());
			client.send(sess);
		}
		else if(e.getSource().equals(GuiPanels.getStartaSpel()))
			swapWindow(GuiPanels.sidaNyttSpel(), GuiTopPanels.Top());
		else if(e.getSource().equals(GuiTopPanels.getTopPanelinställningar()))
			swapWindow(GuiPanels.sidaSettings());
		else if(e.getSource().equals(GuiPanels.getSettingsBack()))
			swapWindow(GuiPanels.sidaLogedin(),GuiTopPanels.Top());
			
	}
	public ClientGuiPanels getPanels()
	{
		return GuiPanels;
	}
	public ClientGuiTopPanels getTopPanels()
	{
		return GuiTopPanels;
	}
}
