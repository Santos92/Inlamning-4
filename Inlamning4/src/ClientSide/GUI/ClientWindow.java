package ClientSide.GUI;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ClientWindow extends JFrame {

	private static final long serialVersionUID = -5560494476621800408L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 800;
	
	ClientWindow(JPanel panel){
		super("Quiz");

		panel.setPreferredSize(new Dimension(WIDTH, HEIGHT));
		panel.setMaximumSize(new Dimension(WIDTH, HEIGHT));
		panel.setMinimumSize(new Dimension(WIDTH, HEIGHT));
		add(panel);
		pack();
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
		
		
	}

}
