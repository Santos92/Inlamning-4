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
	
	//start btns
	JButton regBtn = new JButton("Nytt konto");
	JButton loginBtn = new JButton("Logga in");
	
	//game btns
	
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
	
	public JPanel userMenuSide(){
		
		return null;
	}
	

	private void setupThemes(){
		
		Color topBG = new Color(30,144,255); //Ljusblå
		Color BG = new Color(38,106,208); // Mörkblå
		Color txFdBG = new Color(176,202,222); // ljusblå/grå
		Color buttonBG = new Color(38, 134, 208); // klarblå
		Color text = new Color(255,255,255); // Vitt
		
		Teman.add(new ColorThemes(topBG, BG, txFdBG, buttonBG, text));
	}
	
}
