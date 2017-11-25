package ClientSide.GUI;

import java.awt.BorderLayout;
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
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import ClientSide.Client;
import Communication.Questions.Questions;
import Communication.Questions.Round;

public class ClientGuiPanels {

	private LinkedList<ColorThemes> Teman = new LinkedList<>();
	private ColorThemes Tema;
	private Font headingFont, labelFont, btnFont;
	private ClientGUI GUI;
	private ClientGuiTopPanels topPanels;
	private Client client;
	private Image imageLogo = null;
	private Round round; // skapade Round object
	private Questions questions;
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
	private JButton kategori1 = new JButton("Mat");
	private JButton kategori2 = new JButton("Teknik");
	private JButton kategori3 = new JButton("Historia");
	private JButton goBack = new JButton("Tillbaka");
	
	//Settingssidan
	private JButton userInfo = new JButton("Användaruppgifter");
	private JButton avatar = new JButton("Välj din avatar");
	private JButton colors = new JButton("Byt Färgtema");
	private JButton premium = new JButton("Köp premium");
	private JButton help = new JButton("Hjälp");
	private JButton back = new JButton("Tillbaka");
	
	//LogedinSidan
	private JButton startaSpel = new JButton("Starta nytt spel");
	private JButton dinTur = new JButton("");
	private JButton dinTur2 = new JButton("");
	private JButton avslutadSpel = new JButton("x förlorade mot User1");
	
	//Nyttspel sidan
	private JButton slumpadSpelare = new JButton("Slumpad spelare");
	
	//Top panel
	private JPanel topMenu;
	
	//FrågeSpelSida
	private JButton answer1 = new JButton("");
	private JButton answer2 = new JButton("");
	private JButton answer3 = new JButton("");
	private JButton answer4 = new JButton("");
	private JButton backBack = new JButton("Tillbaka");
	
	//PoängMotståndareSida
	private JButton spela = new JButton("Spela");
	private JButton geUpp = new JButton("Ge Upp");
	private JButton goReturn = new JButton("Tillbaka");
	
	// DinStatistikSida
	private JButton dinStatistik = new JButton("Din Statistik");
	private JButton omspel = new JButton("Omspel");
	private JButton statback = new JButton("Tillbaka");
	
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
		dinTur.removeActionListener(GUI);
		dinTur2.removeActionListener(GUI);
		avslutadSpel.removeActionListener(GUI);
		
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
		
		JLabel yourTurn = new JLabel("Din tur mot: ");
		yourTurn.setBorder(new CompoundBorder(border, margin));
		labelFont = new Font("Arial", Font.BOLD, 17);
		yourTurn.setFont(labelFont);
		yourTurn.setBackground(Tema.getBG());
		yourTurn.setForeground(Tema.getText());
		dinTur.setBackground(Tema.getButtonBG());
		dinTur.setForeground(Tema.getText());
		dinTur.setFont(btnFont);
		dinTur.setBorderPainted(false);
		
	
		dinTur2.setBackground(Tema.getButtonBG());
		dinTur2.setForeground(Tema.getText());
		dinTur2.setFont(btnFont);
		dinTur2.setBorderPainted(false);
		dinTur2.setAlignmentX(40);
		yourTurn.add(dinTur);
		yourTurn.add(dinTur2);
		
		JLabel aktivaSpelLabel = new JLabel("Aktiva spel");
		aktivaSpelLabel.setBorder(new CompoundBorder(labelBorder, labelMargin));
		aktivaSpelLabel.setForeground(Tema.getTxFdBG());
		aktivaSpelLabel.setFont(btnFont);
		
		JLabel avslutadeSpelLabel = new JLabel("Avslutade spel");
		avslutadeSpelLabel.setBorder(new CompoundBorder(labelBorder, labelMargin));
		avslutadeSpelLabel.setForeground(Tema.getTxFdBG());
		avslutadeSpelLabel.setFont(smalFont);
		
		
		avslutadSpel.setBackground(Tema.getButtonBG());
		avslutadSpel.setForeground(Tema.getText());
		avslutadSpel.setFont(btnFont);
		avslutadSpel.setBorderPainted(false);
		avslutadeSpelLabel.add(avslutadSpel);
		
		startaSpel.addActionListener(GUI);
		dinTur.addActionListener(GUI);
		dinTur2.addActionListener(GUI);
		avslutadSpel.addActionListener(GUI);
		
		logedInPanel.add(topMenu);
		logedInPanel.add(userLabel);
		logedInPanel.add(username);
		logedInPanel.add(startaSpel);
		logedInPanel.add(yourTurn);
		logedInPanel.add(dinTur);
		logedInPanel.add(dinTur2);
		logedInPanel.add(aktivaSpelLabel);
		logedInPanel.add(avslutadeSpelLabel);
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
		kategori1.removeActionListener(GUI); 
        kategori2.removeActionListener(GUI);
        kategori3.removeActionListener(GUI);
        goBack.removeActionListener(GUI);   
        
		JPanel väljKat = new JPanel();
		väljKat.setLayout(new GridLayout(6,0, 10,10));
		väljKat.setPreferredSize(new Dimension(500, 500));
		väljKat.setBorder(new EmptyBorder(6,10,25,10));
		väljKat.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.PLAIN, 12);
		väljKat.setFont(headingFont);
		
		JLabel väljkategori = new JLabel("Välj kategori mot: ");
		väljkategori.setFont(headingFont);
		väljkategori.setForeground(Tema.getText());
		JLabel användarnamn = new JLabel("");
		användarnamn.setFont(headingFont);
		användarnamn.setForeground(Tema.getText());
		väljKat.setForeground(Tema.getText());
		
		kategori1.setBorder(new EmptyBorder(20,10,30,10));
		kategori1.setBackground(Tema.getChangeCate1());// change these colors
		kategori1.setForeground(Tema.getText());
		
		kategori2.setBorder(new EmptyBorder(20,10,30,10));
		kategori2.setBackground(Tema.getChangeCate2());
		kategori2.setForeground(Tema.getText());
				
		kategori3.setBorder(new EmptyBorder(20,10,30,10));
		kategori3.setBackground(Tema.getChangeCate3());
		kategori3.setForeground(Tema.getText());
		
		goBack.setBorder(new EmptyBorder(20,10,30,10));
		goBack.setBackground(Tema.getTopBG());
		goBack.setForeground(Tema.getText());
		
		väljKat.add(väljkategori);
		väljKat.add(användarnamn);
		väljKat.add(kategori1);
		väljKat.add(kategori2);
		väljKat.add(kategori3);
		väljKat.add(goBack);
		
		kategori1.addActionListener(GUI);
		kategori2.addActionListener(GUI);
		kategori3.addActionListener(GUI);
		goBack.addActionListener(GUI); 
		
		return väljKat;
	}
	
	public JPanel sidaSvaraFråga() {
		answer1.removeActionListener(GUI); 
        answer2.removeActionListener(GUI);
        answer3.removeActionListener(GUI);
        answer4.removeActionListener(GUI);
        backBack.removeActionListener(GUI);
        
        JPanel svaraFrågan = new JPanel();
	    JPanel question = new JPanel();
	    JLabel questionCategory = new JLabel("Category");
	    JTextField actualQuestion = new JTextField("");// change this to JLabel whose question changes
	    JPanel answers = new JPanel();
	    JPanel timeLimit = new JPanel();
	    JTextField timeLimiter = new JTextField("Time limiter");
	    
	    svaraFrågan.setLayout(new BorderLayout());
	    svaraFrågan.setPreferredSize(new Dimension(500, 500));
	    svaraFrågan.add(question, BorderLayout.NORTH);
	    svaraFrågan.add(answers, BorderLayout.CENTER);
	    svaraFrågan.add(timeLimit, BorderLayout.SOUTH);
        svaraFrågan.setBackground(Tema.getBG());
        
        question.setLayout(new GridLayout(2,1, 10,10));
        question.setBorder(new EmptyBorder(5,10,25,10));
        questionCategory.setBackground(Color.orange);
        actualQuestion.setBackground(Color.white);
        question.add(questionCategory);
        question.add(actualQuestion);
                
        answers.setLayout(new GridLayout(2,2,10,10));
        answers.setBorder(new EmptyBorder(20,10,100,10));
        answers.setBackground(Tema.getBG());
        btnFont = new Font("Arial", Font.PLAIN, 12);
        labelFont = new Font("Arial", Font.BOLD, 12);
        
        answer1.setBackground(Tema.getButtonBlack()); 
        answer1.setFont(btnFont);
        answer1.setLayout(new GridLayout(20,20,5,5));
        answer1.setForeground(Tema.getText());
        
        answer2.setBackground(Tema.getButtonBlack());
        answer2.setFont(btnFont);
        answer2.setLayout(new GridLayout(20,20,5,5));
        answer2.setForeground(Tema.getText());
        
        answer3.setBackground(Tema.getButtonBlack());
        answer3.setFont(btnFont);
        answer3.setLayout(new GridLayout(20,20,5,5));
        answer3.setForeground(Tema.getText());
        
        answer4.setBackground(Tema.getButtonBlack());
        answer4.setFont(btnFont);
        answer4.setLayout(new GridLayout(20,20,5,5));
        answer4.setForeground(Tema.getText());
        
        backBack.setBackground(Tema.getTopBG());
        backBack.setFont(btnFont);
        backBack.setLayout(new GridLayout(20,20,5,5));
        backBack.setForeground(Tema.getText());
        
        answers.add(answer1); answers.add(answer2);
        answers.add(answer3); answers.add(answer4);
        
        
        timeLimit.setLayout(new GridLayout(2,1,10,10));
        timeLimit.setBorder(new EmptyBorder(5,10,5,10));
        timeLimit.add(backBack); timeLimit.add(timeLimiter);
        // svaraFrågan.add(question);
        svaraFrågan.add(answers);
        //  svaraFrågan.add(timeLimit);
             
         answer1.addActionListener(GUI);
         answer2.addActionListener(GUI);
         answer3.addActionListener(GUI);
         answer4.addActionListener(GUI);
         backBack.addActionListener(GUI);
         
         return svaraFrågan;
	}
	public JPanel sidaKampMotståndare() {
		spela.removeActionListener(GUI); 
        geUpp.removeActionListener(GUI);
        goReturn.removeActionListener(GUI);
        
        JPanel spelMotståndare = new JPanel();
        spelMotståndare.setLayout(new BorderLayout());
        spelMotståndare.setLayout(new GridLayout(3,0));
        spelMotståndare.setBackground(Tema.getBG());
        
        JPanel namesAndPoints = new JPanel(); 
        JPanel geUppStarta = new JPanel();
        JPanel ronder = new JPanel();
        JLabel användare1 = new JLabel("Användare1"); // Här ska riktiga användarnamnet stå
        användare1.setHorizontalAlignment(JLabel.CENTER);
        labelFont = new Font("Arial", Font.BOLD, 15);
        headingFont = new Font("Arial", Font.BOLD, 22);
        användare1.setForeground(Tema.getText());
        användare1.setFont(labelFont);
        
        JLabel användare2 = new JLabel("Användare2");
        användare2.setHorizontalAlignment(JLabel.CENTER);
        användare2.setForeground(Tema.getText());
        användare2.setFont(labelFont);
        
        JLabel poäng = new JLabel("Poäng");
        poäng.setHorizontalAlignment(JLabel.CENTER);
        poäng.setForeground(Tema.getText());
        poäng.setFont(headingFont);
        
        JLabel totalaPoängAnvändare1 = new JLabel("0/2");// I stället för knappar kan vi ha en JLabel som ändrar värde e.g. 1/2
        totalaPoängAnvändare1.setHorizontalAlignment(JLabel.CENTER);
        totalaPoängAnvändare1.setBackground(Tema.getVeryDarkBlue());
        totalaPoängAnvändare1.setFont(labelFont);
        totalaPoängAnvändare1.setForeground(Tema.getText());
        
        JLabel totalaPoängAnvändare2 = new JLabel("2/2");
        totalaPoängAnvändare2.setHorizontalAlignment(JLabel.CENTER);
        totalaPoängAnvändare2.setBackground(Tema.getVeryDarkBlue());
        totalaPoängAnvändare2.setFont(labelFont);
        totalaPoängAnvändare2.setForeground(Tema.getText());
        
        JLabel rondNummer = new JLabel("Rond 1"); 
        rondNummer.setHorizontalAlignment(JLabel.CENTER);
        rondNummer.setLayout(new GridLayout(0,1, 10, 10));
        rondNummer.setBorder(new EmptyBorder(5,10,10,5));
        rondNummer.setFont(labelFont);
        rondNummer.setBackground(Tema.getVeryDarkBlue());
        rondNummer.setForeground(Tema.getText());
        
        
        spelMotståndare.setPreferredSize(new Dimension(500, 500));
        spelMotståndare.add(namesAndPoints, BorderLayout.NORTH);
        spelMotståndare.add(ronder, BorderLayout.CENTER);
        spelMotståndare.add(geUppStarta, BorderLayout.SOUTH);
        namesAndPoints.setBackground(Tema.getBG());
        geUppStarta.setBackground(Tema.getBG());
        ronder.setBackground(Tema.getVeryDarkBlue());
        
        namesAndPoints.setLayout(new GridLayout(0,3));
        namesAndPoints.add(användare1); namesAndPoints.add(poäng); namesAndPoints.add(användare2); 
        
        ronder.setLayout(new GridLayout(0,3));
        ronder.add(totalaPoängAnvändare1);ronder.add(rondNummer); ronder.add(totalaPoängAnvändare2);
        
        geUppStarta.setLayout(new GridLayout(0,3, 10, 10));
        geUppStarta.setBorder(new EmptyBorder(50,10,10,10));
        geUppStarta.add(geUpp); geUppStarta.add(spela); geUppStarta.add(goReturn);
        
        geUpp.setBackground(Tema.getButtonRed()); 
        geUpp.setFont(labelFont);
        geUpp.setForeground(Tema.getText());
        geUpp.setLayout(new GridLayout(1,1,100,100));
                
        spela.setBackground(Tema.getStartGameBG());
        spela.setFont(headingFont);
        spela.setForeground(Tema.getText());
        spela.setLayout(new GridLayout(1,1,50,50));
       
        goReturn.setBackground(Tema.getTopBG());
        goReturn.setFont(labelFont);
        goReturn.setForeground(Tema.getText());
        goReturn.setLayout(new GridLayout(1,1,100,100));
        
        spelMotståndare.add(namesAndPoints);
        spelMotståndare.add(ronder);
        spelMotståndare.add(geUppStarta);
        
        spela.addActionListener(GUI);
        geUpp.addActionListener(GUI);
        goReturn.addActionListener(GUI);
        
         return spelMotståndare;
	}
	public JPanel sidaStatistik() {
		dinStatistik.removeActionListener(GUI);
		omspel.removeActionListener(GUI);
		
		JPanel stats = new JPanel();
		stats.setLayout(new GridLayout(6,0, 10,10));
		stats.setPreferredSize(new Dimension(350, 400));
		stats.setBorder(new EmptyBorder(6,10,25,10));
		stats.setBackground(Color.white);
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.PLAIN, 12);
		stats.setFont(headingFont);
		
		JPanel matchAvslutad = new JPanel();
		matchAvslutad.setBackground(Tema.getBG());
		JLabel mAvsl = new JLabel("Match Avslutad");
		Border border = mAvsl.getBorder();
		Border margin = new EmptyBorder(20,30,30,20);
		mAvsl.setBorder(new CompoundBorder(border, margin));
		mAvsl.setFont(headingFont);
		mAvsl.setForeground(Tema.getText());
		matchAvslutad.add(mAvsl);
		
		JPanel poäng = new JPanel();
		poäng.setLayout(new GridLayout(0,3));
		JLabel user1 = new JLabel("User1");
		user1.setHorizontalAlignment(JLabel.CENTER);
		JLabel user2 = new JLabel("User2");
		user2.setHorizontalAlignment(JLabel.CENTER);
		JLabel points = new JLabel("3-6");
		points.setHorizontalAlignment(JLabel.CENTER);
		points.setFont(headingFont);
		poäng.add(user1);poäng.add(points);poäng.add(user2);
		
		JPanel duGavUpp = new JPanel();
		JLabel gaveup = new JLabel("Du gav upp");
		duGavUpp.add(gaveup);
		
		dinStatistik.setBackground(Tema.getBG());
		dinStatistik.setForeground(Tema.getText());
		//dinStatistik.setText("Din Statistik");
		dinStatistik.setFont(headingFont);
		
		omspel.setBackground(Tema.getStartGameBG());
		//omspel.setText("Omspel");
		omspel.setFont(headingFont);
		
		statback.setBackground(Tema.getButtonBG());
		statback.setFont(labelFont);
		
		stats.add(matchAvslutad);
		stats.add(poäng);
		stats.add(duGavUpp);
		stats.add(dinStatistik);
		stats.add(omspel);
		stats.add(statback);
		
		dinStatistik.addActionListener(GUI);
		omspel.addActionListener(GUI);
		return stats;
	}
	
	// SidaStart
	public JButton getRegBtn() {
		return regBtn;
	}
	public JButton getLoginBtn() {
		return loginBtn;
	}
	//sidaLogin
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
	//sidaSkapa
	public JTextField getUsernameTxFdReg() {
		return usernameTxFdReg;
	}
	public JTextField getPasswordTxFdReg() {
		return passwordTxFdReg;
	}
	public JButton getSaveBtn() {
		return saveBtn;
	}
	//SidaSettings
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
	// SidaLoggedIn
	public JButton getStartaSpel() {
		return startaSpel;
	}
	public JButton getDinTur1() {
		return dinTur;
	}
	public JButton getDinTur2() {
		return dinTur2;
	}
	public JButton getAvslutadeSpel() {
		return avslutadSpel;
	}
	// sidaVäljKategori
	public JButton getKategori1() {
		return kategori1;
	}
	public JButton getKategori2() {
		return kategori2;
	}
	public JButton getKategori3() {
		return kategori3;
	}
	public JButton getGoBack() {
		return goBack;
	}
	// sidaNyttSpel
	public JButton getSlumpadSpelare() {
		return slumpadSpelare;
	}
	// sidaSvaraFrågan
	public JButton getAnswer1() {
		return answer1;
	}
	public String getAnswer1Text() {
		return answer1.getText();
	}
	public JButton getAnswer2() {
		return answer2;
	}
	public String getAnswer2Text() {
		return answer2.getText();
	}
	public JButton getAnswer3() {
		return answer3;
	}
	public String getAnswer3Text() {
		return answer3.getText();
	}
	public JButton getAnswer4() {
		return answer4;
	}
	public String getAnswer4Text() {
		return answer4.getText();
	}
	public JButton getBackBack() {
		return backBack;
	}
	// sidaKampMotståndare
	public JButton getSpela() {
		return spela;
	}
	public JButton getGeUpp() {
		return geUpp;
	}
	public JButton getGoReturn() {
		return goReturn;
	}
	// sidaStatistik
	public JButton getStatBack() {
		return statback;
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
		Color buttonChangeCategory1 = new Color(255, 128,0); // orange
		Color buttonChangeCategory2 = new Color(255, 0, 255);// lila
		Color buttonChangeCategory3 = new Color(0, 153, 153); //gråblått
		Color buttonBlack = new Color(32,32,32); // svarta
		Color buttonRed = new Color(255,0,0); // röd
		Color veryDarkBlue = new Color(0, 51, 102); //MycketMörkblå
		Teman.add(new ColorThemes(startGameBG, topBG, BG, txFdBG, buttonBG, buttonChangeCategory1, buttonChangeCategory2,buttonChangeCategory3,buttonBlack, buttonRed, veryDarkBlue, text));
	}
	public void setTema(int id)
	{
		Tema = Teman.get(id);
	}
}
