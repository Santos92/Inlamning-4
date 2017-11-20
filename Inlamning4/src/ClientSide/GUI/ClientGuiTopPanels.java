package ClientSide.GUI;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ClientGuiTopPanels {

	private ClientGUI GUI;
	private ColorThemes Tema;
	private Font headingFont;
	
	//Top buttons
	private JButton refresh = new JButton("Refresh");
	private JButton statistik = new JButton("Statistik");
	private JButton inst�llningar = new JButton("Inst�llningar");
	public ClientGuiTopPanels(ColorThemes Tema, ClientGUI GUI)
	{
		this.GUI = GUI;
		this.Tema = Tema;
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
		inst�llningar.removeActionListener(GUI);
		
		JPanel top = new JPanel();
		top.setLayout(new GridLayout(1,1));
		top.setBackground(Tema.getTopBG());
		headingFont = new Font("Arial", Font.BOLD, 22);
		
		JLabel titel = new JLabel("Quizkampen");
		titel.setForeground(Tema.getText());
		titel.setFont(headingFont);
		
		refresh = new JButton("Refresh");
		statistik = new JButton("Statistik");
		inst�llningar = new JButton("Inst�llningar");
		
		refresh.setBorderPainted(true);
		refresh.setBackground(Tema.getButtonBG());
		
		statistik.setBorderPainted(true);
		statistik.setBackground(Tema.getButtonBG());
		
		inst�llningar.setBorderPainted(true);
		inst�llningar.setBackground(Tema.getButtonBG());
		
		top.add(titel);
		top.add(refresh);
		top.add(statistik);
		top.add(inst�llningar);
		
		refresh.addActionListener(GUI);
		statistik.addActionListener(GUI);
		inst�llningar.addActionListener(GUI);
	
		return top;
	}
	public JButton getTopPanelRefresh() {
		return refresh;
	}
	public JButton getTopPanelstatistik() {
		return statistik;
	}
	public JButton getTopPanelinst�llningar() {
		return inst�llningar;
	}
	
}
