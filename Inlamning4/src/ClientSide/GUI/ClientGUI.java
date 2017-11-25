package ClientSide.GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;

import ClientSide.Client;
import Communication.Session;
import Communication.Session.gameStates;
import Communication.Questions.Match;
import Communication.Questions.Questions;
import Communication.Questions.Round;
import ServerSide.Users.User;
import ServerSide.Users.UserDatabase;

public class ClientGUI extends JPanel implements ActionListener{
	
	private static final long serialVersionUID = 6652272365889996841L;
	private ClientGuiPanels GuiPanels;
	private ClientGuiTopPanels GuiTopPanels;
	private Client client;
	private Round Round; 
	private Match match;
	private Questions Q1;
	private Questions Q2;
	private ColorThemes Color;
	private JPanel mainPanel;
	private JPanel topPanel;
	private JButton changedButton;

	
	public ClientGUI(Client client){
		this.client = client;
		GuiPanels = new ClientGuiPanels(this, this.client);
		GuiTopPanels = GuiPanels.getTopPanels();
		//mainPanel = GuiPanels.sidaStart();
		mainPanel = GuiPanels.sidaLogin();
		//mainPanel = GuiPanels.sidaSkapa();
		//mainPanel = GuiPanels.sidaLogedin();
		//mainPanel = GuiPanels.sidaNyttSpel();
		//mainPanel = GuiPanels.sidaSettings();
		//mainPanel = GuiPanels.sidaKampMotståndare();
		//mainPanel = GuiPanels.sidaSvaraFråga();
		//mainPanel = GuiPanels.sidaVäljKategori();
		//mainPanel = GuiPanels.sidaStatistik();
		
		if(topPanel != null)
		add(topPanel);
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
			swapWindow(GuiPanels.sidaNyttSpel());
		else if(e.getSource().equals(GuiTopPanels.getTopPanelinställningar()))
			swapWindow(GuiPanels.sidaSettings());  
		else if(e.getSource().equals(GuiPanels.getSettingsBack())) // Tar oss inte tillbaka till samma sidaLogedin
		{
			Session sess = new Session();
			sess.setState(gameStates.getMatches);
			sess.setUserName(client.getUserName());
			client.send(sess);
			
		}
		else if(e.getSource().equals(GuiPanels.getSlumpadSpelare()))
		{
			Session sess = new Session();
			sess.setState(gameStates.RandomMatch);
			sess.setUserName(client.getUserName());
			client.send(sess);
			swapWindow(GuiPanels.sidaLogedin());
			
		}
		else if(e.getSource().equals(GuiPanels.getDinTur1())) 
			swapWindow(GuiPanels.sidaKampMotståndare());
		else if(e.getSource().equals(GuiPanels.getDinTur2()))
			swapWindow(GuiPanels.sidaKampMotståndare());  
		else if(e.getSource().equals(GuiPanels.getAvslutadeSpel()))
		 swapWindow(GuiPanels.sidaStatistik());
		else if(e.getSource().equals(GuiPanels.getGeUpp())) 
			swapWindow(GuiPanels.sidaLogedin());
		else if(e.getSource().equals(GuiPanels.getSpela()))
		{	// Slumpa först alla kategorier och knappar med svar
			//if(Round1)
			//swapWindow(GuiPanels.sidaSvaraFråga());
			// Här behövs de slumpade läggas ut på frågan och svaren läggas ut på knapparna
			//else if(Round2)
			swapWindow(GuiPanels.sidaVäljKategori());
			
		}
		else if(e.getSource().equals(GuiPanels.getGoReturn())) 
			swapWindow(GuiPanels.sidaLogedin());
		else if(e.getSource().equals(GuiPanels.getKategori1()))
			{  if(GuiPanels.getKategori1().getText().equalsIgnoreCase("Mat") 
				|| GuiPanels.getKategori1().getText().equalsIgnoreCase("Film")
				|| GuiPanels.getKategori1().getText().equalsIgnoreCase("Teknik") 
				|| GuiPanels.getKategori1().getText().equalsIgnoreCase("Geografi")
				|| GuiPanels.getKategori1().getText().equalsIgnoreCase("Historia")) 
			    {
				swapWindow(GuiPanels.sidaSvaraFråga());
							  
			    }
			}
		else if(e.getSource().equals(GuiPanels.getKategori2()))
			{  if(GuiPanels.getKategori2().getText().equalsIgnoreCase("Mat") 
				|| GuiPanels.getKategori2().getText().equalsIgnoreCase("Film")
				|| GuiPanels.getKategori2().getText().equalsIgnoreCase("Teknik") 
				|| GuiPanels.getKategori2().getText().equalsIgnoreCase("Geografi")
				|| GuiPanels.getKategori2().getText().equalsIgnoreCase("Historia"))
			  {
				swapWindow(GuiPanels.sidaSvaraFråga());
								
			  }
			}
		else if(e.getSource().equals(GuiPanels.getKategori3()))
			{ if(GuiPanels.getKategori3().getText().equalsIgnoreCase("Mat") 
				|| GuiPanels.getKategori3().getText().equalsIgnoreCase("Film")
				|| GuiPanels.getKategori3().getText().equalsIgnoreCase("Teknik") 
				|| GuiPanels.getKategori3().getText().equalsIgnoreCase("Geografi")
				|| GuiPanels.getKategori3().getText().equalsIgnoreCase("Historia")) 
			  {
				swapWindow(GuiPanels.sidaSvaraFråga());
								
			  }
			}
		else if(e.getSource().equals(GuiPanels.getGoBack()))
			swapWindow(GuiPanels.sidaLogedin());
		
		else if(e.getSource().equals(GuiPanels.getAnswer1()))
		{	// Round 1
			
			if(GuiPanels.getAnswer1().getText().equalsIgnoreCase(Q1.getWroAns1())
			||GuiPanels.getAnswer1().getText().equalsIgnoreCase(Q1.getWroAns2())
			|| GuiPanels.getAnswer1().getText().equalsIgnoreCase(Q1.getWroAns3()))
			{
				GuiPanels.getAnswer1().setBackground(Color.getButtonRed()); // Funkar ej
				GuiPanels.getAnswer1().setVisible(true);
			}
			else if(GuiPanels.getAnswer1().getText().equalsIgnoreCase(Q1.getCorAnswer()))
			{
				GuiPanels.getAnswer1().setBackground(Color.getStartGameBG());
				GuiPanels.getAnswer1().setVisible(true); 
			}
			
		}
		else if (e.getSource().equals(GuiPanels.getAnswer2()))
		{

		}
		else if(e.getSource().equals(GuiPanels.getAnswer3()))
		{
			
		}
		else if(e.getSource().equals(GuiPanels.getAnswer4()))
		{
			
		}
		else if(e.getSource().equals(GuiPanels.getBackBack()))
			swapWindow(GuiPanels.sidaLogedin());
		
		else if(e.getSource().equals(GuiPanels.getStatBack()))
			swapWindow(GuiPanels.sidaLogedin());
			
		
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
