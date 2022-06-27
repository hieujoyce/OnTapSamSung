package SumOfProduct;

import java.io.FileInputStream;
import java.util.Scanner;

public class SumOfProduct {
	static long getSum(int start, int end) {
		long length = end - start + 1;
		return length * (start + end) / 2;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SumOfProduct/input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int number = sc.nextInt();
			long sum = 0L;
			int j;
			for(j = 1; j * j <= number; j++) {
				sum += ((number / j) * j);
			}
			int start = j - 1;
			for(int k = number / start; k > 1; k--) {
				int end = number / (k - 1);
				sum += getSum(start + 1, end) * (k - 1);
				start = end;
			}
			
			System.out.println(sum % 1000000007);
		}
	}
}
