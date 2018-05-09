import java.util.*;
import java.net.*;
import java.io.*;

class ClientX{
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		ClientX clientX = new ClientX();
		clientX.run();
	}

	public void run(){

		try{
			
			Scanner sc = new Scanner(System.in);
			boolean x = true;
			socket = new Socket("127.0.0.1",4040);
			new ClientBr(socket);
			new ClientPw(socket);
			new ReceiveUDP(4040);	
			
			//socket.close();			
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
}