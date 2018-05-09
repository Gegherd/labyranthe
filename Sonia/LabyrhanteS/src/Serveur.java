/**
 * Classe Encapsulant la logique du Serveur Labyrhante
 * Elle gère les parties et les démarrent 
 * Elle gère l'inscription des joueurs(clients) aux parties
 */

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.io.Serializable;


 public class Serveur {

	
	// Données pour communication TCP
	public int TCPPort;					//Port d'écoute TCP du Serveur
	private static final int MAX_PARTIES = 10;				// Nombre maximal de parties en parallèle
	private transient ArrayList<Thread> threads; 			//Liste des Threads 
	
	
	// Données nécessaires pour la communication UDP
	public int UDPPort;					//Port d'écoute UDP du Serveur
	final static int taille = 220; 							// Taille maximale des messages UDP
	final static byte buffer[] = new byte[taille];			// Buffer pour contenir le message à envoyer

	
	// Données nécessaires pour le jeu
	public int nbr_parties; //Nombre de parties 
	public LinkedList<Partie> listParties; //Liste de toutes les parties
	public LinkedList<Joueur> listJoueurs; //Liste de tous les joueurs 

 
	public Serveur(int tcp,int udp){
		this.TCPPort=tcp;
		this.UDPPort=udp;
		threads=new ArrayList<Thread>();
		listParties=new LinkedList<Partie>();
		listJoueurs=new LinkedList<Joueur>();
		this.nbr_parties=0;

	}
	
	/**
	*Lancement d'une nouvelle partie
	*/
	private void NouvellePartie(){
		System.out.println("Démarrage d'une nouvelle partie...");
		Thread th = new Thread();
		th.start();
		threads.add(th); 						//On ajoute le nouveau thread a l'arraylist avec tt les thread
		//connect_server();
	}

	
	/**
	 * Connecte le serveur avec ServerSocket sur le port donné
	 * port : port de connexion
	 */
	public void connect_server(){
		System.out.println("Connexion serveur au port : " + TCPPort);
		try{
			ServerSocket server = new ServerSocket(TCPPort);
			while(true){
				Socket socket = server.accept(); 
				Service serv = new Service(socket,this);
				Thread th = new Thread(serv);
				th.start(); 		
				threads.add(th);
				
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}



	/**
	 * Envoie un message UDP
	 * @param message : message à envoyer
	 * @param id : identifiant du client - représente le nom de la machine
	 * @param port : Port UDP sur lequel se fera l'envoie
	 */
	public void SendUDPMessage(String message,String id, int port){
		try{
			//Création de la connexion côté serveur, en spécifiant un port d'écoute
            DatagramSocket server = new DatagramSocket(port);
			
            byte[]data;
			data=message.getBytes();
			DatagramPacket paquet=new DatagramPacket(data,data.length,InetAddress.getByName(id),port);
			server.send(paquet);			//Envoie su message vers le client id
			server.close(); 				// Fermer la connexion et libérer la ressource
			
			} catch(Exception e){
				e.printStackTrace();
			}
	}
	
	
	
	
	
	/**
	 * Au démarrage du serveur, il créé les instances de classes qui lui permetrront de stocker :
	 *   - Serveur : pour gérer le Seveur
	 *   - ClientListe : pour gérer les clients qui communiquent avec lui
	 *   - ArrayList<Partie> : pour gérer Les parties qui s'exécuteronst sur le serveur
	 *   - ArrayList<Thread> : pour gérer les threads affectés 
	 * 
	 * Il démarre ensuite les services dont il a besoin pour communiquer avec les clients :
	 *   - Le Service TCP pour communiquer avec les clients
	 *   - Au lancement de chaque partie, il démarre un nouveau service sur le port de la partie qui multi-diffusera les données de la partie
	 *   
	 * 
	 * @param args
	 */
	public static void main(String[] args){

		ArrayList<Partie> parties = new ArrayList<Partie>() ;				
		ArrayList<Thread> threads = new ArrayList<Thread>();
		Serveur serveur=new Serveur(6262,2904);		//Serveur avec les ports tcp et udp			
		boolean fini=true;

		try {
			serveur.connect_server();
			 /*ServerSocket server=new ServerSocket(TCPPort);
			 System.out.println("Le serveur est a l'ecoute du port "+ server.getLocalPort());
			 while(true){
				 Socket socket=server.accept();
				 System.out.println("Un nouveau client vient de se connecter.");
				 Service serv=new Service(socket);
				 Thread t=new Thread(serv);
				 t.start();*/
		} catch (Exception e){
			e.printStackTrace(); 
		}

		}
}