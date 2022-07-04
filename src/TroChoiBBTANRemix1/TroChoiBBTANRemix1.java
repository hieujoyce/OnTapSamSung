package TroChoiBBTANRemix1;

import java.io.FileInputStream;
import java.util.Scanner;

public class TroChoiBBTANRemix1 {
	static int[] dir_x = {0, -1, 0, 1};
	static int[] dir_y = {-1, 0, 1, 0};
	
	static int isOutside(int x, int y, int N) {
		if(x < 0 || x >= N || y < 0 || y >= N) return 1;
		return 0;
	}
	static int getDir(int dir, char c) {
		if(c == '/') {
			if(dir == 0) return 3;
			else if (dir == 1) return 2;
			else if (dir == 2) return 1;
			else return 0;
		} else if (c == '\\') {
			if(dir == 0) return 1;
			else if (dir == 1) return 0;
			else if (dir == 2) return 3;
			else return 2;
		}
		return dir;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/TroChoiBBTANRemix1/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			sc.nextLine();
			char[][] arr = new char[N][N];
			for(int j = 0; j < N; j++) {
				String str = sc.nextLine();
				for(int k = 0; k < N; k++) {
					arr[j][k] = str.charAt(k);
				}
			}
			int x = 0, y = 0, dir = 2, count = 0;
			while(true) {
				x = x + dir_x[dir];
				y = y + dir_y[dir];
				if(isOutside(x, y, N) == 1) break;
				int oldDir = dir;
				dir = getDir(dir, arr[x][y]);
				if(oldDir != dir) count++;
			}
			
			System.out.println("#" + (i + 1) + " "  + count);
		}
	}
}
