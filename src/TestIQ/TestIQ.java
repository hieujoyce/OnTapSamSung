package TestIQ;

import java.io.FileInputStream;
import java.util.Scanner;

public class TestIQ {
	static int solve(char[][] arr) {
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				int count = 0;
				if(arr[i][j] == '#') count++;
				if(arr[i + 1][j] == '#') count++;
				if(arr[i][j + 1] == '#') count++;
				if(arr[i + 1][j + 1] == '#') count++;
				if(count == 3 || count == 1 || count == 0 || count == 4) {
					return 1;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/TestIQ/input.txt"));
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[4][4];
		for(int i = 0; i < 4; i++) {
			String str = sc.nextLine();
			for(int j = 0; j < 4; j++) {
				arr[i][j] = str.charAt(j);
			}
		}
		int result = solve(arr);
		if (result == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
//		for(int i = 0; i < 4; i++) {
//			for(int j = 0; j < 4; j++) {
//				System.out.printf("%c", arr[i][j]);
//			}
//			System.out.println("");
//		}
	}
}
