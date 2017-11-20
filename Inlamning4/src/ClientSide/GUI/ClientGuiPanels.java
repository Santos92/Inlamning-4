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

import ClientSide.Client;

public class ClientGuiPanels {

	private LinkedList<ColorThemes> Teman = new LinkedList<>();
	private ColorThemes Tema;
	private Font headingFont, labelFont, btnFont;
	private ClientGUI GUI;
	private Client client;
	private ClientGuiTopPanels topPanels;
	
	// Startsidan
	private JButton regBtn = new JButton("Nytt konto");
	private JButton loginBtn = new JButton("Logga in");
	
	//Loginsidan
	private JTextField passwordTxFdLog = new JTextField();
	private JTextField usernameTxFdLog = new JTextField();
	private JButton loginUser = new JButton("Logga in");
	
	private JButton Back = new JButton("Tillbaka");
	
	//RegSidan
	private JTextField usernameTxFdReg = new JTextField();
	private JTextField passwordTxFdReg = new JTextField();
	private JButton saveBtn = new JButton("Spara anv�ndare");
	
	//LogedinSidan
	private JButton startaSpel = new JButton("Starta nytt spel");
	private JButton dinTur = new JButton("Din tur");
	private JButton reklam = new JButton("Reklam");
	private JButton aktivaSpel = new JButton("Aktiva Spel");
	
	//Settingssidan
	private JButton userInfo = new JButton("Anv�ndaruppgifter");
	private JButton avatar = new JButton("V�lj din avatar");
	private JButton colors = new JButton("Byt F�rgtema");
	private JButton premium = new JButton("K�p premium");
	private JButton help = new JButton("Hj�lp");
	private JButton back = new JButton("Tillbaka");
	
	//sidaNyttSpel
//	body.add(s�kSpelare);
//	body.add(facebookV�nner);
//	body.add(slumpadSpelare);
//	body.add(v�nner);
//	body.add(bjudInV�nner);
//	body.add(user1);
	private JButton slumpaSpelare = new JButton("Slumpa ny spelare");
	
	
	public ClientGuiPanels(ClientGUI GUI, Client client)
	{

		this.client = client;
		this.GUI = GUI;
		setupThemes();
		setTema(0);
		topPanels = new ClientGuiTopPanels(GUI);
	}
	public JPanel sidaStart(){

		loginBtn.removeActionListener(GUI);
		regBtn.removeActionListener(GUI);
		
		JPanel start = new JPanel();
		start.setLayout(new GridLayout(4,0,40,40));
		start.setBorder(new EmptyBorder(150,30,20,30));
		start.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 50);
		btnFont = new Font("Arial", Font.BOLD, 30);

		JLabel gameNameLabel = new JLabel("QuizKampen");
		gameNameLabel.setFont(headingFont);
		gameNameLabel.setForeground(Tema.getText());
		
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
		
		loginBtn.addActionListener(GUI);
		regBtn.addActionListener(GUI);
		
		return start;
	}
	
	public JPanel sidaLogin() {
		
		loginUser.removeActionListener(GUI);
		Back.removeActionListener(GUI);
		usernameTxFdLog.removeActionListener(GUI);
		passwordTxFdLog.removeActionListener(GUI);
		
		JPanel login = new JPanel();
		login.setLayout(new GridLayout(7,0, 5, 5));
		login.setBorder(new EmptyBorder(200,30,20,30));
		login.setBackground(Tema.getBG());
		login.setPreferredSize(new Dimension(500, 500));
		headingFont = new Font("Arial", Font.BOLD, 25);
		labelFont = new Font("Arial", Font.BOLD, 17);
		btnFont = new Font("Arial", Font.BOLD, 25);

		JLabel loginLabel = new JLabel("Logga in");
		loginLabel.setFont(headingFont);		
		loginLabel.setForeground(Tema.getText());
		
		JLabel usernameLabel = new JLabel("Anv�ndarnamn");
		usernameLabel.setFont(labelFont);
		usernameLabel.setForeground(Tema.getText());
		
		usernameTxFdLog.setBackground(Tema.getTxFdBG());
		
		JLabel passwordLabel = new JLabel("L�senord");
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Tema.getText());
		
		passwordTxFdLog.setBackground(Tema.getTxFdBG());

		loginUser.setBackground(Tema.getButtonBG());
		loginUser.setForeground(Tema.getText());
		loginUser.setBorderPainted(false);
		loginUser.setFont(btnFont);
		
		Back.setBackground(Tema.getButtonBG());
		Back.setForeground(Tema.getText());
		Back.setBorderPainted(false);
		Back.setFont(btnFont);
	
		login.add(loginLabel);
		login.add(usernameLabel);
		login.add(usernameTxFdLog);
		login.add(passwordLabel);
		login.add(passwordTxFdLog);
		login.add(loginUser);
		login.add(Back);
	
		loginUser.addActionListener(GUI);
		Back.addActionListener(GUI);
		usernameTxFdLog.addActionListener(GUI);
		passwordTxFdLog.addActionListener(GUI);
		
		return login;
	}
	
	public JPanel sidaSkapa() {
			
		saveBtn.removeActionListener(GUI);
		Back.removeActionListener(GUI);
		usernameTxFdReg.removeActionListener(GUI);
		passwordTxFdReg.removeActionListener(GUI);
		
		JPanel create = new JPanel();
		create.setLayout(new GridLayout(9,0, 5, 5));
		create.setBorder(new EmptyBorder(200,30,20,30));
		create.setBackground(Tema.getBG());
		create.setPreferredSize(new Dimension(500, 500));
		headingFont = new Font("Arial", Font.BOLD, 25);
		labelFont = new Font("Arial", Font.BOLD, 17);
		btnFont = new Font("Arial", Font.BOLD, 25);

		JLabel loginLabel = new JLabel("Nytt Konto");
		loginLabel.setFont(headingFont);		
		loginLabel.setForeground(Tema.getText());
		
		JLabel usernameLabel = new JLabel("Anv�ndarnamn: " + "");
		usernameLabel.setFont(labelFont);
		usernameLabel.setForeground(Tema.getText());
		
		usernameTxFdReg.setBackground(Tema.getTxFdBG());
		
		JLabel passwordLabel = new JLabel("L�senord");
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Tema.getText());
		
		passwordTxFdReg.setBackground(Tema.getTxFdBG());
		
		
		saveBtn.setBackground(Tema.getButtonBG());
		saveBtn.setForeground(Tema.getText());
		saveBtn.setBorderPainted(false);
		saveBtn.setFont(btnFont);
		
		Back.setBackground(Tema.getButtonBG());
		Back.setForeground(Tema.getText());
		Back.setBorderPainted(false);
		Back.setFont(btnFont);
	
		create.add(loginLabel);
		create.add(usernameLabel);
		create.add(usernameTxFdReg);
		create.add(passwordLabel);
		create.add(passwordTxFdReg);
		create.add(saveBtn);
		create.add(Back);
	
		saveBtn.addActionListener(GUI);
		Back.addActionListener(GUI);
		usernameTxFdReg.addActionListener(GUI);
		passwordTxFdReg.addActionListener(GUI);
		
		return create;
		}
	
	public JPanel sidaNyttSpel() {
		slumpaSpelare.removeActionListener(GUI);
		JPanel body = new JPanel();
		body.setLayout(new GridLayout(10,1));
		body.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.BOLD, 17);
		JButton s�kSpelare = new JButton("S�k spelare");
		s�kSpelare.setBackground(Tema.getBG());
		s�kSpelare.setForeground(Tema.getText());
		
		JButton facebookV�nner = new JButton("Facebook-v�nner");
		facebookV�nner.setBackground(Tema.getBG());
		facebookV�nner.setForeground(Tema.getText());
		
		slumpaSpelare.setBackground(Tema.getBG());
		slumpaSpelare.setForeground(Tema.getText());
		
		JLabel v�nner = new JLabel("V�nner");
		v�nner.setFont(labelFont);
		v�nner.setForeground(Tema.getText());
		
		JButton bjudInV�nner = new JButton("Bjud in v�nner");
		bjudInV�nner.setBackground(Tema.getBG());
		bjudInV�nner.setForeground(Tema.getText());
		
		JButton user1 = new JButton("User1");
		user1.setBackground(Tema.getBG());
		user1.setForeground(Tema.getText());
		body.add(s�kSpelare);
		body.add(facebookV�nner);
		body.add(slumpaSpelare);
		body.add(v�nner);
		body.add(bjudInV�nner);
		body.add(user1);
		
		slumpaSpelare.addActionListener(GUI);

		return body;
	}
	
	public JPanel sidaLogedin() {	
		startaSpel.removeActionListener(GUI);
		dinTur.removeActionListener(GUI);
		startaSpel.removeActionListener(GUI);
		reklam.removeActionListener(GUI);
		
		JPanel start = new JPanel();
		start.setLayout(new GridLayout(8,1));
		start.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.BOLD, 17);
		
		JLabel anv�ndare = new JLabel("Anv�ndarnamn: ");
		anv�ndare.setForeground(Tema.getText());
		JLabel anv�ndarnamn = new JLabel(" ");
		anv�ndare.setForeground(Tema.getText());
		
		startaSpel.setBackground(Tema.getStartGameBG());
		startaSpel.setForeground(Tema.getText());
		startaSpel.setBorderPainted(false);
		startaSpel.setFont(headingFont);
		
		dinTur.setBackground(Tema.getButtonBG());
		dinTur.setForeground(Tema.getText());
		
		JLabel aktivaSpelLabel = new JLabel("Aktiva spel");
		aktivaSpelLabel.setForeground(Tema.getText());
		
		aktivaSpel.setBackground(Tema.getButtonBG());
		aktivaSpel.setForeground(Tema.getText());
		
		reklam.setBackground(Tema.getButtonBG());
		reklam.setForeground(Tema.getText());
		
		start.add(topPanels.Top());
		start.add(anv�ndare);
		start.add(anv�ndarnamn);
		start.add(startaSpel);
		start.add(dinTur);
		start.add(aktivaSpelLabel);
		start.add(aktivaSpel);
		start.add(reklam);
		
		startaSpel.addActionListener(GUI);
		dinTur.addActionListener(GUI);
		aktivaSpel.addActionListener(GUI);
		reklam.addActionListener(GUI);
		
		return start;
	}
	
	public JPanel sidaSettings() {
		
		userInfo.removeActionListener(GUI);
		avatar.removeActionListener(GUI);
		colors.removeActionListener(GUI);
		premium.removeActionListener(GUI);
		help.removeActionListener(GUI);
		back.removeActionListener(GUI);
		
		JPanel settings = new JPanel();
		settings.setLayout(new GridLayout(8,0,0,5));
		settings.setBorder(new EmptyBorder(5,10,5,10));
		settings.setBackground(Tema.getBG());
		settings.setPreferredSize(new Dimension(500, 800));
		btnFont = new Font("Arial", Font.BOLD, 30);
				
		userInfo.setBackground(Tema.getButtonBG());
		userInfo.setFont(btnFont);
		userInfo.setForeground(Tema.getText());
		userInfo.setBorderPainted(false);
		userInfo.setFont(btnFont);		
				
		avatar.setBackground(Tema.getButtonBG());
		avatar.setFont(btnFont);
		avatar.setForeground(Tema.getText());
		avatar.setBorderPainted(false);
				
		colors.setBackground(Tema.getButtonBG());
		colors.setFont(btnFont);
		colors.setForeground(Tema.getText());
		colors.setBorderPainted(false);
		
		premium.setBackground(Tema.getButtonBG());
		premium.setFont(btnFont);
		premium.setForeground(Tema.getText());
		premium.setBorderPainted(false);
		
		help.setBackground(Tema.getButtonBG());
		help.setFont(btnFont);
		help.setForeground(Tema.getText());
		help.setBorderPainted(false);
				
		back.setBackground(Tema.getButtonBG());
		back.setFont(btnFont);
		back.setForeground(Tema.getText());
		back.setBorderPainted(false);
				
		settings.add(topPanels.TopwithoutButtons());
		settings.add(userInfo);
		settings.add(avatar);
		settings.add(colors);
		settings.add(premium);
		settings.add(help);
		settings.add(back);
		
		userInfo.addActionListener(GUI);
		avatar.addActionListener(GUI);
		colors.addActionListener(GUI);
		premium.addActionListener(GUI);
		help.addActionListener(GUI);
		back.addActionListener(GUI);
		
		return settings;
	}
	
	public JButton getRegBtn() {
		return regBtn;
	}

	public JButton getLoginBtn() {
		return loginBtn;
	}

	public JTextField getPasswordTxFdLog() {
		return passwordTxFdLog;
	}

	public JTextField getUsernameTxFdLog() {
		return usernameTxFdLog;
	}

	public JButton getLoginUser() {
		return loginUser;
	}

	public JButton getBack() {
		return Back;
	}

	public JTextField getUsernameTxFdReg() {
		return usernameTxFdReg;
	}

	public JTextField getPasswordTxFdReg() {
		return passwordTxFdReg;
	}

	public JButton getSaveBtn() {
		return saveBtn;
	}
	
	public JButton getSlumpaSpelare() {
		return slumpaSpelare;
	}
	
	public JButton getStartaSpel() {
		return startaSpel;
	}
	
	public JButton getDinTur() {
		return dinTur;
	}
	
	public JButton getAktivaSpel() {
		return aktivaSpel;
	}
	
	public JButton getReklam() {
		return reklam;
	}
	
	
	public JButton getSettingsUserInfo() {
		return userInfo;
	}
	
	public JButton getSettingsAvatar() {
		return avatar;
	}
	
	public JButton getSettingsColors() {
		return colors;
	}
	
	public JButton getSettingsPremium() {
		return premium;
	}
	
	public JButton getSettingsHelp() {
		return help;
	}
	
	public JButton getSettingsBack() {
		return back;
	}
	public ClientGuiTopPanels getTopPanels()
	{
		return topPanels;
	}
	
	private void setupThemes(){
		Color startGameBG = new Color(51,226,16);// gr�nt
		Color topBG = new Color(30,144,255); //Ljusbl�
		Color BG = new Color(38,106,208); // M�rkbl�
		Color txFdBG = new Color(176,202,222); // ljusbl�/gr�
		Color buttonBG = new Color(38, 134, 208); // klarbl�
		Color text = new Color(255,255,255); // Vitt
		
		Teman.add(new ColorThemes(startGameBG, topBG, BG, txFdBG, buttonBG, text));
	}
	public void setTema(int id)
	{
		Tema = Teman.get(id);
	}
}
