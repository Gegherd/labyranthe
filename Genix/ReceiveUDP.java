import java.io.*;
import java.net.*;
import java.util.*;

class ReceiveUDP implements Runnable{
	private int _p;
	private Thread _t;
	private DatagramSocket _dso;

	public ReceiveUDP(int p){
		_p = p;
		_t = new Thread(this);
		_t.start();
	}

	public void run(){
		try{
			_dso = new DatagramSocket(_p);
			byte[] data=new byte[100];
			DatagramPacket paquet=new DatagramPacket(data,data.length);
			while(true){
				_dso.receive(paquet);
				String st=new String(paquet.getData(),0,paquet.getLength());
				System.out.println("Message UDP de " +paquet.getAddress().toString() +":"+st);
 			}
 		} 
 		catch(Exception e){
 			e.printStackTrace();
 		}
 	}
}