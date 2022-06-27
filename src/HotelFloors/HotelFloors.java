package HotelFloors;

import java.io.FileInputStream;
import java.util.Scanner;

public class HotelFloors {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, -1, 0, 1};
	
	static void run(int x, int y, char[][] arr) {
		if(arr[x][y] == '#') return;
		arr[x][y] = '#';
		for(int i = 0; i < 4; i++) {
			run(x + dx[i], y + dy[i], arr);
		}
	}
	
	static double solve(Scanner sc) {
		int M = sc.nextInt();
		int N =sc.nextInt();
		int people = 0;
		int room = 0;
		sc.nextLine();
		char[][] arr = new char[M][N];
		for(int i = 0; i < M; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < N; j++) {
				arr[i][j] = str.charAt(j);
				if(arr[i][j] == '*') people++;
			}
		}
		
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] == '-' || arr[i][j] == '*') {
					room++;
					run(i, j, arr);
				}
			}
		}
		
//		for(int i = 0; i < M; i++) {
//			for(int j = 0; j < N; j++) {
//				System.out.printf("%c", arr[i][j]);
//			}
//			System.out.println("");
//		}
		
		return ((double)people / room);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/HotelFloors/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			double result = solve(sc);
			System.out.printf("%.2f\n", result);
		}
		
	}
}
