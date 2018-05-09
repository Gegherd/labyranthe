import java.util.*;
import java.io.*;
import java.net.*;

public class Maze{

	public static int sx;
	public static int sy;
	public static int tab[][];

	public static void writeInit(int t [][]){
		sx = t.length;
		sy = t[0].length;
		tab = new int[sx][sy];
		try{
			PrintWriter pw = new PrintWriter("maze.txt");
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

	public static void update(){
		//tab[x2][y2] = 1;
		//tab[x1][y1] = 2;
		try{
			PrintWriter pw = new PrintWriter("maze.txt");
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

	public static void createTab(){
		try {
      		FileInputStream fis = new FileInputStream("maze.txt");
      		char current;
      		int i=0 ,j=0;
      		while (fis.available() > 0) {
        		current = (char) fis.read();
        		if (current!='\n') {
        			//System.out.print(current);
        			tab[i][j] = current - '0';
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

	public static void read(){
		try {
      		FileInputStream fis = new FileInputStream("maze.txt");
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

	public static void main(String[] args) {
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
	}
}