package HeThongPhanTichRemCua;
import java.io.FileInputStream;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/HeThongPhanTichRemCua/input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCaseLength = sc.nextInt();
		
		for(int i = 0; i < testCaseLength; i++) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] arr = new int[n][m * 4];
			
			sc.nextLine();
			sc.nextLine();
			for(int k = 0; k < m; k++) {
				for(int j = 0; j < 4; j++) {
					String str = sc.nextLine();
					for(int h = 0; h < n; h++) {
						if(str.charAt(h * 5 + 1) == '*') {
							arr[h][k * 4 + j] = 1;
						}
					}
				}
				sc.nextLine();
			}
			int[] result = new int[5];
			for(int k = 0; k < m; k++) {
				for(int l = 0; l < n; l++) {
					int count = 0;
					for(int h = k * 4; h < k * 4 + 4; h++) {
						if (arr[l][h] == 1) count++;
					}
					result[count]++;
				}
			}
			System.out.print("#" + (i + 1));
			for(int j = 0; j < 5; j ++) {
				System.out.print(" " + result[j]);
			}
			System.out.println("");
		}
		sc.close();
	}
}
