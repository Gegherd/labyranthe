/**
 * Classe Service tourne sur la machine Serveur
 * Elle permet à la Partie de communiquer sur le port de multi-diffusion associé à cette dernière
 * Chaque Partie aura une instance de cette classe, s'éxécutera sur un Thread distint et diffusera sur un port différent
 * Cette classe assura la communication en multi-diffusion uniquement
 */

public class ServicePartie implements Runnable {

	public int partie; 											// Numéro de la partie associée àl'instance de ce service
	public int portPartie;										// Port associé à la partie surlequelle elle communique avec les joueurs

	
	/**
	 * Constructeur de la classe
	 * @param partie : numéro de la partie
	 * @param port : port de diffusion de la partie
	 */
	public ServicePartie(int partie, int port){
		this.partie=partie;
		this.portPartie=port;
		
	}
	
	/**
	 *  Constitue Le message TCP au client de la partie lui indiquant que la partie est fini
	 * @param id : identifiant du joueur
	 * @return : Le message à envoyer au joueur
	 */
	public String MessageBYE(String id){
		String msg ="";
		 
		 return msg;
	}
	
	
	/**
	 * Constitue le message indiqaunt le déplacement d'un fantôme 
	 * @param x : indique la coordonnée x du nouvel emplacement du fantôme
	 * @param y :  indique la coordonnée y du nouvel emplacement du fantôme
	 * @return :  le message à diffuser aux joueurs
	 */
	public String MessageFAN( int x, int y){
		String msg ="";
		 
		 return msg;
	}
	
	
	/**
	 * Constitue le message indiqaunt la prise d'un fantôme par le joueur id à l'emplacement x,y 
	 * @param id : identifiant du joueur
	 * @param p : nombre de points du joueur - le score réalisé
	 * @param x : indique la coordonnée x de l'emplacement du fantôme à sa prise
	 * @param y : indique la coordonnée y de l'emplacement du fantôme à sa prise
	 * @return  : le message à diffuser aux joueurs
	 */
	public String MessageSCOR( String id, int p, int x, int y){
		String msg ="";
		 
		return msg;
	}
	
	/**
	 * Constitue le message à transmettre à un client pour lui faire parvenir celui envoyé par le Client id2
	 * @param id2 : identifiant du joueur expéditeur du message
	 * @param mess : le message à transmettre
	 * @return : le message à envoyer au client
	 */
	 public String MessageMESP(String id2, String mess){
		 String msg ="";
		 
		 return msg;
	 }
	
	
	@Override
	public void run() {
		
		
	}

}
