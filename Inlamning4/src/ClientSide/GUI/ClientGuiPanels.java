package ClientSide.GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
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
import ClientSide.GUI.MatchActions.GameActions;
import ClientSide.GUI.MatchActions.MatchActions;
import Communication.Session;
import Communication.Session.gameStates;
import Communication.Questions.Match;
import Communication.Questions.Round;

public class ClientGuiPanels implements ActionListener {

	private LinkedList<ColorThemes> Teman = new LinkedList<>();
	private ColorThemes Tema;
	private Font headingFont, labelFont, btnFont;
	private ClientGUI GUI;
	private ClientGuiTopPanels topPanels;
	private Client client;
	private MatchActions matchListener;
	private GameActions gameListener;
	
	private Match match;
	private boolean lastInRound;
	
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
	
	private JButton answer1 = new JButton("1");
	private JButton answer2 = new JButton("2");
	private JButton answer3 = new JButton("3");
	private JButton answer4 = new JButton("4");
	
	JPanel answers = new JPanel();
	
	
	public ClientGuiPanels(ClientGUI GUI, Client client)
	{
		this.GUI = GUI;
		this.client = client;
		matchListener = new MatchActions(this.client, this.GUI);
		gameListener = new GameActions(this.client, this.GUI);
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

		JLabel aktivaSpelLabel = new JLabel("Aktiva spel");
		aktivaSpelLabel.setBorder(new CompoundBorder(labelBorder, labelMargin));
		aktivaSpelLabel.setForeground(Tema.getTxFdBG());
		aktivaSpelLabel.setFont(btnFont);
		
		JLabel avslutadeSpelLabel = new JLabel("Avslutade spel");
		avslutadeSpelLabel.setBorder(new CompoundBorder(labelBorder, labelMargin));
		avslutadeSpelLabel.setForeground(Tema.getTxFdBG());
		avslutadeSpelLabel.setFont(smalFont);
		
		startaSpel.addActionListener(GUI);
		
		logedInPanel.add(topMenu);
		logedInPanel.add(userLabel);
		logedInPanel.add(username);
		logedInPanel.add(startaSpel);		
		if(client.getMatcher() != null)
		{
			JButton[] Matches = new JButton[client.getMatcher().size()];
			for(int x = 0; x<3; x++)
			{
				for(int i = Matches.length-1;i>=0;i--)
				{
					if(i == Matches.length-1 && x == 1)
						logedInPanel.add(aktivaSpelLabel);
					if(i == Matches.length-1 && x == 2)
						logedInPanel.add(avslutadeSpelLabel);
					if(client.getMatcher().get(i).isActive() && client.getMatcher().get(i).isTurn() && x == 0)
					{
						Matches[i] = new JButton("Din tur mot " + client.getMatcher().get(i).getOpponent());
						Matches[i].setBackground(Tema.getButtonBG());
						Matches[i].setForeground(Tema.getText());
						Matches[i].setFont(btnFont);
						Matches[i].setBorderPainted(false);
						Matches[i].putClientProperty("index", i);
						Matches[i].addActionListener(matchListener);
						logedInPanel.add(Matches[i]);
					}
					if(client.getMatcher().get(i).isActive() && !client.getMatcher().get(i).isTurn() && x == 1)
					{
						Matches[i] = new JButton(client.getMatcher().get(i).getOpponent());
						Matches[i].setBackground(Tema.getButtonBG());
						Matches[i].setForeground(Tema.getText());
						Matches[i].setFont(btnFont);
						Matches[i].setBorderPainted(false);
						Matches[i].putClientProperty("index", i);
						Matches[i].addActionListener(matchListener);
						logedInPanel.add(Matches[i]);
					}
					if(!client.getMatcher().get(i).isActive() && x == 2)
					{
						Matches[i] = new JButton(client.getMatcher().get(i).getOpponent());
						Matches[i].setBackground(Tema.getButtonBG());
						Matches[i].setForeground(Tema.getText());
						Matches[i].setFont(btnFont);
						Matches[i].setBorderPainted(false);
						Matches[i].putClientProperty("index", i);
						Matches[i].addActionListener(matchListener);
						logedInPanel.add(Matches[i]);
					}
				}
			}
		}
		
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
	public JPanel sidaVäljKategori(Match m) {
		
		
		
		JPanel väljKat = new JPanel();
		väljKat.setBackground(Tema.getBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		btnFont = new Font("Arial", Font.BOLD, 17);
		väljKat.setFont(headingFont);
		
		JLabel väljkategori = new JLabel("Välj kategori: ");
		JLabel användarnamn = new JLabel("");
		väljKat.setForeground(Tema.getText());
		
		JButton kategori1 = new JButton("Mat");
		kategori1.setBackground(Tema.getChangeCate1());// change these colors
		kategori1.setForeground(Tema.getText());
		
		JButton kategori2 = new JButton("Teknik");
		kategori2.setBackground(Tema.getChangeCate2());
		kategori2.setForeground(Tema.getText());
		
		JButton kategori3 = new JButton("Film");
		kategori3.setBackground(Tema.getChangeCate3());
		kategori3.setForeground(Tema.getText());
		
		väljKat.add(väljkategori);
		väljKat.add(användarnamn);
		väljKat.add(kategori1);
		väljKat.add(kategori2);
		väljKat.add(kategori3);
		
		kategori1.putClientProperty("match", m);
		kategori2.putClientProperty("match", m);
		kategori3.putClientProperty("match", m);
		
		kategori1.removeActionListener(gameListener);
		kategori2.removeActionListener(gameListener);
		kategori3.removeActionListener(gameListener);
		kategori1.addActionListener(gameListener);
		kategori2.addActionListener(gameListener);
		kategori3.addActionListener(gameListener);
		
		
		
		return väljKat;
	}
	public JPanel sidaSvaraFråga(Match m, boolean lastInRound) {
		this.match = m;
		this.lastInRound = lastInRound;
		Round r = match.getRound(match.getCurrentRound());
		
		answer1.removeActionListener(this);
        answer2.removeActionListener(this);
        answer3.removeActionListener(this);
        answer4.removeActionListener(this);
        
        JPanel svaraFrågan = new JPanel();
	    JPanel question = new JPanel();
	    JLabel questionCategory = new JLabel(r.getQ(r.getCurrentQuestion()).getCategory());
	    JLabel actualQuestion = new JLabel(r.getQ(r.getCurrentQuestion()).getQuestion());
	    
	    JPanel timeLimit = new JPanel();
	    JTextField timeLimiter = new JTextField("Time limiter");
	    
	    answer1.setText(r.getQ(r.getCurrentQuestion()).getCorAnswer());
	    answer2.setText(r.getQ(r.getCurrentQuestion()).getWroAns1());
	    answer3.setText(r.getQ(r.getCurrentQuestion()).getWroAns2());
	    answer4.setText(r.getQ(r.getCurrentQuestion()).getWroAns3());
	    
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
        answer1.setBackground(Tema.getButtonBG()); 
        answer1.setFont(btnFont);
        answer1.setLayout(new GridLayout(20,20,5,5));
        answer1.setForeground(Tema.getText());
        answer2.setBackground(Tema.getButtonBG());
        answer2.setFont(btnFont);
        answer2.setLayout(new GridLayout(20,20,5,5));
        answer2.setForeground(Tema.getText());
        answer3.setBackground(Tema.getButtonBG());
        answer3.setFont(btnFont);
        answer3.setLayout(new GridLayout(20,20,5,5));
        answer3.setForeground(Tema.getText());
        answer4.setBackground(Tema.getButtonBG());
        answer4.setFont(btnFont);
        answer4.setLayout(new GridLayout(20,20,5,5));
        answer4.setForeground(Tema.getText());
        
        LinkedList<JButton> AnswerButtons = new LinkedList<>();
        AnswerButtons.add(answer1);
        AnswerButtons.add(answer2);
        AnswerButtons.add(answer3);
        AnswerButtons.add(answer4);
        
        Collections.shuffle(AnswerButtons);
        
        answers.add(AnswerButtons.getFirst()); AnswerButtons.removeFirst();
        answers.add(AnswerButtons.getFirst()); AnswerButtons.removeFirst();
        answers.add(AnswerButtons.getFirst()); AnswerButtons.removeFirst();
        answers.add(AnswerButtons.getFirst()); AnswerButtons.removeFirst();
        
        timeLimit.setLayout(new GridLayout(0,1,10,10));
        timeLimit.setBorder(new EmptyBorder(5,10,5,10));
        timeLimit.add(timeLimiter);
        // svaraFrågan.add(question);
        svaraFrågan.add(answers);
        // svaraFrågan.add(timeLimit);
             
         answer1.addActionListener(this);
         answer2.addActionListener(this);
         answer3.addActionListener(this);
         answer4.addActionListener(this);
        
         return svaraFrågan;
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
	@Override
	public void actionPerformed(ActionEvent e) {
		int score = 0;
		Round r = match.getRound(match.getCurrentRound());
		if(e.getSource() == answer1)
		{
			answer1.setBackground(Color.GREEN);
			answers.revalidate();
			answers.repaint();
			r.getQ(r.getCurrentQuestion()).setChosenAnswear(answer1.getText());
			score ++;
		}
		else
		{
			JButton Temp = (JButton) e.getSource();
			Temp.setBackground(Color.RED);
			Temp.revalidate();
			Temp.repaint();
			r.getQ(r.getCurrentQuestion()).setChosenAnswear(Temp.getText());
		}
		
		if(r.getCurrentQuestion()+1 < match.getAmountOfQuestions())
		{
			r.setCurrentQuestion(r.getCurrentQuestion()+1);
			GUI.swapWindow(GUI.getPanels().sidaSvaraFråga(match, lastInRound));
		}
		else
		{
			System.out.println(lastInRound);
			if(lastInRound)
			{
				match.setTurn(true);
				if(match.getCurrentRound()+1 < match.getAmountOfRounds())
				{
					System.out.println(match.getCurrentRound());
					match.setCurrentRound(match.getCurrentRound()+1);
				}
				else
				{
					match.setActive(false);
					match.setTurn(false);
				}
			}
			else
			{
				match.setTurn(false);
			}
			Session sess = new Session();
			sess.setState(gameStates.FinishedRound);
			sess.setPickedMatch(match);
			sess.setUserName(client.getUserName());
			client.send(sess);
		}
	}
}
