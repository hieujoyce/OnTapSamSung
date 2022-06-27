package DaoVangRemix;

import java.io.FileInputStream;
import java.util.Scanner;

public class DaoVangRemix {
	
	static int solve(int R, int C, Scanner sc) {
		int[][] arr = new int[R][C];
		for(int j = 0; j < R; j++) {
			String str = sc.nextLine();
			for(int k = 0; k < C; k++) {
				if(str.charAt(k) == '1') {
					arr[j][k] = 1;
				} else {
					arr[j][k] = 0;
				}
			}
		}
		
		for(int i = 0; i < R; i++) {
			int check = 1;
			for(int j = 0; j < C; j++) {
				if(arr[i][j] == 1) {
					check = 0;
					break;
				}
			}
			if(check == 1) {
				for(int j = 0; j < C; j++) {
					arr[i][j] = -1;
				}
			}
		}
		
		for(int j = 0; j < C; j++) {
			int check = 1;
			for(int i = 0; i < R; i++) {
				if(arr[i][j] == 1) {
					check = 0;
					break;
				}
			}
			if(check == 1) {
				for(int i = 0; i < R; i++) {
					arr[i][j] = -1;
				}
			}
		}
		int count = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(arr[i][j] == -1) count++;
			}
		}
		
//		System.out.println("--------");
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.printf("%3d", arr[i][j]);
//			}
//			System.out.println("");
//		}
		
		return count;
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/DaoVangRemix/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int R = sc.nextInt();
			int C = sc.nextInt();
			sc.nextLine();
			int result = solve(R, C, sc);
			System.out.println("#" + (i + 1) + " " + result);	
			
		}
	}
}
