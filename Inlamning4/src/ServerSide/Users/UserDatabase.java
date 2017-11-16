package ServerSide.Users;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import Communication.Session;
import Communication.Session.gameStates;
import ServerSide.ClientThread;

public class UserDatabase {
	
	private static ArrayList<User> allUsers = new ArrayList<>();
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
			sess.setMessage("Successful registration");
			server.send(sess);
		}
	}
	public void sparaLista()
	{
		try {
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
			FileInputStream fis = new FileInputStream(UserDatabase);
			ObjectInputStream ois = new ObjectInputStream(fis);
			allUsers = (ArrayList<User>) ois.readObject();
			
			ois.close();
		} catch (ClassNotFoundException | IOException e) {
			// TODO Auto-generated catch block
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
				sess.setMessage("Welcome");
				sess.setUserName(name);
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