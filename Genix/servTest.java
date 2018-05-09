import java.io.*;
import java.util.*;
import java.net.*;

public class servTest{
	public static void main(String[] args) {
		try{
			ServerSocket server = new ServerSocket(4040);
			Socket so = server.accept();
			BufferedReader br = new BufferedReader(new InputStreamReader (so.getInputStream()));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(so.getOutputStream()));
			while(true){
				
				pw.print("Veuillez ecrire ce que vous voulez transformez sans '.'(Fin de sesion) \n");
				pw.flush();
				
				String mess = br.readLine();
				if (mess != null) {
					System.out.println("Recu du Client: "+mess);
				}
				
				//br.close();
				//pw.close();
				//so.close();
			}
			
		}
		catch (Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
	}
}