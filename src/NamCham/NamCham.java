package NamCham;

import java.io.FileInputStream;
import java.util.Scanner;

public class NamCham {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/NamCham/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int count = 0;
			
			for(int j = 0; j < N; j++) {
				int check = 0;
				for(int i = 0; i < N; i++) {
					if(arr[i][j] == 1 || arr[i][j] == 2) {
						if(arr[i][j] == 2 && check == 1) {	
							count++;
						}
						check = arr[i][j];
					}
				}
			}
			
			System.out.println("#" + (t + 1) + " " + count);
		}
	}
}
