package alimir;

public class BinarySearchRecursivePractice {

	private static int binarySearch(int[] arr, int l, int r, int x) {
		// TODO Auto-generated method stub
		if (l <= r) {

			int mid = l + (r - l) / 2;

			if (arr[mid] == x)
				return mid;

			if (x < arr[mid]) {
				return binarySearch(arr, l, mid - 1, x);
			} else {
				return binarySearch(arr, mid + 1, r, x);
			}
		}

		return -1;
	}

	public static void main(String[] args) {

		int[] arr = { 23, 45, 53, 93, 263, 500, 674, 737, 9465 };

		int x = 93;

		int index = binarySearch(arr, 0, arr.length - 1, x);

		System.out.println(index);

	}

}
