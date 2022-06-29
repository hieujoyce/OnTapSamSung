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
	
	static People[] mergeSort(People[] arr, int L, int R){
		if(L == R) {
			return new People[] {arr[L]}; 
		}
		int M = ((R - L) / 2) + L;
		People[] arr1 = mergeSort(arr, L, M);
		People[] arr2 = mergeSort(arr, M + 1, R);
		int length = arr1.length + arr2.length;
		People[] newArr = new People[length];
		int i1 = 0, i2 = 0, i = 0;
		while(i < length) {
			if(i1 < arr1.length && i2 < arr2.length) {
				if(arr1[i1].height < arr2[i2].height) {
					newArr[i] = arr1[i1];
					i1++;
				} else {
					newArr[i] = arr2[i2];
					i2++;
				}
			} else {
				if(i1 >= arr1.length) {
					newArr[i] = arr2[i2];
					i2++;
				} else {
					newArr[i] = arr1[i1];
					i1++;
				}
			}		
			i++;
		}
		return newArr;
	}
	
	static People[] sort(People[] arr) {
		return mergeSort(arr, 0, arr.length - 1);
	}
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("src/QueueRookie/input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int i = 0; i < T; i ++) {
			int N = sc.nextInt();
			People[] arr = new People[N];
			for(int j = 0; j < N; j++) {
				int height = sc.nextInt();
				arr[j] = new People(height);
			}
			for(int j = 0; j < N; j++) {
				arr[j].count = sc.nextInt();
			}
			arr = sort(arr);
			
			People[] newArr = new People[N];
			for(int j = 0; j < N; j++) {
				int index = 0;
				int count = 0;
				while(true) {
					if(newArr[index] == null) {
						if(count == arr[j].count) {
							break;
						}
						count++;
					}
					index++;
				}			
				newArr[index] = arr[j];
			}
			for(int j = 0; j < N; j++) {
				System.out.print(newArr[j].height + " ");
			}
			System.out.println("");
		}
		
	}
}
