package TroChoiPacmanRemix;

import java.io.FileInputStream;
import java.util.Scanner;

public class TroChoiPacmanRemix {
	static int[] dir_x = {0, -1, 0, 1};
	static int[] dir_y = {-1, 0, 1, 0};
	
	static int isOutside(int x, int y, int N) {
		if(x < 0 || x >= N || y < 0 || y >= N) {
			return  1;
		}
		return 0;
	}
	
	static void solve(int index, int N, int M, char[] s_pacman, char[] s_ghost, int[][] matrix) {
		int dir_pacman = 3, dir_ghost = 1, xp = 0, yp = 0, xg = N - 1, yg = N - 1;
		long gold_p = 0, gold_g = 0;
		for(int i = 0; i < M; i++) {
			//pacman
			if(s_pacman[i] == 'C') {
				int x = xp + dir_x[dir_pacman];
				int y = yp + dir_y[dir_pacman];
				if(isOutside(x, y, N) == 0) {
					xp = x;
					yp = y;
				}
			} else if(s_pacman[i] == 'L') {
				dir_pacman = (dir_pacman + 3) % 4;
				int x = xp + dir_x[dir_pacman];
				int y = yp + dir_y[dir_pacman];
				if(isOutside(x, y, N) == 0) {
					xp = x;
					yp = y;
				}
			} else {
				dir_pacman = (dir_pacman + 1) % 4;
				int x = xp + dir_x[dir_pacman];
				int y = yp + dir_y[dir_pacman];
				if(isOutside(x, y, N) == 0) {
					xp = x;
					yp = y;
				}
			}
			//ghost
			if(s_ghost[i] == 'C') {
				int x = xg + dir_x[dir_ghost];
				int y = yg + dir_y[dir_ghost];
				if(isOutside(x, y, N) == 0) {
					xg = x;
					yg = y;
				}
			} else if(s_ghost[i] == 'L') {
				dir_ghost = (dir_ghost + 3) % 4;
				int x = xg + dir_x[dir_ghost];
				int y = yg + dir_y[dir_ghost];
				if(isOutside(x, y, N) == 0) {
					xg = x;
					yg = y;
				}
			} else {
				dir_ghost = (dir_ghost + 1) % 4;
				int x = xg + dir_x[dir_ghost];
				int y = yg + dir_y[dir_ghost];
				if(isOutside(x, y, N) == 0) {
					xg = x;
					yg = y;
				}
			}
			
			if(xp == xg && yp == yg) {
				break;
			} else {
				gold_p += matrix[xp][yp];
				gold_g += matrix[xg][yg];
				matrix[xp][yp] = 0;
				matrix[xg][yg] = 0;
			}
		}	
		System.out.println("#" + (index + 1) + " " + gold_p + " " + gold_g);
	}
	
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/TroChoiPacmanRemix/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] matrix = new int[N][N];
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < N; k++) {
					matrix[j][k] = sc.nextInt();
				}
			}
			
			char[] s_ghost = new char[M];
			char[] s_pacman = new char[M];
			sc.nextLine();
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();
			for(int j = 0; j < M; j++) {
				s_pacman[j] = str1.charAt(j);
			}
			for(int j = 0; j < M; j++) {
				s_ghost[j] = str2.charAt(j);
			}
			
			solve(i, N, M, s_pacman, s_ghost, matrix);
			//
		}
	}
}
