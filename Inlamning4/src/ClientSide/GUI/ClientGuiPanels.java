package ClientSide.GUI;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientGuiPanels {

	
	public JPanel Login()
	{
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(0,2));
		JLabel username = new JLabel("Användarnamn:");
		JTextField nameField = new JTextField(15);
		JLabel password = new JLabel("Lösenord:");
		JTextField passField = new JTextField(15);
		
		
		login.add(username);
		login.add(nameField);
		login.add(password);
		login.add(passField);
		
		return login;
	}
	
	
	public JPanel StartSida() {
		
		
		
		
		return null;
	}

	
}
