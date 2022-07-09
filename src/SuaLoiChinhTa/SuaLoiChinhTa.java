package SuaLoiChinhTa;

import java.io.FileInputStream;
import java.util.Scanner;

public class SuaLoiChinhTa {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/SuaLoiChinhTa/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t = 0; t < T; t++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			sc.nextLine();
			String[] tuDien = new String[N];
			String[] arr = new String[M];
			for(int i = 0; i < N; i++) {
				tuDien[i] = sc.nextLine();
			}
			for(int i = 0; i < M; i++) {
				arr[i] = sc.nextLine();
			}
			System.out.print("#" + (t + 1));
			for(int i = 0; i < M; i++) {
				int count = 0, value = -1;
				for(int j = 0; j < N; j++) {
					//System.out.println(arr[i] + " " + tuDien[j]  + " " + arr[i].length() + " " + tuDien[j].length());
					if(arr[i].length() < tuDien[j].length() - 1 || arr[i].length() > tuDien[j].length() + 1) {
						
					} else {
						int check = 1;
						int tmp = (arr[i].length() > tuDien[j].length() ? arr[i].length() - 1 : tuDien[j].length() - 1);
						for(int k = 0; k < tmp; k++) {
							if(arr[i].charAt(k) != tuDien[j].charAt(k)) {
								check = 0;
								break;
							}
						}
						if(check == 1) {
							if(arr[i].length() == tuDien[j].length() - 1) {
								value = 1;
								count++;
							} else if(arr[i].length() == tuDien[j].length()) {
								if(arr[i].charAt(arr[i].length() - 1) == tuDien[j].charAt(tuDien[j].length() - 1)) {
									value = 0;
									count = 1;
									break;
								} else {
									value = 2;
									count++;
								}
							} else {
								value = 3;
								count++;
							}
							
							//
						}
					}
				}
				//System.out.println("count: " + count);
				
				if(count == 0) {
					System.out.print(" 4");
				} else if(count == 1) {
					System.out.print(" " + value);
				} else {
					System.out.print(" 5");
				}
			}
			System.out.println("");
		}
	}
}
