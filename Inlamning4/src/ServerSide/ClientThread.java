package ServerSide;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import ServerSide.SessionHandling.ServerSessionHandler;


public class ClientThread extends Thread implements Runnable {
	private Socket conn;
	private Server server;
	
	private ObjectInputStream in;
	private ObjectOutputStream out;
	private Thread T;
	
	public ClientThread(Server server, Socket conn) {
		this.conn = conn;
		this.server = server;
		T = new Thread(this);
		
		setupStream();
		T.start();
		
	}
	public void run() {
		while(true)
		{
			try {				
				new ServerSessionHandler(in.readObject());
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				server.printStatus("Klient bortkopplad!");
				break;
			}
		}
	}
	public void setupStream()
	{
		try {
		in = new ObjectInputStream(conn.getInputStream());
		out = new ObjectOutputStream(conn.getOutputStream());
		}
		catch(Exception e) 
		{
			e.printStackTrace();
		}
	}
}