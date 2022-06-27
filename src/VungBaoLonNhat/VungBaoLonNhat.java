package VungBaoLonNhat;

import java.io.FileInputStream;
import java.util.Scanner;

public class VungBaoLonNhat {
	static int getSum(int[][] arr, int x, int y, int h, int w) {
		int sum = 0;
		for(int i = y; i < (y + w); i++) {
			if(arr[x][i] % 2 == 0) sum += arr[x][i];
		}
		for(int i = y; i < (y + w); i++) {
			if(arr[x + h - 1][i] % 2 == 0) sum += arr[x + h - 1][i];
		}
		for(int i = x + 1; i < (x + h - 1); i++) {
			if(arr[i][y] % 2 == 0) sum += arr[i][y];
		}
		for(int i = x + 1; i < (x + h - 1); i++) {
			if(arr[i][y + w - 1] % 2 == 0) sum += arr[i][y + w - 1];
		}
		return sum;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/VungBaoLonNhat/input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCaseLength = sc.nextInt();
		for(int i = 0; i < testCaseLength; i++) {
			int h, w, m, n;
			h = sc.nextInt();
			w = sc.nextInt();
			m = sc.nextInt();
			n = sc.nextInt();
			int[][] arr = new int[m][n];
			for(int j = 0; j < m; j++) {
				for(int k = 0; k < n; k++) {
					arr[j][k] = sc.nextInt();
				}
			}
			int maxSum = 0;
			for(int j = 0; j <= (m - h); j++) {
				for(int k = 0; k <= (n - w); k++) {
					int sum = getSum(arr, j, k, h, w);
					if(sum > maxSum) maxSum = sum;
				}
			}
			System.out.println("#" + (i + 1) + " " + maxSum);
			
		}
	}
}
