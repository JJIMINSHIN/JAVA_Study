package java_mid02.collection.array;

import java.util.Arrays;

/**
 * 배열의 특징
 */
public class ArrayMain2 {

	public static void main(String args[]) {
		int arr[] = new int[5];
		arr[0] = 1;
		arr[1] = 2;
		System.out.println(Arrays.toString(arr));
		
		
		// 배열의 첫번째 위치에 추가
		// 기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 첫번째 위치에 추가
		System.out.println("배열의 첫번째 위치에 3 추가 O(n)");
		int newValue =3;
		addFirst(arr, newValue);
		System.out.println(Arrays.toString(arr));

		// index 위치에 추가
		// 기본 배열의 데이터를 한 칸씩 뒤로 밀고 배열의 index 위치에 추가
		System.out.println("배열의 index(2) 위치에 4 추가 O(n)");
		int idx = 2;
		int value = 4;
		addAtIndex(arr, idx, value);
		System.out.println(Arrays.toString(arr));
		
		// index 마지막 위치에 추가
		System.out.println("배열의 마지막 위치에 5 추가 O(1)");
		addLast(arr, 5);
		System.out.println(Arrays.toString(arr));

	}

	private static void addLast(int[] arr, int i) {
		arr[arr.length-1] =  i;
	}
//												2		4
	private static void addAtIndex(int[] arr, int idx, int value) {
		for (int i = arr.length - 1; i > idx; i--) {
			System.out.println("arr[" + i + "] = " + arr[i] + " arr[" + (i - 1) + "] = " + arr[i - 1]);
			arr[i] = arr[i-1]; // 4-> 3, 3->2, 2->idx, 1->1 ,0 ->0
		}
		arr[idx] = value;
	}

	private static void addFirst(int[] arr, int newValue) {
		for(int i= arr.length-1; i>0; i--) {
			arr[i] = arr[i-1]; // 5-> 4, 4 ->3, 3->2, 2->1, 1->newValue
		}
		arr[0] = newValue;
	}
}
