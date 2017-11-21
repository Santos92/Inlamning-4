package ClientSide.GUI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientGuiTopPanels {

	private ClientGUI GUI;
	private ColorThemes Tema;
	private Font headingFont;
	
	//Top buttons
	private JButton refresh = new JButton("Refresh");
	private JButton statistik = new JButton("Statistik");
	private JButton inställningar = new JButton("Inställningar");
	public ClientGuiTopPanels(ColorThemes Tema, ClientGUI GUI)
	{
		this.GUI = GUI;
		this.Tema = Tema;
	}
	
	
	public JPanel TopwithoutButtons() {
		JPanel top = new JPanel();
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
		top.setBackground(Tema.getTopBG());
		headingFont = new Font("Arial", Font.BOLD, 40);
		top.setPreferredSize(new Dimension(500, 60));
		JLabel titel = new JLabel(" Quizkampen");
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
		top.setLayout(new BoxLayout(top, BoxLayout.LINE_AXIS));
		top.setBackground(Tema.getTopBG());
		headingFont = new Font("Arial", Font.BOLD, 33);
		top.setPreferredSize(new Dimension(500, 50));
		JLabel titel = new JLabel(" Quizkampen");
		titel.setForeground(Tema.getText());
		titel.setFont(headingFont);
		
		JPanel btnHolder = new JPanel();
		btnHolder.setLayout(new GridLayout(0,3));
		
		refresh = new JButton("Refresh");
		refresh.setBorderPainted(false);
		refresh.setBackground(Tema.getTopBG());
		refresh.setForeground(Tema.getText());
		
		statistik = new JButton("Statistik");
		statistik.setBorderPainted(false);
		statistik.setBackground(Tema.getTopBG());
		statistik.setForeground(Tema.getText());
		
		inställningar = new JButton("Inställningar");
		inställningar.setBorderPainted(false);
		inställningar.setBackground(Tema.getTopBG());
		inställningar.setForeground(Tema.getText());
		
		refresh.addActionListener(GUI);
		statistik.addActionListener(GUI);
		inställningar.addActionListener(GUI);
		
		btnHolder.add(refresh);
		btnHolder.add(statistik);
		btnHolder.add(inställningar);
		

		top.add(titel);
		top.add(btnHolder);
		
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
	
}
