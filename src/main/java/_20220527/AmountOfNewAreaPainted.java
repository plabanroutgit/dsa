package _20220527;

import java.util.Arrays;
//https://leetcode.com/problems/amount-of-new-area-painted-each-day/discuss/2061567/Java-Simple-Array-implementation
public class AmountOfNewAreaPainted {

	public int[] amountPainted(int[][] paint) {
		int[] answer = new int[paint.length];
		int[] arr = new int[50001];
		for (int i = 0; i < paint.length; i++) {
			int count = 0;
			int index = paint[i][0];
			while (paint[i][1] > index) {
				if (arr[index] == 0) {
					arr[index] = paint[i][1];
					count++;
					index++;
				} else {
					index = arr[index];
				}
			}
			answer[i] = count;
		}
		return answer;
	}

	public static void main(String[] args) {

		int[][] paint = { { 1, 4 }, { 4, 7 }, { 5, 8 } };

		AmountOfNewAreaPainted a = new AmountOfNewAreaPainted();

		System.out.println(Arrays.toString(a.amountPainted(paint)));

	}

}
