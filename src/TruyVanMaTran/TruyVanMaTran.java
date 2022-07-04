package TruyVanMaTran;

import java.io.FileInputStream;
import java.util.Scanner;

public class TruyVanMaTran {
	
	static void output(int t, int[] arr) {
		System.out.print("#" + t);
		for(int i = 0; i < arr.length; i++) {
			System.out.print(" " + arr[i]);
		}
		System.out.println("");
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/TruyVanMaTran/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			int[][] arr = new int[N][M];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[] result = new int[K];
			for(int i = 0; i < K; i++) {
				int x = 0, y = 0, count = 0;
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a == 3) {
					x = b % N;
				} else if(a == 4) {
					y = b % M;
				} else if(a == 1) {
					x = N - b % N;
				} else {
					y = M - b % M;
				}

				for(int j = 0; j < N - 1; j++) {
					int xt = (j + x) % N;
					for(int k = 0; k < M - 1; k++) {
						int yt = (k + y) % M;
						if(
							(arr[xt][yt] == 1 && arr[(xt + 1) % N][yt] == 1 && arr[xt][(yt + 1) % M] == 1 && arr[(xt + 1) % N][(yt + 1) % M] == 1) 
							|| (arr[xt][yt] == 2 && arr[(xt + 1) % N][yt] == 2 && arr[xt][(yt + 1) % M] == 2 && arr[(xt + 1) % N][(yt + 1) % M] == 2)
						) {
							count++;
						}
					}
				}
				result[i] = count;
			}
			output(t + 1, result);
		}
	}
}
