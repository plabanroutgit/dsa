package alimir;

public class BinarySearchIterativePractice {

	private static int binarySearch(int[] arr, int x) {

		if (arr == null || arr.length == 0)
			return -1;

		int l = 0, r = arr.length - 1;

		while (l <= r) {

			int mid = l + (r - l) / 2;

			if (arr[mid] == x)
				return mid;

			if (x < arr[mid]) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] arr = { 2, 34, 56, 76, 98, 100, 763, 7333, 11111 };

		int index = binarySearch(arr, 56);

		System.out.println(index);

	}

}
