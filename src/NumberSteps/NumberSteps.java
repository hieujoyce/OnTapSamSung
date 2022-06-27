package NumberSteps;

import java.io.FileInputStream;
import java.util.Scanner;

public class NumberSteps {
	
	static int getNumber(int x, int y) {
		if(x - y == 0) {
			if(x % 2 == 0) return x + y;
			else return x + y - 1;
		} else if (x - y == 2) {
			if(x % 2 == 0) return x + y;
			 return x + y - 1;
		}
		return -1;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/NumberSteps/input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for(int i = 0; i < N; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			int result = getNumber(n1, n2);
			if(result == -1) {
				System.out.println("No Number");
			} else {
				System.out.println(result);
			}
		}
	}
}
