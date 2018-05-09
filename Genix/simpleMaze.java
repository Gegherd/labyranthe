import java.util.*;
import java.io.*;
import java.net.*;

public class simpleMaze{

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

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int x = 0;
		int y = 0;
		int condition = 0;

		int tab[][]={
			{2,0,0,0},
			{1,1,1,0},
			{0,0,1,0},
			{0,0,1,3}
		};
		
		while(tab[tab.length-1][(tab[tab.length-1].length)-1]==3){
			condition = 0;
			while(condition==0){
				for (int i = 0;i<tab.length;i++) {
					for (int j = 0;j<tab[i].length;j++) {
						if (tab[i][j]==8) {
							tab[i][j]=1;
						}
					}
				}
				int fx = randomFantome(0,tab.length-1);
				int fy = randomFantome(0,(tab[tab.length-1].length)-1);
				if(tab[fx][fy]==1){
					tab[fx][fy] = 8;
					condition = 1;
				}
			}
			display(tab);
			System.out.println("Où voulez vous aller? (up,down,right,left)");
			String mess = sc.next();
			System.out.println("De combien voulez vous avancer?");
			int n = sc.nextInt();
			
			switch(mess){
				case "right":
					try{
						if(tab[x][y+n] == 0){
							System.out.println("Vous avez touché un mur!!!");
						}
						else if (tab[x][y+n] == 8){
							System.out.println("Bien joué, vous avez attrapé un fantôme!");
							tab[x][y]=1;
							y+= n;
							tab[x][y]=2;
							//display(tab);
						}
						else{
							System.out.println("Rien à signaler, vous avez avancé!");
							tab[x][y]=1;
							y+= n;
							tab[x][y]=2;
							//display(tab);
						}
					}
					catch(Exception e){
						System.out.println("En dehors de la zone du labyrinthe!");
					}
					break;
				case "left":
					try{
						if(tab[x][y-n] == 0){
						System.out.println("Vous avez touché un mur!!!");
						}
						else if (tab[x][y-n] == 8){
							System.out.println("Bien joué, vous avez attrapé un fantôme!");
							tab[x][y]=1;
							y-= n;
							tab[x][y]=2;
							//display(tab);
						}
						else{
							System.out.println("Rien à signaler, vous avez avancé!");
							tab[x][y]=1;
							y-= n;
							tab[x][y]=2;
							//display(tab);
						}
					}
					catch(Exception e){
						System.out.println("En dehors de la zone du labyrinthe!");
					}
					break;
				case "up":
					try{
						if(tab[x-n][y] == 0){
						System.out.println("Vous avez touché un mur!!!");
						}
						else if (tab[x-n][y] == 8){
							System.out.println("Bien joué, vous avez attrapé un fantôme!");
							tab[x][y]=1;
							x-= n;
							tab[x][y]=2;
							//display(tab);
						}
						else{
							System.out.println("Rien à signaler, vous avez avancé!");
							tab[x][y]=1;
							x-= n;
							tab[x][y]=2;
							//display(tab);
						}
					}
					catch(Exception e){
						System.out.println("En dehors de la zone du labyritnhe!");
					}
					break;
				case "down":
					try{
						if(tab[x+n][y] == 0){
							System.out.println("Vous avez touché un mur!!!");
						}
						else if (tab[x+n][y] == 8){
							System.out.println("Bien joué, vous avez attrapé un fantôme!");
							tab[x][y]=1;
							x+= n;
							tab[x][y]=2;
							//display(tab);
						}
						else{
							System.out.println("Rien à signaler, vous avez avancé!");
							tab[x][y]=1;
							x+= n;
							tab[x][y]=2;
							//display(tab);
						}
					}
					catch(Exception e){
						System.out.println("En dehors de la zone du labyrinthe!");
					}
					break;
				default:
					System.out.println("Ce que vous avez écrit ne fait pas partie des 4 choix proposés!");
					break;
			}
			System.out.println("x: "+x+" and y: "+y);
		}
		System.out.println("Bravo, vous êtes sortie du labyrinthe!");	
	}
}