package CountThePairs;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CountThePairs {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/CountThePairs/input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Set<Integer> mySet = new HashSet<>();
		int count = 0;
		for(int i = 0; i < N; i++) {
			mySet.add(arr[i]);
			if(mySet.contains(arr[i] - K)) count++;
			if(mySet.contains(arr[i] + K)) count++;
		}
		System.out.println(count);
		sc.close();
	}
}
