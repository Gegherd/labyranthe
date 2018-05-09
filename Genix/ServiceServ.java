import java.net.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class ServiceServ implements Runnable
{
 	private Thread _t;
 	private Socket _s;
  	private PrintWriter _pw;
 	private BufferedReader _br;
 	private Serv _serv;
 	private int _nClient = 0;
 	private int n = 0;
 	private Maze maze = new Maze();
 	

 	public ServiceServ(Socket s, Serv serv)
 	{
 		_serv = serv;
 		_s = s;
 		try
	 	{
	 		_pw = new PrintWriter(_s.getOutputStream());
	 		_br = new BufferedReader(new InputStreamReader(_s.getInputStream()));
	 		_nClient = serv.addClient(_s.getLocalAddress().toString());

	 		_pw.print("GAMES "+_serv.n+"***\n");
 			_pw.flush();

 			
	 	}
	 	catch(Exception e)
	 	{
			System.out.println(e);
			e.printStackTrace();
	 	}
	 	_t = new Thread(this);
	 	_t.start();
	}

 	public void run(){
 		int x = 0;
		int y = 0;
		int condition = 0;

 		String _mess = "";
 		System.out.println("Connection du client "+ _nClient);
		try
	 	{
			while(maze.tab[maze.tab.length-1][(maze.tab[maze.tab.length-1].length)-1]==3){
				condition = 0;
				while(condition==0){
					for (int i = 0;i<maze.tab.length;i++) {
						for (int j = 0;j<maze.tab[i].length;j++) {
							if (maze.tab[i][j]==8) {
								maze.tab[i][j]=1;
								maze.update();
							}
						}
					}
					int fx = randomFantome(0,maze.tab.length-1);
					int fy = randomFantome(0,(maze.tab[maze.tab.length-1].length)-1);
					if(maze.tab[fx][fy]==1){
						maze.tab[fx][fy] = 8;
						maze.update();
						condition = 1;
					}
				}
				display(maze.tab);
				_pw.print("Que faire? (u,d,r,l,udp)\n");
				_pw.flush();
				_mess = _br.readLine();
				if (Objects.equals(_mess,"udp")!=true) {
					_pw.print("De combien voulez vous avancer?\n");
					_pw.flush();
					n = Integer.parseInt(_br.readLine());
				}
				

				if (Objects.equals(_mess,"r")) {
					try{
						if(maze.tab[x][y+n] == 0){
							_pw.print("Vous avez touché un mur!!!\n");
							_pw.flush();
							_mess = _br.readLine();
						}
						else if (maze.tab[x][y+n] == 8){
							_pw.print("Bien joué, vous avez attrapé un fantôme!\n");
							_pw.flush();
							maze.tab[x][y]=1;
							maze.update();
							y+= n;
							maze.tab[x][y]=2;
							maze.update();
							_mess = _br.readLine();
							//display(tab);
						}
						else{
							_pw.print("Rien à signaler, vous avez avancé!\n");
							_pw.flush();
							maze.tab[x][y]=1;
							maze.update();
							y+= n;
							maze.tab[x][y]=2;
							maze.update();
							_mess = _br.readLine();
							//display(tab);
						}
					}
					catch(Exception e){
						_pw.print("En dehors de la zone du labyrinthe!\n");
						_pw.flush();
						_mess = _br.readLine();
					}
				}
				else if (Objects.equals(_mess,"l")) {
					try{
						if(maze.tab[x][y-n] == 0){
							_pw.print("Vous avez touché un mur!!!\n");
							_pw.flush();
							_mess = _br.readLine();
						}
						else if (maze.tab[x][y-n] == 8){
							_pw.print("Bien joué, vous avez attrapé un fantôme!\n");
							_pw.flush();
							maze.tab[x][y]=1;
							maze.update();
							y-= n;
							maze.tab[x][y]=2;
							maze.update();
							_mess = _br.readLine();
							//display(tab);
						}
						else{
							_pw.print("Rien à signaler, vous avez avancé!\n");
							_pw.flush();
							maze.tab[x][y]=1;
							maze.update();
							y-= n;
							maze.tab[x][y]=2;
							maze.update();
							_mess = _br.readLine();
							//display(tab);
						}
					}
					catch(Exception e){
						_pw.print("En dehors de la zone du labyrinthe!\n");
						_pw.flush();
						_mess = _br.readLine();
					}
				}
				else if (Objects.equals(_mess,"u")) {
					try{
						if(maze.tab[x-n][y] == 0){
						_pw.print("Vous avez touché un mur!!!\n");
						_mess = _br.readLine();
						}
						else if (maze.tab[x-n][y] == 8){
							_pw.print("Bien joué, vous avez attrapé un fantôme!\n");
							_pw.flush();
							maze.tab[x][y]=1;
							maze.update();
							x-= n;
							maze.tab[x][y]=2;
							maze.update();
							_mess = _br.readLine();
							//display(tab);
						}
						else{
							_pw.print("Rien à signaler, vous avez avancé!\n");
							_pw.flush();
							maze.tab[x][y]=1;
							maze.update();
							x-= n;
							maze.tab[x][y]=2;

							_mess = _br.readLine();
							//display(tab);
						}
					}
					catch(Exception e){
						_pw.print("En dehors de la zone du labyritnhe!\n");
						_pw.flush();
						_mess = _br.readLine();
					}
				}
				else if (Objects.equals(_mess,"d")) {
					try{
						if(maze.tab[x+n][y] == 0){
							_pw.print("Vous avez touché un mur!!!\n");
							_pw.flush();
							_mess = _br.readLine();
						}
						else if (maze.tab[x+n][y] == 8){
							_pw.print("Bien joué, vous avez attrapé un fantôme!\n");
							_pw.flush();
							maze.tab[x][y]=1;
							maze.update();
							x+= n;
							maze.tab[x][y]=2;
							maze.update();
							_mess = _br.readLine();
							//display(tab);
						}
						else{
							_pw.print("Rien à signaler, vous avez avancé!\n");
							_pw.flush();
							maze.tab[x][y]=1;
							maze.update();
							x+= n;
							maze.tab[x][y]=2;
							maze.update();
							_mess = _br.readLine();
							//display(tab);
						}
					}
					catch(Exception e){
						_pw.print("En dehors de la zone du labyrinthe!\n");
						_pw.flush();
						_mess = _br.readLine();
					}
				}
				else if (Objects.equals(_mess,"udp")) {
						_pw.print("Quelle est votre message?\n");
						_pw.flush();
						_mess = _br.readLine();
						_serv.sendAll(_mess);
						_pw.print("UDP envoyé!\n");
						_pw.flush();
				}
				else{
						_pw.print("Ce que vous avez écrit ne fait pas partie des 4 choix proposés!\n");
						_pw.flush();
						_mess = _br.readLine();
				}
				System.out.println("x: "+x+" and y: "+y);
			}
			_pw.print("Bravo, vous êtes sortie du labyrinthe!\n");
			_pw.flush();	

	 		_pw.close();
	 		_br.close();
	 		_s.close();
	 	}
		catch(Exception e){
		 System.out.println(e);
		 e.printStackTrace();
	 	}

	 	/*finally
	 	{
	 		if(_s!=null){
	
		 		try
		 		{
		 			System.out.println("Deconnexion du client "+ _nClient);
		 			_serv.delClient(_nClient);
		 			_s.close();
		 		}
		 		catch(Exception e)
		 		{
		 			System.out.println(e);
		 			e.printStackTrace();
		 		}
		 	}
	 	}*/
	}

	public static void display(int tab[][]){
		for (int i = 0;i<tab.length;i++) {
			for (int j = 0;j<tab[i].length;j++) {
				System.out.print(tab[i][j]);
			}
			System.out.print("\n");
		}
		System.out.println("");
	}

	public static int randomFantome(int min, int max){
   		int range = (max - min) + 1;     
   		return (int)(Math.random() * range) + min;
	}
}