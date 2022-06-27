package DoMinRemix;

import java.io.FileInputStream;
import java.util.Scanner;

public class DoMinRemix {
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	static int isOutside(int x, int y, int M, int N) {
		if(x < 0 || x >= M || y < 0 || y >= N) return 1;
		return 0;
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
		int count = 0;
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == '.') {
					for(int k = 0; k < 8; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if(isOutside(x, y, M, N) == 0 && arr[x][y] == '*') {
							count++;
						}
					}
				}
			}
		}
		
		
//		for(int i = 0; i < M; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.printf("%c", arr[i][j]);
//			}
//			System.out.println("");
//		}
		
		return count;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/DoMinRemix/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int result = solve(sc);
			System.out.println("Case #" + (i + 1) + ": " + result);
		}
	}
}
