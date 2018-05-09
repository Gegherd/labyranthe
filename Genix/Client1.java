import java.util.*;
import java.net.*;
import java.io.*;

class Client1{
	private Socket socket;
	private BufferedReader br;
	private PrintWriter pw;
	private Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		Client1 client1 = new Client1();
		client1.run();
	}

	public void run(){

		try{
			
			Scanner sc = new Scanner(System.in);
			boolean x = true;
			socket = new Socket("localhost",4040);
				
			while(x==true){				
				//int value = 0;
				//System.out.println("try");
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

				String mess = br.readLine();
				if(mess!=null){
					System.out.println(mess);
					System.out.println("try to send...");
					String res = sc.nextLine();
					if (res=="bye") {
						x = false;
					}
					pw.print(res+"\n");
					pw.flush();
				}
			}
				pw.close();
				br.close();
				socket.close();			
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
}












	// reads to the end of the stream 
				/*while((value = br.read()) != -1) {

					// converts int to character
					char c = (char)value;

					// prints character
					System.out.print(c);
				}
				System.out.println("/");*/