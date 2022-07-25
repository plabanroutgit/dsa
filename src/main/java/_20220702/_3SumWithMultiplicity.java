package _20220702;

public class _3SumWithMultiplicity {

	public int threeSumMulti(int[] arr, int target) {

		int count = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				for (int k = j + 1; k < arr.length; k++) {
					if (arr[i] + arr[j] + arr[k] == target)
						count++;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {

		// int[] arr = { 1, 1, 2, 2, 3, 3, 4, 4, 5, 5 };
		int[] arr = { 1, 1, 2, 2, 2, 2 };
		int target = 5;
		_3SumWithMultiplicity sm = new _3SumWithMultiplicity();
		System.out.println(sm.threeSumMulti(arr, target));
	}

}
