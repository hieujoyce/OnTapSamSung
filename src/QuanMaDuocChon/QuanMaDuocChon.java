package QuanMaDuocChon;

import java.io.FileInputStream;
import java.util.Scanner;

public class QuanMaDuocChon {
	static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dy = {-2, -1, 1, 2, 2, 1, -1, -2};
	
	static int isOutside(int x, int y, int N) {
		if(x < 0 || x >= N || y < 0 || y >= N) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/QuanMaDuocChon/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int M = sc.nextInt();
			int D = sc.nextInt();
			
			int[] knight_x = new int[K];
			int[] knight_y = new int[K];
			
			int[][] arr = new int[N][N];	
			
			for(int j = 0; j < K * 2; j++) {
				if(j % 2 == 0) {
					knight_x[j / 2] = sc.nextInt();
				} else {
					knight_y[j / 2] = sc.nextInt();
				}
			}
			for(int j = 0; j < K; j++) {
				arr[knight_x[j]][knight_y[j]] = 2;
			}
			
			for(int j = 0; j < M; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = 1;
			}
			
			for(int j = 0; j < D; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				arr[x][y] = -1;
			}
			
			int index = 0;
			int max = 0;
			for(int j = 0; j < K; j++) {
				int count = 0;
				for(int k = 0; k < 8; k++) {
					int x = knight_x[j] + dx[k];
					int y = knight_y[j] + dy[k];
					if(isOutside(x, y, N) == 0 && (arr[x][y] == 1 || arr[x][y] == 2)) {
						count++;
					}
				}
				if(count > max) {
					max = count;
					index = j;
				}
			}
			
			System.out.println("#" + (i + 1) + " " + knight_x[index] + " " + knight_y[index] + " " + max);
			//
		}
	}
}
