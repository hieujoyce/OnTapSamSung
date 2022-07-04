package TroChoiBBTANRemix2;
import java.io.FileInputStream;
import java.util.Scanner;

public class TroChoiBBTANRemix2 {
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
	
	static int solve(char[][] arr, int N, int xf, int yf, int dirf) {
		int x = xf, y = yf, dir = dirf, count = 0;
		while(true) {
			int oldDir = dir;
			dir = getDir(dir, arr[x][y]);
			if(oldDir != dir) count++;
			x = x + dir_x[dir];
			y = y + dir_y[dir];
			if(isOutside(x, y, N) == 1) break;
		}
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/TroChoiBBTANRemix2/input.txt"));
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
			int maxCount = 0, x = 0, y = 0;
			for(int j = 0; j < N; j++) {
				int count = solve(arr, N, j, 0, 2);
				if(count > maxCount) {
					maxCount = count;
					x = j;
					y = 0;
				}
			}
			for(int j = 0; j < N; j++) {
				int count = solve(arr, N, N - 1, j, 1);
				if(count > maxCount) {
					maxCount = count;
					x = N - 1;
					y = j;
				}
			}
			for(int j = N - 1; j >= 0; j--) {
				int count = solve(arr, N, j, N - 1, 0);
				if(count > maxCount) {
					maxCount = count;
					x = j;
					y = N - 1;
				}
			}
			for(int j = N - 1; j >= 0; j--) {
				int count = solve(arr, N, 0, j, 3);
				if(count > maxCount) {
					maxCount = count;
					x = 0;
					y = j;
				}
			}
			
			
			System.out.println("#" + (i + 1) + " " + x + " " + y + " " + maxCount);
		}
	}
}
