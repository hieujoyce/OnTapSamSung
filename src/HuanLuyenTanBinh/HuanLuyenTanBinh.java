package HuanLuyenTanBinh;

import java.io.FileInputStream;
import java.util.Scanner;

public class HuanLuyenTanBinh {
	static int getIndexLeft(int s, int[] arr) {
		int index = s;
		for(int i = index + 1; i < arr.length; i++) {
			if(arr[i] != -1) {
				index = i;
				break;
			}
		}
		return index;
	}
	
	static int getIndexRight(int s, int[] arr) {
		int index = s;
		for(int i = index - 1; i >= 0; i--) {
			if(arr[i] != -1) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/HuanLuyenTanBinh/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			int score = 0;
			for(int i = 0; i < N; i++) {
				int s = sc.nextInt() - 1;
				if(s == 0) {
					int index = getIndexLeft(s, arr);
					score += arr[index];
				} else if (s == N - 1) {
					int index = getIndexRight(s, arr);
					score += arr[index];
				} else {
					int indexL = getIndexLeft(s, arr);
					int indexR = getIndexRight(s, arr);
					if(indexL == s && indexR == s) {
						score += arr[indexL];
					} else if (indexL == s && indexR != s) {
						score += arr[indexR];
					} else if (indexR == s && indexL != s) {
						score += arr[indexL];
					} else {
						score += (arr[indexL] * arr[indexR]);
					}
				}
				arr[s] = -1;
			}
			
			System.out.println("#" + (t + 1) + " " + score);
		}
		
	}
}
