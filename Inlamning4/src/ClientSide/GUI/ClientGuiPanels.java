package ClientSide.GUI;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientGuiPanels {

	private LinkedList<ColorThemes> Teman = new LinkedList<>();
	private ColorThemes Tema;
	
	public ClientGuiPanels()
	{
		setupThemes();
		setTema(0);
	}
	
	public void setTema(int id)
	{
		Tema = Teman.get(id);
	}
	
	
	public JPanel Login()
	{
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(4,0));
		
		JLabel username = new JLabel("Användarnamn:");
		JTextField nameField = new JTextField(15);
		JLabel password = new JLabel("Lösenord:");
		JTextField passField = new JTextField(15);
		JButton loginBtn = new JButton("Logga in");
		JButton regBtn = new JButton("Registrera");

		login.setBackground(Tema.getBG());
		
		login.add(username);
		login.add(nameField);
		login.add(password);
		login.add(passField);
		login.add(loginBtn);
		login.add(regBtn);
		
		return login;
	}
	
	
	public JPanel StartSida() {
		
		
		
		return null;
	}

	private void setupThemes()
	{
		Teman.add(new ColorThemes(new Color(30,144,255), new Color(0,102,204), new Color(102, 104, 204), new Color(255,255,255)));
	}
	
}
