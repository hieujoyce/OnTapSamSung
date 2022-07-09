package QuanTotCoTuong;

import java.io.FileInputStream;
import java.util.Scanner;

public class QuanTotCoTuong {
	static String getQuanTot(int x) {
		if(x == 0) return "A";
		else if(x == 2) return "B";
		else if(x == 4) return "C";
		else if(x == 6) return "D";
		else return "E";
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/QuanTotCoTuong/input.txt"));
		Scanner sc = new Scanner(System.in);
		int y = sc.nextInt();
		int x = sc.nextInt();
		
		if(y <= 3) {
			System.out.println("-1");
		} else if(y == 4) {
			if(x % 2 == 1) {
				System.out.println("-1");
			} else {
				System.out.println("1");
				System.out.println(getQuanTot(x));
			}
		} else {
			if(x % 2 == 0) {
				System.out.println((y - 3));
				System.out.println(getQuanTot(x));
			} else {
				System.out.println((y - 3) + 1);
				System.out.println(getQuanTot(x - 1));
			}
		}
		
	}
}
