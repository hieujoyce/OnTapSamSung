package QueueRookie;

import java.io.FileInputStream;
import java.util.Scanner;

public class QueueRookie {
	public static class People {
		int height;
		int count;
		
		People(int height) {
			this.height = height;
		}
	}
	
	public static void output(int[] arr, int N) {
		System.out.println("");
		for(int i = 0; i < N; i++) {
			System.out.printf("%d ", arr[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/QueueRookie/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		
		for(int i = 0; i < T; i ++) {
			People[] arr = new People[N];
			for(int j = 0; j < N; j++) {
				int height = sc.nextInt();
				arr[j] = new People(height);
			}
			for(int j = 0; j < N; j++) {
				
			}
		}
		
	}
}
