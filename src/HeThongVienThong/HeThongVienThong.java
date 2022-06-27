package HeThongVienThong;

import java.io.FileInputStream;
import java.util.Scanner;

public class HeThongVienThong {
	
	static int[] x_dir = {-1, 0, 1, 0};
	static int[] y_dir = {0, -1, 0, 1};
	
	static int isOutside(int x, int y, int M, int N) {
		if(x >= 0 && x < M && y >= 0 && y < N) {
			return 1;
		}
		return 0;
	}
	
	static void cover(int range, int x, int y, char[][] arr, int M, int N) {
		for(int i = 0; i < 4; i++) {
			for(int j = 1; j <= range; j++) {
				int x1 = x + x_dir[i] * j;
				int y1 = y + y_dir[i] * j;
				if(isOutside(x1, y1, M, N) == 1) {
					if(arr[x1][y1] != 'A' && arr[x1][y1] != 'B' && arr[x1][y1] != 'C') {
						arr[x1][y1] = '1';
					}
				}
			}
		}
	}
	
	static int solve(Scanner sc) {
		int M = sc.nextInt();
		int N = sc.nextInt();
		sc.nextLine();
		char[][] arr = new char[M][N];
		
		for(int i = 0; i < M; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 'A') {
					cover(1, i, j, arr, M, N);
				} else if (arr[i][j] == 'B') {
					cover(2, i, j, arr, M, N);
				}  else if (arr[i][j] == 'C') {
					cover(3, i, j, arr, M, N);
				}
			}
		}
		
		int count = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == 'H') {
					count++;
				}
			}
		}	
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/HeThongVienThong/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i++) {
			int result = solve(sc);
			System.out.println("#" + (i + 1) + " " + result);
		}
	}
}
