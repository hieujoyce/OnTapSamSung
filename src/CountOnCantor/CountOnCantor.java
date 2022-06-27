package CountOnCantor;

import java.io.FileInputStream;
import java.util.Scanner;

public class CountOnCantor {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/CountOnCantor/input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int delta = 1 + 8 * a;
			double n = (-1 + Math.sqrt(delta)) / (2);
			int l = (int)Math.ceil(n);
			int m = l - 1;
			int k = m * (m + 1) / 2 + 1;
			int x, y;
			if(l % 2 == 0) {
				x = 1; 
				y = l;
				for(int j = 0; j < a - k; j++) {
					x++; y--;
				}
			} else {
				x = l;
				y = 1;
				for(int j = 0; j < a - k; j++) {
					x--; y++;
				}
			}
			System.out.println("TERM " + a + " IS " + x + "/" + y);
		}
		sc.close();
	}
}
