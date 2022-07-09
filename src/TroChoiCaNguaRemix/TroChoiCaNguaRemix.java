package TroChoiCaNguaRemix;

import java.io.FileInputStream;
import java.util.Scanner;

public class TroChoiCaNguaRemix {
	static int isWin;
	
	static void run(int index, int[] chess, int value, int[] board) {
		if(chess[index] == -1 && value != 6) {
			return;
		}
		if(chess[index] == -1 && value == 6) {
			chess[index] = 0;
			board[index * 12 + 1] = index + 1;
			return;
		}
		if(chess[index] < 47) {
			if((chess[index] + value) <= 47) {
				int canMove = 1;
				for(int i = 1; i < value; i++) {
					int index1 = (index * 12 + 1 + chess[index] + i) % 48;
					if(board[index1] != 0) {
						canMove = 0;
						break;
					}
				}
				if(canMove == 1) {
					int index1 = (index * 12 + 1 + chess[index] + value) % 48;
					int index2 = (index * 12 + 1 + chess[index]) % 48;
					board[index2] = 0;
					if(board[index1] != 0) {
						chess[board[index1] - 1] = -1; 
					}
					board[index1] = index + 1;
					chess[index] += value;
				}
			} else {
				return;
			}
		} else if (chess[index] == 47) {
			int index1 = (index * 12 + 1 + chess[index]) % 48;
			board[index1] = 0;
			chess[index] = 47 + value;
		} else {
			if(chess[index] == 53) {
				chess[index]++;
				isWin = 1;
				return;
			}
			int tmp = chess[index] - 47;
			if (value < tmp) {
				return;
			} else {
				chess[index] = 47 + value;
			}
		}
	}

	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/TroChoiCaNguaRemix/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			isWin = 0;
			int N = sc.nextInt();
			int[][] arr = new int[4][N];
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int[] board = new int[48];
			int[] chess = {-1, -1, -1, -1};
			int tmp = 22;
			for(int j = 0; j < N; j++) {
//				for(int i = 0; i < 4; i++) {
//					run(i, chess, arr[i][j], board);
//					if(j == tmp) {
//						System.out.println(arr[i][j]);
//						for(int k = 0; k < 48; k++) {
//							System.out.print(board[k] + " ");
//						}
//						System.out.println("");
//					}
//				}
//				if(j == tmp) break;
				if(isWin == 1) break;
				for(int i = 0; i < 4; i++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println("");
				for(int i = 0; i < 4; i++) {
					run(i, chess, arr[i][j], board);
					for(int k = 0; k < 48; k++) {
						System.out.print(board[k] + " ");
					}
					System.out.println("");
				}
				System.out.println("--------------------------------");
			}
			System.out.print("#" + (t + 1) + ":");
			System.out.print(" Dong: " + ((chess[0] == -1) ? -1 : 54 - chess[0]) + ",");
			System.out.print(" Tay: " + ((chess[1] == -1) ? -1 : 54 - chess[1]) + ",");
			System.out.print(" Nam: " + ((chess[2] == -1) ? -1 : 54 - chess[2]) + ",");
			System.out.print(" Bac: " + ((chess[3] == -1) ? -1 : 54 - chess[3]));
			System.out.println("");
			
		}
	}
}
