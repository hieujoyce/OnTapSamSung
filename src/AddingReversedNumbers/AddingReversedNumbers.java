package AddingReversedNumbers;

import java.io.FileInputStream;
import java.util.Scanner;

public class AddingReversedNumbers {
	
	static int reversedNumber(int n) {
		if (n < 10) return n;
		int tmp = n;
		int result = 0;
		while(tmp != 0) {
			result = result * 10 + (tmp % 10);
			tmp /= 10;
		}
		return result;
	}
	
	static int sumReversed(int n1, int n2) {
		int rn1 = reversedNumber(n1);
		int rn2 = reversedNumber(n2);
		return reversedNumber(rn1 + rn2);
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/AddingReversedNumbers/input.txt"));
		Scanner s = new Scanner(System.in);
		int N = s.nextInt();
		for(int i = 0; i < N; i++) {
			s.nextLine();
			int num1 = s.nextInt();
			int num2 = s.nextInt();
			int sumReversed = sumReversed(num1, num2);
			System.out.println(sumReversed);
		}
	}
}
