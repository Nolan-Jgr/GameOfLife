//Nolan Jaeger
//CS 4306
//Ahmed
//Fall 2021
//Assignment1
package GoL;

import java.lang.reflect.Array;
import java.util.*;
public class GameOfLife {
	public static void main(String[]args) {
		int n = 10;
		int[][] arr = new int[5][5];
		int[][] neighbors = new int[5][5];
		long startTime = System.nanoTime();
		for(int x=0;x < arr.length;x++) {
			for(int y=0;y < arr[0].length;y++) {
				arr[x][y] = (int)(Math.random()*2);
			}
		}
		
		while(n <= 50) {
			System.out.println(n + "th Generation");
			for(int[] x : arr) {
				for(int y : x) {
					System.out.print(y + " ");
				}
				System.out.println();
			}
			long endTime = System.nanoTime();
			long Time = (endTime - startTime)/1000000;
			System.out.println("Elapsed Time: " + Time + "ms");
			startTime = System.nanoTime();
			for(int x = 0;x < arr.length;x++) {
				for(int y = 0;y < arr[0].length;y++) {
					int neighbor = 0;
						if(x+1 < arr.length && arr[x+1][y] == 1) {
							neighbor++;
						}
						if(x-1 >= 0 && arr[x-1][y] == 1) {
							neighbor++;
						}
						if(y+1 < arr.length && arr[x][y+1] == 1) {
							neighbor++;
						}
						if(y-1 >= 0 && arr[x][y-1] == 1) {
							neighbor++;
						}
						if((x+1 < arr.length && y+1 < arr.length) && arr[x+1][y+1] == 1) {
							neighbor++;
						}
						if((x+1 < arr.length && y-1 >= 0) && arr[x+1][y-1] == 1) {
							neighbor++;
						}
						if((x-1 >= 0 && y+1 < arr.length) && arr[x-1][y+1] == 1) {
							neighbor++;
						}
						if((x-1 >= 0 && y-1 >= 0) && arr[x-1][y-1] == 1){
							neighbor++;
						}
						neighbors[x][y] = neighbor;	
				}
				
			}		
			for(int i = 0; i < neighbors.length;i++) {
				for(int j = 0; j < neighbors[0].length;j++) {
					if(neighbors[i][j] == 3 && arr[i][j] == 0) {
						arr[i][j] = 1;
					}
					else if((neighbors[i][j] == 2 || neighbors[i][j] == 3) && arr[i][j] == 1){
						arr[i][j] = 1;
					}
					else {
						arr[i][j] = 0;
					}
				}
			}

			n+=10;

		}
		
	}

}
