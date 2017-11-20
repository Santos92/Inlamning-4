package ClientSide.GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ClientGuiTopPanels {
	
	private LinkedList<ColorThemes> Teman = new LinkedList<>();
	private ClientGUI GUI;
//	private ClientGuiPanels GUI;
	private ColorThemes Tema;
	private Font headingFont;
	
	
	//Top buttons
	private JButton refresh = new JButton("Refresh");
	private JButton statistik = new JButton("Statistik");
	private JButton inställningar = new JButton("Inställningar");
	public ClientGuiTopPanels(ClientGUI  GUI)
	{
		setupThemes();
		setTema(0);
		this.GUI = GUI;
//		this.Tema = Tema;
	}
	
	public JPanel TopwithoutButtons() {
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,1));
		top.setBackground(Tema.getTopBG());
		top.setBorder(new EmptyBorder(5,10,5,10));
		headingFont = new Font("Arial", Font.BOLD, 22);
		JLabel titel = new JLabel("Quizkampen");
		titel.setForeground(Tema.getText());
		titel.setFont(headingFont);
		top.add(titel);
		return top;
	}
	
	public JPanel Top() {
		refresh.removeActionListener(GUI);
		statistik.removeActionListener(GUI);
		inställningar.removeActionListener(GUI);
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,1));
		top.setBackground(Tema.getTopBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		
		JLabel titel = new JLabel("Quizkampen");
		titel.setForeground(Tema.getText());
		titel.setFont(headingFont);
		
		refresh = new JButton("Refresh");
		statistik = new JButton("Statistik");
		inställningar = new JButton("Inställningar");
		
		refresh.setBorderPainted(true);
		refresh.setBackground(Tema.getButtonBG());
		
		statistik.setBorderPainted(true);
		statistik.setBackground(Tema.getButtonBG());
		
		inställningar.setBorderPainted(true);
		inställningar.setBackground(Tema.getButtonBG());
		
		top.add(titel);
		top.add(refresh);
		top.add(statistik);
		top.add(inställningar);
		
		refresh.addActionListener(GUI);
		statistik.addActionListener(GUI);
		inställningar.addActionListener(GUI);
	
		return top;
	}
	public JButton getTopPanelRefresh() {
		return refresh;
	}
	public JButton getTopPanelstatistik() {
		return statistik;
	}
	public JButton getTopPanelinställningar() {
		return inställningar;
	}
	private void setupThemes(){
		Color startGameBG = new Color(51,226,16);// grönt
		Color topBG = new Color(30,144,255); //Ljusblå
		Color BG = new Color(38,106,208); // Mörkblå
		Color txFdBG = new Color(176,202,222); // ljusblå/grå
		Color buttonBG = new Color(38, 134, 208); // klarblå
		Color text = new Color(255,255,255); // Vitt
		
		Teman.add(new ColorThemes(startGameBG, topBG, BG, txFdBG, buttonBG, text));
	}
	public void setTema(int id)
	{
		Tema = Teman.get(id);
	}
	
}
