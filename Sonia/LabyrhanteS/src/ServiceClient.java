/**
 * Classe Service tourne sur la machine Serveur
 * Elle assure le transfert des messages transmis d'un client vers le Serveur en destinantion d'un autre client
 * Cette partie de la communication se fera en UDP
 */

import java.io.*; 
import java.net.*;
import java.util.*;


public class ServiceClient {

	 final static int taille = 1024; 
	 final static byte buffer[] = new byte[taille];
	  
	
	  /**
	   * Constructeur de la classe
	   */
	  public ServiceClient(){		  
		  
	  }

	  
	public static void main(String[] args){

		  //PROTOCOLE UDP
		  try{
	          InetAddress serveur = InetAddress.getByName("127.0.0.1"); 
	
	          Scanner sc = new Scanner(System.in);
	          System.out.println("Veuillez saisir un mot :");
	          String str=sc.nextLine();
	          byte buffer[] = str.getBytes(); 
	
	          DatagramPacket dataSent = new DatagramPacket(buffer,buffer.length,serveur,4545);  //Données envoyées 
	          DatagramSocket socket = new DatagramSocket(); //Envoyer et recevoir les paquets 
	          
	          dataSent.setData(buffer); //On affecte les donnees à envoyer
	
	          socket.send(dataSent);  //On envoie au serveur. 
	          System.out.println("Mot envoyé");
	
	          //On attend une reponse
	          DatagramPacket dataRecieved = new DatagramPacket(new byte[buffer.length],buffer.length);  //Données recues
	          System.out.println("On attend une reponse du serveur...");
	          socket.receive(dataRecieved);  //Bloque le thread courant jusqu'a reception
	          System.out.println("Data received : " + new String(dataRecieved.getData())); 
	          System.out.println("From : " + dataRecieved.getAddress() + ":" + dataRecieved.getPort()); 

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

}
	  
}
