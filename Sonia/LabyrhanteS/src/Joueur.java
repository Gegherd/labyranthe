import java.io.Serializable;

/**
 * Encapsule la modélisation logique du joueur
 * Garde les informations propre au joueurs
 * Un joueur est mappé sur un client : ils ont le même identifiant
 */

public class Joueur implements Serializable
{

	private static final long serialVersionUID = -630838556107604579L;
	
	
	public String id;									//Identifiant du joueur
	public String ip;									//Adresse ip
	
	public int portUDP;									//Port UDP du joueur
	public int points;									// Nombre de points du joueur : score dans la parrie
	public int partie;									// Num de la partie auquel le joueur est inscrit. -1 -> joueur n'est inscrit à aucune partie
	public int x;										//Coordonnée x du joueur(Client)dans le labyrinthe
	public int y;										//Coordonnée y du joueur (Client)dans le labyrinthe
	public boolean online;								// Indique si le joueur a envoyé un START ou pas				

	
	/**
	 * Constructeur de la classe Joueur
	 */
	public Joueur(String id, String ip){
		this.id=id;
		this.ip=ip;
		//this.portUDP=port;
		this.points=0;
		this.online=false;
		this.partie=(-1);
		this.x=0;
		this.y=0;
	}
		
	public String toString(){
		return ( this.id + " - Son IP : " + this.ip);
	}

	/**
	 * Déplace un joueur 
	 * @param sens : Sens du déplacement
	 * @param d : nombre de cases à sauter
	 */
	public void DeplacerJoueur(String sens, int d){
		
		
	}
}
