package ClientSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

import ClientSide.GUI.ClientGUI;
import ClientSide.SessionHandling.ClientSessionHandling;

public class Client implements Runnable {

	private static final int PORT = 2424;
	private static final String IP = "127.0.0.1";
	
	private ClientGUI GUI;
	
	private Socket conn;
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Thread Listener;
	private boolean Connected = false;
	
	public Client()
	{
		connect();
		setupStream();
		Start();
		GUI = new ClientGUI(this);
	}
	public void run()
	{
		System.out.println("Lyssnaren igång");
		while(true)
		{
			try {
				new ClientSessionHandling(this, GUI, in.readObject());
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Klass hittades ej");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Server stänger ner...");
				System.exit(0);
				break;
			}
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
			System.out.println("Strömmar kopplade");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Kunde inte koppla strömmar");
		}
	}
	public static void main(String[] args)
	{
		
		new Client();
	}
}
