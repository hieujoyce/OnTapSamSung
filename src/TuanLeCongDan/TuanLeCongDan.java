package TuanLeCongDan;

import java.io.FileInputStream;
import java.util.Scanner;

public class TuanLeCongDan {
	
	static int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
//	static int x_seat = -1;
//	static int y_seat = -1;
	static int findCheckSeat(int[][] arr, int R, int C) {
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(arr[i][j] == -1) return 1;
			}
		}
		return 0;
	}
	
	static void findLocationSeat(int[][] arr, int R, int C) {
		int x_seat = -1;
		int y_seat = -1;
		int max = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {
				if(arr[i][j] == -1) {
					int count = 0;
					for(int k = 0; k < 8; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						if(isOutside(x, y, R, C) == 0 && arr[x][y] != -1) {
							count++;
						}
					}
					if(count > max) {
						max = count;
						x_seat = i;
						y_seat = j;
					}
				}
			}
		}
		arr[x_seat][y_seat] = 0;
	}
	
	static int isOutside(int x, int y, int R, int C) {
		if(x >= 0 && x < R && y >= 0 && y < C) {
			return 0;
		}
		return 1;
	}
	
	static int check(int x, int y, int R, int C) {
		if((x == 0 && y == 0) || (x == 0 && y == C - 1) || (x == R - 1 && y == 0) || (x == R - 1 && y == C - 1)) {
			return 3;
		}
		if(x > 0 && x < R - 1 && y > 0 && y < C - 1) {
			return 8;
		}
		return 5;
	}
	
	static int getAmountShakeHands(int[][] arr, int R, int C) {
		int count = 0;
		for(int i = 0; i < R; i++) {
			for(int j = 0; j < C; j++) {			
				if(arr[i][j] != -1) {
					for(int k = 0; k < 8; k++) {
						int x = i + dx[k];
						int y = j + dy[k];
						int check = check(x, y, R, C);
						if(isOutside(x, y, R, C) == 0 && arr[x][y] != -1 && k > 3) {
							arr[i][j]++;
							arr[x][y]++;
							count++;
						}
					}
				}
			}
		}
		return count;
	}
	
	static int solve(int[][] arr, int R, int C) {
		if(findCheckSeat(arr, R, C) == 0) {
			int result = getAmountShakeHands(arr, R, C);
			return result;
		} else {
			findLocationSeat(arr, R, C);
			int result = getAmountShakeHands(arr, R, C);
			return result;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/TuanLeCongDan/input.txt"));
		Scanner sc = new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.nextInt();
		sc.nextLine();
		int[][] arr = new int[R][C];
		for(int i = 0; i < R; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < C; j++) {
				if(str.charAt(j) == '.') {
					arr[i][j] = -1;
				} else {
					arr[i][j] = 0;
				}
			}
		}
		
		int result = solve(arr, R, C);
		
		System.out.println(result);
		
//		for(int i = 0; i < R; i++) {
//			for(int j = 0; j < C; j++) {
//				System.out.printf("%d", arr[i][j]);
//			}
//			System.out.println("");
//		}
	}
}
