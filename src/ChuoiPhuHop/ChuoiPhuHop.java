package ChuoiPhuHop;

import java.io.FileInputStream;
import java.util.Scanner;

public class ChuoiPhuHop {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/ChuoiPhuHop/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		sc.nextLine();
		for(int t = 0; t < T; t++) {
			String P = sc.nextLine();
			String S = sc.nextLine();
			//System.out.println(P + " " + S);
			int index1 = 0, result = -1;
			for(int i = 0; i < S.length(); i++) {
				int index2 = i;
				while(true) {
					if(index1 == P.length() || index2 == S.length()) {
						break;
					}
					if(P.charAt(index1) == '.' && index1 + 1 < P.length() && P.charAt(index1 + 1) == '*') {
						char c = S.charAt(index2);
						int dem1 = 0, dem2 = 1;
						while(true) {
							index2++;
							dem1++;
							if(index2 >= S.length()) {
								index2--;
								break;
							}
							if(S.charAt(index2) != c) {
								index2--;
								break;
							}
						}
						index1++;
						while(index1 + 1 < P.length() && P.charAt(index1 + 1) == c && dem2 < dem1) {
							dem2++;
							index1++;
						}
					} else if(P.charAt(index1) == '.') {
						
					} else if(P.charAt(index1) != S.charAt(index2)) {
						break;
					}
					index1++;
					index2++;
				}
				if(index1 == P.length() && (index2 - i) > result ) {
					result = index2 - i;
				}
				index1 = 0;
			}
			
			System.out.println("#" + (t + 1) + " " + result);
		}
	}
}
