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
	}

	public static void main(String[] args){
		int tab[][]={
			{2,0,0,0},
			{1,1,1,0},
			{0,0,1,0},
			{0,0,1,3}
		};
		display(tab);
	}
}