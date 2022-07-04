package Robot2;

import java.io.FileInputStream;
import java.util.Scanner;

public class Robot2 {
	static int[] dir_x = {-1, 0, 1, 0};
	static int[] dir_y = {0, 1, 0, -1};
	
	static double getDistance(int x1, int y1, int x2, int y2) {		
		return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
	}
	
	static int getDir(int dir, char c) {
		if(c == 'W') {
			return 0;
		} else if(c == 'N') {
			return 1;
		} else if(c == 'E') {
			return 2;
		} else if(c == 'S') {
			return 3;
		} else if(c == 'C') {
			return dir;
		} else if(c == 'L') {
			return (dir + 3) % 4;		
		} else if(c == 'R'){
			return (dir + 1) % 4;
		} else {
			return (dir + 2) % 4;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/Robot2/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int K = sc.nextInt();
			sc.nextLine();
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();
			char[] arrA = new char[K];
			char[] arrB = new char[K];
			for(int j = 0; j < K; j++) {
				arrA[j] = str1.charAt(j);
			}
			for(int j = 0; j < K; j++) {
				arrB[j] = str2.charAt(j);
			}
			
			int dir_A = 1, dir_B = 1, xA = 0, yA = 0, xB = 0, yB = 0, result = 0;
			for(int j = 0; j < K; j++) {
				//A
				dir_A = getDir(dir_A, arrA[j]);
				xA = xA + dir_x[dir_A];
				yA = yA + dir_y[dir_A];
				//B
				dir_B = getDir(dir_B, arrB[j]);
				xB = xB + dir_x[dir_B];
				yB = yB + dir_y[dir_B];
				
				if(xA == X && yA == Y && xB == X && yB == Y) {
					result = 1;
					break;
				} else if(xA == X && yA == Y) {
					result = 2;
					break;
				} else if(xB == X && yB == Y) {
					result = 3;
					break;
				}	
			}
			if(result == 1) {
				System.out.println("#" + (i + 1) + " Good game!");
			} else if(result == 2) {
				System.out.println("#" + (i + 1) + " Team A win");
			} else if(result == 3) {
				System.out.println("#" + (i + 1) + " Team B win");
			} else {
				double dA = getDistance(X, Y, xA, yA);
				double dB = getDistance(X, Y, xB, yB);
				System.out.printf("#%d %.3f %.3f\n", i + 1, dA, dB);
			}
		}
		
		
		sc.close();
	}
}
