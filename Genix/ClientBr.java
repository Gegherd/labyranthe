import java.io.*;
import java.util.*;
import java.net.*;

class ClientBr implements Runnable{
	
	private Socket _s;
	private Thread _t;
	private BufferedReader _br;
	private Scanner sc = new Scanner(System.in);

	public ClientBr(Socket s){
		_s=s;
		_t = new Thread(this);
		_t.start();
	}

	public void run(){
		try{
			boolean x = true;
			while(x==true){
				_br = new BufferedReader(new InputStreamReader(_s.getInputStream()));
				String mess = _br.readLine();
				if(mess!=null){
					System.out.println(mess);
				}
			}
			_br.close();
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
}