package ClientSide.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ClientGuiPanels {

	private LinkedList<ColorThemes> Teman = new LinkedList<>();
	private ColorThemes Tema;
	private Font headingFont, labelFont, btnFont;
	
	public ClientGuiPanels()
	{
		setupThemes();
		setTema(0);
	}
	
	public void setTema(int id)
	{
		Tema = Teman.get(id);
	}
	
	
	public JPanel startSide(){

		JPanel start = new JPanel();
		start.setLayout(new GridLayout(4,0,40,40));
		start.setBorder(new EmptyBorder(150,30,20,30));
		start.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 50);
		btnFont = new Font("Arial", Font.BOLD, 30);

		JLabel gameNameLabel = new JLabel("QuizKampen");
		gameNameLabel.setFont(headingFont);
		gameNameLabel.setForeground(Tema.getText());
		
		JButton regBtn = new JButton("Nytt konto");
		JButton loginBtn = new JButton("Logga in");
		
		regBtn.setBackground(Tema.getButtonBG());
		regBtn.setFont(btnFont);
		regBtn.setForeground(Tema.getText());
		regBtn.setBorderPainted(false);
		regBtn.setMargin(new Insets(30, 30, 30, 30));
		
		
		loginBtn.setBackground(Tema.getButtonBG());
		loginBtn.setFont(btnFont);
		loginBtn.setForeground(Tema.getText());
		loginBtn.setBorderPainted(false);
		loginBtn.setMargin(new Insets(30, 30, 30, 30));

		start.add(gameNameLabel);
		start.add(regBtn);
		start.add(loginBtn);
		
		return start;
	}
	
	
	public JPanel loginSide() {
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(6,0, 5, 5));
		login.setBorder(new EmptyBorder(200,30,20,30));
		login.setBackground(Tema.getBG());
		login.setPreferredSize(new Dimension(500, 500));
		headingFont = new Font("Arial", Font.BOLD, 25);
		labelFont = new Font("Arial", Font.BOLD, 17);
		btnFont = new Font("Arial", Font.BOLD, 25);

		JLabel loginLabel = new JLabel("Logga in");
		loginLabel.setFont(headingFont);		
		loginLabel.setForeground(Tema.getText());
		
		JLabel usernameLabel = new JLabel("Användarnamn");
		usernameLabel.setFont(labelFont);
		usernameLabel.setForeground(Tema.getText());
		JTextField usernameTxFd = new JTextField();
		usernameTxFd.setBackground(Tema.getTxFdBG());
		
		JLabel passwordLabel = new JLabel("Lösenord");
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Tema.getText());
		JTextField passwordTxFd = new JTextField();
		passwordTxFd.setBackground(Tema.getTxFdBG());
		
		JButton loginBtn = new JButton("Logga in");
		loginBtn.setBackground(Tema.getButtonBG());
		loginBtn.setForeground(Tema.getText());
		loginBtn.setBorderPainted(false);
		loginBtn.setFont(btnFont);
	
		login.add(loginLabel);
		login.add(usernameLabel);
		login.add(usernameTxFd);
		login.add(passwordLabel);
		login.add(passwordTxFd);
		login.add(loginBtn);
	
		return login;
	}
	

	
	public JPanel AndraSida() {
		JPanel start = new JPanel();
		start.setLayout(new GridLayout(7,1));
		start.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.BOLD, 17);
		
		JLabel användare = new JLabel("Användarnamn: ");
		användare.setForeground(Tema.getText());
		JLabel användarnamn = new JLabel(" ");
		användare.setForeground(Tema.getText());
		
		JButton startaSpel = new JButton("Starta nytt spel");
		startaSpel.setBackground(Tema.getStartGameBG());
		startaSpel.setForeground(Tema.getText());
		startaSpel.setBorderPainted(false);
		startaSpel.setFont(headingFont);
		
		JButton dinTur = new JButton("Din tur mot ");
		dinTur.setBackground(Tema.getBG());
		dinTur.setForeground(Tema.getText());
		
		JLabel aktivaSpelLabel = new JLabel("Aktiva spel");
		aktivaSpelLabel.setForeground(Tema.getText());
		JButton aktivaSpel = new JButton("Användare väntar på att spelare ska acceptera");
		aktivaSpel.setBackground(Tema.getBG());
		aktivaSpel.setForeground(Tema.getText());
		
		JButton reklam = new JButton("Reklam");
		
		start.add(användare);
		start.add(användarnamn);
		start.add(startaSpel);
		start.add(dinTur);
		start.add(aktivaSpelLabel);
		start.add(aktivaSpel);
		start.add(reklam);
		
		return start;
	}
	public JPanel TopwithoutButtons() {
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,1));
		top.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		JLabel titel = new JLabel("Quizkampen");
		titel.setForeground(Tema.getText());
		titel.setFont(headingFont);
		top.add(titel);
		return top;
	}
	
	public JPanel Top() {
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,1));
		top.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.BOLD, 17);
		
		JLabel titel = new JLabel("Quizkampen");
		titel.setForeground(Tema.getText());
		titel.setFont(headingFont);
		
		JButton refresh = new JButton("Refresh");
		JButton statistik = new JButton("Statistik");
		JButton inställningar = new JButton("Inställningar");
		refresh.setBorderPainted(true);
		refresh.setBackground(Tema.getBG());
		statistik.setBorderPainted(true);
		statistik.setBackground(Tema.getBG());
		inställningar.setBorderPainted(true);
		inställningar.setBackground(Tema.getBG());
		
		top.add(titel);
		top.add(refresh);
		top.add(statistik);
		top.add(inställningar);
	
		return top;
	}
	
	public JPanel StartaNyttSpel() {// Panel man kommer till när man trycker på gröna knappen
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(10,1));
		body.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.BOLD, 17);
		JButton sökSpelare = new JButton("Sök spelare");
		sökSpelare.setBackground(Tema.getBG());
		sökSpelare.setForeground(Tema.getText());
		
		JButton facebookVänner = new JButton("Facebook-vänner");
		facebookVänner.setBackground(Tema.getBG());
		facebookVänner.setForeground(Tema.getText());
		
		JButton slumpadSpelare = new JButton("Slumpad spelare");
		slumpadSpelare.setBackground(Tema.getBG());
		slumpadSpelare.setForeground(Tema.getText());
		
		JLabel vänner = new JLabel("Vänner");
		vänner.setFont(labelFont);
		vänner.setForeground(Tema.getText());
		
		JButton bjudInVänner = new JButton("Bjud in vänner");
		bjudInVänner.setBackground(Tema.getBG());
		bjudInVänner.setForeground(Tema.getText());
		
		JButton user1 = new JButton("User1");
		user1.setBackground(Tema.getBG());
		user1.setForeground(Tema.getText());
		body.add(sökSpelare);
		body.add(facebookVänner);
		body.add(slumpadSpelare);
		body.add(vänner);
		body.add(bjudInVänner);
		body.add(user1);
		
		
		return body;
	}

	public JPanel createUserSide() {
			
		JPanel create = new JPanel();
		create.setLayout(new GridLayout(8,0, 5, 5));
		create.setBorder(new EmptyBorder(200,30,20,30));
		create.setBackground(Tema.getBG());
		create.setPreferredSize(new Dimension(500, 500));
		headingFont = new Font("Arial", Font.BOLD, 25);
		labelFont = new Font("Arial", Font.BOLD, 17);
		btnFont = new Font("Arial", Font.BOLD, 25);

		JLabel loginLabel = new JLabel("Nytt Konto");
		loginLabel.setFont(headingFont);		
		loginLabel.setForeground(Tema.getText());
		
		JLabel usernameLabel = new JLabel("Användarnamn");
		usernameLabel.setFont(labelFont);
		usernameLabel.setForeground(Tema.getText());
		JTextField usernameTxFd = new JTextField();
		usernameTxFd.setBackground(Tema.getTxFdBG());
		
		JLabel passwordLabel = new JLabel("Lösenord");
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Tema.getText());
		JTextField passwordTxFd = new JTextField();
		passwordTxFd.setBackground(Tema.getTxFdBG());
		
		JButton saveBtn = new JButton("Spara användare");
		saveBtn.setBackground(Tema.getButtonBG());
		saveBtn.setForeground(Tema.getText());
		saveBtn.setBorderPainted(false);
		saveBtn.setFont(btnFont);
	
		create.add(loginLabel);
		create.add(usernameLabel);
		create.add(usernameTxFd);
		create.add(passwordLabel);
		create.add(passwordTxFd);
		create.add(saveBtn);
	
		return create;
		

		}
	

	private void setupThemes()
	{
		Teman.add(new ColorThemes(new Color(51,226,16),new Color(30,144,255), new Color(38,106,208),  new Color(176,202,222), new Color(38, 134, 208), new Color(255,255,255)));
	/*
	 *  Color startGameBG = new Color(51,226,16); // grönt
	 *  Color topBG = new Color(30,144,255); //Ljusblå
 		Color BG = new Color(38,106,208); // Mörkblå
 		Color txFdBG = new Color(176,202,222); // ljusblå/grå
 		Color buttonBG = new Color(38, 134, 208); // klarblå
 		Color text = new Color(255,255,255); // Vitt
	 */
	
	}
	
}
