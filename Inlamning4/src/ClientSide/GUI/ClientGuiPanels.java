package ClientSide.GUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClientGuiPanels {

	
	public JPanel Login()
	{
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(0,2));
		JLabel username = new JLabel("Anv�ndarnamn:");
		JTextField nameField = new JTextField(15);
		JLabel password = new JLabel("L�senord:");
		JTextField passField = new JTextField(15);
		
		
		login.add(username);
		login.add(nameField);
		login.add(password);
		login.add(passField);
		
		return login;
	}
	
	
	public JPanel StartSida() {
		JPanel start = new JPanel();
		start.setLayout(new GridLayout(7,1));
		JLabel anv�ndare = new JLabel("Anv�ndarnamn: ");
		JLabel anv�ndarnamn = new JLabel(" ");
		JButton startaSpel = new JButton("Starta nytt spel");
		JButton dinTur = new JButton("Din tur mot ");
		JLabel aktivaSpelLabel = new JLabel("Aktiva spel");
		JButton aktivaSpel = new JButton("Anv�ndare v�ntar p� att spelare ska acceptera");
		JButton reklam = new JButton("Reklam");
		
		start.add(anv�ndare);
		start.add(anv�ndarnamn);
		start.add(startaSpel);
		start.add(dinTur);
		start.add(aktivaSpelLabel);
		start.add(aktivaSpel);
		start.add(reklam);
		
		return start;
	}
	
	public JPanel Top() {
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,1));
		JLabel titel = new JLabel("Quizkampen");
		JButton refresh = new JButton("Refresh");
		JButton statistik = new JButton("Statistik");
		JButton inst�llningar = new JButton("Inst�llningar");
		
		top.add(titel);
		top.add(refresh);
		top.add(statistik);
		top.add(inst�llningar);
	
		return top;
	}
	
	public JPanel StartaNyttSpel() {
		JPanel body = new JPanel();
		
		return body;
	}

	
}
