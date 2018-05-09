/**
 * Classe Service qui tourne sur la machine Serveur et écoute sur  TCP et UDP
 * Elle assure la communication entre les machines clientes et le serveur
 */

import java.net.*;
import java.util.*;
import java.io.*;
import java.lang.*;


public class Service implements Runnable{
	
	Serveur serveur;
	Socket socket; 

	//private String tcp_adresse;


 
 	/**
 	 * Constructeur de la classe
 	 * @param s
 	 * @param liste
 	 */
 	public Service(Socket s, Serveur serv){
 		this.socket=s;
 		this.serveur=serv;

 	}


	
	/**
	 * Construit le message que le Serveur envoie au Client pour lui
	 * indiquer les parties pour lesquelles les joueurs se sont inscrit mais pas encore commencées
	 * @param n : indique le nombre de parties
	 */
	public String MessageGAMES(int n){
		String msg ="GAMES "+ n +"***";
		return msg;
	}

	/**
	 * Construit le message que le Serveur envoie au client à la suite du message GAMES
	 * @param m : indique le numéro de la partie
	 * @param s : ndique le nombre de joueur inscrit
	 */
	public String MessageGAME(int m, int s){
		String msg ="GAME "+m+ " "+ s+"***";
		 return msg;
	}

	/**
	 * Construit le message que le Serveur envoie au client pour lui indique
	 *  que la partie m a été créée et qu'il est inscrit dans cette partie
	 * @param m : indique le numérie e la partie
	 */
	public String MessageREGOK(int m){
		String msg ="REGOK "+m+"***";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer
	 *  que son inscription à une partie (nouvelle ou non) a échoué
	 */
	public String MessageREGNO(){
		String msg ="REGNO***";
		
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer
	 *  que sa désincription de la partie m a été effectuée 
	 * @param m : indique le numéro de la partie
	 */
	public String MessageUNREGOK(int m){
		String msg ="UNREGOK "+ m +"***";
		 
		return msg;
	}
		
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer
	 *  qu'il n'est inscrit à aucune partie
	 */
	public String MessageDUNNO(){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour 
	 * lui indiquer la taille du labyrinthe
	 * @param m : indique le numéro de la partie
	 * @param h : indique la hauteur du labyrinthe
	 * @param w : indique la largeur du labyrinthe
	 */
	public String MessageSIZE_EX(int m, int h, int w){
		String msg ="";
		 
		return msg;
	}
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer 
	 * le nombre de joueurs inscrits dans la partie m. Ne peut être envoyé que si le Clent n'a pas envoyé START
	 * @param m : indique le numéro de la partie
	 * @param s : indique le nombre de joueurs
	 */
	public String MessageLIST_EX(int m, int s){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer les joueurs de sa partie
	 * Le Serveur envoie s (nbr de joueurs message de ce type
	 * @param id : indique l'identifiant du joueur
	 */
	public String MessagePLAYER(String id){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie aux clients iscrits à une partie quand tous derniers ont envoyé un message START
	 * @param m : indique le numéro de la partie
	 * @param h : indique la hauteur du labyrinthe
	 * @param w : indique la largeur du labyrinthe
	 * @param f : indique le nbre de fantômes
	 * @param ip : indique l'adresse ip de multi-diffusion de la partie
	 * @param port : indique le port de multi-diffusion de la partie
	 */
	public String MessageWELCOME(int m, int h, int w, int f, String ip, int port){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 *  Construit le message que le Serveur envoie au client pour lui indiquer
	 *  la nouvelle position après déplacement sans rencontre de fantôme
	 * @param x : indique la coordonnée x du joueur
	 * @param y : indique la coordonnée y du joueur
	 */
	public String MessageMOV(int x, int y){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer
	 * la nouvelle position après déplacement avec rencontre de fantôme
	 * @param x : indique la coordonnée x du joueur
	 * @param y : indique la coordonnée y du joueur
	 * @param p : indique son nouveau score de points récoltés
	 */
	public String MessageMOF(int x, int y, int p){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour
	 * dire au revoir avant de déconnecter le Client
	 */
	public String MessageBYE(){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour 
	 * lui indiquer le nombre de joueurs dans la partie
	 * @param s : indique le nombre de joueurs
	 */
	public String MessageGLIST_EX(int s){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui donner les informations sur les joueur de sa partie
	 * Le Serveur envoie s (nbr de joueurs message de ce type
	 * @param id : id indique l'identifiant du joueur
	 * @param x : indique la coordonne x du joueur
	 * @param y : indique la coordonnée y du joueur
	 * @param p : indique le score du joueur
	 */
	public String MessagePLAYER(String id, int x, int y, int p){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui
	 * indiquer que son message a été diffusé
	 */
	public String MessageALL_EX(){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer
	 *  que son message a été transmis
	 */
	public String MessageSEND_EX(){
		String msg ="";
		 
		return msg;
	}

	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer
	 *  que son message n'a pas été transmis
	 */
	public String MessageNOSEND(){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 * Construit le message envoyé par le joueur id, que le Serveur diffuse
	 * Ce message est multi-diffusé
	 * @param id : indique l'identifiant du joueur
	 * @param mess : indique le message du joueur
	 */
	public String MessageMESA(String id, String mess){
		String msg ="";
		 
		return msg;
	}
	
	
	/**
	 *  Construit le message que le Serveur diffuse la fin de la partie 
	 *  en indiquant l'dentifiant du joueur gagnant et son score 
	 *  Ce message est multi-diffusé
	 * @param id : indique l'identifiant du joueur gagnant
	 * @param p : indique le score du joueur gagnat
	 * @return : Le message END à envoyer au client
	 */
	public String MessageEND(String id, int p){
		String msg ="";
		 
		return msg;
	}

	//Cherche si un joueur est inscrit dans une partie 
	public int searchPartie(String id_client){
		int partie=0;
		ListIterator<Partie> li=serveur.listParties.listIterator(0);
			while(li.hasNext()){
				Partie p=li.next();
				boolean client =p.isInList(id_client);
				if(client==true){
					partie=p.numPartie;
					System.out.println("Joueur " + id_client+" trouver dans la partie " + p.numPartie);
				}			
			}
		return partie;
	}
	
	
	
	/**
	 * Analyse et traite les messages envoyés par le client 
	 * @param mess : message reçu de chez le client
	 * @throws IOException
	 */
public void AnalyseMessage (String mess,Joueur j) throws IOException{
	String [] mess_array; //Tableau contenant le message envoyer par le client
	String reponse = ""; //Reponse du serveur
	int num_partie;
	String id_client="";
	int port_udp_client;
	Joueur current=null;
	
	mess_array = mess.split(" ");
	//Supprimer les *** ? 

	PrintWriter pw = new PrintWriter(new OutputStreamWriter(this.socket.getOutputStream()));
	
	switch(mess_array[0]){

		case "NEW": //Creer une nouvelle partie

			if(mess_array.length!=3){
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}
			id_client=mess_array[1];
			System.out.println(id_client + " demande la creation d'une nouvelle partie \n ");
			try{
				port_udp_client = Integer.parseInt(mess_array[2]);
			} catch (NumberFormatException e){
				System.out.println("Erreur dans le format de la commande");
				break;
			}

			//Creer une nouvelle partie
			Partie p=new Partie();
			serveur.listParties.add(p);
			serveur.nbr_parties++;
			System.out.println("Creation d'une nouvelle partie reussie. \n id de la partie = "+ p.numPartie);
			p.addJoueur(j); //Ajouter le joueur a la liste des joueurs de la partie
		/*	for(int i = 0; i < serveur.listParties.size(); i++){

      			System.out.println("Élément à l'index " + i + " = " + serveur.listParties.get(i));
  			}*/

			j.partie=p.numPartie; //Maj du num de la partie auquel le joueur est inscrit
			System.out.println("Ajout du joueur a la liste des joueurs de la partie : " + j.partie);
			//Si l'inscription a la partie est ok 
			reponse = MessageREGOK(p.numPartie);
			//System.out.println("Rep du serveur = " + reponse);
			// else
			//reponse=MessageREGNO();
			pw.println(reponse);
			pw.flush();
			break;	



		case "REG":	 //Rejoindre une partie

			if(mess_array.length!=4){
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}
			id_client=mess_array[1];	
			ListIterator<Joueur> lij=serveur.listJoueurs.listIterator(0);
			while(lij.hasNext()){
				Joueur jo=lij.next();
				//System.out.println(jo.id);
				if(jo.id.equals(id_client)){ //Si on trouve un joueur dans la liste avec le même id que celui envoyé par le client
					current=jo;
				}
			}
			//System.out.println(current.toString());

			//Recuperer le num de port et le num de partie
			try{
				port_udp_client = Integer.parseInt(mess_array[2]);
				System.out.println("Port UDP du client :"+ port_udp_client);
				num_partie= Integer.parseInt(mess_array[3]);
				System.out.println("Num de la partie demandee:"+ num_partie);

			} catch (NumberFormatException e){
				System.out.println("Erreur dans le format de la commande");
				break;
			}	

			//Chercher la partie correspondant dans la linkedlist
			ListIterator<Partie> li=serveur.listParties.listIterator(0);
			while(li.hasNext()){
				Partie pt=li.next();
				System.out.println(pt.numPartie);
				if(pt.numPartie==num_partie){ //Si on trouve une partie dans la liste avec le même id que celui envoyé par le client
					
					if(current !=null){
					pt.addJoueur(current);
					System.out.println("Le joueur " + current.id + " a ete inscrit a la partie "+ pt.numPartie);
					}
				}
			}
			//Ajouter le joueur a la partie		
			//Si l'inscription a la partie est ok
			reponse = MessageREGOK(num_partie);
			// else
			//reponse=MessageREGNO();
			pw.println(reponse);
			pw.flush();
			break;



		case "START***": //Start une partie - La partie commence quand tt les joueurs inscrits ont fait start
			if(mess_array.length!=1){
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}




		case "UNREG***": //Desinscription à une partie
			try{
				num_partie= Integer.parseInt(mess_array[1]);
				System.out.println("Num de la partie :"+ num_partie);
			} catch (NumberFormatException e){
				System.out.println("Erreur dans le format de la commande");
				break;
			}
			//Supprimer le joueur de la partie	
			reponse = MessageUNREGOK(num_partie);
			pw.println(reponse);
			pw.flush();
			break;
			
		case "SIZE?": //Taille du labyrinthe
			try{
				num_partie= Integer.parseInt(mess_array[1]);
				System.out.println("Num de la partie :"+ num_partie);
			}catch (NumberFormatException e){
				System.out.println("Erreur dans le format de la commande");
				break;
			}
		//	reponse = MessageSIZE_EX(num_partie);
			pw.println(reponse);
			pw.flush();
			break;	

		case "LIST?": //Nbr de joueurs inscrits dans la partie m
			try{
				num_partie= Integer.parseInt(mess_array[1]);
				System.out.println("Num de la partie :"+ num_partie);
			}catch (NumberFormatException e){
				System.out.println("Erreur dans le format de la commande");
				break;
			}		
		case "GAMES?": //Nbr de parties pour lesquels il y'a des joueurs inscrits
			
		case "UP":
			if(mess_array.length!=2){ //On teste que le format du message est bon
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}

			try{
				int deplacement= Integer.parseInt(mess_array[1]); //On recupere le deplacement demandé par le client
				//System.out.println("deplacement :"+ deplacement);
				int partie = searchPartie(id_client); //On cherche le num de la partie auquel est connecte le client
				//System.out.println(partie); 

				ListIterator<Partie> lit=serveur.listParties.listIterator(0); //On parcourt la liste des parties pour envoyer en message up() a la bonne partie
				while(lit.hasNext()){
					Partie pt=lit.next();
					if(pt.numPartie== partie){ 
						pt.Up(deplacement); //On envoie a la partie le num de deplacement que le client a demander
					}
				}

				//Si le deplacement est autorise 
				//...
				//Sinon ...
			}catch (NumberFormatException e){
				System.out.println("Erreur dans le format de la commande");
				break;
			}

			
			//Tester si il a fait un bon mouvement 
			//getAnswer()
			break;
		case "DOWN":
			
		case "LEFT":
			
		case "RIGHT":
			
		case "QUIT":
			
		case "GLIST?":
			
		case "ALL?":
			
		case "SEND":

		// case lancer : partie.encours=true; 

		default :
		System.out.println("Commande non reconnue");
		break;

		// envoyer au client un message " ERROR "
			
	}
	//pw.close();
	
}
	
public void run(){
		boolean stop = false;
		String resp = "";
		String id_current;

		//System.out.println("Service.run()");
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw=new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			//Creation du nouveau joueur
			String id= br.readLine();
			String ip=(socket.getInetAddress().getHostName());
			Joueur j=new Joueur(id,ip); 
			serveur.listJoueurs.add(j);
			/*for(int i = 0; i < serveur.listJoueurs.size(); i++){

      			System.out.println("Élément à l'index " + i + " = " + serveur.listJoueurs.get(i));
  			}	*/

			System.out.println("\n --- Une nouvelle connexion de : " + j.toString());

			//Envoi du msg GAMES
			resp="GAMES "+ serveur.nbr_parties + "***";
			pw.println(resp);
			pw.flush();

			//Envoie des msg GAME
			if(serveur.listParties.size()!=0){
				ListIterator<Partie> li=serveur.listParties.listIterator(0);
				while(li.hasNext()){
					Partie pt=li.next();
					resp=MessageGAME(pt.numPartie,pt.NBJoueurs);
					pw.println(resp);
					pw.flush();
					
				}
			} else {
				pw.println("Aucune partie");
				pw.flush();
			}
			

			while(!stop){
				
				String mess = br.readLine();
				System.out.println("Message recu du client : " + mess);
				if(mess == null){
					stop=true;
					break;
				}
				//Analyser le message et répondre au client
				AnalyseMessage(mess,j);


				// if msg== START le serveur ne repond pas

			}

			System.out.println("Serveur fermer");
			br.close();
			pw.close();
			socket.close();

		}catch(IOException |NumberFormatException e){
			e.printStackTrace();
		}
}
}