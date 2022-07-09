package Divisibility;

import java.io.FileInputStream;
import java.util.Scanner;

public class Divisibility {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/Divisibility/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			int k = (int)Math.ceil((double)n / x) - 1;
			for(int j = 1; j <= k; j++) {
				int result = x * j;
				if(result > 1 && result % y != 0) {
					System.out.print(result + " ");
				}
			}
			System.out.println("");
		}
	}
}
