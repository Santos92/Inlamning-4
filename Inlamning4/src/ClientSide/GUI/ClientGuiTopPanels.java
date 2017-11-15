package ClientSide.GUI;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ClientGuiTopPanels {

	private ColorThemes Tema;
	private Font headingFont;
	
	public ClientGuiTopPanels(ColorThemes Tema)
	{
		this.Tema = Tema;
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
	
}
