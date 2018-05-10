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
	String id_client="";

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
		String msg ="DUNNO***";
		 
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
	public String MessageLIST(int m, int s){
		String msg ="LIST! "+ m+ " " + s +"***";
		return msg;
	}
	
	
	/**
	 * Construit le message que le Serveur envoie au client pour lui indiquer les joueurs de sa partie
	 * Le Serveur envoie s (nbr de joueurs message de ce type
	 * @param id : indique l'identifiant du joueur
	 */
	public String MessagePLAYER(String id){
		String msg ="PLAYER "+ id +"***";
		 
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
		int partie=-1;
		ListIterator<Partie> li=serveur.listParties.listIterator(0);
			while(li.hasNext()){
				Partie p=li.next();
				boolean client =p.isInList(id_client);
				if(client==true){
					partie=p.numPartie;
					//System.out.println("Joueur " + id_client+" trouver dans la partie " + p.numPartie);
				}			
			}
		return partie;
	}

	//Retourne la partie auquel est inscrit le joueur 
	public Partie Partie_joueur(String id_client){
		Partie partie=null;

		ListIterator<Partie> li=serveur.listParties.listIterator(0);
			while(li.hasNext()){
				Partie p=li.next();
				boolean client =p.isInList(id_client);
				if(client==true){
					partie=p;
					//System.out.println("Joueur " + id_client+" trouver dans la partie " + p.numPartie);
				}			
			}
		return partie;
	}


	//retourne True si tous les joueurs d'une partie on fait START
	public boolean Joueurs_Start(){
		ListIterator<Joueur> li=serveur.listJoueurs.listIterator(0);
			while(li.hasNext()){
				Joueur j=li.next();
				if(j.online==false){
					return false;
				}
			}
		return true;
	}

	//Lancer une nouvelle partie
	public void Lancer_Partie(Partie p){
		boolean start=Joueurs_Start(); 
		if (start == true){
		/*	Thread th = new Thread(p);
			th.start(); 		
			threads.add(th); */
			System.out.println("Tous les joueurs de la partie ont fait START. La partie " + p.numPartie +" peut commencer.");
			//On lance un nouveau Thread
		} else {
			System.out.println("Il manque des joueurs pour commencer la partie numero " + p.numPartie);

		}			
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
	int port_udp_client;
	Joueur current=null;
	String mess_clean= mess.replace("***", "");
	//System.out.println("Message clean = " + mess_clean);
	mess_array = mess_clean.split(" ");

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
				j.portUDP=port_udp_client;
				//System.out.println("Port UDP du client : " + j.portUDP);
			} catch (NumberFormatException e){
				pw.println("REGNO***");
				pw.flush();
				System.out.println("Erreur dans le format de la commande");
				break;
			}

			//Creer une nouvelle partie
			Partie p=new Partie();
			serveur.listParties.add(p);
			serveur.nbr_parties++;
			j.partie=p.numPartie;
		//	System.out.println("Creation d'une nouvelle partie reussie. \n id de la partie = "+ p.numPartie);
			p.addJoueur(j); //Ajouter le joueur a la liste des joueurs de la partie
		/*	for(int i = 0; i < serveur.listParties.size(); i++){

      			System.out.println("Élément à l'index " + i + " = " + serveur.listParties.get(i));
  			}*/

			j.partie=p.numPartie; //Maj du num de la partie auquel le joueur est inscrit
			//System.out.println("Ajout du joueur a la liste des joueurs de la partie : " + j.partie);
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
			/*ListIterator<Joueur> lij=serveur.listJoueurs.listIterator(0);
			while(lij.hasNext()){
				Joueur jo=lij.next();
				//System.out.println(jo.id);
				if(jo.id.equals(id_client)){ //Si on trouve un joueur dans la liste avec le même id que celui envoyé par le client
					current=jo;
				}
			}
			//System.out.println(current.toString()); */

			//Recuperer le num de port et le num de partie
			try{
				port_udp_client = Integer.parseInt(mess_array[2]);
				j.portUDP=port_udp_client;
				num_partie= Integer.parseInt(mess_array[3]);

			} catch (NumberFormatException e){
				pw.println("REGNO***");
				pw.flush();				
				break;
			}	

			boolean partie_trouvee=false;
			//Chercher la partie correspondant dans la linkedlist
			ListIterator<Partie> li=serveur.listParties.listIterator(0);
			while(li.hasNext()){
				Partie pt=li.next();

				if(pt.numPartie==num_partie){ //Si on trouve une partie dans la liste avec le même id que celui envoyé par le client
					
					partie_trouvee=true;
					if(j.partie == (-1)){ //Si le joueur n'est inscrit a aucune partie
						
						if(partie_trouvee==true){ //Si la partie demandee existe 
							pt.addJoueur(j);
							System.out.println("Le joueur " + j.id + " au port UDP "+ j.portUDP + " a ete inscrit a la partie "+ pt.numPartie);
							reponse = MessageREGOK(num_partie);
							pw.println(reponse);
							pw.flush();
							break;
						} 
					} 
				}
			}
			reponse = MessageREGNO();
			pw.println(reponse);
			pw.flush();
			break;

		case "START": //Start une partie - La partie commence quand tt les joueurs inscrits ont fait start
			if(mess_array.length!=1){
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}

			j.online=true;
			Partie pa=Partie_joueur(j.id);
			System.out.println("Le client a fait START : " + pa.toString());
			//Le serveur ne repond rien
			Lancer_Partie(pa);
			//Tester si tous les joueurs de la partie ont fait START, si c'est le cas on lance la partie

			break;

		case "UNREG": //Desinscription à une partie
			if(mess_array.length!=1){
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}

			System.out.println(id_client);
			num_partie = searchPartie(id_client); //On cherche le num de la partie auquel est connecte le client
			
			if(num_partie==-1){ //Si le joueur n'est inscrit a aucune partie
				pw.println("DUNNO***");
				pw.flush();
				break;
			}
			System.out.println(id_client + " demande sa desincription a la partie "+ num_partie);

				ListIterator<Partie> lit2=serveur.listParties.listIterator(0); //On parcourt la liste des parties pour envoyer en message up() a la bonne partie
				while(lit2.hasNext()){
					Partie pt=lit2.next();
					if(pt.numPartie== num_partie){ 
						j.partie=(-1);
						pt.deleteJoueur(id_client); 			//Supprimer le joueur de la partie	
					}
				}
			reponse = MessageUNREGOK(num_partie);
			pw.println(reponse);
			pw.flush();
			break;
			
		case "SIZE?": //Taille du labyrinthe
			if(mess_array.length!=2){
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}
			int taille=-1;
			try{
				num_partie= Integer.parseInt(mess_array[1]);
				ListIterator<Partie> lit3=serveur.listParties.listIterator(0); //On parcourt la liste des parties 
				while(lit3.hasNext()){
				Partie par=lit3.next();
					if(par.numPartie== num_partie){ 
						//Recup la taille du labyrinthe
						//taille = ...
					}
				}
				if (taille==-1){ //Si le num de la partie demandee par le client n'existe pas
					reponse = MessageDUNNO();
					pw.println(reponse);
					pw.flush();
					break;
				}
			}catch (NumberFormatException e){
				pw.println("Erreur format de la commande");
				pw.flush();
				System.out.println("Erreur dans le format de la commande");
				break;
			}


		//	reponse = MessageSIZE_EX(num_partie);
			pw.println(reponse);
			pw.flush();
			break;	

		case "LIST?": //Nbr de joueurs inscrits dans la partie m

			if(mess_array.length!=2){
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}

			String listejoueurs="";
			int nbrjoueurs=-1; //Nombre de joueurs de la partie demandee
			try{

				num_partie= Integer.parseInt(mess_array[1]); 
				ListIterator<Partie> lit3=serveur.listParties.listIterator(0); //On parcourt la liste des parties 
				while(lit3.hasNext()){
				Partie par=lit3.next();
					if(par.numPartie== num_partie){ 
						listejoueurs=par.getListJoueurs();
						nbrjoueurs=par.NBJoueurs;
					}
				}
				if (nbrjoueurs==(-1)){ //Si le num de la partie demandee par le client n'existe pas
					reponse = MessageDUNNO();
					pw.println(reponse);
					pw.flush();
					break;
				}
			}catch (NumberFormatException e){
				pw.println("Erreur format de la commande");
				pw.flush();
				System.out.println("Erreur dans le format de la commande");
				break;
			}
			//Envoi du msg LIST
			reponse = MessageLIST(num_partie,nbrjoueurs);
			pw.println(reponse);
			pw.flush();

			//Envoi de tt les msg PLAYER
			String[] tab=listejoueurs.split(" ");
			for(int i=0;i<tab.length;i++){
				reponse = MessagePLAYER(tab[i]);
				pw.println(reponse);
				pw.flush();
			}
			break;

		case "GAMES?": //Nbr de parties pour lesquels il y'a des joueurs inscrits
			
			//Envoi du msg GAMES
			String resp="GAMES "+ serveur.nbr_parties + "***";
			pw.println(resp);
			pw.flush();

			//Envoie des msg GAME
			if(serveur.listParties.size()!=0){
				ListIterator<Partie> list=serveur.listParties.listIterator(0);
				while(list.hasNext()){
					Partie pat=list.next();
					resp=MessageGAME(pat.numPartie,pat.NBJoueurs);
					//System.out.println("ENVOI DE GAME");
					pw.println(resp);
					pw.flush();
					
				}
			}

		case "UP":
			String repU = "";
			if(mess_array.length!=2){ //On teste que le format du message est bon
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}

			try{
				int deplacement= Integer.parseInt(mess_array[1]); //On recupere le deplacement demandé par le client
				int partie = searchPartie(id_client); //On cherche le num de la partie auquel est connecte le client
				ListIterator<Partie> lit=serveur.listParties.listIterator(0); //On parcourt la liste des parties pour envoyer en message up() a la bonne partie
				while(lit.hasNext()){
					Partie pt=lit.next();
					if(pt.numPartie== partie){ 
						Joueur jou=pt.getJoueur(id_client);
						repU =pt.Up(deplacement,jou); //On envoie a la partie le num de deplacement que le client a demander
						pw.println(repU);
						pw.flush();
						break;
					}
				}
			}catch (NumberFormatException e){
				pw.println("Erreur format de la commande");
				pw.flush();
				System.out.println("Erreur dans le format de la commande");
				break;
			}
			break;

		case "DOWN":
			String repD = "";
			if(mess_array.length!=2){ //On teste que le format du message est bon
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}

			try{
				int deplacement= Integer.parseInt(mess_array[1]); //On recupere le deplacement demandé par le client
				int partie = searchPartie(id_client); //On cherche le num de la partie auquel est connecte le client
				ListIterator<Partie> lit=serveur.listParties.listIterator(0); //On parcourt la liste des parties pour envoyer en message up() a la bonne partie
				while(lit.hasNext()){
					Partie pt=lit.next();
					if(pt.numPartie== partie){ 
						Joueur jou=pt.getJoueur(id_client);
						repD = pt.Down(deplacement,jou); //On envoie a la partie le num de deplacement que le client a demander
						pw.println(repD);
						pw.flush();
						break;
					}
				}
			}catch (NumberFormatException e){
				pw.println("Erreur format de la commande");
				pw.flush();
				System.out.println("Erreur dans le format de la commande");
				break;
			}
			break;

		case "LEFT":
			String repL = "";
			if(mess_array.length!=2){ //On teste que le format du message est bon
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}

			try{
				int deplacement= Integer.parseInt(mess_array[1]); //On recupere le deplacement demandé par le client
				int partie = searchPartie(id_client); //On cherche le num de la partie auquel est connecte le client
				ListIterator<Partie> lit=serveur.listParties.listIterator(0); //On parcourt la liste des parties pour envoyer en message up() a la bonne partie
				while(lit.hasNext()){
					Partie pt=lit.next();
					if(pt.numPartie== partie){ 
						Joueur jou=pt.getJoueur(id_client);
						repL=pt.Left(deplacement,jou); //On envoie a la partie le num de deplacement que le client a demander
						pw.println(repL);
						pw.flush();
						break;
					}
				}
			}catch (NumberFormatException e){
				pw.println("Erreur format de la commande");
				pw.flush();
				System.out.println("Erreur dans le format de la commande");
				break;
			}
			break;

		case "RIGHT":
			String repR = "";
			if(mess_array.length!=2){ //On teste que le format du message est bon
				pw.println("Erreur format de la commande");
				pw.flush();
				break;
			}

			try{
				int deplacement= Integer.parseInt(mess_array[1]); //On recupere le deplacement demandé par le client
				int partie = searchPartie(id_client); //On cherche le num de la partie auquel est connecte le client
				ListIterator<Partie> lit=serveur.listParties.listIterator(0); //On parcourt la liste des parties pour envoyer en message up() a la bonne partie
				while(lit.hasNext()){
					Partie pt=lit.next();
					if(pt.numPartie== partie){ 
						Joueur jou=pt.getJoueur(id_client);
						repR=pt.Right(deplacement,jou); //On envoie a la partie le num de deplacement que le client a demander
						pw.println(repR);
						pw.flush();
						break;
					}
				}
			}catch (NumberFormatException e){
				pw.println("Erreur format de la commande");
				pw.flush();
				System.out.println("Erreur dans le format de la commande");
				break;
			}
			break;
		case "QUIT":
			
		case "GLIST?":
			
		case "ALL?":
			
		case "SEND":

		default :
			pw.println("Commande non reconnue");
			pw.flush();
			break;
			
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

			//Tester si l'identififiant est unique
			for(int i = 0; i < serveur.listJoueurs.size(); i++){
				if( id.equals(serveur.listJoueurs.get(i).id) ){
					pw.println("Identifiant deja pris.");
					pw.flush();
					id=br.readLine();
				} 
  			}

			String ip=(socket.getInetAddress().getHostName());
			//Le client choisit son port et on teste si il est free
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
			} 

			while(!stop){
				
				String mess = br.readLine();
				System.out.println("Message recu de " + j.id + " : " + mess);
				if(mess == null){
					stop=true;
					break;
				}

				//Analyser le message et répondre au client
				AnalyseMessage(mess,j);

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