package QKP;

import java.io.FileInputStream;
import java.util.Scanner;

public class QKP {
	static int[] dir_kx = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int[] dir_ky = {-2, -1, 1, 2, 2, 1, -1, -2};
	static int[] dir_qx = {0, -1, -1, -1, 0, 1, 1, 1};
	static int[] dir_qy = {-1, -1, 0, 1, 1, 1, 0, -1};
	
	static int isOutside(int x, int y, int n, int m) {
		if(x < 1 || x > n || y < 1 || y > m) {
			return 1;
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/QKP/input.txt"));
		Scanner sc = new Scanner(System.in);
		int index = 1;
		
		while(true) {
			int n =  sc.nextInt();
			int m = sc.nextInt();
			if(n == 0 || m == 0) break;
			int[][] arr = new int[n + 1][m + 1];
			int count = n * m;
			int q = sc.nextInt();
			count -= q;
			int[][] arr_q = new int [q][2];
			for(int i = 0; i < q; i++) {
				arr_q[i][0] = sc.nextInt();
				arr_q[i][1] = sc.nextInt();
				arr[arr_q[i][0]][arr_q[i][1]] = 3;
			}
			
			int k = sc.nextInt();
			count -= k;
			int[][] arr_k = new int [k][2];
			for(int i = 0; i < k; i++) {
				arr_k[i][0] = sc.nextInt();
				arr_k[i][1] = sc.nextInt();
				arr[arr_k[i][0]][arr_k[i][1]] = 2;
			}
			
			int p = sc.nextInt();
			count -= p;
			int[][] arr_p = new int [p][2];
			for(int i = 0; i < p; i++) {
				arr_p[i][0] = sc.nextInt();
				arr_p[i][1] = sc.nextInt();
				arr[arr_p[i][0]][arr_p[i][1]] = 1;
			}
			
			for(int i = 0; i < q; i++) {
				for(int j = 0; j < 8; j++) {
					int x = arr_q[i][0] + dir_qx[j];
					int y = arr_q[i][1] + dir_qy[j];
					int tmp = 1;

					while(isOutside(x, y, n, m) == 0 && (arr[x][y] == 0 || arr[x][y] == -1)) {
						if(arr[x][y] == 0) count--;
						arr[x][y] = -1;
						tmp++;
						x = arr_q[i][0] + dir_qx[j] * tmp;
						y = arr_q[i][1] + dir_qy[j] * tmp;
					}
				}
			}
			
			for(int i = 0; i < k; i++) {
				for(int j = 0; j < 8; j++) {
					int x = arr_k[i][0] + dir_kx[j];
					int y = arr_k[i][1] + dir_ky[j];
					if(isOutside(x, y, n, m) == 0 && arr[x][y] == 0) {
						arr[x][y] = -1;
						count--;
					}
				}
			}
			
			System.out.println("Board " + index + " has " + count + " safe squares.");
			index++;
			//
		}
	}
}
