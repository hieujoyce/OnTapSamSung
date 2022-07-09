package MarioQuaCau;

import java.io.FileInputStream;
import java.util.Scanner;

public class MarioQuaCau {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/MarioQuaCau/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][5];
			char[] dir = new char[N];
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < 5; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			sc.nextLine();
			String str = sc.nextLine();
			for(int j = 0; j < N; j++) {
				dir[j] = str.charAt(j);
			}
			int x = N, y = 2, isWin = 1, coin = 0;
			for(int j = 0; j < N; j++) {
				int dir_x = -1, dir_y = 0;
				if(dir[j] == 'C') {
					dir_y = 0;
				} else if(dir[j] == 'L') {
					dir_y = -1;
				} else if(dir[j] == 'R') {
					dir_y = 1;
				}
				
				x = x + dir_x;
				y = y + dir_y;
				if(arr[x][y] == 0) {
				} else if(arr[x][y] == 1) {
					coin++;
				} else {
					isWin = 0;
					break;
				}
			}
			if(isWin == 0) {
				System.out.println("#" + (i + 1) + " NO");
			} else {
				System.out.println("#" + (i + 1) + " YES " + coin);
			}
			//
		}
	}
}
