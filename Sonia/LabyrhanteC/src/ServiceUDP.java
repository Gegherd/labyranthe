/**
 * Classe Service tourne sur la machine Client
 * Assure l'écoute sur le port UDP du Client 
 * Reçoie les messages transmis par le Serveur de la part des joueurs et les affiche sur la console
 */

/**
 * @author Sonia.KORAICHI
 *
 */

import java.io.*; 
import java.net.*;


public class ServiceUDP implements Runnable {
	
	 final static int taille = 220;  			// Taille des messages UDP  200 pour le msg + la taille du type de message et ses paramètres :                //  System.out.println("Message reçu : " + msg);				//Affichage de tout le message : MESP ...  Reste a n'affiche r QUE le message, pas la commande avec le message
	 byte[] message = new byte[taille]; 		// Tableau d'octet pour stocker le message reçu
	 int port;									// Port UDP du client surlequel se fera l'écoute
	 boolean connect;
	  
	 public ServiceUDP(int p){
		 
		 this.port=p;
	 }
	 
	 
	 /**
	  * Interprête la commande UDP MESP et affiche uniquement le message envoyé par le joueur et l'identifiant du joueur
	  * @param msg : Message du Serveur à interpêter
	  */
	private void AfficheMessageClient(String msg){
		String s ="";
		String id="";
		
		// ICI le code pour extraire le message de la commande MESP id2 mess+++ dans s
		// et l'identifiant du joueur dans id
		
		
		 System.out.println(id + " dit  -> " + s);		// Affichage du message sur la console di joueur
		 
	}
	  
	@Override
	public void run() {
		
		try{
		DatagramSocket clienSocket = new DatagramSocket(port);
       				      
         while(connect)				// Tant que le joueur ne s'est pas déconnecter. 
            {   	 
        		 DatagramPacket paquetRecu = new DatagramPacket(message, message.length);
        		 clienSocket.receive(paquetRecu);
        		 String msg = new String( paquetRecu.getData());
  
        		 //  System.out.println("Message reçu : " + msg);				//Affichage de tout le message : MESP ...  Reste a n'affiche r QUE le message, pas la commande avec le message
        		 AfficheMessageClient(msg);
             
        	 }
         
			}catch (SocketException e) {
        		 e.printStackTrace();
        	 } catch (UnknownHostException e) {
        		 e.printStackTrace();
        	 } catch (IOException e) {
                e.printStackTrace();
        	 }
  
	}
}
