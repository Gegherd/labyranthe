import java.util.*;
import java.io.*;
import java.net.*;

public class Labyrinthe{

//Pour chaque nouvelle partie, creer un nouveau fichier 
	
	public static int sx;
	public static int sy;
	//public static int tab[][];

	public static void writeInit(int t [][],int numPartie){ //Creer un fichier avec le labyrinthe
		try{
			PrintWriter pw = new PrintWriter("maze"+numPartie+".txt");
			for (int i =0;i<t.length;i++){
				for (int j=0;j<t[i].length;j++){
					pw.print(t[i][j]);
				}
				//pw.print('.');
				pw.print("\n");
			}
			pw.close();
		}
		catch(Exception e){
			System.out.println(e);
		 	e.printStackTrace();
		}
	}

	public static void update(int numPartie,int tab[][]){ //Maj du coup du joueur dans le fichier
		//tab[x2][y2] = 1;
		//tab[x1][y1] = 2;
		try{
			PrintWriter pw = new PrintWriter("maze"+numPartie+".txt");
			for (int i =0;i<tab.length;i++){
				for (int j=0;j<tab[i].length;j++){
					pw.print(tab[i][j]);
				}
				//pw.print('.');
				pw.print("\n");
			}
			pw.close();
		}
		catch(Exception e){
			System.out.println(e);
		 	e.printStackTrace();
		}
	}

	public static void createTabSec(int tab1[][],int numPartie,int tab2[][]){ //Prends le fichier texte et creer un tab
		try {
      		FileInputStream fis = new FileInputStream("maze"+numPartie+".txt");
      		char current;
      		int i=0 ,j=0;
      		while (fis.available() > 0) {
        		current = (char) fis.read();
        		if (current!='\n') {
        			//System.out.print(current);
        			tab2[i][j] = current - '0';
        			j++;
        		}
        		else{
        			i++;
        			j=0;
        		}
      		}
    	} 
    	catch (IOException e) {
     		e.printStackTrace();
    	}
	}

	public static void read(int numPartie){
		try {
      		FileInputStream fis = new FileInputStream("maze"+numPartie+".txt");
      		char current;
      		int i ,j;
      		while (fis.available() > 0) {
        		current = (char) fis.read();
        		if (current=='\n') {
        			//System.out.print("Espace!");
        		}
        		System.out.print(current);
      		}
    	} 
    	catch (IOException e) {
     		e.printStackTrace();
    	}
	}

/*	public static void main(String[] args) {
		int t[][]={
			{2,0,0,0},
			{1,1,1,0},
			{0,0,1,0},
			{0,0,1,3}
		};
		writeInit(t);
		read();
		System.out.println("");
		createTab();
		read();
		System.out.println("");
		//update(1,0,0,0);
		//read();
	}*/
}
