package ServerSide;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import ServerSide.Users.UserDatabase;

public class Server extends JFrame implements ActionListener, Runnable{

	private static final long serialVersionUID = -3601049710007946605L;
	private static final int port = 2424;
	private ServerSocket server;
	private boolean ServerRunning = false;
	private Thread Listener;
	
	private JTextArea statusWindow = new JTextArea();
	private JScrollPane sp = new JScrollPane(statusWindow);
	private JButton StartClose = new JButton("Starta server");
	private UserDatabase UserDB;
	
	public void run() {
		while(true)
		{
			try {
				printStatus("V�ntart p� koppling fr�n Klient...");
				new ClientThread(this, server.accept());
				printStatus("Klient kopplad!");
			} catch (IOException e) {
				printStatus("Server st�nger ner...");
				break;
			}
		}
	}
	public Server()
	{
		UserDB = new UserDatabase();
		statusWindow.setEditable(false);
		setLayout(new BorderLayout());
		
		add(StartClose, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		
		addWindowListener(new WindowAdapter() { public void windowClosing(WindowEvent WE)
		{
			if(ServerRunning)
			{
			Disconnect();
			System.exit(0);			
			}
		}});
		setSize(500,600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		StartClose.addActionListener(this);
	}
	public void Connect()
	{
		try {
			statusWindow.setText("");
			printStatus("F�rs�ker binda server till port: " + port);
			server = new ServerSocket(port);
			UserDB.laddaLista();
			printStatus("Servern �r nu ig�ng och lyssnar p� port: " + port);
			StartClose.setText("St�ng server");
			Start();
		} catch (IOException e) {
			printStatus("Server kunde inte lyssna p� porten: " + port);
		}
	}
	public void Disconnect()
	{
		try {
			server.close();
			UserDB.sparaLista();
			Stop();
			StartClose.setText("Starta server");
		} catch (IOException e) {
			printStatus("Servern kunde inte st�nga ner");
		}
	}
	public void printStatus(String s)
	{
		statusWindow.append(s + "\n");
	}
	public void actionPerformed(ActionEvent arg0) {
		if(ServerRunning)
			Disconnect();
		else
			Connect();
	}
	public synchronized void Start()
	{
		if(!ServerRunning)
		{
			Listener = new Thread(this);
			Listener.start();
			ServerRunning = true;
		}
	}
	public synchronized void Stop()
	{
		if(ServerRunning)
		{
			Listener.interrupt();
			Listener = null;
			ServerRunning = false;
		}
	}
	public UserDatabase getUserDB()
	{
		return UserDB;
	}
	public static void main(String[] args)
	{
		new Server();
	}
}