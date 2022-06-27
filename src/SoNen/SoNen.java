package SoNen;

import java.io.FileInputStream;
import java.util.Scanner;

public class SoNen {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SoNen/input.txt"));
		Scanner s = new Scanner(System.in);
		int length = s.nextInt();
		for(int i = 0; i < length; i++) {
			int el = s.nextInt();
			int result = el;
			while(result >= 10) {
				int tmp = result;
				result = 0;
				while(tmp > 0) {
					result += (tmp % 10);
					tmp = tmp / 10;
				}
			}
			System.out.println("#" + (i + 1) + " " + result);
		}
	}
}
