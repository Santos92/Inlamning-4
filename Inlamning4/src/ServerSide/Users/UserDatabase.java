package ServerSide.Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import Communication.Session;
import Communication.Session.gameStates;
import ServerSide.ClientThread;

public class UserDatabase { 
	
	private static LinkedList<User> allUsers = new LinkedList<>();
	private File UserDatabase = new File("Inlamning4\\src\\ServerSide\\Users\\AllUsers.txt");
	
	public UserDatabase() 
	{
		
		UserDatabase = new File("Inlamning4\\src\\ServerSide\\Users\\AllUsers.txt");
		if(!UserDatabase.exists())
			UserDatabase = new File("src\\ServerSide\\Users\\AllUsers.txt");
	}
	
	public void register(String name, String pass, ClientThread server) {
		boolean userExist = false;
		for(User x : allUsers)
		{
			if(x.getNamn().equals(name))
			{
				Session sess = new Session();
				sess.setState(gameStates.FailReg);
				sess.setMessage("Användare finns redan med namnet! försök igen.");
				sess.setUserName(name);
				server.send(sess);
				userExist = true;
				break;
			}
		}
		if(!userExist){
			allUsers.add(new User(name, pass));
			Session sess = new Session();
			sess.setState(gameStates.OkReg);
			sess.setUserName(name);
			server.setUserName(name);
			sess.setMessage("Successful registration " + name);
			server.send(sess);
		}
	}
	public void sparaLista()
	{
		try {
			if(!UserDatabase.exists())
				UserDatabase.createNewFile();
	 FileOutputStream fos = new FileOutputStream(UserDatabase);
	 ObjectOutputStream oos = new ObjectOutputStream(fos);
	 oos.writeObject(allUsers);
	 oos.close();
	}catch(Exception e) { 
		 e.printStackTrace();
	}
}
	public void laddaLista()
	{
	    try {
			if(!UserDatabase.exists())
				UserDatabase.createNewFile();
			else
			{
			FileInputStream fis = new FileInputStream(UserDatabase);
			ObjectInputStream ois = new ObjectInputStream(fis);
			allUsers = (LinkedList<User>) ois.readObject();
			
			ois.close();
			}
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		}
		
	}
	public void login(String name, String pass, ClientThread server) {
		
		boolean loggedIn = false;
		for(User x : allUsers)
			
		{
			if(x.getNamn().equalsIgnoreCase(name) && x.getPassword().equalsIgnoreCase(pass)) 
			{
				Session sess = new Session();
				sess.setState(gameStates.AuthAccept);
				sess.setMessage("Welcome " + name);
				sess.setUserName(name);
				server.setUserName(name);
				server.send(sess);
				loggedIn = true;
				break;
				
			}
		}
		if(!loggedIn) {
			Session sess = new Session();
			sess.setState(gameStates.FailAuth);
			sess.setMessage("Wrong credentials");
			server.send(sess);
			
		}
	}
}