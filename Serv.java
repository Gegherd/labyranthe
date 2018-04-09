import java.net.*;
import java.io.*;
import java.util.*;

public class Serv
{

	private Vector _tabClients = new Vector();
	private int _nbClients = 0;

 	public static void main(String[] args)
 	{
	 	Serv serv = new Serv();
	 	try
	 	{
	 		Integer port;
	 		if (args.length<=0) {
	 			port = new Integer(4040);
	 		}
	 		else
	 		{
	 			port = new Integer(args[0]);
	 		}
	 		new ProtCom(serv);
	 		ServerSocket ss = new ServerSocket(port.intValue());
	 		welcome(port);

	 		while(true){
	 			System.out.println("bloc 1");
	 			new ServiceServ(ss.accept(),serv);
	 			System.out.println("bloc 2");
	 		}
		}
		catch(Exception e)
		{
		 	System.out.println(e);
		 	e.printStackTrace();
		}
	}

	public static void welcome(Integer port)
	{
		System.out.println("Bienvenue dans le Labyranthe");
	}

	/*synchronized public void sendAll(String m,String last)
	{
		PrintWriter pw;
		for (int i = 0;i<_tabClients.size();i++) 
		{
			pw = (PrintWriter) _tabClients.elementAt(i);
			if (pw != null) 
			{
				pw.print(m+last);
				pw.flush();
			}	
		}
	}*/

	synchronized public void delClient(int i)
	{
		_nbClients--;
		if (_tabClients.elementAt(i) != null)
		{
			_tabClients.removeElementAt(i);
		}
	}

	synchronized public int addClient(PrintWriter pw)
	{
		_nbClients++;
		_tabClients.addElement(pw);
		return _tabClients.size()-1;
	}

	synchronized public int getNbClients()
	{
		return _nbClients;
	}
}	