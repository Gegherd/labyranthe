import java.net.*;
import java.io.*;
import java.util.*;

public class Serv
{

	private ArrayList _tabClients = new ArrayList();
	private int _nbClients = 0;
	private int tmp = 0;
	private static Maze maze = new Maze();
	public static int n;

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
	 		n=0;
	 		new ProtCom(serv);
	 		ServerSocket ss = new ServerSocket(port.intValue());		
	 		welcome(port);
	 		int tab[][]={
			{2,0,0,0},
			{1,1,1,0},
			{0,0,1,0},
			{0,0,1,3}
			};
			maze.writeInit(tab);
			maze.createTab();
	 		while(true){
	 			new ServiceServ(ss.accept(),serv);
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

	synchronized public void sendAll(String m)
	{
		try{
			DatagramSocket dso = new DatagramSocket();
			byte[] data;
			String s = m+"\n";
			data = s.getBytes();			
			for (int i = 0;i<_tabClients.size();i++) 
			{
				String tmp = _tabClients.get(i).toString();
				DatagramPacket paquet = new DatagramPacket(data,data.length,InetAddress.getByName(tmp),4040);
				dso.send(paquet);
			}
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		
	}

	synchronized public void delClient(int i)
	{
		_nbClients--;
		if (_tabClients.get(i) != null)
		{
			_tabClients.remove(i);
		}
	}

	synchronized public int addClient(String s)
	{
		_nbClients++;
		_tabClients.add(s.substring(1));
		return _tabClients.size()-1;
	}

	synchronized public int getNbClients()
	{
		for (int i=0;i<_nbClients;i++) {
			System.out.println(_tabClients.get(i));
		}
		return _nbClients;
	}
}	