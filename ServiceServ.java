import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class ServiceServ implements Runnable
{
 	private Thread _t;
 	private Socket _s;
 	private PrintWriter _pw;
 	private BufferedReader _br;
 	private Serv _serv;
 	private int _nClient = 0;

 	public ServiceServ(Socket s, Serv serv)
 	{
 		_serv = serv;
 		_s = s;
 		try
	 	{
	 		_pw = new PrintWriter(new OutputStreamWriter(_s.getOutputStream()));
	 		_br = new BufferedReader(new InputStreamReader(s.getInputStream()));
	 		_nClient = serv.addClient(_pw);
	 	}
	 	catch(Exception e)
	 	{
			System.out.println(e);
			e.printStackTrace();
	 	}
	 	_t = new Thread(this);
	 	_t.start();
	}

 	public void run()
 	{
 		String mess = "";
 		System.out.println("Connection du client "+ _nClient);
		try
	 	{
	 		System.out.println("rentre dans le try");
	 		char tabChar[] = new char[1];
	 		while(_br.read(tabChar,0,1)!=-1)
	 		{
	 			
	 			if(tabChar[0]=='\u0000' && tabChar[0] != '\n' && tabChar[0] != '\r')
	 			{
	 				mess += tabChar[0];
	 			}
	 			else if (!mess.equalsIgnoreCase(""))
	 			{
	 				if(tabChar[0]=='\u0000')
	 				{
	 					_serv.sendAll(mess,""+tabChar[0]);
	 				}
	 				else
	 				{
	 					_serv.sendAll(mess,"");
	 				}
	 				mess="";
	 			}
	 		}
	 		System.out.print("message: "+tabChar[0]);
	 		System.out.println("Outside of while");
	 	}
		catch(Exception e)
	 	{
		 System.out.println(e);
		 e.printStackTrace();
	 	}

	 	finally
	 	{
	 		try
	 		{
	 			System.out.println("Deconnexion du client "+ _nClient);
	 			_serv.delClient(_nClient);
	 			_s.close();
	 		}
	 		catch(Exception e)
	 		{
	 			System.out.println(e);
	 			e.printStackTrace();
	 		}
	 	}
	 }
}