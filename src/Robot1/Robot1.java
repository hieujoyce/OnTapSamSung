package Robot1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Robot1 {
	// x -1 0 1 0
	// y 0 1 0 -1
	static int checkDir(int x1, int y1, int x2, int y2) {
		int delx = x2 - x1;
		int dely = y2 - y1;
		if(delx == -1 && dely == 0) {
			return 0;
		} else if(delx == 0 && dely == 1) {
			return 1;
		} else if(delx == 1 && dely == 0) {
			return 2;
		} else {
			return 3;
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/Robot1/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int i = 0; i < T; i++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][2];
			int count = 0;
			int dir = 0;
			arr[0][0] = sc.nextInt();
			arr[0][1] = sc.nextInt();
			for(int j = 1; j < N; j++) {
				arr[j][0] = sc.nextInt();
				arr[j][1] = sc.nextInt();
				if(j >= 2) {
					int oldDir = dir;
					dir = checkDir(arr[j - 1][0], arr[j - 1][1], arr[j][0], arr[j][1]);
					if( (oldDir + 1) % 4 == dir) {
						count++;
					}
				} else {
					dir = checkDir(0, 0, arr[j][0], arr[j][1]);
				}
			}
			System.out.println("#" + (i + 1) + " " + count);
		}
	}
}
