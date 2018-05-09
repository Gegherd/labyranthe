import java.io.Serializable;
import java.util.ArrayList;
import java.util.*;


/**
 * Structure de données pour stocker les données et la logique d'une Partie
 */


public class Partie {
	
//	private static final long serialVersionUID = 5464055556436257037L;
	
	//public String ip; 							//adresse ip de la partie
	public int numPartie;						//Numéro de la partie 
	public int NBJoueurs;						//Nbre de joueurs inscrits
	public ArrayList<Joueur> listJoueurs;		//Liste des joueurs inscrits à la partie
	public Labyrinthe laby;						//Labyrinthe associé à la Partie
	public boolean Encours;						// Statut de la partie : Encours=true -> Partie démarée sinon la Partie n'est pas encore lancée
	public Thread th;							// Thread associé à la partie
	
	public int port;						//Port de la partie	
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

	
	//Ajoute un joueur a la partie
	public void addJoueur(Joueur j){
		this.listJoueurs.add(j);
		this.NBJoueurs++;
	}

	//Pour le Up 
	public String Up(int deplacement){
		String rep="";

		System.out.println("Demande un deplacement de :" + deplacement);
		//Tester si le deplacement est autorise et si c'est ok faire la mise a jour
		return rep;
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
}
