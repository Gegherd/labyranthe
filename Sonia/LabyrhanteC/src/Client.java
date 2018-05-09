/**
 * Classe Contenant les données et la logique du Client
 * Elle tourne sur une machine Client
 * Elle assurera la communication avec le Serveur en TCP
 * Elle réceptionnera les eventuels messages envoyés par un Client sur son port UDP
 * Elle receptionnera et stockera les informations difussées par la partie
 */

/**
 * @author Sonia.KORAICHI
 *
 */

import java.util.Scanner;
import java.net.Socket;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Serializable;

class Client {
	
	//données pour gérer la communication
	private String id;								// Identifiant du client
	private int port_udp;							// Port UDP du client
	private boolean on_line;						// Statut du client En ligne ou non
	private transient Socket socket;				//Socket attribuée par le Serveur lors de la connexion à ce dernier

	private static String SVR; 						// stocke le nom ou l'adresse IP du serveur
	public  static int TCPPort_SVR ; 				// stocke le port d'écoute du serveur

	
	/**
	 * Constructeur de la classe
	 * @param id : identifiant du client
	 * @param port_udp : port udp du client
	 */
	public Client(String id,int port_udp){
		this.id = id;
		this.port_udp =port_udp;
		this.on_line = false;
	}
	
	
	/**
	 *  Demande à l'utilisateur d'introduire les données pour identifier sa machine client
	 */
	public static Client initClient(String idclient, int port){
		
		Client clt = new Client(idclient, port);
		return clt;
	}
	
	
	/**
	 *  Demande à l'utilisateur d'introduire les données pour configurer la machine Serveur
	 */
	public static void GetConfigServer(){
		
	 // Lire les entrées utilisateurs pour le nom ou l'adresse et le port
		
	//Temporairement et pour teste les fixe
		
		TCPPort_SVR = 6262;
		SVR = "127.0.0.1";
	};
	
	

	/**
	 * Analyse et traite les messages envoyés par le serveur 
	 * @param mess : message reçu de chez le serveur
	 * @throws IOException
	 */
	private void AnalyseMessage (String mess) throws IOException{
	String [] mess_array;
	
	mess_array = mess.split(" ");

	PrintWriter pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
	
	switch(mess_array[0]){

		case "GAMES":
			
		case "GAME":
		
		case "REGOK":
		
		case "REGNO":
			
		case "UNREGOK":
			
		case "DUNNO":
			
		case "SIZE!":
			
		case "LIST!":
			
		case "PLAYER":
			// 2 cas selon le nombre de paramètres après la commande
			
		case "WELCOME":
			
		case "RIGHT":
			
		case "MOV":
			
		case "MOF":
			
		case "BYE":
			
		case "GLIST!":
			
		case "ALL!":
			
		case "SEND!":
			
		case "NOSEND":
			
			
		default :
		// envoyer au client un message " ERROR "
			
	}
	
	}		

	
	
	
	public static void main(String[] args) {
		
		try{
			
			GetConfigServer();						// Initialise les informations Nom ou adresse du Serveur et son port TCP
			
			Socket socket=new Socket(SVR,TCPPort_SVR);
			Scanner sc= new Scanner(System.in);
			
			//Afficher l'information de la connexion
			System.out.println("Connexion avec le serveur reussie! \n \n");
			System.out.println("Votre port TCP : "+socket.getLocalPort());
			System.out.println("Port du serveur  : "+socket.getPort());
			System.out.println("La machine locale est : "+socket.getLocalAddress().getHostName());
			System.out.println("La machine distante est : "+socket.getInetAddress().getHostName() + "\n\n");
			

			//Instancier les classes pour envoyer et recevoir
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
			System.out.println("Choissisez votre identifiant svp : ");
			String idclient=sc.nextLine();
			Client clt = initClient(idclient,socket.getLocalPort());				// Initialise les informations id et numéro de port UDP du client
			pw.println(idclient); 
			pw.flush();

			//Récupérer la réponse du Serveur à notre demande de connection
			String mess=br.readLine();
			System.out.println("Messages recus du serveur :\n "+mess);
			boolean fini=true;
			String line = br.readLine();
			//Faire une boucle pour recevoir tt les msg GAME
			System.out.println(line);

		    /*while (line != null) {
		        System.out.println(line);
		        line = br.readLine();
		    }*/

		  	/*  for (String line = br.readLine(); line != null; line = br.readLine()) {
   				System.out.println(line);
			}
			*/	System.out.println(" Vous pouvez commencer par creer une nouvelle partie [NEW id port], ou en rejoindre une [REG id port m]:");
			while (fini){
					String str=sc.nextLine();
					pw.println(str);
					pw.flush();
					System.out.println("Message envoyé au serveur. \n");
					
					mess=br.readLine();
					System.out.println("Message recu :"+mess +"\n");
					if(str.equals("Close")){
						fini=false;
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