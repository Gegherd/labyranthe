import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;


/**
 * Structure de données pour stocker les données et la logique d'une Partie
 */


public class Partie implements Runnable{
	
	private String rep;						// Reponse donner au joueur
	public String ip; 						//Adresse ip de la partie
	public int port;						//Port de multidiffusion de la partie	
	private int tabP[][];
	public int numPartie;						//Numéro de la partie 
	public int NBJoueurs;						//Nbre de joueurs inscrits
	public ArrayList<Joueur> listJoueurs;		//Liste des joueurs inscrits à la partie
	public Labyrinthe maze;						//Labyrinthe associé à la Partie
	public boolean Encours;						// Statut de la partie : Encours=true -> Partie démarée sinon la Partie n'est pas encore lancée
	public Thread th;							// Thread associé à la partie
	
	public static int id_partie=0;

	//Methode pour generer un entier unique 
	public synchronized int getUniqueId(){
	    return (id_partie++);
	}
	
	/**
	 * Constructeur de la classe Partie
	 */
	public Partie(){
		this.numPartie=getUniqueId();
		this.port=6000; //Trouver un nouveau port pour chq nouvelle partie
		this.Encours=false;
		this.NBJoueurs=0;
		listJoueurs=new ArrayList<Joueur>();
		//Genix
		maze = new Labyrinthe();
		int tab[][]={
			{2,0,0,0},
			{1,1,1,0},
			{0,0,1,0},
			{0,0,1,3}
			};
		this.tabP = new int[tab.length][tab[0].length];
		maze.writeInit(tab,numPartie);
		maze.createTabSec(tab,numPartie,this.tabP);
		//*/
	}


	//Retourne true si un joueur est inscrit dans cette partie 
	public boolean isInList(String id_client){
		ListIterator<Joueur> li=this.listJoueurs.listIterator(0);
			while(li.hasNext()){
				Joueur j=li.next();
				if(j.id.equals(id_client)){
					return true;
				}
			}
		return false;
	}

	public void sendUDP(String id, String msg){

	}

	//Retourne le joueur inscrit dans la partie avec l'identifiant id
	public Joueur getJoueur(String id_client){
		Joueur jo=null;
		ListIterator<Joueur> li=this.listJoueurs.listIterator(0);
			while(li.hasNext()){
				Joueur j=li.next();
				if(j.id.equals(id_client)){
					return j;
				}
			}
		return jo;
	}
	
	//Inscrire un joueur a la partie
	public void addJoueur(Joueur j){
		this.listJoueurs.add(j);
		this.NBJoueurs++;
	}


	//Desinscrire un joueur a la partie
	public void deleteJoueur(String id_client){
		Joueur jo=getJoueur(id_client);
		this.listJoueurs.remove(jo);
		this.NBJoueurs--;
	}

	//Retourne la liste de tous les joueurs inscrits a une partie
	public String getListJoueurs(){
		String rep="";
		ListIterator<Joueur> li=this.listJoueurs.listIterator(0);
			while(li.hasNext()){
				Joueur j=li.next();
				rep+=j.id;
				rep+=" ";
			}
		System.out.println("Liste des joueurs de la partie : " + rep);
		return rep;
	}


	//Pour le Up 
	public String Up(int deplacement, Joueur j){
		String rep="";

		System.out.println("Demande un deplacement de :" + deplacement);
				//Tester si le deplacement est autorise et si c'est ok faire la mise a jour
				//Test d'ajout de Genix 09/05/18
				//Comment avoir la position du joueur concerné?
			try{
				if(this.tabP[j.x-deplacement][j.y] == 0){
					rep= "Vous avez touché un mur!!!\n";
				}
				else if (this.tabP[j.x-deplacement][j.y] == 8){
					rep="Bien joué, vous avez attrapé un fantôme!\n";
					this.tabP[j.x][j.y]=1;
					maze.update(numPartie,this.tabP);
					j.x-= deplacement;
					this.tabP[j.x][j.y]=2;
					maze.update(numPartie,this.tabP);
					j.points+=10;
					rep="MOF "+j.x+" "+j.y+" "+j.points+"***\n";
				}
				else if (this.tabP[j.x-deplacement][j.y] == 1){
					rep="Rien à signaler, vous avez avancé!\n";
					this.tabP[j.x][j.y]=1;
					maze.update(numPartie,this.tabP);
					j.x-= deplacement;
					this.tabP[j.x][j.y]=2;
					rep="MOV "+j.x+" "+j.y+"***\n";
				}
			}
			catch(Exception e){
				rep="En dehors de la zone du labyrinthe!\n";
			}
				//*/
			//rep= "OK";
			return rep;
	}

	public String Down(int deplacement, Joueur j){
		String rep="";
		display(this.tabP);
		System.out.println("Demande un deplacement de :" + deplacement);
				//Tester si le deplacement est autorise et si c'est ok faire la mise a jour
				//Test d'ajout de Genix 09/05/18
				//Comment avoir la position du joueur concerné?
			try{
				if(this.tabP[j.x+deplacement][j.y] == 0){
					rep= "Vous avez touché un mur!!!\n";
				}
				else if (this.tabP[j.x+deplacement][j.y] == 8){
					this.tabP[j.x][j.y]=1;
					maze.update(numPartie,this.tabP);
					j.x+= deplacement;
					this.tabP[j.x][j.y]=2;
					maze.update(numPartie,this.tabP);
					j.points+=10;
					rep="MOF "+j.x+" "+j.y+" "+j.points+"***\n";
				}
				else if (this.tabP[j.x+deplacement][j.y] == 1){
					this.tabP[j.x][j.y]=1;
					maze.update(numPartie,this.tabP);
					j.x+= deplacement;
					this.tabP[j.x][j.y]=2;
					rep="MOV "+j.x+" "+j.y+"***\n";
				}
			}
			catch(Exception e){
				rep="En dehors de la zone du labyrinthe!\n";
			}
				//*/
		display(this.tabP);
			//rep= "OK";
		return rep;
	}
	
	public String Right(int deplacement, Joueur j){
		String rep="";
		display(this.tabP);
		System.out.println("Demande un deplacement de :" + deplacement);
				//Tester si le deplacement est autorise et si c'est ok faire la mise a jour
				//Test d'ajout de Genix 09/05/18
				//Comment avoir la position du joueur concerné?
			try{
				if(this.tabP[j.x][j.y+deplacement] == 0){
					rep= "Vous avez touché un mur!!!\n";
				}
				else if (this.tabP[j.x][j.y+deplacement] == 8){
					rep="Bien joué, vous avez attrapé un fantôme!\n";
					this.tabP[j.x][j.y]=1;
					maze.update(numPartie,this.tabP);
					j.y+= deplacement;
					this.tabP[j.x][j.y]=2;
					maze.update(numPartie,this.tabP);
					j.points+=10;
					rep="MOF "+j.x+" "+j.y+" "+j.points+"***\n";
				}
				else if (this.tabP[j.x][j.y+deplacement] == 1){
					rep="Rien à signaler, vous avez avancé!\n";
					this.tabP[j.x][j.y]=1;
					maze.update(numPartie,this.tabP);
					j.y+= deplacement;
					this.tabP[j.x][j.y]=2;
					rep="MOV "+j.x+" "+j.y+"***\n";
				}
			}
			catch(Exception e){
				rep="En dehors de la zone du labyrinthe!\n";
			}
				//
			//rep= "OK";
			display(this.tabP);
			return rep;
	}

	public String Left(int deplacement, Joueur j){
		String rep="";
		display(this.tabP);
		System.out.println("Demande un deplacement de :" + deplacement);
				//Tester si le deplacement est autorise et si c'est ok faire la mise a jour
				//Test d'ajout de Genix 09/05/18
				//Comment avoir la position du joueur concerné?
			try{
				if(this.tabP[j.x][j.y-deplacement] == 0){
					rep= "Vous avez touché un mur!!!\n";
				}
				else if (this.tabP[j.x][j.y-deplacement] == 8){
					rep="Bien joué, vous avez attrapé un fantôme!\n";
					this.tabP[j.x][j.y]=1;
					maze.update(numPartie,this.tabP);
					j.y-= deplacement;
					this.tabP[j.x][j.y]=2;
					maze.update(numPartie,this.tabP);
					j.points+=10;
					rep="MOF "+j.x+" "+j.y+" "+j.points+"***\n";
				}
				else if (this.tabP[j.x][j.y-deplacement] == 1){
					rep="Rien à signaler, vous avez avancé!\n";
					this.tabP[j.x][j.y]=1;
					maze.update(numPartie,this.tabP);
					j.y-= deplacement;
					this.tabP[j.x][j.y]=2;
					rep="MOV "+j.x+" "+j.y+"***\n";
				}
			}
			catch(Exception e){
				rep="En dehors de la zone du labyrinthe!\n";
			}
				//
			//rep= "OK";
			display(this.tabP);
			return rep;
	}
	
	public static void display(int tab[][]){ //Test pour afficher le tabP
		for (int i = 0;i<tab.length;i++) {
			for (int j = 0;j<tab[i].length;j++) {
				System.out.print(tab[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("");
	}

	public String toString(){
		return ("Partie numero "+ this.numPartie + " avec "+ this.NBJoueurs + " joueurs.");
	}
	/*

	//Pour la multi-diffusion
	public static void main(){
		try{
		DatagramSocket dso=new DatagramSocket();
		byte[]data;
		for(int i=0;i <= 10; i++){
		//Thread.sleep(1000);
		String s="MESSAGE "+i+" \n";
		data=s.getBytes();
		InetSocketAddress ia=new InetSocketAddress("225.1.2.4",9999);
		DatagramPacket paquet=new 
		DatagramPacket(data,data.length,ia);
		dso.send(paquet);
		}
		} catch(Exception e){
		e.printStackTrace();
		}
*/
	//Recupere un msg du serveur et le traite
/*	public String getAnswer(Socket so){
		String rep;

		//On recupere la requete du serveur
		BufferedReader br = new BufferedReader(new InputStreamReader(so.getInputStream()));
		String s =br.readline();
		br.close();

		//On la traite

		//On lui repond
		return rep;
	}*/
	public void run(){
		while(true){

		}
	}
}
