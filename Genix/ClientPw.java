import java.io.*;
import java.util.*;
import java.net.*;

class ClientPw implements Runnable{
	
	private Socket _s;
	private Thread _t;
	private PrintWriter _pw;
	private Scanner sc = new Scanner(System.in);

	public ClientPw(Socket s){
		_s=s;
		_t = new Thread(this);
		_t.start();
	}

	public void run(){
		try{
			boolean x = true;
			while(x==true){
					_pw = new PrintWriter(new OutputStreamWriter(_s.getOutputStream()));
					String res = sc.nextLine();
					if (res=="bye") {
						x = false;
					}
					_pw.print(res+"\n");
					_pw.flush();
			}
			_pw.close();
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
}