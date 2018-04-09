import java.util.*;
import java.net.*;
import java.io.*;

class Client1{
	public static void main(String[] args) {
		try{
			//String s1 = args[0],s2 = args[1];
			Scanner sc = new Scanner(System.in);
			String res="";
			boolean x = true;
			Socket socket = new Socket("localhost",4040);

			
			while(x == true){
				
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				res = sc.next();
				
				pw.print(res+"\n");
				pw.flush();
				String mess = br.readLine();
				System.out.println(mess);
				
				pw.close();
				br.close();			
				
			}
		socket.close();
			
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
}