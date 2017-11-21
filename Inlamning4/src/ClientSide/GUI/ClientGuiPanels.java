package ClientSide.GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import ClientSide.Client;

public class ClientGuiPanels {

	private LinkedList<ColorThemes> Teman = new LinkedList<>();
	private ColorThemes Tema;
	private Font headingFont, labelFont, btnFont;
	private ClientGUI GUI;
	private ClientGuiTopPanels topPanels;
	private Client client;
	
	private Image imageLogo = null;
	
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
	private JButton saveBtn = new JButton("Spara användare");
	
	//VäljKategoriSidan
	private JButton kategori1 = new JButton("");
	private JButton kategori2 = new JButton("");
	private JButton kategori3 = new JButton("");
	
	//Settingssidan
	private JButton userInfo = new JButton("Användaruppgifter");
	private JButton avatar = new JButton("Välj din avatar");
	private JButton colors = new JButton("Byt Färgtema");
	private JButton premium = new JButton("Köp premium");
	private JButton help = new JButton("Hjälp");
	private JButton back = new JButton("Tillbaka");
	
	//LogedinSidan
	private JButton startaSpel = new JButton("Starta nytt spel");
	
	//Nyttspel sidan
	private JButton slumpadSpelare = new JButton("Slumpad spelare");
	
	//Top panel
	private JPanel topMenu;
	
	public ClientGuiPanels(ClientGUI GUI, Client client)
	{
		this.GUI = GUI;
		this.client = client;
		setupThemes();
		setTema(0);
		topPanels = new ClientGuiTopPanels(Tema, this.GUI);
	}
	public JPanel sidaStart(){
		loginBtn.removeActionListener(GUI);
		regBtn.removeActionListener(GUI);
		try {
			URL urlLogo= new URL("http://www.icon2s.com/wp-content/uploads/2012/09/Letter-Q-150x150.png");
			imageLogo = ImageIO.read(urlLogo);
		
		} catch (IOException e) {
			e.getMessage();
		}
		
		JPanel start = new JPanel();
		start.setLayout(new GridLayout(5,0,40,40));
		start.setBorder(new EmptyBorder(100,30,20,30));
		start.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 50);
		btnFont = new Font("Arial", Font.BOLD, 30);


		JLabel gameNameLabel = new JLabel("uizKampen");
		gameNameLabel.setIcon(new ImageIcon(imageLogo));
		gameNameLabel.setIconTextGap(0);
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
		
		usernameTxFdLog.setBackground(Tema.getTxFdBG());
		
		JLabel passwordLabel = new JLabel("Lösenord");
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Tema.getText());		
		passwordTxFdLog.setBackground(Tema.getTxFdBG());
		
		JPanel btnHolder = new JPanel();
        btnHolder.setLayout(new GridLayout(0,2));
        btnHolder.setBackground(Tema.getBG());

		loginUser.setBackground(Tema.getButtonBG());
		loginUser.setForeground(Tema.getText());
		loginUser.setBorderPainted(false);
		loginUser.setFont(btnFont);
		
		Back.setBackground(Tema.getButtonBG());
		Back.setForeground(Tema.getText());
		Back.setBorderPainted(false);
		Back.setFont(btnFont);
	
		btnHolder.add(loginUser);
		btnHolder.add(Back);
		
		login.add(loginLabel);
		login.add(usernameLabel);
		login.add(usernameTxFdLog);
		login.add(passwordLabel);
		login.add(passwordTxFdLog);
		login.add(btnHolder);
	
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
		create.setLayout(new GridLayout(6,0, 5, 5));
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
		
		usernameTxFdReg.setBackground(Tema.getTxFdBG());
		
		JLabel passwordLabel = new JLabel("Lösenord");
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Tema.getText());
		
		passwordTxFdReg.setBackground(Tema.getTxFdBG());
		
        JPanel btnHolder = new JPanel();
        btnHolder.setLayout(new GridLayout(0,2));
        btnHolder.setBackground(Tema.getBG());
		
		saveBtn.setBackground(Tema.getButtonBG());
		saveBtn.setForeground(Tema.getText());
		saveBtn.setBorderPainted(false);
		saveBtn.setFont(btnFont);
		
		Back.setBackground(Tema.getButtonBG());
		Back.setForeground(Tema.getText());
		Back.setBorderPainted(false);
		Back.setFont(btnFont);
		
        btnHolder.add(saveBtn);
        btnHolder.add(Back);
	
		create.add(loginLabel);
		create.add(usernameLabel);
		create.add(usernameTxFdReg);
		create.add(passwordLabel);
		create.add(passwordTxFdReg);
        create.add(btnHolder);

		saveBtn.addActionListener(GUI);
		Back.addActionListener(GUI);
		usernameTxFdReg.addActionListener(GUI);
		passwordTxFdReg.addActionListener(GUI);
		
		return create;
	}
	public JPanel sidaLogedin() {
		
		startaSpel.removeActionListener(GUI);	
		topMenu = topPanels.Top();

		JPanel logedInPanel = new JPanel();
		logedInPanel.setLayout(new GridLayout(0,1));
		logedInPanel.setBackground(Tema.getBG());
		Font smalFont = new Font("Arial", Font.BOLD, 15);
		headingFont = new Font("Arial", Font.BOLD, 30);
		btnFont = new Font("Arial", Font.BOLD, 17);

		JLabel userLabel = new JLabel("Användarnamn: " + client.getUserName());
		Border border = userLabel.getBorder();
		Border margin = new EmptyBorder(10,70,0,0);
		userLabel.setBorder(new CompoundBorder(border, margin));
		userLabel.setForeground(Tema.getTxFdBG());
		userLabel.setFont(smalFont);

		JLabel username = new JLabel(client.getUserName());
		Border labelBorder = userLabel.getBorder();
		Border labelMargin = new EmptyBorder(20,0,0,0);
		username.setBorder(new CompoundBorder(labelBorder, labelMargin));
		username.setFont(headingFont);
		username.setForeground(Tema.getText());
	
		startaSpel = new JButton("Starta nytt spel");
		startaSpel.setForeground(Tema.getText());
		startaSpel.setBackground(Tema.getButtonBG());
		startaSpel.setBorderPainted(true);
		startaSpel.setFont(headingFont);
		startaSpel.setBackground(Tema.getStartGameBG());
		
		JButton dinTur = new JButton("Din tur mot User1");
		dinTur.setBackground(Tema.getButtonBG());
		dinTur.setForeground(Tema.getText());
		dinTur.setFont(btnFont);
		dinTur.setBorderPainted(false);
		
		JButton dinTur2 = new JButton("Din tur mot User2");
		dinTur2.setBackground(Tema.getButtonBG());
		dinTur2.setForeground(Tema.getText());
		dinTur2.setFont(btnFont);
		dinTur2.setBorderPainted(false);
		dinTur2.setAlignmentX(40);

		JLabel aktivaSpelLabel = new JLabel("Aktiva spel");
		aktivaSpelLabel.setBorder(new CompoundBorder(labelBorder, labelMargin));
		aktivaSpelLabel.setForeground(Tema.getTxFdBG());
		aktivaSpelLabel.setFont(btnFont);
		
		JLabel avslutadeSpelLabel = new JLabel("Avslutade spel");
		avslutadeSpelLabel.setBorder(new CompoundBorder(labelBorder, labelMargin));
		avslutadeSpelLabel.setForeground(Tema.getTxFdBG());
		avslutadeSpelLabel.setFont(smalFont);
		
		JButton avslutadSpel = new JButton("x förlorade mot User1");
		avslutadSpel.setBackground(Tema.getButtonBG());
		avslutadSpel.setForeground(Tema.getText());
		avslutadSpel.setFont(btnFont);
		avslutadSpel.setBorderPainted(false);

		startaSpel.addActionListener(GUI);
		
		logedInPanel.add(topMenu);
		logedInPanel.add(userLabel);
		logedInPanel.add(username);
		logedInPanel.add(startaSpel);
		logedInPanel.add(dinTur);
		logedInPanel.add(dinTur2);
		logedInPanel.add(aktivaSpelLabel);
		if(client.getMatcher() != null)
		{
			JButton[] ActiveMatches = new JButton[client.getMatcher().size()];
			for(int i = client.getMatcher().size()-1;i>=0;i--)
			{
				ActiveMatches[i] = new JButton(client.getMatcher().get(i).getOpponent());
				ActiveMatches[i].setBackground(Tema.getButtonBG());
				ActiveMatches[i].setForeground(Tema.getText());
				ActiveMatches[i].setFont(btnFont);
				ActiveMatches[i].setBorderPainted(false);
				logedInPanel.add(ActiveMatches[i]);
			}
		}
		logedInPanel.add(avslutadeSpelLabel);
		logedInPanel.add(avslutadSpel);
		
		return logedInPanel;
	}
	public JPanel sidaNyttSpel() {
		
		back.removeActionListener(GUI);
		slumpadSpelare.removeActionListener(GUI);
		
		JPanel topMenu = new JPanel();
		topMenu = topPanels.TopwithoutButtons();

		JPanel newGamePanel = new JPanel();
		newGamePanel.setLayout(new GridLayout(11,0));
		newGamePanel.setBorder(new EmptyBorder(0,0,80,0));
		newGamePanel.setBackground(Tema.getBG());
		btnFont = new Font("Arial", Font.BOLD, 22);
		labelFont = new Font("Arial", Font.BOLD, 18);
		
		JLabel empty = new JLabel();
		JLabel spelaMed = new JLabel("Vem vill du spela med?");
		Border border = spelaMed.getBorder();
		Border margin = new EmptyBorder(20,30,0,20);
		spelaMed.setBorder(new CompoundBorder(border, margin));
		spelaMed.setFont(labelFont);
		spelaMed.setForeground(Tema.getText());
		
		JButton sökSpelare = new JButton("Sök spelare");
		sökSpelare.setBackground(Tema.getTopBG());
		sökSpelare.setForeground(Tema.getText());
		sökSpelare.setFont(btnFont);
		sökSpelare.setBorderPainted(false);
		
		slumpadSpelare.setBackground(Tema.getTopBG());
		slumpadSpelare.setForeground(Tema.getText());
		slumpadSpelare.setFont(btnFont);
		slumpadSpelare.setBorderPainted(false);
		
		JLabel empty1 = new JLabel();
		JLabel vänner = new JLabel("Vänner");
		border = vänner.getBorder();
		margin = new EmptyBorder(20,30,0,20);
		vänner.setBorder(new CompoundBorder(border, margin));
		vänner.setFont(labelFont);
		vänner.setForeground(Tema.getText());

		JButton bjudInVänner = new JButton("Bjud in vänner");
		bjudInVänner.setBackground(Tema.getTopBG());
		bjudInVänner.setForeground(Tema.getText());
		bjudInVänner.setFont(btnFont);
		bjudInVänner.setBorderPainted(false);
		
		JButton user1 = new JButton("User1");
		user1.setBackground(Tema.getTopBG());
		user1.setForeground(Tema.getText());
		user1.setFont(btnFont);
		user1.setBorderPainted(false);
		JLabel empty2 = new JLabel("");
		
		back = new JButton("Tillbaka");
		back.setBackground(Tema.getTopBG());
		back.setForeground(Tema.getText());
		back.setFont(btnFont);
		back.setBorderPainted(false);
		
		newGamePanel.add(topMenu);
		newGamePanel.add(empty);
		newGamePanel.add(spelaMed);
		newGamePanel.add(sökSpelare);
		newGamePanel.add(slumpadSpelare);
		newGamePanel.add(empty1);
		newGamePanel.add(vänner);
		newGamePanel.add(bjudInVänner);
		newGamePanel.add(user1);
		newGamePanel.add(empty2);
		newGamePanel.add(back); 
		
		back.addActionListener(GUI);
		slumpadSpelare.addActionListener(GUI);
		return newGamePanel;
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
		userInfo.setMargin(new Insets(30, 30, 30, 30));
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
	public JPanel sidaVäljKategori() {
		JPanel väljKat = new JPanel();
		väljKat.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.BOLD, 17);
		väljKat.setFont(headingFont);
		
		JLabel väljkategori = new JLabel("Välj kategori mot: ");
		JLabel användarnamn = new JLabel("");
		väljKat.setForeground(Tema.getText());
		
		JButton kategori1 = new JButton();
		kategori1.setBackground(Tema.getChangeCate1());// change these colors
		kategori1.setForeground(Tema.getText());
		
		JButton kategori2 = new JButton();
		kategori2.setBackground(Tema.getChangeCate2());
		kategori2.setForeground(Tema.getText());
		
		JButton kategori3 = new JButton();
		kategori3.setBackground(Tema.getChangeCate3());
		kategori3.setForeground(Tema.getText());
		
		väljKat.add(väljkategori);
		väljKat.add(användarnamn);
		väljKat.add(kategori1);
		väljKat.add(kategori2);
		väljKat.add(kategori3);
		
		kategori1.addActionListener(GUI);
		kategori2.addActionListener(GUI);
		kategori3.addActionListener(GUI);
		
		return väljKat;
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
	public JButton getStartaSpel() {
		return startaSpel;
	}
	public JButton getKategori1() {
		return kategori1;
	}
	public JButton getKategori2() {
		return kategori2;
	}
	public JButton getKategori3() {
		return kategori3;
	}
	public JButton getSlumpadSpelare() {
		return slumpadSpelare;
	}
	public ClientGuiTopPanels getTopPanels()
	{
		return topPanels;
	}
	private void setupThemes(){
		Color startGameBG = new Color(51,226,16);// grönt
		Color topBG = new Color(30,144,255); //Ljusblå
		Color BG = new Color(38,106,208); // Mörkblå
		Color txFdBG = new Color(176,202,222); // ljusblå/grå
		Color buttonBG = new Color(38, 134, 208); // klarblå
		Color text = new Color(255,255,255); // Vitt
		Color buttonChangeCategory1 = new Color(255, 128,0);
		Color buttonChangeCategory2 = new Color(255, 0, 255);
		Color buttonChangeCategory3 = new Color(0, 153, 153);
		Teman.add(new ColorThemes(startGameBG, topBG, BG, txFdBG, buttonBG, buttonChangeCategory1, buttonChangeCategory2,buttonChangeCategory3, text));
	}
	public void setTema(int id)
	{
		Tema = Teman.get(id);
	}
}
