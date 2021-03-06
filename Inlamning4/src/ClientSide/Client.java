package ClientSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import ClientSide.GUI.ClientGUI;
import ClientSide.SessionHandling.ClientSessionHandling;
import Communication.Questions.Match;

public class Client implements Runnable {

	private static final int PORT = 2424;
	private static final String IP = "127.0.0.1";
	
	private ClientGUI GUI;
	private Socket conn;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Thread Listener;
	private boolean Connected = false;
	private String UserName;
	private LinkedList<Match> matcher;	
	
	public Client()
	{
		GUI = new ClientGUI(this);
		connect();
		setupStream();
		Start();
	}
	public void run()
	{
		System.out.println("Lyssnaren ig�ng");
		while(true)
		{
			try {
				System.out.println("v�ntar p� paket");
				new ClientSessionHandling(this, GUI, in.readObject());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Klass hittades ej");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Server st�nger ner...");
				System.exit(0);
				break;
			}
		}
	}
	public void send(Object obj)
	{
		try {
			out.writeUnshared(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public synchronized void Start()
	{
		if(!Connected)
		{
			Listener = new Thread(this);
			Listener.start();
			Connected = true;	
		}
	}
	public void connect()
	{
		try {
			System.out.println("Kopplar upp...");
			conn = new Socket(IP, PORT);
			System.out.println("Uppkopplad!");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kunde inte koppla upp dig till servern");
			System.exit(0);
		}
	}
	public void setupStream()
	{
		try {
			out = new ObjectOutputStream(conn.getOutputStream());
			in = new ObjectInputStream(conn.getInputStream());
			System.out.println("Str�mmar kopplade");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kunde inte koppla str�mmar");
		}
	}
	public static void main(String[] args)
	{
		new Client();
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public LinkedList<Match> getMatcher() {
		return matcher;
	}
	public void setMatcher(LinkedList<Match> matcher) {
		this.matcher = matcher;
	}
}
